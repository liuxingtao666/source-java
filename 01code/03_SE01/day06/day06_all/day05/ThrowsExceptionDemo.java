package day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * throws关键字
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
	 * throws用于声明该方法可能抛出的异常
	 * 这样可以通知调用者，在调用该方法是就应当
	 * 想好解决办法。
	 */
	public static void parse(String str)
					throws ParseException{
		SimpleDateFormat sdf
			= new SimpleDateFormat(
					"yyyy-MM-dd");
		/*
		 * 因为SimpleDateFormat的parse
		 * 方法声明了throws抛出ParseException
		 * 所以我们在调用该方法的这里就要做处理
		 * 要么我们在这里try-catch
		 * 要么我们的方法也声明该异常的抛出
		 */
		Date date = sdf.parse(str);
		
	}
}


