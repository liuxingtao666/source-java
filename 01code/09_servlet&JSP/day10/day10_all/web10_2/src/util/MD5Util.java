package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static void test1() throws 
	NoSuchAlgorithmException{
		String str = "I  love you";
		//创建一个使用指定算法加密的工具
		MessageDigest md = 
			MessageDigest.getInstance("md5");
		//加密
		byte[] buf  = 
			md.digest(str.getBytes());
		//因为加密之后得到的是一个字节数组,
		//不方便使用，所以，需要将其转换成一
		//个字符串
		BASE64Encoder encoder = 
			new BASE64Encoder();
		//BASE64Encoder可以将任意的一个
		//字节数组转换成一个字符串。
		String str2 = encoder.encode(buf);
		System.out.println(str2);
	}
	
	public static String encrypt(String str) 
	throws NoSuchAlgorithmException{
		MessageDigest md = 
			MessageDigest.getInstance("md5");
		byte[] buf  = 
			md.digest(str.getBytes());
		BASE64Encoder encoder = 
			new BASE64Encoder();
		String str2 = encoder.encode(buf);
		return str2;
	}
	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		//test1();
		System.out.println(encrypt("test"));
	}

}
