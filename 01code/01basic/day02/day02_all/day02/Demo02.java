package day02;

public class Demo02 {
	public static void main(String[] args) {
		int a = 5;//00000101
		//�� �ڴ���a��ת��Ϊ2���Ƶ��ַ���
		String bin = Integer.toBinaryString(a);
		System.out.println(bin);//101
		int max = Integer.MAX_VALUE;
		System.out.println(max); 
		String hex = Integer.toHexString(max);
		bin = Integer.toBinaryString(max);
		System.out.println(bin);//31��1
		System.out.println(hex);//7fffffff
		String oct = Integer.toOctalString(max);
		System.out.println(oct);
		int b = 0x7fffffff;
	}
}



