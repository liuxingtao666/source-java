package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ��������2
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
		 * ����Ҫ��:
		 * ��ĸ�ٵ���ǰ��
		 * ����һ���Ƚ���
		 * �ȽϹ���Ϊ��ĸ�ٵ�С
		 */
		Comparator<String> comparator
			= new Comparator<String>(){
				/*
				 * ����ֵ��>0:o1>o2
				 * ����ֵ��<0:o1<o2
				 * ����ֵ=0:o1==o2
				 */
				public int compare(String o1, String o2) {
					return o1.length()-o2.length();
				}		
		};
		
		Collections.sort(list, comparator);
		System.out.println(list);
	}
}









