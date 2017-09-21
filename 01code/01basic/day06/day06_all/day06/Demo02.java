package day06;

import java.util.Arrays;

public class Demo02 {
	public static void main(String[] args) {
		int[] line0={0,0,0,0,0,0,1,0,0,0};
		int[] line1={0,0,0,0,0,1,1,0,0,1};
		int[] line2={1,0,1,0,1,0,1,1,0,1};
		int[] line3={1,1,1,1,1,1,1,1,1,1};
		//           0 1 2 3 4 5 6 7 8 9 
		//line2->line3 line1->line2 
		//line0->line1 clear line0
		System.arraycopy(line2,0,line3,0,10);
		System.arraycopy(line1,0,line2,0,10);
		System.arraycopy(line0,0,line1,0,10);
		Arrays.fill(line0, 0);
		//fill Ìî³äÂú0
		System.out.println(Arrays.toString(line0));
		System.out.println(Arrays.toString(line1));
		System.out.println(Arrays.toString(line2));
		System.out.println(Arrays.toString(line3));
	}

}
