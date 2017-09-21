package day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java中的日期
 * @author Administrator
 *
 */
public class DateDemo {
	public static void main(String[] args) throws ParseException {
		//表示当前系统时间
		Date date = new Date();
		
		System.out.println(date);
		/*
		 * SimpleDateFormat
		 * 用于在字符串与日期间相互转换
		 * Date ==> SimpleDateFormat ==> String
		 * String ==> SimpleDateFormat ==> Date
		 * 两者之间转换的桥梁是日期格式字符串
		 * 
		 */
//		SimpleDateFormat sdf
//			= new SimpleDateFormat(
//				"yyyy-MM-dd HH:mm:ss");
//		
//		String str = sdf.format(date);
//		System.out.println(str);
//		
//		/*
//		 * String -> Date
//		 */
//		String dateStr = "11-25-2012";
//		SimpleDateFormat sdf2
//			= new SimpleDateFormat(
//				"MM-dd-yyyy"
//			);
//		Date date2 = sdf2.parse(dateStr);
//		System.out.println(date2);
		
		
		Calendar calendar
			= Calendar.getInstance();
		
		/*
		 * Date -> Calendar Calendar.setTime()
		 * Calendar -> Date Calendar.getTime()
		 * 
		 */
	
		//2011-3-20
		calendar.set(Calendar.YEAR, 2011);
		/*
		 * DAY_OF_YEAR
		 * 
		 * DAY_OF_MONTH == DATE
		 * 
		 * DAY_OF_WEEK
		 * 
		 * 
		 */
		//Calendar支持溢出进位
		calendar.set(Calendar.DATE, 32);
		System.out.println(calendar.getTime());
	
		int month = 
			calendar.get(Calendar.MONTH);
		System.out.println(
			"现在是:"+(month+1)+"月");
		
		//在当前时间上加1天
		calendar.add(
				Calendar.DAY_OF_YEAR, 1);
		System.out.println(
			calendar.getTime()
		);
	}
}



