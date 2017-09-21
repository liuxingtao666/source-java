package day02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 测试集合相关方法
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//java.util
		Collection c 
			= new ArrayList();
		
		//向集合中添加元素
		c.add("A");
		c.add("B");
		c.add("C");
		
		System.out.println(c);//[A,B,C]
		
		System.out.println(c.size());//3
		
		System.out.println("是否不含有元素:"+c.isEmpty());
		
		c.clear();//清空集合
		
		System.out.println("是否不含有元素:"+c.isEmpty());
		
		System.out.println(c.size());//0
	}
}




