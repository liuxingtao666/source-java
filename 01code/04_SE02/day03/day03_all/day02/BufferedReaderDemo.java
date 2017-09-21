package day02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读取文本文件 
 */
public class BufferedReaderDemo {
	public static void main(String[] args) 
		throws Exception{
		//BufferedReader 提供了功能强大的
		//ReadLine 读取一行的方法
		BufferedReader in = 
			new BufferedReader(//按行读取
			new InputStreamReader(//读取文件
			new BufferedInputStream( //提高读效率
			new FileInputStream("b.txt")//打开文件
			),"utf-8"));
		String str = in.readLine();
		System.out.println(str);
		str = in.readLine();
		System.out.println(str);
		str = in.readLine();//null,文件尾部
		System.out.println(str);
		in.close();
	}

}



