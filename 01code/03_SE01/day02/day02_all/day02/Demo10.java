package day02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Calendar ��������
 *
 */
public class Demo10 {
	public static void main(String[] args) {
		//Calendar c = new GregorianCalendar();
		Calendar cal = Calendar.getInstance();
		// ��ȡʱ���������
		int year = cal.get(Calendar.YEAR);
		//��ȡʱ���������
		int month = cal.get(Calendar.MONTH);
		//��ȡ���������е�����
		int d = cal.get(Calendar.DAY_OF_MONTH);
		//��ȡ�����������еڼ���
		d = cal.get(Calendar.DAY_OF_WEEK);
		//��ȡ���������еڼ���
		d = cal.get(Calendar.DAY_OF_YEAR);
		
		Date date = cal.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat();
		System.out.println(fmt.format(date)); 
	}
}





