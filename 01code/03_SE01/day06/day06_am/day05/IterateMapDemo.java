package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ����Map�����е�value
 * @author Administrator
 *
 */
public class IterateMapDemo {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("����", 12);
		map.put("����", 67);
		map.put("����", 12);
		//��ȡMap�����е�value
		Collection<Integer> values 
			= map.values();
		//�������е�value
		for(Integer i : values){
			System.out.println(i);
		}
		
	}
	
}










