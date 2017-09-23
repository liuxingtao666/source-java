package day04.pm;

public class Demo08 {
	public static void main(String[] args) {
		int a = 4;
		final int b = 5;
		class Foo{
			public void t(){
				//System.out.println(a);//±‡“Î¥Ì
				System.out.println(b);
			}
		}
		Foo f = new Foo();
		f.t();
	}
}
