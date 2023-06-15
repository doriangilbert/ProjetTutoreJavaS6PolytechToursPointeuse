package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * builder class for the creation of the socket for the TCPMassage class (server side)!
 */
public class TCPServerBuilder extends TCPMessage
{
	ServerSocket ss;
	Socket s;
	InetSocketAddress isA;

	/**
	 * Default constructor, define the attributes with default values.
	 */
	TCPServerBuilder()
	{
		ss = null;
		s = null;
		isA = null;
	}

	/**
	 * Create a socket.
	 * 
	 * @throws IOException
	 */
	protected void setSocket() throws IOException
	{
		isA = new InetSocketAddress("localhost", 8085);
		ss = new ServerSocket(isA.getPort());
		/** we can include more setting, later … */
	}
}
