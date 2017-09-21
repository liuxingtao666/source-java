package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) 
		throws Exception {
		//PrintWriter提供了功能强大println
		PrintWriter out = 
			new PrintWriter(
			new OutputStreamWriter(
			new BufferedOutputStream(
			new FileOutputStream("b.txt")
			),"utf-8"));
		//println()输出文本一行会追加回车
		out.println("好好学习天天向上");
		out.println("好好学习天天向上");
		out.close();	
	}
}



