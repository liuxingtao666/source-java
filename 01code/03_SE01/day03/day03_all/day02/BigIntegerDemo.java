package day02;

import java.math.BigInteger;

/**
 * BigInteger��������һ��������
 * @author Administrator
 *
 */
public class BigIntegerDemo {
	public static void main(String[] args) {
		/*
		 * ����200�Ľ׳�
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








