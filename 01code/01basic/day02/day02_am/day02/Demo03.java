package day02;
/**
 * long 类型表示时间 
 */
public class Demo03 {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		System.out.println(now);
		long year = now/1000/60/60/24/365+1970;
		System.out.println(year); 
		long end = Long.MAX_VALUE;
		year = end/1000/60/60/24/365+1970;
		System.out.println(year); 
	}
}
