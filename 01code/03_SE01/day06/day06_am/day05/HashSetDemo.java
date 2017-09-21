package day04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set集合
 * 不可重复集
 * @author Administrator
 *
 */
public class HashSetDemo {
	public static void main(String[] args) {
		//java.util.Set
		Set<String> set
			= new HashSet<String>();
		/*
		 * hashSet无序指的是存入的顺序与取出
		 * 的顺序不一致，当元素不变的前提下，集合
		 * 内部的存储顺序是一样的
		 */
		set.add("four");
		set.add("five");
		set.add("one");
		set.add("two");
		set.add("three");
		//重复元素将被忽略
		set.add("one");
		
		System.out.println(set);
		System.out.println(set.size());
		
		set.remove("one");
		
		System.out.println(set);
		
		/*
		 * 遍历Set集合
		 */
		Iterator<String> it 
			= set.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
		//新循环
		for(String str : set){
			System.out.println(str);
		}
	}
}










