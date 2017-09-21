package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * List 可重复集
 * 两个常用实现：
 * ArrayList&LinkedList
 * 测试get与set方法
 * @author Administrator
 *
 */
public class ListDemo {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		
		//获取第二个元素
		String str = 
			(String)list.get(1);
		System.out.println(str);
		
		//遍历集合
		for(int i=0;i<list.size();i++){
			str = (String)list.get(i);
			System.out.println(str);
		}
		
		/*
		 * set方法:替换元素
		 * 注意:下标的取值应在0到size-1的范围
		 * 否则抛出下标越界
		 * 返回值为被替换的元素
		 */
		System.out.println("被替换的元素:");
		System.out.println(
			list.set(1, "2"));
		System.out.println(list);
		
		/*
		 * List还提供了add和remove方法
		 * 
		 * void add(int index,E e)
		 * 在指定下标位置处插入元素，原位置及
		 * 后去的元素顺序向后移动
		 * 
		 * [one,2,3,three]
		 */
		list.add(2,"3");
		System.out.println(list);
		/*
		 * E remove(int index)
		 * 删除并返回给定下标位置的元素
		 */
		str = (String)list.remove(1);
		System.out.println("deleted:"+str);
		//[one,3,three]
		System.out.println(list);
	}
}




