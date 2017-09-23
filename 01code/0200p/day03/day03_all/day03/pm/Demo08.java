package day03.pm;
// 静态代码块
public class Demo08 {
	public static void main(String[] args) {
		Hoo h1 = new Hoo();
		Hoo h2 = new Hoo();
	}
}
class Hoo{
	{//代码块，在创建对象时候执行，很少用
		System.out.println("HI");
	}
	static {//在加载Hoo类时候执行
		System.out.println("Ye");
	}
}




