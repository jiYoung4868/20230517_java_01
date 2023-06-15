package kh.lclass.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kh.lclass.chat.client.ClientGUI;

public class ServerBackground { // server는 무조건 서버소켓이 필요함! 하지만 클라이언트가 여러명 접속하기에 ArrayList로 소켓처리
	private ServerSocket serverSocket;
	private ServerGUI gui;

	// client 여러명을 관리 : socket + nickname
	private Map<String, BufferedWriter> mapClients = new HashMap<String, BufferedWriter>();
	private String nickName;
	private Socket socket;
	
	private int count; // 현재 접속자 수 체크

	public void setting() { // 서버 생성 및 설정
		
		Collections.synchronizedMap(mapClients);//참고: 동시 접속자로 map에 정보가 동기화 되어 들어가도록 설정
		
		try {
			serverSocket = new ServerSocket(7777);
			while (true) { // 방문자 접속을 계속 받아들임. 무한반복함. GUI프로그램일 경우 창 닫힐때까지 계속 반복됨.
				socket = serverSocket.accept(); // client 받음
				new Client(socket).start();

			}
//				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addClient(String nickname) { // 클라이언트가 접속하면 그 정보를 나타내어 주는 메서드
		gui.appendMsg(nickname + "님이 접속했습니다.");
	}

	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}

	public void sendMessage(String msg) { // client들 모두에게 msg전달
		Set<String> keys = mapClients.keySet();
		for (String key : keys) {
			BufferedWriter wr = mapClients.get(key);
			try {
				wr.write(key + ":" + msg + "\n"); // 줄바꿈이 있어야 읽혀짐
				wr.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Client extends Thread {
//		private Socket socket;
		private BufferedReader br;
		private BufferedWriter bw;
		private String nickname;

		public Client(Socket socket) {

			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				String nickname = br.readLine(); // 접속되면 nickname이 전달될 것임

				addClient(nickname); // server화면에 표현

				mapClients.put(nickname, bw); // br은 아래서 다해주니까 bw만, outputStream관리 map에 추가
				sendMessage(nickname + "님 접속했습니다.");// client map 모두에게 접속 정보 전달

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() { // 클라이언트마다 각각에서 전달되어오는 메시지를 화면에 출력, Client와 입력통로가 끊어지지 않았다면 계속 반복, Client에서 수신받은
							// msg
			while (br != null) {
				try {
					String msg = br.readLine();
					gui.appendMsg(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}