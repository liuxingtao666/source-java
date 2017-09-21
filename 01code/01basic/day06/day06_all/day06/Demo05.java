package day06;

import java.util.Arrays;

public class Demo05 {
	public static void main(String[] args) {
		int[] ary = {2,1,5,1,6,7,8,9};
		Demo05.sort(ary);
		System.out.println(Arrays.toString(ary));
	}
	public static void sort(int[] ary){
		for(int i=0; i<ary.length-1; i++){
			for(int j=0; j<ary.length-i-1; j++){
				if(ary[j]>ary[j+1]){
					int t=ary[j];
					ary[j]=ary[j+1];
					ary[j+1]=t;
				}
			}
		}
	}
}
