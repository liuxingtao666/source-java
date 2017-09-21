package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 遍历Map中所有的value
 * @author Administrator
 *
 */
public class IterateMapDemo {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("张三", 12);
		map.put("李四", 67);
		map.put("王五", 12);
		//获取Map中所有的value
		Collection<Integer> values 
			= map.values();
		//遍历所有的value
		for(Integer i : values){
			System.out.println(i);
		}
		
	}
	
}










