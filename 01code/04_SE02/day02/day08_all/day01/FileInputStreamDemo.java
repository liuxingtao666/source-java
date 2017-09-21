package day01;

import java.io.FileInputStream;

/**
 * 文件字节输入流
 * @author Administrator
 *
 */
public class FileInputStreamDemo {
	public static void main(String[] args)throws Exception {
		/*
		 * FileInputStream(String fileName)
		 * FileInputStream(File file)
		 */
		FileInputStream fis
			= new FileInputStream("fos.dat");
		
		/*
		 *  int read()
		 *  int read(byte[] d) 
		 */
		int d = fis.read();
		System.out.println(d);
		
		
		
		fis.close();
	}
}




