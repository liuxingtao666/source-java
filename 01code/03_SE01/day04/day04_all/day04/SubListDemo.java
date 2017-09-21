package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合提供了一个方法，可以获取该集合的子集:
 * 
 * List<E> subList(int fromIndex,int toIndex)
 * 
 * @author Administrator
 *
 */
public class SubListDemo {
	public static void main(String[] args) {
		List<Integer> list
			= new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);	
		/*
		 * 获取子集 3-7
		 * java api中使用两个数字来描述范围
		 * 基本上都是含头不含尾的
		 */
		List<Integer> subList
			= list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * 修改子集元素
		 */
		for(int i=0;i<subList.size();i++){
			/*
			 * 简化代码的原则:从下往上，等量代换
			 */
			int num = subList.get(i);
			num = num * 10;
			subList.set(i, num);
		}
		System.out.println(subList);
		System.out.println(list);
		
		//向子集中添加元素
		subList.add(100);
		System.out.println(subList);
		System.out.println(list);
		
		//从子集中删除一个元素
		subList.remove(0);
		System.out.println(subList);
		System.out.println(list);
		/*
		 * 操作子集相当于操作原集合中的那部分内容
		 */
	}
}





