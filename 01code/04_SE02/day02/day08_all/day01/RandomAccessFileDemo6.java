package day01;

import java.io.RandomAccessFile;

/**
 * 追加写操作
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
		 * 将游标移动到文件的末尾
		 * 
		 */
		raf.seek(raf.length());
		
		raf.write(97);
		
		raf.close();
	}
}




