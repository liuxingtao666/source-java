package day01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * ʹ�û����ֽ�����ɸ��Ʋ���
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args)throws Exception {
		
		FileInputStream fis
			= new FileInputStream(
				"FishGame.rar"	
			  );
		/*
		 * ΪFIS��װ��������������߶�ȡЧ��
		 * BufferedInputStream(
		 * 			InputStream in)
		 */
		BufferedInputStream bis
			= new BufferedInputStream(
				fis	
			);	
		FileOutputStream fos
			= new FileOutputStream(
				"FileGame_copy4.rar"
			  );
		BufferedOutputStream bos
			= new BufferedOutputStream(
				fos	
			);
		int d = -1;
		while( ( d = bis.read() ) != -1 ){
			bos.write(d);
		}
		
		/*
		 * �ر���ʱ���ر������ĸ߼�������
		 */
		bis.close();
		bos.close();
		
	}
}
