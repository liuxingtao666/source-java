package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) 
		throws Exception {
		//PrintWriter�ṩ�˹���ǿ��println
		PrintWriter out = 
			new PrintWriter(
			new OutputStreamWriter(
			new BufferedOutputStream(
			new FileOutputStream("b.txt")
			),"utf-8"));
		//println()����ı�һ�л�׷�ӻس�
		out.println("�ú�ѧϰ��������");
		out.println("�ú�ѧϰ��������");
		out.close();	
	}
}



