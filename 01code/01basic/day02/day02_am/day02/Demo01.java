package day02;

public class Demo01 {
	public static void main(String[] args) {
		//Java的编译器调用Integer API 算法
		//将“5”转化为2进制数据了 00000101
		int age = 5;
		age = age + 1;// 00000110
		//API方法println调用Integer的算法
		//将2进制00000110转化为 "6" 然后输出
		System.out.println(age);//6
		//Integer 整数 java.lang
		int max = Integer.MAX_VALUE;
		System.out.println(max); 
		int val = max+1;//发生计算溢出
		System.out.println(val);//要避免的现象 
	}
}
