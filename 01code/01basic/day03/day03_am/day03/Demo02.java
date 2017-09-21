package day03;

public class Demo02 {
	public static void main(String[] args) {
		int index=0;
		int n = 3;
		System.out.println(index++%n);//0
		System.out.println(index++%n);//1
		System.out.println(index++%n);//2
		System.out.println(index++%n);//0
		System.out.println(index++%n);//1
		System.out.println(index++%n);//2
		System.out.println(index++%n);//0
		System.out.println(index++%n);//1
		System.out.println(index++%n);//2
		System.out.println(index);
	}

}
