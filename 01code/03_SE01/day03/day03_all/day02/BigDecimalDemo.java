package day02;

import java.math.BigDecimal;

/**
 * BigDecimal用于描述一个大浮点数
 * 描述的数字精度由内存上限决定
 * @author Administrator
 *
 */
public class BigDecimalDemo {
	public static void main(String[] args) {
		//java.math.BigDecimal
		BigDecimal d1
			= new BigDecimal("3.0");
		BigDecimal d2
			= BigDecimal.valueOf(2.9);
		
		BigDecimal d3 = d1.subtract(d2);
		System.out.println(d3);
		
		/*
		 * 通常在除法中不适用该方法，因为
		 * 这避免不了商为无限小数时的后果
		 */
//		d1.divide(d2);
		/*
		 * 通常使用3个参数的方法
		 * 参数1：除数
		 * 参数2：小数点保留位数
		 * 参数3：舍入模式，常用四舍五入
		 */
		d3 = d1.divide(
				d2, 
				9, 
				BigDecimal.ROUND_HALF_UP
				);
		System.out.println(d3);
	}
}








