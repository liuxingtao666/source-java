package day01;

import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 基于缓存的读取方法
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args)throws Exception {
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.txt","r"	
			  );
		
		byte[] buf = new byte[100];
		/*
		 * 尝试从demo.txt文件中读取100个字节
		 */
		int len = raf.read(buf);
		System.out.println("实际读取到了:"+len+"字节");		
		System.out.println(Arrays.toString(buf));		
		/*
		 * String(byte[] d)
		 * 将给定的字节数组中的所有字节按照系统
		 * 默认的编码集转换为字符串
		 */
		String str 
			= new String(buf);
		System.out.println(str);		
		/*
		 * String(byte[] d,String charsetName)
		 * 将给定字节数组中的所有字节按照给定的编码集
		 * 转换为对应的字符串
		 */
		str = new String(buf,"utf-8");
		System.out.println(str.length());
		System.out.println(str);
		
		/*
		 * String(
		 * 	byte[] d,
		 * 	int offset,  从数组的那里开始(下标)
		 * 	int length,  连续多少个字节
		 * 	String charsetName
		 * )
		 * 将给定字节数组中的部分字节按照指定的字符集
		 * 转换为对应的字符串
		 */
		str = new String(
				buf,0,len,"UTF-8");
		
		raf.close();
	}
}





