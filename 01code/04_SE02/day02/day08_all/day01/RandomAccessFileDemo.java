package day01;

import java.io.RandomAccessFile;

/**
 * ���ڶ�д�ļ����ݵ���
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args)throws Exception {
		/*
		 * 1:����RAF���ڶ�ȡԭ�ļ�
		 * 2:����RAF����д��Ŀ���ļ�
		 * 3:ѭ������
		 *   3.1:��ԭ�ļ���ȡһ���ֽڣ�ֻҪ����-1
		 *   3.2:����ȡ������ֽ�д��Ŀ���ļ�
		 * 4:������RAF�ر����ͷ���Դ
		 */
		//1
		RandomAccessFile src
			= new RandomAccessFile(
				"FishGame.rar","r"
			  );
		//2
		RandomAccessFile des
			= new RandomAccessFile(
				"FishGame_copy.rar","rw"	
			  );	
		//3
		int d = -1;//����ÿһ�ζ�ȡ��һ���ֽ�
		while( ( d = src.read() ) != -1 ){
			des.write(d);
		}
		
		//4
		src.close();
		des.close();
		System.out.println("�������");
	}
}




