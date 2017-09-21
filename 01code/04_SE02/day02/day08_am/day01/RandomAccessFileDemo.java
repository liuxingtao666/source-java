package day01;

import java.io.RandomAccessFile;

/**
 * 用于读写文件内容的类
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args)throws Exception {
		/*
		 * 1:创建RAF用于读取原文件
		 * 2:创建RAF用于写入目标文件
		 * 3:循环操作
		 *   3.1:从原文件读取一个字节，只要不是-1
		 *   3.2:将读取的这个字节写入目标文件
		 * 4:将两个RAF关闭以释放资源
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
		int d = -1;//保存每一次读取的一个字节
		while( ( d = src.read() ) != -1 ){
			des.write(d);
		}
		
		//4
		src.close();
		des.close();
		System.out.println("复制完毕");
	}
}




