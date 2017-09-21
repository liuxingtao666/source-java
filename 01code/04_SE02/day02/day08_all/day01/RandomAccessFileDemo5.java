package day01;

import java.io.RandomAccessFile;

/**
 * 随机访问文件
 * @author Administrator
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args)throws Exception {
		
		RandomAccessFile raf
			= new RandomAccessFile(
				"data.dat","rw"	
			  );
		
		raf.write(97);
		
		byte[] data 
			= "hello".getBytes("utf-8");
		
		raf.write(data);
		
		/*
		 * RandomAccessFile的读写操作
		 * 是基于游标的。总是在游标当前指向
		 * 的地方进行读写。每当读写后游标会
		 * 自动向后移动。
		 */
		//将游标移动到第一个字节上。
		raf.seek(0);
		
		//读取一个字节
		int num = raf.read();
		System.out.println(num);
		
		raf.close();
	}
}




