package application;

import java.io.IOException;
import java.io.OutputStream;

public class TCPClientMessage extends TCPClientBuilder {

	public void send(String message) {
		try {
			setSocket();
			String msOut = message;
			System.out.println("TCPClient : Message Sent : " + msOut);
			OutputStream out = s.getOutputStream();
			setStreamBuffer(msOut.getBytes().length + 1);
			writeMessage(out, msOut);
			s.close();
		} catch (IOException e) {
			System.out.println("IOException TCPClientMessage");
		}
	}
}
