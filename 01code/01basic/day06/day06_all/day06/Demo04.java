package day06;

import java.util.Arrays;
/**
 * 数组变长算法。 
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] ary = {2,3,4};
		System.out.println(
				Arrays.toString(ary)); 
		//扩容
		ary=Arrays.copyOf(ary, ary.length+1);
		System.out.println(
				Arrays.toString(ary)); 
		//追加
		ary[ary.length-1]=9;
		System.out.println(
				Arrays.toString(ary)); 
		//将1元素与最后元素交换
		int t=ary[1];
		ary[1]=ary[ary.length-1];
		ary[ary.length-1]=t;
		//删除最后元素
		ary = Arrays.copyOf(ary,ary.length-1);
		System.out.println(
				Arrays.toString(ary)); 
	}
}
