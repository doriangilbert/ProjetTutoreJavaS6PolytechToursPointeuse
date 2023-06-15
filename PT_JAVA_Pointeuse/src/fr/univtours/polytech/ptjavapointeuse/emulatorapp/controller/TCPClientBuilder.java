package fr.univtours.polytech.ptjavapointeuse.emulatorapp.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import fr.univtours.polytech.ptjavapointeuse.common.TCPMessage;

/**
 * builder class for the creation of the socket for the TCPMassage class (client side)!
 */
public class TCPClientBuilder extends TCPMessage
{
	Socket s;
	InetSocketAddress isA;
	
	public static String address = "localhost";
	public static int port = 8085;

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
	 * 
	 * @throws IOException
	 */
	protected void setSocket() throws IOException
	{
		isA = new InetSocketAddress(address, port);
		s = new Socket(isA.getHostName(), isA.getPort());
		/** we can include more setting, later … */
	}
}
