package day04.pm;

public class Demo07 {
	public static void main(String[] args) {

	}
}
class Goo{
	public void t1(){
		this.new Koo();
		new Foo();
	}
	public static void t2(){
		//this.new Koo(); ±‡“Î¥ÌŒÛ
		new Foo();
	}
	class Koo{
	}
	static class Foo{
	}
}


