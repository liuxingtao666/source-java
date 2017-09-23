package day03;

public class Demo05 {
	public static void main(String[] args) {
		Person p = new Student();
		test(p);
		p = new Person();
		test(p);
	}
	public static void test(Person p){
		System.out.println(p.name);
		//System.out.println(p.sid);
		p.whoru();//p类型上没有whoru()方法就编译错误
	}//Java 编译器根据变量类型检查属性和方法
}//Java 在运行期间调用对象类型的方法
class Student extends Person{
	int sid = 5;
	public void whoru(){System.out.println(name);}
}
class Person{
	String name = "Tom";
	public void whoru(){}
}