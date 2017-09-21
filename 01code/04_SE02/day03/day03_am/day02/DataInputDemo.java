package day02;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 数据输入流 
 *
 */
public class DataInputDemo {
	public static void main(String[] args) 
			throws IOException {
		/** 打开文件 */
		DataInputStream in = 
			new DataInputStream(
			new BufferedInputStream(
			new FileInputStream("d.dat")));
		int row = in.readInt();
		int col = in.readInt();
		System.out.println(row+","+col);
		double pi = in.readDouble();
		System.out.println(pi);
		in.close();
	}

}



