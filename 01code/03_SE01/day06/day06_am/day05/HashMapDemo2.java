package day04;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap的key最好不要在使用时修改其内容
 * 否则hashcode值改变了，会影响操作
 * @author Administrator
 *
 */
public class HashMapDemo2 {
	public static void main(String[] args) {
		Map<Element,String> map
			= new HashMap<Element,String>();
		
		Element key = new Element(1,2);
		
		map.put(key, "传奇");
		
		System.out.println(map);
		
		System.out.println(
			map.containsKey(key));//true
			
		map.put(key, "苍松");
		System.out.println(map);
		
		
		key.setX(2);//key的hashcode变了
		
		System.out.println(
			map.containsKey(key));
		
		map.put(key, "传奇");
		System.out.println(map);
		
		
		String str = map.get(key);
		System.out.println(str);
		
		//想获取苍松
		key.setX(1);
		str = map.get(key);
		System.out.println(str);
		
		
	}
}





