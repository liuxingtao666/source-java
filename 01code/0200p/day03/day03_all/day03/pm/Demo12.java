package day03.pm;

public class Demo12 {
	public static void main(String[] args) {
		int a;
		final int b;
		a = 1;
		b = 6;
		a = 8;
		//b = 9;//�������
		//
		test(6,7);
		test(8,9);
	}
	public static void test(final int x, int y){
		//x = 4;//���������ڵ���ʱ���ʼ��
		y = 5;
	}
}



