package day02;

public class Demo01 {
	public static void main(String[] args) {
		//Java�ı���������Integer API �㷨
		//����5��ת��Ϊ2���������� 00000101
		int age = 5;
		age = age + 1;// 00000110
		//API����println����Integer���㷨
		//��2����00000110ת��Ϊ "6" Ȼ�����
		System.out.println(age);//6
		//Integer ���� java.lang
		int max = Integer.MAX_VALUE;
		System.out.println(max); 
		int val = max+1;//�����������
		System.out.println(val);//Ҫ��������� 
	}
}
