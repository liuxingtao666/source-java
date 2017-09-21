package day05;
/**
 * Exception的两个常用方法
 * @author Administrator
 *
 */
public class ExceptionApiDemo {
	public static void main(String[] args) {
		try {
			String str = "";
			System.out.println(str.charAt(0));
		} catch (Exception e) {
			/*
			 *  输出该异常出现的堆栈信息
			 *  有助于我们改善代码 
			 */
			e.printStackTrace();
			//获取异常的信息
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}




