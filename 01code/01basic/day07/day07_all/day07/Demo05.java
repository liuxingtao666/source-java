package day07;

import java.util.Arrays;
import java.util.Random;

public class Demo05 {
	public static void main(String[] args) {
		int[] t = Demo05.gen();
		System.out.println(Arrays.toString(t)); 
	}
	/**
	 * 生成双色球彩票号码，返回值是一个数组
	 * 前6个代表红球号码，是按照小到大排序
	 * 第7个代表蓝球号码
	 * 策略：
	 *   1) 生成 6 个红球号码
	 *   2) 对6个号码排序
	 *   3) 扩容为7个号码
	 *   4) 追加一个蓝球号码
	 * @return 一个号码数组
	 */
	public static int[] gen(){
		int[] balls= {1,2,3,4,5,6,7,8,9,
				10,11,12,13,14,15,16,17,18,
				19,20,21,22,23,24,25,26,27,
				28,29,30,31,32,33};
		boolean[] used=new boolean[balls.length];
		int i;
		int[] ticket = new int[6];//彩票号
		int index = 0;
 		Random r = new Random(); 
 		do{
 			i = r.nextInt(balls.length);
 			if(used[i]) continue;
 			ticket[index++] = balls[i];
 			used[i] = true;
 		}while(index!=6);
		Arrays.sort(ticket);//排序
		ticket=Arrays.copyOf(ticket, 6+1);//扩容
		ticket[ticket.length-1]= 
			balls[r.nextInt(16)];//追加蓝色球
		return ticket;//返回彩票号
	}
}





