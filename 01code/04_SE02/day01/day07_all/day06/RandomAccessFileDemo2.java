package day06;

import java.io.RandomAccessFile;

/**
 * 读取文件
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
		 * 读取1个字节，但是是以int值的形式返回
		 * 实际上这个int值只有低8位有效
		 * 若该方法返回值为-1,则表示文件读取到了
		 * 末尾 EOF (End of File)
		 */
		int d = raf.read();
		System.out.println(d);
		//再次读取1个字节
		d = raf.read();
		System.out.println(d);//?
		raf.close();
	}
}
