package day03;
import java.util.Scanner;
public class Demo03 {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		int year = 2014;
		System.out.print("������ݣ�");
		year = console.nextInt();
		if(((year%4==0) && !(year%100==0))||
				(year%400==0)){
			System.out.println(year+"����");
		}else{
			System.out.println(year+"��������");
		}
	}

}
