package day02;

public class Demo07 {
	public static void main(String[] args) {
		//�Զ�ת��
		int i = -2;
		long l = i;
		System.out.println(l);//64λ��-2
		//ǿ������ת��
		l = -6L;
		//i = l;//�����,����ֱ�Ӹ�ֵ
		i = (int)l;
		System.out.println(i);//-6 32λ��-6
		//�������
		l = 0x12abef00000005L;
		i = (int)l;//��ȥ�ߵ�32λ "12abef"
		System.out.println(i);
		System.out.println(l);
		System.out.println(Long.toBinaryString(l));
		
		//float �ķ�Χ������long�ķ�Χ
		float p = 3.1415926535897F * 
				100000000000000000000F;
		System.out.println(p); 
		float f = Long.MAX_VALUE;
		System.out.println(f); 
		//������ʧ
		double d = 3.1415926535897D;
		float x = (float)d;
		System.out.println(d);
		System.out.println(f);
		
		//ʵ��С��������������������4��5��
		double price = 4.56;
		long val = (long)(price + 0.5);
		System.out.println(val);//5
	}
}




