package day02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * �ı��Ķ�ȡ 
 */
public class ReaderDemo {
	public static void main(String[] args)
		throws Exception{
		Reader in = 
			new InputStreamReader(
			new BufferedInputStream(
			new FileInputStream("a.txt")	
			),"utf-8");
		//read��ȡbyte���о�������Ϊchar��䵽
		//int�ĵ�16λ����
		int c = in.read();
		System.out.println((char)c); 
		c = in.read();
		System.out.println((char)c); 
		c = in.read();//-1
		System.out.println(c);//-1
		in.close();
	}

}







