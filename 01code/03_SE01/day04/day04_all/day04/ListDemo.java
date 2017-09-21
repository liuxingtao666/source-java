package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * List ���ظ���
 * ��������ʵ�֣�
 * ArrayList&LinkedList
 * ����get��set����
 * @author Administrator
 *
 */
public class ListDemo {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		
		//��ȡ�ڶ���Ԫ��
		String str = 
			(String)list.get(1);
		System.out.println(str);
		
		//��������
		for(int i=0;i<list.size();i++){
			str = (String)list.get(i);
			System.out.println(str);
		}
		
		/*
		 * set����:�滻Ԫ��
		 * ע��:�±��ȡֵӦ��0��size-1�ķ�Χ
		 * �����׳��±�Խ��
		 * ����ֵΪ���滻��Ԫ��
		 */
		System.out.println("���滻��Ԫ��:");
		System.out.println(
			list.set(1, "2"));
		System.out.println(list);
		
		/*
		 * List���ṩ��add��remove����
		 * 
		 * void add(int index,E e)
		 * ��ָ���±�λ�ô�����Ԫ�أ�ԭλ�ü�
		 * ��ȥ��Ԫ��˳������ƶ�
		 * 
		 * [one,2,3,three]
		 */
		list.add(2,"3");
		System.out.println(list);
		/*
		 * E remove(int index)
		 * ɾ�������ظ����±�λ�õ�Ԫ��
		 */
		str = (String)list.remove(1);
		System.out.println("deleted:"+str);
		//[one,3,three]
		System.out.println(list);
	}
}




