package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Stock;

public class JsonTest {
	/**
	 * java对象转换成一个json字符串
	 *	{'code':'600015','name':'山东高速',
	 *	'price':'20'}
	 */
	public static void test1(){
		Stock s = new Stock();
		s.setCode("600015");
		s.setName("山东高速");
		s.setPrice("20");
		JSONObject obj = 
			JSONObject.fromObject(s);
		String str = obj.toString();
		System.out.println(str);
	}
	
	/**
	 * 将java对象组成的集合(List)或者数组转换
	 * 成一个json字符串。
	 *	[{'code':'600011','name':'山东高速1',
	 *	'price':'20'},{'code':'600012','name':'山东高速2',
	 *	'price':'20'},{'code':'600013','name':'山东高速3',
	 *	'price':'20'}]
	 */
	public static void test2(){
		List<Stock> stocks = 
			new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s = new Stock();
			s.setCode("60001" + (i + 1));
			s.setName("山东高速"+ (i + 1));
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
