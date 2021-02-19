package test.base.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8888);
			OutputStream os = socket.getOutputStream();
			os.write("Hi Server".getBytes());
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
