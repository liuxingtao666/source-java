package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 用于读写文件的类
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
			 * 参数1:文件的路径
			 * 参数2:模式  两种常用的"r" , "rw"
			 * 
			 * RandomAccessFile会自动检测要操作的
			 * 文件是否存在，不存在则创建.
			 * 若创建文件失败，
			 * 会抛出FileNotFoundException
			 */
//			raf = new RandomAccessFile(
//					"raf.dat",
//					"rw"
//				  );
			
			/*
			 * RandomAccessFile(
			 * 			File file,String mode)
			 * 创建基于给定的File对象所描述的文件
			 * 进行读写操作的RandomAccessFile
			 */
			File file 
				= new File("raf.dat");
			raf = new RandomAccessFile(
					file,
					"rw"
				  );
			
			/*
			 * 读写文件是按照字节为单位进行的
			 */
			/*
			 * RandomAccessFile提供了很多的写方法
			 * 最基础的是:
			 * void write(int d)
			 * 写一个字节，写的是给定的int值的"低八位"
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



