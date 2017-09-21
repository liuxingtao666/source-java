package day04;

public class Demo06 {
	public static void main(String[] args) {
		long sum=0, num=0;
		for(int i=1; i<=9; i++){
			//i=1 2 3 4 ... 9
			num=num*10+9;
			sum+=num;
			//跟踪语句,跟踪变量的运行期间的值
			System.out.println(
					i+","+num+","+sum);
		}
		System.out.println(sum); 
	}

}
