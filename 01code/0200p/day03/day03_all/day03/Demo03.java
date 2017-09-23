package day03;

public class Demo03 {
	public static void main(String[] args) {
		Goo g = new Goo();
		System.out.println(g.a+","+g.b+","+g.c);
	}
}
class Goo extends Hoo{
	int c=8;
	public Goo(){
		super();
		/*初始化*/
		a=1;
		b=2;
		c=3;
	}
}
class Hoo extends Noo{
	int b = 1;
	public Hoo(){super();/*初始化*/a=3;b=7;}
}
class Noo{
	int a = 5;
	public Noo(){/*属性初始化*/a=6;}
}
