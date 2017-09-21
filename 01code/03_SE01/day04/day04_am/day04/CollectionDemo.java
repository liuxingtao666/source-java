package day03;

import java.util.LinkedList;

/**
 * Collection提供了一个方法
 * 可以将集合转换为数组
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
		 *	转换为指定类型的数组
		 *	转换前提是指定的数组类型要和集合
		 *  中存放的元素类型匹配 
		 *  
		 *  当给定的数组长度可以存放集合中所有元素时
		 *  就使用给定的数组，若不行，就创建新数组
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










