package day01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * ʹ���ļ��ֽ�������FIS���ļ��ֽ������FOS
 * ʵ���ļ��ĸ��Ʋ���
 * @author Administrator
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws Exception {
		/*
		 *  1:����FIS���ڶ�ȡԭ�ļ�
		 *  2:����FOS������Ŀ���ļ�д����
		 *  3:ѭ������
		 *    3.1 ��ԭ�ļ���ȡһ���ֽ�
		 * 	  3.2 �����ֽ�д��Ŀ���ļ�
		 *  4:�ر�������	
		 */
		//1
		FileInputStream fis
			= new FileInputStream(
				"FishGame.rar"
			  );
		
		//2
		FileOutputStream fos
			= new FileOutputStream(
				"FishGame_copy3.rar"	
			  );
		
		int len = -1;
		byte[] buf = new byte[1024*10];
		
		while( ( len = fis.read(buf) ) != -1 ){
			fos.write(buf,0,len);
		}
		
		fis.close();
		fos.close();
	}
}
