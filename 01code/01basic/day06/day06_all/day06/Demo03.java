package day06;

import java.util.Arrays;

public class Demo03 {
	public static void main(String[] args) {
		int[] ary0 = {3,4,5};
		int[] ary = Arrays.copyOf(ary0, 4); 
		System.out.println(
				Arrays.toString(ary0));
		System.out.println(
				Arrays.toString(ary));
	}
}


