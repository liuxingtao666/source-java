package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 转换为线程安全的集合
 * @author Administrator
 *
 */
public class SyncCollection {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		list = 
			Collections
			.synchronizedList(list);
		
		System.out.println(list);
	}
}




