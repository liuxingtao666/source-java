package day03;

public class Demo02 {
	public static void main(String[] args) {
		new Koo();
		//A.编译错 B.运行异常 C.无 D.Foo()
	}
}
class Foo{
	public Foo() {
		System.out.println("Foo()"); 
	}
}
class Koo extends Foo{
	public Koo() {
		//System.out.println("准备调用super");
		super();//调用父类的无参数构造器
	}
}


