package day03;

import java.util.Scanner;
public class Demo01 {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		//��������
		double v0, t, g; //��������
		double v, s; //�������
		//��ʼ������
		g = 9.8;
		System.out.print("�����ٶȺ�ʱ�䣺");
		v0 = console.nextDouble();//30;//��/��
		t =  console.nextDouble();//0.5;//��
		//�㷨
		s = v0*t - 1.0/2 * g * t * t;
		v = v0 - g*t;
		//��ʾ���
		System.out.println("�ƶ��ˣ�"+s+"��");
		System.out.println("�ٶ��ǣ�"+v+"m/s");
	}

}
