package day03;

public class Demo02 {
	public static void main(String[] args) {
		new Koo();
		//A.����� B.�����쳣 C.�� D.Foo()
	}
}
class Foo{
	public Foo() {
		System.out.println("Foo()"); 
	}
}
class Koo extends Foo{
	public Koo() {
		//System.out.println("׼������super");
		super();//���ø�����޲���������
	}
}


