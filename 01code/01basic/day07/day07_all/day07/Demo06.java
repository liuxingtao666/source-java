package day07;

import java.util.Arrays;

public class Demo06 {
	public static void main(String[] args) {
		char c = 65;
		int a = 65;		
		System.out.println(c);//'A'
		System.out.println(a);//65
//Java API �ṩ�� ���ص� println����
//Ҳ����˵:������println(char) println(int) 
// ��ͬ�ķ�����
		char[] chs = {65,66,67};
		int[] ary = {65,66,67};
		//println(char[]) �����ַ������
		System.out.println(chs);//ABC
		//println(Object) �����toString()���
		System.out.println(ary);//[I@de6ced
		//���������������
		//println(String) 
		System.out.println(Arrays.toString(ary));
		//System.out.
	}
}
