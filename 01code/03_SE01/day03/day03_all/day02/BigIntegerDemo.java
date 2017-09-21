package day02;

import java.math.BigInteger;

/**
 * BigInteger用于描述一个大整数
 * @author Administrator
 *
 */
public class BigIntegerDemo {
	public static void main(String[] args) {
		/*
		 * 计算200的阶乘
		 */
		BigInteger num 
			= new BigInteger("1");
		for(int i=2;i<=200;i++){
			num = num.multiply(
					BigInteger.valueOf(i)
				  );
		}
		
		System.out.println(num);
		System.out.println(num.toString().length());
	}
}








