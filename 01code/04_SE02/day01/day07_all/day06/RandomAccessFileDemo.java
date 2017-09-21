package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * ���ڶ�д�ļ�����
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			/*
			 * RandomAccessFile(
			 * 		String filePath,String mode)
			 * ����1:�ļ���·��
			 * ����2:ģʽ  ���ֳ��õ�"r" , "rw"
			 * 
			 * RandomAccessFile���Զ����Ҫ������
			 * �ļ��Ƿ���ڣ��������򴴽�.
			 * �������ļ�ʧ�ܣ�
			 * ���׳�FileNotFoundException
			 */
//			raf = new RandomAccessFile(
//					"raf.dat",
//					"rw"
//				  );
			
			/*
			 * RandomAccessFile(
			 * 			File file,String mode)
			 * �������ڸ�����File�������������ļ�
			 * ���ж�д������RandomAccessFile
			 */
			File file 
				= new File("raf.dat");
			raf = new RandomAccessFile(
					file,
					"rw"
				  );
			
			/*
			 * ��д�ļ��ǰ����ֽ�Ϊ��λ���е�
			 */
			/*
			 * RandomAccessFile�ṩ�˺ܶ��д����
			 * ���������:
			 * void write(int d)
			 * дһ���ֽڣ�д���Ǹ�����intֵ��"�Ͱ�λ"
			 */
			System.out.println(Integer.toBinaryString((int)'a'));
			//                           vvvvvvvv
			//00000000 00000000 00000001 00000000
			raf.write(257);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(raf != null){
					raf.close();
				}				
			} catch (IOException e) {
			} 
		}
		
		
		
	}
}



