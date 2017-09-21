package day06;

import java.io.RandomAccessFile;

/**
 * 基于读写方法复制文件
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args)throws Exception {
		
		/*
		 * 思路:
		 *   1:创建一个RAF用来读取原文件
		 *   2:创建一个RAF用来向目标文件中写
		 *   3:循环操作
		 *     3.1: 从原文件读取一个字节
		 *     3.2: 将该字节写到目标文件
		 *   4:关闭两个RAF  
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
		int d = 0;//保存每次读取的1个字节
		while( ( d =src.read() ) != -1 ){
			des.write(d);
		}
		
		//4
		src.close();
		des.close();		
		System.out.println("拷贝完毕!");
	}
}
