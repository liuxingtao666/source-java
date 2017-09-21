package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 新循环遍历集合
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
		//新循环遍历集合
		/*
		 * 新循环在编译的过程中会转换为迭代器
		 * 
		 */
		for (String string : c) {
			System.out.println(string);
			/*
			 * 新循环中不能通过集合删除元素
			 * 当然增加元素也不行
			 */
//			c.remove(string);
//			c.add("a");
		}
		
		
	}
}
