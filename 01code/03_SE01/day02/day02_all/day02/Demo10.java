package day02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Calendar 日历类型
 *
 */
public class Demo10 {
	public static void main(String[] args) {
		//Calendar c = new GregorianCalendar();
		Calendar cal = Calendar.getInstance();
		// 获取时间分量：年
		int year = cal.get(Calendar.YEAR);
		//获取时间分量：月
		int month = cal.get(Calendar.MONTH);
		//获取分量：月中的天数
		int d = cal.get(Calendar.DAY_OF_MONTH);
		//获取分量：星期中第几天
		d = cal.get(Calendar.DAY_OF_WEEK);
		//获取分量：年中第几天
		d = cal.get(Calendar.DAY_OF_YEAR);
		
		Date date = cal.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat();
		System.out.println(fmt.format(date)); 
	}
}





