package day02;
/**
 * 忽略（Ignore）大小写比较字符串相等
 */
public class Demo05 {
	public static void main(String[] args) {
		String str = "Bye";
		if("bye".equalsIgnoreCase(str)){
			System.out.println("再见"); 
		}
	}
}
