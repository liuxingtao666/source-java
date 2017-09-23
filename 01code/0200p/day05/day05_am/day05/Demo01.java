package day05;
/**
 * 匿名类 
 */
public class Demo01 {
	public static void main(String[] args) {
		Foo foo = new Foo(){};//匿名内部类
		//Koo koo = new Koo();//编译错误
		Koo koo = new Koo(){};//创建Koo接口的
		//匿名类实例，是对Koo接口的便捷实现
		Koo[] ks = new Koo[1];
		//创建数组，元素Koo类型的对象
		//Goo goo=new Goo(){};//编译错，没有实现方法
		Goo goo=new Goo(){
			public void test() {
				System.out.println("test");
			}
		};
		goo.test();
	}
}
interface Goo{
	void test();
}
interface Koo{
}
class Foo{
}


