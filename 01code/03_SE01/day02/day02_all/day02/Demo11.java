package day02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar ʱ�����
 */
public class Demo11 {
	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar();
		//����ʱ����㣺����5�����Ժ�
		cal.add(Calendar.MONTH, 5);
		Date date = cal.getTime();
		SimpleDateFormat fmt=
			new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(date));  
		//��ʱ����㣺5���Ժ�
		long now = System.currentTimeMillis();
		long toDate = now+1000L*60*60*24*5;
		System.out.println(fmt.format(toDate));  
	}
}







