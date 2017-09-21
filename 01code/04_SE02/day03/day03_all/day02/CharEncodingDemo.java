package day02;

import java.io.UnsupportedEncodingException;

//字符编码
public class CharEncodingDemo {
	public static void main(String[] args) 
	throws UnsupportedEncodingException{
		String str="ABC中国";//字符序列
		//将str编码为byte序列
		byte[] bytes = 
			str.getBytes("utf-8");
		//windows xp GBK 7个byte
		// utf-8 9个byte
		System.out.println(
				bytes.length);
		//将byte数组解码为 char序列（字符串）
		String s = 
			new String(bytes,"utf-8");
		System.out.println(s);
	}

}
