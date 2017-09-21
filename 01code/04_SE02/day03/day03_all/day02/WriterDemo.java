package day02;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriterDemo {
	public static void main(String[] args) 
		throws IOException {
		//打开一个文件
		Writer out = 
			new OutputStreamWriter(
			new BufferedOutputStream(
			new FileOutputStream("a.txt"))
			,"utf-8");
		//将字符'好'按照utf-8编码为byte，写入
		//到文件中。
		out.write('好');//可以将字符写入文件
		out.write('好');
		out.close();
		File f = new File("a.txt");
		System.out.println(f.length());
	}
}
