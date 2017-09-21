package day01;

import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * ���ڻ���Ķ�ȡ����
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
		 * ���Դ�demo.txt�ļ��ж�ȡ100���ֽ�
		 */
		int len = raf.read(buf);
		System.out.println("ʵ�ʶ�ȡ����:"+len+"�ֽ�");		
		System.out.println(Arrays.toString(buf));		
		/*
		 * String(byte[] d)
		 * ���������ֽ������е������ֽڰ���ϵͳ
		 * Ĭ�ϵı��뼯ת��Ϊ�ַ���
		 */
		String str 
			= new String(buf);
		System.out.println(str);		
		/*
		 * String(byte[] d,String charsetName)
		 * �������ֽ������е������ֽڰ��ո����ı��뼯
		 * ת��Ϊ��Ӧ���ַ���
		 */
		str = new String(buf,"utf-8");
		System.out.println(str.length());
		System.out.println(str);
		
		/*
		 * String(
		 * 	byte[] d,
		 * 	int offset,  ����������￪ʼ(�±�)
		 * 	int length,  �������ٸ��ֽ�
		 * 	String charsetName
		 * )
		 * �������ֽ������еĲ����ֽڰ���ָ�����ַ���
		 * ת��Ϊ��Ӧ���ַ���
		 */
		str = new String(
				buf,0,len,"UTF-8");
		
		raf.close();
	}
}





