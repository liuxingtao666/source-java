package day02;

import java.io.UnsupportedEncodingException;

//�ַ�����
public class CharEncodingDemo {
	public static void main(String[] args) 
	throws UnsupportedEncodingException{
		String str="ABC�й�";//�ַ�����
		//��str����Ϊbyte����
		byte[] bytes = 
			str.getBytes("utf-8");
		//windows xp GBK 7��byte
		// utf-8 9��byte
		System.out.println(
				bytes.length);
		//��byte�������Ϊ char���У��ַ�����
		String s = 
			new String(bytes,"utf-8");
		System.out.println(s);
	}

}
