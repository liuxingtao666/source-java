package day05;

public class ExceptionDemo3 {
	public static void main(String[] args) {
		
		try {
			
			String str = null;
			System.out.println(str.length());
		//子类异常的捕获在上
		} catch (NullPointerException e) {
			
		//父类异常的捕获在下	
		} catch (Exception e){
			
		}
		
	}
}
