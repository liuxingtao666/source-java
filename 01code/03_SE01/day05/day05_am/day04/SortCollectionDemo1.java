package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ��������
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
		 * ���򼯺�ʹ�ü��ϵĹ�����
		 * Collections
		 * Collection��Collections������
		 */
		System.out.println(list);
		//�Լ��Ͻ�����Ȼ����
		Collections.sort(list);
		
		System.out.println(list);
	}
}



