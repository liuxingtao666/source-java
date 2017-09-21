package day01;

import java.io.RandomAccessFile;

/**
 * 基于缓存的写方法
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args)throws Exception {
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.txt","rw"
			);		
		String str = "大家好！我是苍老师!";
		/*
		 * 根据系统默认编码集将字符串转换为
		 * 对应的字节序列
		 */
//		byte[] data = str.getBytes();
		
		/*
		 * 使用指定的编码集将字符串转换为字节
		 */
		byte[] data = str.getBytes("UTF-8");
		//将字节数组一次性写出
		raf.write(data);
		
		raf.close();
	}
}











