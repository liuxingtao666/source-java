package day01;

import java.util.Scanner;
import java.util.Random;
public class Demo01 {
	public static void main(String[] args) {
		//Scanner 扫描器 可以实现从控制台console读取数据
		Scanner console = new Scanner(System.in);
		//调用nextLine方法读取一行数据给name
		// console控制台.的 next 下一 Line行
		// = 赋值 给 name
		String name = console.nextLine();//name="Tom"
		System.out.println("Hello "+ name);//"Hello Tom"
		// y = f(4+x)
		Random random = new Random();
		int n = random.nextInt(10);//生成[0,10)范围随机数
		System.out.println(n); 
	}
}







