package day04;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 以键值对(key-value)的形式保存元素
 * 我们可以把Map看做一个多行两列的表格
 * @author Administrator
 *
 */
public class HashMapDemo {
	public static void main(String[] args) {
		/*
		 * Map有两个泛型定义
		 * K:key的类型
		 * V:value的类型
		 */
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		
		map.put("张三", 22);
		map.put("李四", 11);
		map.put("王五", 45);
		map.put("传奇", 16);
		map.put("苍松", 50);
		/*
		 * {key=value,key=value....}
		 */
		System.out.println(map);
		/*
		 * 根据给定的key获取对应的value
		 */
		int age = map.get("苍松");
		System.out.println("苍老师今年:"+age);
		/*
		 * 当调用get方法获取value时，若给定的
		 * key在map中不存在，则返回值为null
		 */
		//这里因为会自动拆箱，所以可能引发空指针
//		int age1 = map.get("范传奇");
//		System.out.println(
//				"范老师今年:"+age1);
		
		Integer rv = map.put("苍老师", 22);
		System.out.println(map);
		System.out.println(rv);
		/*
		 * 相同的key是替换value操作，
		 * 返回值为被替换的value
		 */
		rv = map.put("苍老师", 11);
		System.out.println(map);
		System.out.println(rv);
		
		
		/*
		 * Map也支持包含方法
		 * boolean containsKey(Object k)
		 * 查看给定的key是否被包含
		 * 
		 * boolean containsValue(Object v)
		 * 查看给定的value是否被包含
		 */
		
		boolean bk = map.containsKey("传奇");
		System.out.println(
				"key中是否含有传奇:"+bk);
		
		
		boolean bv = map.containsValue(22);
		System.out.println(
				"value中是否含有22:"+bv);
		
		
	}
}



