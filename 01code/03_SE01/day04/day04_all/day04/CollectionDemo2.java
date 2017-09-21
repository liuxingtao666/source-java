package day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合也支持泛型
 * 用来约束集合中元素的类型
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		//泛型用来约束集合中元素类型。
		List<String> c
			= new ArrayList<String>();
		
		c.add("a");//只能存入String
		c.add("b");
		c.add("c");
		for(int i=0;i<c.size();i++){
			//获取元素无须再造型
			String str = c.get(i);
			System.out.println(str);
		}
		//获取迭代器
		/*
		 * 迭代器同样支持泛型
		 * 而迭代器的泛型类型需要与它所遍历的集合的
		 * 泛型类型一致
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
	}
}



