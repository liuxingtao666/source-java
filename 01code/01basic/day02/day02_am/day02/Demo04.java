package day02;

public class Demo04 {

	public static void main(String[] args) {
		double pi=3.1415926535897932384626433832;
		float p = 3.1415926535897932384626433832F;
		System.out.println(pi);
		System.out.println(p);
		double s = Math.sin(pi);
		System.out.println(s);
		System.out.println(Math.abs(s)<0.0000001);//true
		double d = 2.6;
		System.out.println(d-2);
	}

}
