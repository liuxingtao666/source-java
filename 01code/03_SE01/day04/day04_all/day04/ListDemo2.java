package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * List其它方法
 * @author Administrator
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("3");
		list.add("4");
		//[1,2,3,3,4]
		System.out.println(list);
		System.out.println(
				list.indexOf("3"));//2
		System.out.println(
				list.lastIndexOf("3"));//3
		
	}
}
