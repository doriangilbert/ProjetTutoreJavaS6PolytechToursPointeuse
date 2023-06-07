package application;
import java.io.IOException;
import java.io.InputStream;

public class TCPServerMessage extends TCPServerBuilder {
	
	public String receive() {
		String msIn ="";
		try {
			setSocket();
			s = ss.accept();
			InputStream in = s.getInputStream();
			setStreamBuffer(ss.getReceiveBufferSize());
			msIn = readMessage(in);
			System.out.println("TCPServer : Message Received : " + msIn);
			//System.out.println(msIn);
			//in.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			System.out.println("IOException TCPServerMessage");
		}
		return msIn;
	}
}
