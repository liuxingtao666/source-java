package day01;
/** Object 是任何类型的父类型，Object是多态的 */
public class Demo01 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		Object obj = foo;
		//Object 类型是Foo的父类型
		obj = new Koo();
	}
}
class Foo /* extends Object */ {
}
class Koo{
}
