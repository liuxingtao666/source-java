package day05;
/**
 * java 异常捕获机制
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String str = null;
			print(str);
		}catch(NullPointerException e){
			System.out.println("空指针了");
		}
		System.out.println("程序结束了");
	}
	
	public static void print(String str){
		System.out.println(
				"字符串长度:"+str.length());
	}
}




