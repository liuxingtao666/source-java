package day05;

import java.util.Arrays;

public class Demo08 {
	public static void main(String[] args) {
		int[] ary = {3,4,5};
//str="["+ary[0]+", "+ary[1]+", "+ary[2]+"]";
		String str = Arrays.toString(ary);
		System.out.println(ary); 
		
		char[] answer = {'A','C','D'};
		char[] input1 = {'A','B','C','D'};
		char[] input2 = {'A','C','D'};
		char[] input3 = {'A','D','C'};
		System.out.println(
				Arrays.equals(answer, input1));
		System.out.println(
				Arrays.equals(answer, input2));
		
		Arrays.sort(input3);
		System.out.println(
				Arrays.toString(input3));
		System.out.println(
				Arrays.equals(answer, input3));
	
		String[] names = 
			{"Tom","Andy","Jerry","Lee"};
		Arrays.sort(names);
		System.out.println(
				Arrays.toString(names));
	}
}




