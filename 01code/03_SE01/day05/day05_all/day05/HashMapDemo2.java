package day04;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap��key��ò�Ҫ��ʹ��ʱ�޸�������
 * ����hashcodeֵ�ı��ˣ���Ӱ�����
 * @author Administrator
 *
 */
public class HashMapDemo2 {
	public static void main(String[] args) {
		Map<Element,String> map
			= new HashMap<Element,String>();
		
		Element key = new Element(1,2);
		
		map.put(key, "����");
		
		System.out.println(map);
		
		System.out.println(
			map.containsKey(key));//true
			
		map.put(key, "����");
		System.out.println(map);
		
		
		key.setX(2);//key��hashcode����
		
		System.out.println(
			map.containsKey(key));
		
		map.put(key, "����");
		System.out.println(map);
		
		
		String str = map.get(key);
		System.out.println(str);
		
		//���ȡ����
		key.setX(1);
		str = map.get(key);
		System.out.println(str);
		
		
	}
}





