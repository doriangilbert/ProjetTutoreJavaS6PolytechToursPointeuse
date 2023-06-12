package application;

class TCPBuffer {
	protected byte[] buffer;
	private final int size = 8192;

	/** The set method for the buffer. */
	void setStreamBuffer(int size) {
		if (size > 0)
			buffer = new byte[size];
		else
			buffer = new byte[this.size];
	}

	/*
	 * void setSocket() throws IOException { isA = new
	 * InetSocketAddress("localhost", 8080); ss = new ServerSocket(isA.getPort());
	 * setStreamBuffer(ss.getReceiveBufferSize()); }
	 */

	protected void fillChar(String msOut) {
		if (msOut != null)
			if (msOut.length() < buffer.length)
				for (int i = 0; i < msOut.length(); i++)
					buffer[i] = (byte) msOut.charAt(i);
	}

	void clearBuffer() {
		for (int i = 0; i < buffer.length; i++)
			buffer[i] = 0;
	}

	protected int count;

	protected int count() {
		for (int i = 0; i < buffer.length; i++)
			if (buffer[i] == 0)
				return i;
		return buffer.length;
	}
}