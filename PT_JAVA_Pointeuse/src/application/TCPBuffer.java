package application;

/**
 * Preparation of the buffer class for the TCPMessage class!
 */
class TCPBuffer
{
	protected byte[] buffer;
	private final int size = 8192;
	protected int count;

	/** 
	 * The set method for the buffer.
	 */
	void setStreamBuffer(int size)
	{
		if (size > 0)
		{
			buffer = new byte[size];
		}
		else
		{
			buffer = new byte[this.size];
		}
	}

	/*
	 * void setSocket() throws IOException { isA = new
	 * InetSocketAddress("localhost", 8080); ss = new ServerSocket(isA.getPort());
	 * setStreamBuffer(ss.getReceiveBufferSize()); }
	 */

	/**
	 * Fill the buffer if the message we want to send (in this case, an ID with the date and the rounded time of the current time)
	 * 
	 * @param 	msOut	The message that we want to transfer to the Central Application.
	 */
	protected void fillChar(String msOut)
	{
		//** If we have an actual message **//
		if (msOut != null)
		{
			//** We verify if it's too long or not **//
			if (msOut.length() < buffer.length)
			{
				//** If not, we put all the message's characters inside the buffer **//
				for (int i = 0; i < msOut.length(); i++)
				{
					buffer[i] = (byte) msOut.charAt(i);
				}
			}
		}
	}

	/**
	 * Take out every character inside a buffer (by replacing every of them by a 0).
	 */
	void clearBuffer()
	{
		for (int i = 0; i < buffer.length; i++)
		{
			buffer[i] = 0;
		}
	}

	/**
	 * To have the number of characters in the buffer.
	 * 
	 * @return	the number of characters inside the buffer, ready to be sent to the Central Application.
	 */
	protected int count()
	{
		for (int i = 0; i < buffer.length; i++)
		{
			if (buffer[i] == 0)
			{
				return i;
			}
		}
		return buffer.length;
	}
}