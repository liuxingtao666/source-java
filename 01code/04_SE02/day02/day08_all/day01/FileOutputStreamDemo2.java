package day01;

import java.io.FileOutputStream;

/**
 * ׷��д����
 * @author Administrator
 *
 */
public class FileOutputStreamDemo2 {
	public static void main(String[] args)throws Exception {
		
		/*
		 * FileOutputStream(
		 * 		String fileName,
		 *      boolean append)
		 * append��Ϊtrue,����׷��д����
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
