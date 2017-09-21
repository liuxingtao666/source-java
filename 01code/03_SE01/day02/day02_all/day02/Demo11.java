package day02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar 时间计算
 */
public class Demo11 {
	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar();
		//复杂时间计算：计算5个月以后
		cal.add(Calendar.MONTH, 5);
		Date date = cal.getTime();
		SimpleDateFormat fmt=
			new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(date));  
		//简单时间计算：5天以后
		long now = System.currentTimeMillis();
		long toDate = now+1000L*60*60*24*5;
		System.out.println(fmt.format(toDate));  
	}
}







