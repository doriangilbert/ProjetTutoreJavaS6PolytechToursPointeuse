package application;

import java.io.IOException;
import java.io.InputStream;

public class TCPServerMessage extends TCPServerBuilder implements Runnable {

	public void run() {
		do {
			String message = this.receive();
			System.out.println("AppCentrale : Message Received : " + message);
		} while (true);
	}

	public String receive() {
		String msIn = "";
		try {
			setSocket();
			s = ss.accept();
			InputStream in = s.getInputStream();
			setStreamBuffer(ss.getReceiveBufferSize());
			msIn = readMessage(in);
			System.out.println("TCPServer : Message Received : " + msIn);
			s.close();
			ss.close();
		} catch (IOException e) {
			System.out.println("IOException TCPServerMessage");
		}
		return msIn;
	}
}
