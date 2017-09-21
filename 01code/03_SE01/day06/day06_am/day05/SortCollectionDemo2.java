package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 集合排序2
 * @author Administrator
 *
 */
public class SortCollectionDemo2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		
		list.add("adm");
		list.add("ben");
		list.add("jazz");
		list.add("BigBoss");
		list.add("Marry");
		list.add("bill");
		list.add("Xiloer");
		list.add("Kate");
		list.add("killer");
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		/*
		 * 排序要求:
		 * 字母少的在前。
		 * 定义一个比较器
		 * 比较规则为字母少的小
		 */
		Comparator<String> comparator
			= new Comparator<String>(){
				/*
				 * 返回值若>0:o1>o2
				 * 返回值若<0:o1<o2
				 * 返回值=0:o1==o2
				 */
				public int compare(String o1, String o2) {
					return o1.length()-o2.length();
				}		
		};
		
		Collections.sort(list, comparator);
		System.out.println(list);
	}
}









