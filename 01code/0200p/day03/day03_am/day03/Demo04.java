package day03;

import java.util.Arrays;

public class Demo04 {
	public static void main(String[] args) {
		int[] ary1 = {3,6,1,9,2};
		Demo04.sort(ary1);
		System.out.println(
				Arrays.toString(ary1));
		int[] ary2 = {9,1,2,4,6,7,2,5,8};
		Demo04.sort(ary2);
		System.out.println(
				Arrays.toString(ary2));
	}
	public static void sort(int[] ary){
		int i,j,k;
		for(i=1; i<ary.length; i++){
			k = ary[i];
			for(j=i-1; j>=0 && ary[j]>k; j--){
				ary[j+1]=ary[j];
			}
			ary[j+1]=k;
		}
	}
}
