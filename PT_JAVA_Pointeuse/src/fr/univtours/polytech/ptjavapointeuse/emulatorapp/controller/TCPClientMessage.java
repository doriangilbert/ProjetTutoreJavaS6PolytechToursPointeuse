package fr.univtours.polytech.ptjavapointeuse.emulatorapp.controller;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The class that will create and send the message via a TCP connection!
 */
public class TCPClientMessage extends TCPClientBuilder
{
	
	/**
	 * Will put the message inside a buffer, ready to be sent.
	 * 
	 * @param  message	The message to send
	 */
	public void send(String message)
	{
		try
		{
			//** Creation of the socket **//
			setSocket();
			
			//** We take the message to copy it into the buffer **//
			String msOut = message;
			System.out.println("TCPClient : Message Sent : " + msOut);
			OutputStream out = s.getOutputStream();
			setStreamBuffer(msOut.getBytes().length + 1);
			writeMessage(out, msOut);
			s.close();
		}
		
		catch (IOException error)
		{
			System.out.println("Emulator App (client) : Transmission error");
		}
	}
}
