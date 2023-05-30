package application;
import java.io.IOException;
import java.io.InputStream;

public class TCPServerMessage extends TCPServerBuilder {
	
	static boolean isAlreadySet = false;
	
	public String recevoir() {
		String msIn ="";
		try {
			if (isAlreadySet == false) {
				setSocket();
			}
			s = ss.accept();
			InputStream in = s.getInputStream();
			//byte[] buffer = new byte[8192];
			//int count = in.read(buffer);
			//String msIn = new String(buffer, 0, count);
			setStreamBuffer(ss.getReceiveBufferSize());
			msIn = readMessage(in);
			//System.out.println(msIn);
			in.close();
			//s.close();
			//ss.close();
		} catch (IOException e) {
			System.out.println("IOException TCPServerMessage");
		}
		return msIn;
	}
}
