package day02;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ������ط�������
 * 
 * @author Administrator
 * 
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		Collection c3 = new ArrayList();
		
		c1.add("one");
		c1.add("two");
		c1.add("three");
		
		c2.add("four");
		c2.add("five");
		
		c3.add("one");
		c3.add("two");
		
		/*
		 * ��c2�е�����Ԫ����ӵ�c1��
		 */
		c1.addAll(c2);//[one,two,three,four,five]
		System.out.println(c1);
		
		/*
		 * ɾ��c1����c3��ͬ��Ԫ��
		 */
		c1.removeAll(c3);
		//[three,four,five]
		System.out.println(c1);
		
		/*
		 * ȡ����
		 * ֻ����c1����c2��ͬ��Ԫ��
		 */
		//[four,five]
		c1.retainAll(c2);
		System.out.println(c1);
	}
}




