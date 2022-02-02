package demo.stream;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.charset.Charset;

public class TestIO {

	static Class<?> pointerToClass;

	public static void main(String[] args) throws Exception {
		init();
		
		// 从标准输入执行系统命令
		URL url = Thread.currentThread().getContextClassLoader().getResource("ModifyFileNamesInBulk.bat");
		File file = new File(url.toURI());
		String command = StringUtils.joinWith(" ", "cmd /k start /d", file.getParent(), file.getName());
		Runtime.getRuntime().exec(command);

//		long s = System.currentTimeMillis();
//		copyFileByByteStream("D:\\source.jpg", "D:\\target.jpg");
//		long e = System.currentTimeMillis();
//		System.out.println("字节流传输毫秒数：" + (e - s));

//		s = System.currentTimeMillis();
//		copyFileByCharStream("D:\\source.txt", "D:\\target.txt");
//		e = System.currentTimeMillis();
//		System.out.println("字符流传输毫秒数：" + (e - s));

	}

	public static void init() throws Exception {
		// 通过类加载器反射类
		pointerToClass = Class.forName("sun.nio.cs.UTF_8");
	}

	private static void copyFileByByteStream(String sourcePath, String targetPath) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(sourcePath));
			bos = new BufferedOutputStream(new FileOutputStream(targetPath, true));
			byte[] bytes = new byte[1024];
			Integer numberOfBytes = null;
			while ((numberOfBytes = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, numberOfBytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bis, bos);
		}
	}

	private static void copyFileByCharStream(String sourcePath, String targetPath) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			Constructor<?> constructor = pointerToClass.getConstructor();
			Charset charset = (Charset) constructor.newInstance();

			br = new BufferedReader(new FileReader(sourcePath, charset));
			bw = new BufferedWriter(new FileWriter(targetPath, true));
			char[] chars = new char[1024];
			Integer numberOfChars = null;
			while ((numberOfChars = br.read(chars)) != -1) {
				bw.write(chars, 0, numberOfChars);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(bw, br);
		}
	}

	// 关闭资源
	private static void close(AutoCloseable... resourceList) {
		for (AutoCloseable resource : resourceList) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
