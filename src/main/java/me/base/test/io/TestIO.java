package me.base.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestIO {

	public static void main(String[] args) {
	    File file1 = new File("d:\\hhh\\test.txt");
	    System.out.println(file1.getPath());	    
	    System.out.println(file1.getAbsolutePath());
	    System.out.println(file1.getName());
	    
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("D:\\a.txt"));
			fos.write(545455);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
