package application;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClientBuilder extends TCPMessage {
	Socket s;
	InetSocketAddress isA;

	TCPClientBuilder() {
		s = null;
		isA = null;
	}

	protected void setSocket() throws IOException {
		isA = new InetSocketAddress("localhost", 8085);
		//isA = new InetSocketAddress("192.168.0.51", 8085);
		s = new Socket(isA.getHostName(), isA.getPort());
		/** we can include more setting, later … */
	}
}
