package day03;

import java.util.LinkedList;

/**
 * Collection�ṩ��һ������
 * ���Խ�����ת��Ϊ����
 * @author Administrator
 *
 */
public class CollectionDemo {
	public static void main(String[] args) {
		LinkedList c
			= new LinkedList();
		c.add("one");
		c.add("two");
		c.add("three");
		
		/*
		 * Object[] toArray()
		 */
		System.out.println(c);
		Object[] array = c.toArray();
		System.out.println(array.length);
		for(int i=0;i<array.length;i++){
			String str 
				= (String)array[i];
			System.out.println(str);
		}
		
		
		/*
		 *	ת��Ϊָ�����͵�����
		 *	ת��ǰ����ָ������������Ҫ�ͼ���
		 *  �д�ŵ�Ԫ������ƥ�� 
		 *  
		 *  �����������鳤�ȿ��Դ�ż���������Ԫ��ʱ
		 *  ��ʹ�ø��������飬�����У��ʹ���������
		 */
		String[] arrays 
			= (String[])
			  c.toArray(new String[2]);
		for(int i=0;i<arrays.length;i++){
			String str = arrays[i]; 
			System.out.println(str);
		}
	}
}










