package day06;

import java.io.RandomAccessFile;

/**
 * ��ȡ�ļ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args)throws Exception {
		
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","r"
			  );
		/*
		 * int read()
		 * ��ȡ1���ֽڣ���������intֵ����ʽ����
		 * ʵ�������intֵֻ�е�8λ��Ч
		 * ���÷�������ֵΪ-1,���ʾ�ļ���ȡ����
		 * ĩβ EOF (End of File)
		 */
		int d = raf.read();
		System.out.println(d);
		//�ٴζ�ȡ1���ֽ�
		d = raf.read();
		System.out.println(d);//?
		raf.close();
	}
}
