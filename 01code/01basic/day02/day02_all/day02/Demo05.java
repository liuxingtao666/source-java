package day02;

import java.util.Random;
/**
 * 字符类型
 * 字符是一个整数 
 */
public class Demo05 {
	public static void main(String[] args) {
		char c = 20013;// 中
		System.out.println(c);//中
		char ch = '中';//20013
		//内存中的实际存储情况,二进制
		System.out.println(
			Integer.toBinaryString('中'));
		System.out.println((int)'中');
		System.out.println('中');//中
		//输出 '0' ~ '9'  'A'~'Z' 'a'~'z'
		System.out.println((int)'0');
		System.out.println((int)'1');
		System.out.println((int)'9');
		System.out.println((int)'A');
		//...
		
		c = 'A'+1;
		System.out.println(c);//"B"
		//字符的运算用途：
		//如何随机生成 'A' ~ 'Z'
		//就是生成数： 65 ~ 90 
		// = [65, 91) = 65 + [0,26)
		// = 65 + random.nextInt(26)
		// = 'A' + random.nextInt(26)
		Random random = new Random();
		int n = random.nextInt(26);
		c = (char)('A'+n);
		System.out.println(n);
		System.out.println(c);
		
		//用途之2
		//将 数字字符转化为对应的数字
		//   '6' 转化为  6
		// 就是将数字字符减去字符'0'
		ch = '8';
		n = ch-'0';
		System.out.println(n); 

		//字符的字面量
		
	}
}






