package test.base.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.InetSocketAddress;

public class ClientTCP {
	public static void main(String[] args) throws IOException {
		// 创建客户端套接字（无链接状态）
		Socket plugForServer = new Socket();
		// 连接服务器
		plugForServer.connect(new InetSocketAddress("127.0.0.1", 9001), 10000);

		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		InputStreamReader isr = null;
		try {
			// 从本地输入流读
			File file = new File("d:\\MyClient\\cat.jpg");
			bis = new BufferedInputStream(new FileInputStream(file));
			// 向客户端输出流（服务器输入流）写
			bos = new BufferedOutputStream(plugForServer.getOutputStream());
			// 执行上传（等同复制）
			byte[] bytes = new byte[1024 * 8];
			int numberOfBytes;
			while ((numberOfBytes = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, numberOfBytes);
			}
			plugForServer.shutdownOutput();
			System.out.println("文件已上传");

			// 从客户端输入流（服务器输出流）读
			isr = new InputStreamReader(plugForServer.getInputStream(), "UTF-8");
			char[] chars = new char[1024];
			isr.read(chars);
			System.out.println(new String(chars));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(isr);
			close(bos);
			close(bis);
			close(plugForServer);
		}
	}

	// 关闭资源
	private static void close(AutoCloseable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
