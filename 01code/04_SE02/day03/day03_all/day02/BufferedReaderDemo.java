package day02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * ��ȡ�ı��ļ� 
 */
public class BufferedReaderDemo {
	public static void main(String[] args) 
		throws Exception{
		//BufferedReader �ṩ�˹���ǿ���
		//ReadLine ��ȡһ�еķ���
		BufferedReader in = 
			new BufferedReader(//���ж�ȡ
			new InputStreamReader(//��ȡ�ļ�
			new BufferedInputStream( //��߶�Ч��
			new FileInputStream("b.txt")//���ļ�
			),"utf-8"));
		String str = in.readLine();
		System.out.println(str);
		str = in.readLine();
		System.out.println(str);
		str = in.readLine();//null,�ļ�β��
		System.out.println(str);
		in.close();
	}

}



