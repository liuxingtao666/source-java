package day07;

import java.util.Arrays;

public class Demo06 {
	public static void main(String[] args) {
		char c = 65;
		int a = 65;		
		System.out.println(c);//'A'
		System.out.println(a);//65
//Java API 提供了 重载的 println方法
//也就是说:有两个println(char) println(int) 
// 不同的方法！
		char[] chs = {65,66,67};
		int[] ary = {65,66,67};
		//println(char[]) 按照字符串输出
		System.out.println(chs);//ABC
		//println(Object) 输出了toString()结果
		System.out.println(ary);//[I@de6ced
		//如何输出数组的内容
		//println(String) 
		System.out.println(Arrays.toString(ary));
		//System.out.
	}
}
