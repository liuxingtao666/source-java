package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * List�����ṩ��һ�����������Ի�ȡ�ü��ϵ��Ӽ�:
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
		 * ��ȡ�Ӽ� 3-7
		 * java api��ʹ������������������Χ
		 * �����϶��Ǻ�ͷ����β��
		 */
		List<Integer> subList
			= list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * �޸��Ӽ�Ԫ��
		 */
		for(int i=0;i<subList.size();i++){
			/*
			 * �򻯴����ԭ��:�������ϣ���������
			 */
			int num = subList.get(i);
			num = num * 10;
			subList.set(i, num);
		}
		System.out.println(subList);
		System.out.println(list);
		
		//���Ӽ������Ԫ��
		subList.add(100);
		System.out.println(subList);
		System.out.println(list);
		
		//���Ӽ���ɾ��һ��Ԫ��
		subList.remove(0);
		System.out.println(subList);
		System.out.println(list);
		/*
		 * �����Ӽ��൱�ڲ���ԭ�����е��ǲ�������
		 */
	}
}





