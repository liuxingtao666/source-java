package day04;

public class Demo03 {
	public static void main(String[] args) {
		double sum = 0;
		for (int i = 1; i < 10000; i += 4) {
			sum += 1.0 / i - 1.0 / (i + 2);
		}
		double pi = sum * 4;
		System.out.println(pi);
	}

}
