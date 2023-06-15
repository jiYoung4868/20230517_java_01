package kh.lclass.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBackground {
	private Socket socket; // 필드는 따로 close 안해도 됨. garbage collection에 의해 close 될 예정임.
	private BufferedReader br;
	private BufferedWriter bw;
	private String nickname;
	private ClientGUI gui; // null값이 들어있음

	public void disconnection() { // 알아서 close 되겠지만, garbage collection에 맡기고 싶지 않을 때, disconnection() 메서드 이용
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
		}
	}

	// client가 서버에 접속 -
	public void connection() {
		try {
			// 서버와 연결
			socket = new Socket("127.0.0.1", 7777);
			// 서버와 입/출력 통로 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			bw.write(nickname + "\n");
			bw.flush();

			// server와 입력통로가 끊어지지 않았다면, 계속 반복확인함.
			// server에서 수신받은 msg

			while (br != null) { // br이 close되지 않는다면, 무한반복.
				String msg = br.readLine();
				gui.appendMsg(msg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendMessage(String msg) {// server에 msg 전달
		try {
			bw.write(nickname + ":" + msg + "\n");
			bw.flush();
			gui.appendMsg(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setNickname(String nickName) {
		this.nickname = nickName;
	}

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}
}
