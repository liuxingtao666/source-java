package day01;
/**
 * toString ����
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
	//��дObject��toString����
	public String toString() {return a+"Goo"; }
}





