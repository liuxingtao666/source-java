package day01;

import java.util.Scanner;
import java.util.Random;
public class Demo01 {
	public static void main(String[] args) {
		//Scanner ɨ���� ����ʵ�ִӿ���̨console��ȡ����
		Scanner console = new Scanner(System.in);
		//����nextLine������ȡһ�����ݸ�name
		// console����̨.�� next ��һ Line��
		// = ��ֵ �� name
		String name = console.nextLine();//name="Tom"
		System.out.println("Hello "+ name);//"Hello Tom"
		// y = f(4+x)
		Random random = new Random();
		int n = random.nextInt(10);//����[0,10)��Χ�����
		System.out.println(n); 
	}
}







