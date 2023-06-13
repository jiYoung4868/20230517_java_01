package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoReceiver {
	public static void main(String[] args) {
		new UdpEchoReceiver().receiverUdp();
	}

	public void receiverUdp() {
		int myPort = 6001;
//		int destPort = 5001;
		DatagramSocket dSock = null;
		try {
			dSock = new DatagramSocket(myPort);
			while (true) {
				byte[] byteMsg = new byte[1000];
				DatagramPacket receivedData = new DatagramPacket(byteMsg, byteMsg.length);
				dSock.receive(receivedData);

//				System.out.println(byteMsg.length);
//				System.out.println(receivedData.getData().length);
//				System.out.println(receivedData.getLength());
//				System.out.println(receivedData.getAddress());
//				System.out.println(receivedData.getPort());

				String receivedStr = new String(receivedData.getData());
				System.out.println("수신메시지: " + receivedStr);

				DatagramPacket sendData = new DatagramPacket(receivedData.getData(), receivedData.getLength(),
						receivedData.getAddress(), receivedData.getPort());

				dSock.send(sendData);

			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
