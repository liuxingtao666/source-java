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
		//��һ���ļ�
		Writer out = 
			new OutputStreamWriter(
			new BufferedOutputStream(
			new FileOutputStream("a.txt"))
			,"utf-8");
		//���ַ�'��'����utf-8����Ϊbyte��д��
		//���ļ��С�
		out.write('��');//���Խ��ַ�д���ļ�
		out.write('��');
		out.close();
		File f = new File("a.txt");
		System.out.println(f.length());
	}
}
