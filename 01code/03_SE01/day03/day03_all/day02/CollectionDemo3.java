package day02;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合相关方法测试
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
		 * 将c2中的所有元素添加到c1中
		 */
		c1.addAll(c2);//[one,two,three,four,five]
		System.out.println(c1);
		
		/*
		 * 删除c1中与c3相同的元素
		 */
		c1.removeAll(c3);
		//[three,four,five]
		System.out.println(c1);
		
		/*
		 * 取交集
		 * 只保留c1中与c2相同的元素
		 */
		//[four,five]
		c1.retainAll(c2);
		System.out.println(c1);
	}
}




