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
	 * 生成n个不重复的大写字符
	 * @param n 
	 * @return 
	 */
	public static char[] generate(int n){
		char[] chs  = {'A','B','C','D','E',
				'F','G','H','I','J','K','L'};
		boolean[] uesed=new boolean[chs.length];
		int i; //是取chs数组时候的位置
		char[] answer = new char[n];
		int index = 0;//是answer中序号
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
	 * 从控制台获取用户的输入
	 * @return 返回5个字符，或者bye
	 */
	public static char[] getInput(){
		Scanner in = new Scanner(System.in);
		System.out.print("输入猜测答案：");
		String str = in.nextLine();//"ABCDE"
		//{'A','B','C','D','E'}
		//将str转化为对应的字符数组
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
			System.out.println("天下无双！");
			return; //return 语句可以提前结束方法
		}
		System.out.println("猜了"+times+
				"次 猜中"+count+"个字符 "+ 
				location + "个位置");
	}
}





