package day02;
/**
 * 测试包装类将字符串转换为基本类型数据
 * @author Administrator
 *
 */
public class IntegerDemo5 {
	public static void main(String[] args) {
		String str = "12345 ";
		int num = Integer.parseInt(str);
		System.out.println(num+1);
		
		str = "123.123";
		float f = Float.parseFloat(str);
		System.out.println(f + 1);
		//若给定的数字格式不匹配会抛出异常
//		num = Integer.parseInt(str);
//		System.out.println();
	}
}




