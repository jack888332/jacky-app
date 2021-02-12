package me.base.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import sun.nio.cs.UTF_8;

public class TestIO {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		copyFileByByteStream("D:\\source.jpg", "D:\\target.jpg");
		long e = System.currentTimeMillis();
		System.out.println("字节流传输毫秒数：" + (e - s));

		s = System.currentTimeMillis();
		copyFileByCharStream("D:\\source.txt", "D:\\target.txt");
		e = System.currentTimeMillis();
		System.out.println("字符流传输毫秒数：" + (e - s));

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
			try {
				if (bos != null) {
					bos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void copyFileByCharStream(String sourcePath, String targetPath) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(sourcePath, new UTF_8()));
			bw = new BufferedWriter(new FileWriter(targetPath, true));
			char[] chars = new char[1024];
			Integer numberOfChars = null;
			while ((numberOfChars = br.read(chars)) != -1) {
				bw.write(chars, 0, numberOfChars);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
