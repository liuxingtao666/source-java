package day03;

public class Demo05 {
	public static void main(String[] args) {
		//��� a>b �� ab����
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
