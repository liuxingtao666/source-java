package day07;
import java.util.Random;

public class Demo04 {
	public static void main(String[] args) {
		/*
		 * Random ��α������������û���������
		 * Random �ṩ���������һ���̶��������
		 * �������  Random ����ʱ�����������
		 * �̶��ģ� ������ǹ̶�����
		 *  
		 */
		Random r = new Random(3);//������3
		//��������ǹ̶��ģ������������ǹ̶���
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		//���ϲ���8�����ֹ��� ���� �ǹ̶�
		//�ֲ���Χ���� [0,5) ����
		
		//����ʹ�õ�ǰϵͳʱ����Ϊ����
		//ʱ�����ӱ仯�ܿ죬���о�ÿ�ζ���仯
		//Random r = new Random();
		//������ģ�������������
	}
}
 



