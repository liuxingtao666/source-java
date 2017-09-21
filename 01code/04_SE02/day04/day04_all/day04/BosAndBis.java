package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * FileReader FileWriter
 * @author Administrator
 *
 */
public class BosAndBis {
	public static void main(String[] args)throws Exception {
//		FileOutputStream fos
//			= new FileOutputStream("bos.txt");
//		
//		OutputStreamWriter osw
//			= new OutputStreamWriter(fos);
		/*
		 * FileWriter可以向给定的文件中写出字符
		 * FileWriter不允许修改字符集，这个要注意。
		 */
		FileWriter writer
			= new FileWriter("bos.txt");
		
		/*
		 * 构造方法中参数要求传入Writer
		 */
		BufferedWriter bw
			= new BufferedWriter(writer);
		
		
		bw.write("helloworld");
		bw.newLine();
		bw.write("随便");
		
		bw.close();
		
		
		
//		FileInputStream fis	
//			= new FileInputStream("bos.txt");
//		
//		InputStreamReader isr
//			= new InputStreamReader(fis);
		
		
		FileReader reader
			= new FileReader("bos.txt");
		
		BufferedReader br
			= new BufferedReader(reader);
		
		
		br.readLine();
		
	}
}




