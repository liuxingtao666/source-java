package day05;

import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		int score;
		do {
			System.out.print(" ‰»Î∑÷ ˝£∫");
			score = console.nextInt();
		} while (score < 0 || score > 100);
		System.out.println(score);
	}
}
