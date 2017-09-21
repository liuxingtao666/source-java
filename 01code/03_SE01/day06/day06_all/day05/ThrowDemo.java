package day05;
/**
 * 主动抛出异常
 * @author Administrator
 *
 */
public class ThrowDemo {
	public static void main(String[] args) {
		Human h = new Human();
		try{
			h.setAge(1000);//抛出异常
			/*
			 * 抛出异常后，try语句块中此行代码
			 * 之下的所有代码均不会再执行，而是
			 * 跳到catch中。
			 */
			System.out.println(h);//不会执行
		}catch(Exception e){
			System.out.println("年龄不合法");
		}
		
	}
}

class Human{
	private int age;
	
	public void setAge(int age){
		if(age<=0||age>130){
			throw new RuntimeException("不符合人类年龄");
		}
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "我今年:"+age+"岁";
	}
}





