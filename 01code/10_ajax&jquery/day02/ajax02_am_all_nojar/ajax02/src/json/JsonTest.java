package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Stock;

public class JsonTest {
	/**
	 * java����ת����һ��json�ַ���
	 *	{'code':'600015','name':'ɽ������',
	 *	'price':'20'}
	 */
	public static void test1(){
		Stock s = new Stock();
		s.setCode("600015");
		s.setName("ɽ������");
		s.setPrice("20");
		JSONObject obj = 
			JSONObject.fromObject(s);
		String str = obj.toString();
		System.out.println(str);
	}
	
	/**
	 * ��java������ɵļ���(List)��������ת��
	 * ��һ��json�ַ�����
	 *	[{'code':'600011','name':'ɽ������1',
	 *	'price':'20'},{'code':'600012','name':'ɽ������2',
	 *	'price':'20'},{'code':'600013','name':'ɽ������3',
	 *	'price':'20'}]
	 */
	public static void test2(){
		List<Stock> stocks = 
			new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s = new Stock();
			s.setCode("60001" + (i + 1));
			s.setName("ɽ������"+ (i + 1));
			s.setPrice("20");
			stocks.add(s);
		}
		JSONArray obj = 
			JSONArray.fromObject(stocks);
		String str = obj.toString();
		System.out.println(str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test2();
	}

}
