package day02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 文本的读取 
 */
public class ReaderDemo {
	public static void main(String[] args)
		throws Exception{
		Reader in = 
			new InputStreamReader(
			new BufferedInputStream(
			new FileInputStream("a.txt")	
			),"utf-8");
		//read读取byte序列经过解码为char填充到
		//int的低16位返回
		int c = in.read();
		System.out.println((char)c); 
		c = in.read();
		System.out.println((char)c); 
		c = in.read();//-1
		System.out.println(c);//-1
		in.close();
	}

}







