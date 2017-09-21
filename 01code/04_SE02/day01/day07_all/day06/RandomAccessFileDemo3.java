package day06;

import java.io.RandomAccessFile;

/**
 * ���ڶ�д���������ļ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args)throws Exception {
		
		/*
		 * ˼·:
		 *   1:����һ��RAF������ȡԭ�ļ�
		 *   2:����һ��RAF������Ŀ���ļ���д
		 *   3:ѭ������
		 *     3.1: ��ԭ�ļ���ȡһ���ֽ�
		 *     3.2: �����ֽ�д��Ŀ���ļ�
		 *   4:�ر�����RAF  
		 */
		//1
		RandomAccessFile src
			= new RandomAccessFile(
					"FishGame.rar","r");
		
		//2
		RandomAccessFile des
			= new RandomAccessFile(
					"FishGame_copy.rar", "rw");
		
		//3
		int d = 0;//����ÿ�ζ�ȡ��1���ֽ�
		while( ( d =src.read() ) != -1 ){
			des.write(d);
		}
		
		//4
		src.close();
		des.close();		
		System.out.println("�������!");
	}
}
