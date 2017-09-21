package day02;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试集合相关方法
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c 
			= new ArrayList();
		
		c.add(new Point(1,2));
		c.add(new Point(1,2));
		c.add(new Point(1,2));
		/*
		 * [(1,2) , (3,4) , (5,6)]
		 * 
		 * 集合重写toString的格式
		 * [元素1.toString(), 元素2.toString(),...]
		 */
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * contains方法会将给定的元素与集合中
		 * 每一个元素顺序进行equals比较，只要
		 * 有元素比较结果为true,这认为集合包含
		 * 该元素
		 */
		if(c.contains(p)){
			System.out.println("包含");
			/*
			 * remove方法:
			 * 集合会使用给定元素与集合中每个元素
			 * 依次比较，删除【第一个】与给定元素equals
			 * 比较为true的元素。
			 */
			c.remove(p);
			System.out.println(c);
		}else{
			System.out.println("不包含");
		}
	}
}





