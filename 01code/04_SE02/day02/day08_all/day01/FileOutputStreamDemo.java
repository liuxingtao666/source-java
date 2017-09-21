package day01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ��ֽ������
 * ���ֽ�Ϊ��λ���ļ���д������
 * @author Administrator
 *
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			
			/*
			 * FileOutputStream(String fileName)
			 * ���ݸ������ļ�·��������Ӧ���ļ������
			 */
//			fos = new FileOutputStream("fos.dat");
			
			/*
			 * FileOutputStream(File file)
			 */
			File file = new File("fos.dat");
			fos = new FileOutputStream(file);
			
			
			/*
			 * д������:
			 * void write(int d)
			 * void write(byte[] d)
			 * void write(byte[] d,int offset,int length)
			 */
			
			fos.write(97);
			
			fos.write("hello".getBytes());
			
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
		

	}
}



