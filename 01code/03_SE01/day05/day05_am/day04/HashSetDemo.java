package day04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set����
 * �����ظ���
 * @author Administrator
 *
 */
public class HashSetDemo {
	public static void main(String[] args) {
		//java.util.Set
		Set<String> set
			= new HashSet<String>();
		/*
		 * hashSet����ָ���Ǵ����˳����ȡ��
		 * ��˳��һ�£���Ԫ�ز����ǰ���£�����
		 * �ڲ��Ĵ洢˳����һ����
		 */
		set.add("four");
		set.add("five");
		set.add("one");
		set.add("two");
		set.add("three");
		//�ظ�Ԫ�ؽ�������
		set.add("one");
		
		System.out.println(set);
		System.out.println(set.size());
		
		set.remove("one");
		
		System.out.println(set);
		
		/*
		 * ����Set����
		 */
		Iterator<String> it 
			= set.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
		//��ѭ��
		for(String str : set){
			System.out.println(str);
		}
	}
}










