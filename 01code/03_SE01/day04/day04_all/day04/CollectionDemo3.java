package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * �����з��͵�ע������
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		
		List<String> list
			= new ArrayList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
//		list.add(1);
		
		List list2 = list;
		list2.add(1);
		
		System.out.println(list.size());
		/*
		 * �����ڻ�ȡԪ��ʱ���Զ�����
		 * ʲôʱ���Զ����ͣ�
		 * ��ȡԪ�غ��ڸ�ֵ��ָ������ʱ
		 */
		String str = list.get(3);
		
		
	}
}
