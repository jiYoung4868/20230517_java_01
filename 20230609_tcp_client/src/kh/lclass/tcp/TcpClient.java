package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {
	public void testTCPClient(String ip, int port) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		// Scanner sc = new Scanner(System.in);
		// Scanner와 유사한 기능
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		try {
			socket = new Socket(ip, port);
			System.out.println("서버에 접속 성공");

			in = socket.getInputStream(); // 이걸로 클라이언트가 주는 내용 읽음
			out = socket.getOutputStream();
			// 6. 보조 스트림을 통해 성능 개선
			br = new BufferedReader(new InputStreamReader(in)); // 문자 형태로 만들어주고 속도 올려주기
			pw = new PrintWriter(new OutputStreamWriter(out));

			while (true) {
				String sendMsg = null;

				System.out.println("메시지>>");
				sendMsg = stdIn.readLine();
				System.out.println("#####" + sendMsg);

				pw.println(sendMsg);
				pw.flush();

				String receivedMsg = br.readLine();
				System.out.println("서버로부터 받은 메시지: " + receivedMsg);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (stdIn != null)
					stdIn.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // close는 역순 brwr==>inout==>sssc
		}
	}

}