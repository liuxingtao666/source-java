package day04;

import java.util.HashMap;
import java.util.Map;

/**
 * Map �Լ�ֵ��(key-value)����ʽ����Ԫ��
 * ���ǿ��԰�Map����һ���������еı��
 * @author Administrator
 *
 */
public class HashMapDemo {
	public static void main(String[] args) {
		/*
		 * Map���������Ͷ���
		 * K:key������
		 * V:value������
		 */
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		
		map.put("����", 22);
		map.put("����", 11);
		map.put("����", 45);
		map.put("����", 16);
		map.put("����", 50);
		/*
		 * {key=value,key=value....}
		 */
		System.out.println(map);
		/*
		 * ���ݸ�����key��ȡ��Ӧ��value
		 */
		int age = map.get("����");
		System.out.println("����ʦ����:"+age);
		/*
		 * ������get������ȡvalueʱ����������
		 * key��map�в����ڣ��򷵻�ֵΪnull
		 */
		//������Ϊ���Զ����䣬���Կ���������ָ��
//		int age1 = map.get("������");
//		System.out.println(
//				"����ʦ����:"+age1);
		
		Integer rv = map.put("����ʦ", 22);
		System.out.println(map);
		System.out.println(rv);
		/*
		 * ��ͬ��key���滻value������
		 * ����ֵΪ���滻��value
		 */
		rv = map.put("����ʦ", 11);
		System.out.println(map);
		System.out.println(rv);
		
		
		/*
		 * MapҲ֧�ְ�������
		 * boolean containsKey(Object k)
		 * �鿴������key�Ƿ񱻰���
		 * 
		 * boolean containsValue(Object v)
		 * �鿴������value�Ƿ񱻰���
		 */
		
		boolean bk = map.containsKey("����");
		System.out.println(
				"key���Ƿ��д���:"+bk);
		
		
		boolean bv = map.containsValue(22);
		System.out.println(
				"value���Ƿ���22:"+bv);
		
		
	}
}



