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
		p.whoru();//p������û��whoru()�����ͱ������
	}//Java ���������ݱ������ͼ�����Ժͷ���
}//Java �������ڼ���ö������͵ķ���
class Student extends Person{
	int sid = 5;
	public void whoru(){System.out.println(name);}
}
class Person{
	String name = "Tom";
	public void whoru(){}
}