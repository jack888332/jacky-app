package test.base.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestIO {

	public static void main(String[] args) {
		File file1 = new File("d:\\hhh\\test.txt");
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		if (file1.exists()) {
			System.out.println(file1.isDirectory());
			System.out.println(file1.isFile());
		}

		FileOutputStream fos;
		try {
			file1.createNewFile();
			fos = new FileOutputStream(file1);
			fos.write(545455);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		
	}

}
