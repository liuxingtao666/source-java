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
		 * FileWriter������������ļ���д���ַ�
		 * FileWriter�������޸��ַ��������Ҫע�⡣
		 */
		FileWriter writer
			= new FileWriter("bos.txt");
		
		/*
		 * ���췽���в���Ҫ����Writer
		 */
		BufferedWriter bw
			= new BufferedWriter(writer);
		
		
		bw.write("helloworld");
		bw.newLine();
		bw.write("���");
		
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




