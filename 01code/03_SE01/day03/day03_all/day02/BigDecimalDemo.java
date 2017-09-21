package day02;

import java.math.BigDecimal;

/**
 * BigDecimal��������һ���󸡵���
 * ���������־������ڴ����޾���
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
		 * ͨ���ڳ����в����ø÷�������Ϊ
		 * ����ⲻ����Ϊ����С��ʱ�ĺ��
		 */
//		d1.divide(d2);
		/*
		 * ͨ��ʹ��3�������ķ���
		 * ����1������
		 * ����2��С���㱣��λ��
		 * ����3������ģʽ��������������
		 */
		d3 = d1.divide(
				d2, 
				9, 
				BigDecimal.ROUND_HALF_UP
				);
		System.out.println(d3);
	}
}








