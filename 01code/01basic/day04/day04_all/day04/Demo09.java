package day04;

public class Demo09 {
	public static void main(String[] args) {
		int num = 73812;
		int sum = 0, last;
		while (num != 0) {
			last = num % 10;
			sum = sum * 10 + last;
			num /= 10;
		}
		System.out.println(sum);
	}

}
