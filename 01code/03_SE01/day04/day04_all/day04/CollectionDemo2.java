package day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����Ҳ֧�ַ���
 * ����Լ��������Ԫ�ص�����
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		//��������Լ��������Ԫ�����͡�
		List<String> c
			= new ArrayList<String>();
		
		c.add("a");//ֻ�ܴ���String
		c.add("b");
		c.add("c");
		for(int i=0;i<c.size();i++){
			//��ȡԪ������������
			String str = c.get(i);
			System.out.println(str);
		}
		//��ȡ������
		/*
		 * ������ͬ��֧�ַ���
		 * ���������ķ���������Ҫ�����������ļ��ϵ�
		 * ��������һ��
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
	}
}



