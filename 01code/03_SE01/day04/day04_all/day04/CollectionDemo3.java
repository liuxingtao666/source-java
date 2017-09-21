package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合中泛型的注意事项
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		
		List<String> list
			= new ArrayList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
//		list.add(1);
		
		List list2 = list;
		list2.add(1);
		
		System.out.println(list.size());
		/*
		 * 泛型在获取元素时会自动造型
		 * 什么时候自动造型？
		 * 获取元素后在赋值给指定变量时
		 */
		String str = list.get(3);
		
		
	}
}
