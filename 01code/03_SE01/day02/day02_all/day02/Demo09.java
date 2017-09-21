package day02;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Date
 */
public class Demo09 {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		System.out.println(year+","+month); 
		SimpleDateFormat fmt1 
			= new SimpleDateFormat();//系统默认的格式
		SimpleDateFormat fmt2 
			= new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
		String d1 = fmt1.format(date);
		String d2 = fmt2.format(date);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(fmt2.format(0)); 
		System.out.println(fmt2.format(now)); 
		System.out.println(fmt2.format(5)); 
		System.out.println(
				fmt2.format(1000L*60*60*24)); 
		System.out.println(
				fmt2.format(now + 1000L*60*60*24)); 
	}
}


