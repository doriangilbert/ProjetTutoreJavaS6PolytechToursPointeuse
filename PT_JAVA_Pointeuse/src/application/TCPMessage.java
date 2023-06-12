package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class TCPMessage extends TCPBuffer {
	/** The (simple) text write method. */
	void writeMessage(OutputStream out, String msOut) throws IOException {
		if ((out != null) & (msOut != null)) {
			fillChar(msOut);
			out.write(buffer);
			out.flush();
			clearBuffer();
		}
	}

	/** The (simple) text read method. */
	String readMessage(InputStream in) throws IOException {
		if (in != null) {
			in.read(buffer);
			count = count();
			if (count > 0)
				return new String(buffer, 0, count);
		}
		return null;
	}

	void loopWriteMessage(OutputStream out, int loop) throws IOException {
		for (int i = 0; i < loop; i++) {
			fillAtRandom(buffer);
			out.write(buffer);
			out.flush();
		}
	}

	private void fillAtRandom(byte[] buffer) {
		for (int i = 0; i < buffer.length; i++)
			buffer[i] = (byte) r.nextInt(256);
	}

	private Random r = new Random();
}
