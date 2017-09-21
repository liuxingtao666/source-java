package day01;
/**
 * toString 方法
 */
public class Demo02 {
	public static void main(String[] args) {
		Goo goo = new Goo(5);
		String s = "HI"+goo;//"HI"+goo.toString();
		System.out.println(s); 
		System.out.println(goo); 
	}
}
class Goo{
	int a;
	public Goo(int a) {this.a = a;}
	//重写Object的toString方法
	public String toString() {return a+"Goo"; }
}





