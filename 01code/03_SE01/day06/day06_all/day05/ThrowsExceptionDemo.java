package day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * throws�ؼ���
 * @author Administrator
 *
 */
public class ThrowsExceptionDemo {
	public static void main(String[] args) {
		try {
			parse("1999-01-02");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/*
	 * throws���������÷��������׳����쳣
	 * ��������֪ͨ�����ߣ��ڵ��ø÷����Ǿ�Ӧ��
	 * ��ý���취��
	 */
	public static void parse(String str)
					throws ParseException{
		SimpleDateFormat sdf
			= new SimpleDateFormat(
					"yyyy-MM-dd");
		/*
		 * ��ΪSimpleDateFormat��parse
		 * ����������throws�׳�ParseException
		 * ���������ڵ��ø÷����������Ҫ������
		 * Ҫô����������try-catch
		 * Ҫô���ǵķ���Ҳ�������쳣���׳�
		 */
		Date date = sdf.parse(str);
		
	}
}


