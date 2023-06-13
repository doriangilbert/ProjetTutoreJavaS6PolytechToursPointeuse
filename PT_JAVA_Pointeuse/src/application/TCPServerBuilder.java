package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBuilder extends TCPMessage
{
	ServerSocket ss;
	Socket s;
	InetSocketAddress isA;

	TCPServerBuilder()
	{
		ss = null;
		s = null;
		isA = null;
	}

	protected void setSocket() throws IOException
	{
		isA = new InetSocketAddress("localhost", 8085);
		ss = new ServerSocket(isA.getPort());
		ss.setSoTimeout(100000);
		/** we can include more setting, later … */
	}
}
