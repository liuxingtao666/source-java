package day05;
import java.util.Arrays;
/**
 * ����ĵ���
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] ary1=new int[] { 3, 5, 7, 2, 6 };
		//�����ary1.toString()�����û������
		System.out.println(ary1);//���������������
		// 0 1 2 3 4 ����5
		// ��������Ԫ�� ary1[i] i = 0 1 2 3 4
		for (int i = 0; i < 5; i++) {
			// i = 0 1 2 3 4
			System.out.print(ary1[i] + " ");
		}
		System.out.println();
		//����ʹ��API �������������
		System.out.println(
				Arrays.toString(ary1)); 
	}

}
