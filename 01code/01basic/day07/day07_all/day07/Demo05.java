package day07;

import java.util.Arrays;
import java.util.Random;

public class Demo05 {
	public static void main(String[] args) {
		int[] t = Demo05.gen();
		System.out.println(Arrays.toString(t)); 
	}
	/**
	 * ����˫ɫ���Ʊ���룬����ֵ��һ������
	 * ǰ6�����������룬�ǰ���С��������
	 * ��7�������������
	 * ���ԣ�
	 *   1) ���� 6 ���������
	 *   2) ��6����������
	 *   3) ����Ϊ7������
	 *   4) ׷��һ���������
	 * @return һ����������
	 */
	public static int[] gen(){
		int[] balls= {1,2,3,4,5,6,7,8,9,
				10,11,12,13,14,15,16,17,18,
				19,20,21,22,23,24,25,26,27,
				28,29,30,31,32,33};
		boolean[] used=new boolean[balls.length];
		int i;
		int[] ticket = new int[6];//��Ʊ��
		int index = 0;
 		Random r = new Random(); 
 		do{
 			i = r.nextInt(balls.length);
 			if(used[i]) continue;
 			ticket[index++] = balls[i];
 			used[i] = true;
 		}while(index!=6);
		Arrays.sort(ticket);//����
		ticket=Arrays.copyOf(ticket, 6+1);//����
		ticket[ticket.length-1]= 
			balls[r.nextInt(16)];//׷����ɫ��
		return ticket;//���ز�Ʊ��
	}
}





