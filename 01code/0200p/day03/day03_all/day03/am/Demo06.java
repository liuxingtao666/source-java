package day03.am;

public class Demo06 {
	public static void main(String[] args) {
		Cheater c = new Cheater();
		Person p = c;
		System.out.println(c.name+","+p.name); 
	}
}
class Cheater extends Person{//Æ­×Ó
	String name="Ï²ÑóÑó";
}
class Person{
	String name="»ÒÌ«ÀÉ";
}


