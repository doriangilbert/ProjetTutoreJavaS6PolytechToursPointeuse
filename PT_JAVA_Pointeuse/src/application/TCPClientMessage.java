package application;
import java.io.IOException;
import java.io.OutputStream;

public class TCPClientMessage extends TCPClientBuilder {
	public void envoyer(String message) {
		try {
			setSocket();
			//String msOut = "Aujourd'hui, TP ASR Java.";
			String msOut = message;
			OutputStream out = s.getOutputStream();
			// byte[] buffer = msOut.getBytes();
			// out.write(buffer);
			// out.flush();
			setStreamBuffer(msOut.getBytes().length + 1);
			writeMessage(out, msOut);
			out.close();
			s.close();
		} catch (IOException e) {
			System.out.println("IOException TCPClientMessage");
		}
	}
}
