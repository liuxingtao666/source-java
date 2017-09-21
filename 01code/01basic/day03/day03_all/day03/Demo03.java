package day03;
import java.util.Scanner;
public class Demo03 {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		int year = 2014;
		System.out.print("输入年份：");
		year = console.nextInt();
		if(((year%4==0) && !(year%100==0))||
				(year%400==0)){
			System.out.println(year+"闰年");
		}else{
			System.out.println(year+"不是闰年");
		}
	}

}
