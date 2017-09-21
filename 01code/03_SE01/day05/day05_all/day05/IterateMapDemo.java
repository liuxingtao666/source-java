package day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����Map
 * @author Administrator
 *
 */
public class IterateMapDemo {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		
		map.put("����", 12);
		map.put("����", 23);
		map.put("����", 46);
		map.put("����", 27);
		
		/*
		 * ��ȡ���е�key
		 * Set keySet()
		 * �÷����Ὣmap�����е�key����һ��
		 * set���ϲ�����
		 */
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			System.out.println("key:"+key);
		}
		
		/*
		 * �������еļ�ֵ��
		 * Set entrySet()
		 * 
		 * �÷����ὫMap��ÿһ���ֵ�Դ���Set���ϲ�
		 * ����
		 * 
		 * Map��һ���ڲ���Entry
		 * Entry���������ԣ��ֱ𱣴�key��value
		 * ����һ��Entryʵ�����Ա�ʾһ���ֵ��
		 * 
		 * ���ص�Set�����������ɸ�Entryʵ����
		 * 
		 * EntryҲ֧�ַ��ͣ���Ҫ������������
		 * һ����key��һ����value��
		 * ͨ��Entry�ķ��ͺ����Ӧ��Mapһ�� 
		 */
		//java.util.Map.Entry;
		Set<  Entry<String,Integer>  > entrys
			= map.entrySet();
		
		for(Entry<String,Integer> entry : entrys){
			String key = entry.getKey();//��ȡkey
			Integer value = entry.getValue();//��ȡvalue
			System.out.println(key+":"+value);
			
		}
		
		
	}
}





