package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合排序
 * @author Administrator
 *
 */
public class SortCollectionDemo1 {
	public static void main(String[] args) {
		List<Point> list
			= new ArrayList<Point>();
		
		list.add(new Point(1,5));
		list.add(new Point(3,4));
		list.add(new Point(2,2));
		
		/*
		 * 排序集合使用集合的工具类
		 * Collections
		 * Collection与Collections的区别？
		 */
		System.out.println(list);
		//对集合进行自然排序
		Collections.sort(list);
		
		System.out.println(list);
	}
}



