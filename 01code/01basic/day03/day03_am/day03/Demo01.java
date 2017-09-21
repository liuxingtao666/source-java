package day03;

import java.util.Scanner;
public class Demo01 {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		//定义数据
		double v0, t, g; //输入数据
		double v, s; //输出数据
		//初始化数据
		g = 9.8;
		System.out.print("输入速度和时间：");
		v0 = console.nextDouble();//30;//米/秒
		t =  console.nextDouble();//0.5;//秒
		//算法
		s = v0*t - 1.0/2 * g * t * t;
		v = v0 - g*t;
		//显示结果
		System.out.println("移动了："+s+"米");
		System.out.println("速度是："+v+"m/s");
	}

}
