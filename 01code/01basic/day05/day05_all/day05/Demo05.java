package day05;

public class Demo05 {
	public static void main(String[] args) {
		int[] ary = {3,4,5};
		int a = ary[0];//��ȡ����Ԫ��
		System.out.println(a);//3
		ary[0] = 8;//�޸�����Ԫ��
		ary[0]++; 
		System.out.println(ary[0]);//9
		System.out.println(ary.length);//3
		//�����쳣
		System.out.println(ary[3]);
	}
}
