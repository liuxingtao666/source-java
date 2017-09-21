package day04;

public class Demo02 {
	public static void main(String[] args) {
		int sum = 0;/* 0 */
		int i;
		for (i=2/*1*/; i<10/*2*/; i+=2/*4*/){
			// i = 2 4 6 8 ÓÐÐ§µÄi
			sum += i;/* 3 */
		}
		System.out.println(sum+","+i);//10
	}

}
