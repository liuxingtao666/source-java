package day02;
/**
 * 输出数字的2进制与16进制
 * @author Administrator
 *
 */
public class IntegerDemo6 {
	public static void main(String[] args) {
		//获取100的2进制形式字符串
		String bStr =
			Integer.toBinaryString(100);
		System.out.println(bStr);
		
		//获取100的16进制形式字符串
		String hStr = 
			Integer.toHexString(100);
		System.out.println(hStr);
	}
}





