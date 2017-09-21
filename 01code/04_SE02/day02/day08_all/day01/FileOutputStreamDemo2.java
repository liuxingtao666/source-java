package day01;

import java.io.FileOutputStream;

/**
 * 追加写操作
 * @author Administrator
 *
 */
public class FileOutputStreamDemo2 {
	public static void main(String[] args)throws Exception {
		
		/*
		 * FileOutputStream(
		 * 		String fileName,
		 *      boolean append)
		 * append若为true,则是追加写操作
		 * 
		 * FileOutputStream(
		 * 		File file,
		 * 		boolean append
		 * 		)     
		 *      
		 */
		FileOutputStream fos
			= new FileOutputStream(
				"fos.txt",true
			);
		
		fos.write('a');
		
		fos.close();
	}
}
