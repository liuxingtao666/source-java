package day03.pm;
import day03.pm.sub.Koo;
public class Demo07 {
	public static void main(String[] args) {
		//day03.pm.sub.Koo koo = 
		//	new day03.pm.sub.Koo();
		Koo koo = new Koo();
		//System.out.println(koo.a);
		//System.out.println(koo.b);
		//System.out.println(koo.c);
		System.out.println(koo.d);
		Foo foo = new Foo();
		//System.out.println(foo.a);
		System.out.println(foo.b);
		System.out.println(foo.c);
		System.out.println(foo.d);
	}
}
class Goo extends Koo{
	public void test(){
		//System.out.println(super.a);
		//System.out.println(super.b);
		System.out.println(super.c);
		System.out.println(super.d);
	}
}
class Foo{
	private int a = 1;
	int b = 2;
	protected int c = 3;
	public int d = 4;
}






