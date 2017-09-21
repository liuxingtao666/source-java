package day02;

public class IntegerDemo2 {
	public static void main(String[] args) {
//		/*
//		 * 基本类型转换为包装类
//		 */
//		int i = 1;
//		Integer ii = new Integer(i);
//		
//		double d = 123.123;
//		Double dd = new Double(d);
//		
//		/*
//		 * 从包装类转换为其对应的基本类型
//		 * 包装类提供一个方法 XXXValue()
//		 */
//		int inum = ii.intValue();
//		double dnum = dd.doubleValue();
//		
//		System.out.println(inum);
//		System.out.println(dnum);
		
		/*
		 * java推荐我们在从基本类型转换为
		 * 包装类时不使用构造方法的方式
		 * 而是使用valueOf方法的方式
		 * 所有包装类都支持一个静态方法valueOf()
		 */
		
		Integer i1 = Integer.valueOf(127);
		Integer i2 = Integer.valueOf(127);
		System.out.println(i1==i2);
	}
}


