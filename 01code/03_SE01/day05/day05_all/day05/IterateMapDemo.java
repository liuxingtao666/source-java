package day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历Map
 * @author Administrator
 *
 */
public class IterateMapDemo {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		
		map.put("张三", 12);
		map.put("李四", 23);
		map.put("王五", 46);
		map.put("赵六", 27);
		
		/*
		 * 获取所有的key
		 * Set keySet()
		 * 该方法会将map中所有的key存入一个
		 * set集合并返回
		 */
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历所有的键值对
		 * Set entrySet()
		 * 
		 * 该方法会将Map中每一组键值对存入Set集合并
		 * 返回
		 * 
		 * Map有一个内部类Entry
		 * Entry有两个属性，分别保存key与value
		 * 所以一个Entry实例可以表示一组键值对
		 * 
		 * 返回的Set集合中有若干个Entry实例。
		 * 
		 * Entry也支持泛型，需要声明两个泛型
		 * 一个是key的一个是value的
		 * 通常Entry的泛型和其对应的Map一致 
		 */
		//java.util.Map.Entry;
		Set<  Entry<String,Integer>  > entrys
			= map.entrySet();
		
		for(Entry<String,Integer> entry : entrys){
			String key = entry.getKey();//获取key
			Integer value = entry.getValue();//获取value
			System.out.println(key+":"+value);
			
		}
		
		
	}
}





