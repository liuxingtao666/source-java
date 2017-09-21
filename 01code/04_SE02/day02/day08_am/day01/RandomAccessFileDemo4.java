package day01;

import java.io.RandomAccessFile;

/**
 * 基于缓存的读写操作来完成复制文件
 * @author Administrator
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args)throws Exception {
		RandomAccessFile src
			= new RandomAccessFile(
				"FishGame.rar","r"	
			  );
		
		RandomAccessFile des
			= new RandomAccessFile(
				"FishGame_copy2.rar", "rw"
			  );
		
		//创建一个缓冲区
		byte[] buf = new byte[1024*10];
		//记录每次读取的实际的字节长度
		int len = 0;
		
		
		long start 
		= System.currentTimeMillis();
		
		while(  (len = src.read(buf)) != -1 ){
			des.write(buf,0,len);
		}
		
		long end 
		= System.currentTimeMillis();
		System.out.println("耗时:"+(end-start)+"毫秒");
		
		src.close();
		des.close();
	}
}




