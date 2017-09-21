package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection提供了一个方法
 * Iterator iterator()
 * 该方法会获取一个迭代器，用于遍历集合
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
		 * 迭代器遍历元素时要遵循:
		 * 问取删(删不是必须的)
		 * 取之前一定要确保问过，并且有元素
		 * 
		 * 问: boolean hasNext()
		 * 	  集合中是否还有元素可以遍历
		 * 
		 * 取: E next()
		 * 	 将该元素取出
		 * 
		 * 
		 * 若需要在迭代过程中删除集合元素，我们不能
		 * 通过调用集合的删除方法，而是使用迭代器的
		 * 删除方法。否者会抛出异常。
		 * 
		 * 迭代器的删除方法:
		 * void remove()
		 * 删除上一次next方法获取的元素.
		 * remove方法只能在next被执行后调用一次。
		 */
		while(it.hasNext()){
			String str = (String)it.next();
			if(str.equals("*")){
//				c.remove(str); //不允许
				it.remove();
//				it.remove();//不允许
			}
		}
		System.out.println(c);
	}
}









