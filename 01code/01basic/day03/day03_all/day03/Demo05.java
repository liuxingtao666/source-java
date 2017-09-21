package day03;

public class Demo05 {
	public static void main(String[] args) {
		//如果 a>b 将 ab交换
		int a = 7;
		int b = 3;
		if(a>b){
			int t = a;
			a = b;
			b = t;
		}
		System.out.println(a+","+b); 
		System.out.println(a+','+b); 
	}

}
