package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection�ṩ��һ������
 * Iterator iterator()
 * �÷������ȡһ�������������ڱ�������
 * @author Administrator
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		
		Collection c
			= new ArrayList();
		c.add("a");
		c.add("*");
		c.add("b");
		c.add("*");
		c.add("c");
		c.add("*");
		c.add("d");
		
		Iterator it = c.iterator();
		/*
		 * ����������Ԫ��ʱҪ��ѭ:
		 * ��ȡɾ(ɾ���Ǳ����)
		 * ȡ֮ǰһ��Ҫȷ���ʹ���������Ԫ��
		 * 
		 * ��: boolean hasNext()
		 * 	  �������Ƿ���Ԫ�ؿ��Ա���
		 * 
		 * ȡ: E next()
		 * 	 ����Ԫ��ȡ��
		 * 
		 * 
		 * ����Ҫ�ڵ���������ɾ������Ԫ�أ����ǲ���
		 * ͨ�����ü��ϵ�ɾ������������ʹ�õ�������
		 * ɾ�����������߻��׳��쳣��
		 * 
		 * ��������ɾ������:
		 * void remove()
		 * ɾ����һ��next������ȡ��Ԫ��.
		 * remove����ֻ����next��ִ�к����һ�Ρ�
		 */
		while(it.hasNext()){
			String str = (String)it.next();
			if(str.equals("*")){
//				c.remove(str); //������
				it.remove();
//				it.remove();//������
			}
		}
		System.out.println(c);
	}
}









