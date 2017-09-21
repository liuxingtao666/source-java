package day02;

import java.util.Random;

public class Demo06 {
	public static void main(String[] args) {
		Random random = new Random(
				System.currentTimeMillis());
		int n = random.nextInt(26);
		System.out.println(n);
		n = random.nextInt(26);
		System.out.println(n);
		n = random.nextInt(26);
		System.out.println(n);
		n = random.nextInt(26);
		System.out.println(n);
	}
}
