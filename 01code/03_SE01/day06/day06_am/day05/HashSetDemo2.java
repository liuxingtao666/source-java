package day04;

import java.util.HashSet;
import java.util.Set;

/**
 * ����hashcode��HashSet��Ӱ��
 * @author Administrator
 *
 */
public class HashSetDemo2 {
	public static void main(String[] args) {
		Element e = new Element(1,2);
		
		Set<Element> set
			= new HashSet<Element>();
		System.out.println("hash:"+e.hashCode());
		set.add(e);
		System.out.println(set.size());
		System.out.println(set);
		
		//�ڶ��η���
		set.add(e);//��ͬ�������ظ�����
		System.out.println(set.size());
		System.out.println(set);
		
		//�����η���
		System.out.println("hash:"+e.hashCode());
		e.setX(2);
		System.out.println("newhash:"+e.hashCode());
		System.out.println(set.contains(e));//?
		set.add(e);//�ڶ��η����˼�����
		System.out.println(set.size());
		System.out.println(set);
		
		//ɾ��e
		set.remove(e);
		System.out.println(set);
		
		set.remove(e);
		System.out.println(set);
		
		//��ɾ����һ�δ����e����Ҫ��hashcode��ԭ
		System.out.println(e.hashCode());
		e.setX(1);
		System.out.println(e.hashCode());
		
		System.out.println(set.contains(e));
		
		set.remove(e);
		System.out.println(set);
	}
}








