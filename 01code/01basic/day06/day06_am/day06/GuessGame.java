package day06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
		char[] answer, input;
		int times=0, count, location, n=5;
		answer = generate(n);
		System.out.println(answer);
		char[] bye = {'b','y','e'};
		for(;;){
			input = getInput();
			if(Arrays.equals(input, bye)){
				break;
			}
			times++;
			int[] result=check(answer, input);
			count=result[0];
			location=result[1];
			show(times, count, location);
			if(count==n && location==n){
				break;
			}
		}
	}
	/**
	 * ����n�����ظ��Ĵ�д�ַ�
	 * @param n 
	 * @return 
	 */
	public static char[] generate(int n){
		char[] chs  = {'A','B','C','D','E',
				'F','G','H','I','J','K','L'};
		boolean[] uesed=new boolean[chs.length];
		int i; //��ȡchs����ʱ���λ��
		char[] answer = new char[n];
		int index = 0;//��answer�����
		Random random = new Random();
		do{
			i = random.nextInt(chs.length);//3
			if(uesed[i]){continue;}
			answer[index++] = chs[i];
			uesed[i]=true;
		}while(index!=n);
		return answer;
	}
	/**
	 * �ӿ���̨��ȡ�û�������
	 * @return ����5���ַ�������bye
	 */
	public static char[] getInput(){
		Scanner in = new Scanner(System.in);
		System.out.print("����²�𰸣�");
		String str = in.nextLine();//"ABCDE"
		//{'A','B','C','D','E'}
		//��strת��Ϊ��Ӧ���ַ�����
		char[] input = str.toCharArray();
		return input;
	}
	public static int[] check(
			char[] answer, char[] input){
		int count=0, location=0;
		for(int i=0; i<answer.length; i++){
			for(int j=0; j<input.length; j++){
				if(answer[i]==input[j]){
					count++;
					if(i==j){
						location++;
					}
					break;
				}
			}
		}
		return new int[]{count, location};
	}
	public static void show(int times, 
			int count, int location){
		if(count==5 || location==5){
			System.out.println("������˫��");
			return; //return ��������ǰ��������
		}
		System.out.println("����"+times+
				"�� ����"+count+"���ַ� "+ 
				location + "��λ��");
	}
}





