package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void testTcpServer(int port) {

		ServerSocket ss = null; // (닫아주기 위해) [[얘는 한개]]
		Socket sc = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;

		try {
			// 2. 서버용 소켓 객체 생성
			ss = new ServerSocket(port);

			while (true) {

				System.out.println("클라이언트 접속 대기중 ...");
				// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림,
				// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대해 소켓 객체 생성
				sc = ss.accept();// [[얘는 들어오는 대로 만들어짐]]
				System.out.println("클라이언트 접속됨: " + sc.getLocalPort());
				System.out.println("클라이언트 접속됨: " + sc.getPort());

				// 5. 연결된 클라이언트와 입출력 스트림 생성
				in = sc.getInputStream(); // 이걸로 클라이언트가 주는 내용 읽음
				out = sc.getOutputStream();
				// 6. 보조 스트림을 통해 성능 개선
				br = new BufferedReader(new InputStreamReader(in)); // 문자 형태로 만들어주고 속도 올려주기
				wr = new BufferedWriter(new OutputStreamWriter(out));

				String receivedMsg = null;
				while ((receivedMsg = br.readLine()) != null) {
					System.out.println("받은메시지: " + receivedMsg);
					wr.write("메시지 잘 받았음.\n");
					wr.flush();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (wr != null)
					wr.close(); // close는 역순 brwr==>inout==>sssc
				if (br != null)
					br.close();
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (sc != null)
					sc.close();
				if (ss != null)
					ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
