package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ��ѭ����������
 * @author Administrator
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection<String> c
			= new ArrayList<String>();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		//��ѭ����������
		/*
		 * ��ѭ���ڱ���Ĺ����л�ת��Ϊ������
		 * 
		 */
		for (String string : c) {
			System.out.println(string);
			/*
			 * ��ѭ���в���ͨ������ɾ��Ԫ��
			 * ��Ȼ����Ԫ��Ҳ����
			 */
//			c.remove(string);
//			c.add("a");
		}
		
		
	}
}
