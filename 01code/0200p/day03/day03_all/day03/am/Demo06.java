package day03.am;

public class Demo06 {
	public static void main(String[] args) {
		Cheater c = new Cheater();
		Person p = c;
		System.out.println(c.name+","+p.name); 
	}
}
class Cheater extends Person{//ƭ��
	String name="ϲ����";
}
class Person{
	String name="��̫��";
}


