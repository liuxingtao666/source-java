package day02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * ���Լ�����ط���
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//java.util
		Collection c 
			= new ArrayList();
		
		//�򼯺������Ԫ��
		c.add("A");
		c.add("B");
		c.add("C");
		
		System.out.println(c);//[A,B,C]
		
		System.out.println(c.size());//3
		
		System.out.println("�Ƿ񲻺���Ԫ��:"+c.isEmpty());
		
		c.clear();//��ռ���
		
		System.out.println("�Ƿ񲻺���Ԫ��:"+c.isEmpty());
		
		System.out.println(c.size());//0
	}
}




