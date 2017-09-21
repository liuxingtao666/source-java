package day05;
/**
 * 捕获多个异常
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			int num = Integer.parseInt(str);
		} catch (NullPointerException e) {
			System.out.println("空指针了!");
		} catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界了!");
		} catch(Exception e){
			System.out.println("反正就是出了个错!");
		}
		
		
		System.out.println("程序结束了");
	}
}




