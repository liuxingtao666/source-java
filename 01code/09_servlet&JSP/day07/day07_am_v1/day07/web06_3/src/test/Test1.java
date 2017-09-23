package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test1 {
	
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) 
	throws UnsupportedEncodingException {
		String str = "中国";
		/*
		 * encode方法会将字符串str按照指定的
		 * 字符集先进行编码，然后将得到的字节数组
		 * 转换成一个ascii字符串的形式。
		 */
		String str2 =
			URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
		String str3 = 
			URLDecoder.decode(str2,"utf-8");
		System.out.println(str3);
	}

}
