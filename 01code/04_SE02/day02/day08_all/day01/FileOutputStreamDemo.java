package day01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流
 * 以字节为单位向文件中写出数据
 * @author Administrator
 *
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			
			/*
			 * FileOutputStream(String fileName)
			 * 根据给定的文件路径创建对应的文件输出流
			 */
//			fos = new FileOutputStream("fos.dat");
			
			/*
			 * FileOutputStream(File file)
			 */
			File file = new File("fos.dat");
			fos = new FileOutputStream(file);
			
			
			/*
			 * 写出方法:
			 * void write(int d)
			 * void write(byte[] d)
			 * void write(byte[] d,int offset,int length)
			 */
			
			fos.write(97);
			
			fos.write("hello".getBytes());
			
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
		

	}
}



