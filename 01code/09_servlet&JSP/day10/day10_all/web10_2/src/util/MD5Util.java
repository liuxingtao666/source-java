package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static void test1() throws 
	NoSuchAlgorithmException{
		String str = "I  love you";
		//����һ��ʹ��ָ���㷨���ܵĹ���
		MessageDigest md = 
			MessageDigest.getInstance("md5");
		//����
		byte[] buf  = 
			md.digest(str.getBytes());
		//��Ϊ����֮��õ�����һ���ֽ�����,
		//������ʹ�ã����ԣ���Ҫ����ת����һ
		//���ַ���
		BASE64Encoder encoder = 
			new BASE64Encoder();
		//BASE64Encoder���Խ������һ��
		//�ֽ�����ת����һ���ַ�����
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
