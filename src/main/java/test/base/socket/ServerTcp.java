package test.base.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcp {
	public static void main(String[] args) throws IOException {
		// 创建服务器套接字（无绑定参数）
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket();
		// 服务器套接字绑定端口，约束连接数
		server.bind(new InetSocketAddress(9001), 10);

		while (true) {
			// 侦听与此套接字建立的连接并接受它。该方法将【阻塞】，直到建立连接为止。
			Socket plugForClient = server.accept();
			// 开启处理客户端请求的线程。没有公共数据，不存在线程安全问题。
			new Thread(new Runnable() {
				@Override
				public void run() {
					BufferedInputStream bis = null;
					BufferedOutputStream bos = null;
					OutputStreamWriter osw = null;
					try {
						// 从服务器输入流（客户端输出流）读
						bis = new BufferedInputStream(plugForClient.getInputStream());
						// 向本地输出流写
						File file = new File("d:\\MyServer\\" + System.currentTimeMillis() + ".jpg");
						bos = new BufferedOutputStream(new FileOutputStream(file));
						// 执行复制
						byte[] bytes = new byte[1024 * 8];
						int numberOfBytes;
						while ((numberOfBytes = bis.read(bytes)) != -1) {
							bos.write(bytes, 0, numberOfBytes);
							bos.flush();
						}
						System.out.println("上传的文件已保存");

						// 向服务器输出流（客户端输入流）写
						osw = new OutputStreamWriter(plugForClient.getOutputStream(), "UTF-8");
						osw.write("文件上传成功");
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						close(osw);
						close(bos);
						close(bis);
						close(plugForClient);
					}
				}
			}).start();
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
