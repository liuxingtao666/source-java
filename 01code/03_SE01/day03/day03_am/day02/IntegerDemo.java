package day02;

import java.util.Date;

public class IntegerDemo {
	public static void main(String[] args) {
		String str = "123";
		print(str);
		
		Date date = new Date();
		print(date);
		
		int a = 1;
		Integer aa = new Integer(a);
		Long l = new Long(123l);
		print(l);
		
	}
	
	public static void print(Object obj){
		String str = obj.toString();
		System.out.println(str);
	}
}





