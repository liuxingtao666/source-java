package day06;

import java.util.Arrays;
import java.util.Random;

public class Demo06 {
	public static void main(String[] args) {
		int[] ary1 = new int[50000];
		Random random = new Random(5);
		for(int i=0; i<ary1.length; i++){
			ary1[i]=random.nextInt();
		}
		int[] ary2=Arrays.copyOf(
				ary1, ary1.length);
		long t1 = System.currentTimeMillis();
		Arrays.sort(ary1);
		long t2 = System.currentTimeMillis();
		Demo05.sort(ary2);
		long t3 = System.currentTimeMillis();
		System.out.println(
				Arrays.equals(ary1, ary2));
		System.out.println((t2-t1)+","+(t3-t2)); 
	}
}




