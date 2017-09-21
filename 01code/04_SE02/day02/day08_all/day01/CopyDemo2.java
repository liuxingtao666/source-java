package day01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 使用缓冲字节流完成复制操作
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args)throws Exception {
		
		FileInputStream fis
			= new FileInputStream(
				"FishGame.rar"	
			  );
		/*
		 * 为FIS加装缓冲输入流，提高读取效率
		 * BufferedInputStream(
		 * 			InputStream in)
		 */
		BufferedInputStream bis
			= new BufferedInputStream(
				fis	
			);	
		FileOutputStream fos
			= new FileOutputStream(
				"FileGame_copy4.rar"
			  );
		BufferedOutputStream bos
			= new BufferedOutputStream(
				fos	
			);
		int d = -1;
		while( ( d = bis.read() ) != -1 ){
			bos.write(d);
		}
		
		/*
		 * 关闭流时，关闭最外层的高级流即可
		 */
		bis.close();
		bos.close();
		
	}
}
