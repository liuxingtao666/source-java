package day02;

import java.util.Random;
/**
 * �ַ�����
 * �ַ���һ������ 
 */
public class Demo05 {
	public static void main(String[] args) {
		char c = 20013;// ��
		System.out.println(c);//��
		char ch = '��';//20013
		//�ڴ��е�ʵ�ʴ洢���,������
		System.out.println(
			Integer.toBinaryString('��'));
		System.out.println((int)'��');
		System.out.println('��');//��
		//��� '0' ~ '9'  'A'~'Z' 'a'~'z'
		System.out.println((int)'0');
		System.out.println((int)'1');
		System.out.println((int)'9');
		System.out.println((int)'A');
		//...
		
		c = 'A'+1;
		System.out.println(c);//"B"
		//�ַ���������;��
		//���������� 'A' ~ 'Z'
		//������������ 65 ~ 90 
		// = [65, 91) = 65 + [0,26)
		// = 65 + random.nextInt(26)
		// = 'A' + random.nextInt(26)
		Random random = new Random();
		int n = random.nextInt(26);
		c = (char)('A'+n);
		System.out.println(n);
		System.out.println(c);
		
		//��;֮2
		//�� �����ַ�ת��Ϊ��Ӧ������
		//   '6' ת��Ϊ  6
		// ���ǽ������ַ���ȥ�ַ�'0'
		ch = '8';
		n = ch-'0';
		System.out.println(n); 

		//�ַ���������
		
	}
}






