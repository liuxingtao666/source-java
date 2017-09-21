package day07;
import java.util.Random;

public class Demo04 {
	public static void main(String[] args) {
		/*
		 * Random 是伪随机数，计算机没有真随机数
		 * Random 提供的随机数是一个固定随机序列
		 * 如果创建  Random 对象时候给的种子是
		 * 固定的， 结果就是固定序列
		 *  
		 */
		Random r = new Random(3);//种子是3
		//如果种子是固定的，产生的序列是固定的
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		System.out.println(r.nextInt(5));
		//如上产生8个数字构成 数列 是固定
		//分布范围是在 [0,5) 以内
		
		//可以使用当前系统时间作为种子
		//时间种子变化很快，序列就每次都会变化
		//Random r = new Random();
		//这样就模拟了真随机现象
	}
}
 



