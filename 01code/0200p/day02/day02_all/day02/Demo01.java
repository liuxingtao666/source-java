package day02;
/**
 * 默认构造器现象 
 */
public class Demo01 {
	public static void main(String[] args) {
		Foo f = new Foo();//调用默认构造器
		//Koo k = new Koo();//编译错误，没有构造器
		//Koo() 
		//选择运行结果：
		//A.编译错误 B.运行异常 C.无 D.Koo(int)
		Koo k = new Koo(8);
		//A.编译错误 B.运行异常 C.8 D.Koo(int)
	}
}
class Foo{
}
class Koo{
	public Koo(int a){
		System.out.println("Koo(int)"); 
	}
}



