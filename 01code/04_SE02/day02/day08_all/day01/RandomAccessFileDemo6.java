package day01;

import java.io.RandomAccessFile;

/**
 * ׷��д����
 * @author Administrator
 *
 */
public class RandomAccessFileDemo6 {
	public static void main(String[] args)throws Exception {
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.dat",
				"rw"
			  );

		/*
		 * ���α��ƶ����ļ���ĩβ
		 * 
		 */
		raf.seek(raf.length());
		
		raf.write(97);
		
		raf.close();
	}
}




