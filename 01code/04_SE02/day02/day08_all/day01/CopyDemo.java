package day01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 使用文件字节输入流FIS与文件字节输出流FOS
 * 实现文件的复制操作
 * @author Administrator
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws Exception {
		/*
		 *  1:创建FIS用于读取原文件
		 *  2:创建FOS用于向目标文件写数据
		 *  3:循环操作
		 *    3.1 从原文件读取一个字节
		 * 	  3.2 将该字节写入目标文件
		 *  4:关闭两个流	
		 */
		//1
		FileInputStream fis
			= new FileInputStream(
				"FishGame.rar"
			  );
		
		//2
		FileOutputStream fos
			= new FileOutputStream(
				"FishGame_copy3.rar"	
			  );
		
		int len = -1;
		byte[] buf = new byte[1024*10];
		
		while( ( len = fis.read(buf) ) != -1 ){
			fos.write(buf,0,len);
		}
		
		fis.close();
		fos.close();
	}
}
