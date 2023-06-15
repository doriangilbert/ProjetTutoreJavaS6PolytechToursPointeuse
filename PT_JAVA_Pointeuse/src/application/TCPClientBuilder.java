package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * builder class for the creation of the socket for the TCPMassage class (client side)!
 */
public class TCPClientBuilder extends TCPMessage
{
	Socket s;
	InetSocketAddress isA;

	/**
	 * Default constructor, define the attributes with default values.
	 */
	TCPClientBuilder()
	{
		s = null;
		isA = null;
	}

	/**
	 * Create a socket that will transport the message (the check) to the CentralApplication.
	 * The socket will destroy itself 100 seconds after being created.
	 * 
	 * @throws IOException
	 */
	protected void setSocket() throws IOException
	{
		isA = new InetSocketAddress("localhost", 8085);
		s = new Socket(isA.getHostName(), isA.getPort());
		//** Time set from its creation to its own destruction (its lifetime) **//
		s.setSoTimeout(100000);
		/** we can include more setting, later … */
	}
}
