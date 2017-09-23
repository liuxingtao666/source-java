package day03.pm;

public class Demo09 {
	public static void main(String[] args) {
		Cat tom=new Cat(5);
		Cat kitty=new Cat(2);
		System.out.print(tom.age+","+kitty.age);
		System.out.println(Cat.numOfCats);
	}
}
class Cat{
	int age;
	static int numOfCats;//默认0
	public Cat(int age) {
		this.age = age;
		Cat.numOfCats++;//统计猫的数量
	}
}