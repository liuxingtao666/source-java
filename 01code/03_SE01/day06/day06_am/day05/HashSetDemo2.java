package day04;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试hashcode对HashSet的影响
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
		
		//第二次放入
		set.add(e);//相同对象不能重复放入
		System.out.println(set.size());
		System.out.println(set);
		
		//第三次放入
		System.out.println("hash:"+e.hashCode());
		e.setX(2);
		System.out.println("newhash:"+e.hashCode());
		System.out.println(set.contains(e));//?
		set.add(e);//第二次放入了集合中
		System.out.println(set.size());
		System.out.println(set);
		
		//删除e
		set.remove(e);
		System.out.println(set);
		
		set.remove(e);
		System.out.println(set);
		
		//想删除第一次存入的e，需要将hashcode还原
		System.out.println(e.hashCode());
		e.setX(1);
		System.out.println(e.hashCode());
		
		System.out.println(set.contains(e));
		
		set.remove(e);
		System.out.println(set);
	}
}








