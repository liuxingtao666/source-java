package day01;
/** Object ���κ����͵ĸ����ͣ�Object�Ƕ�̬�� */
public class Demo01 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		Object obj = foo;
		//Object ������Foo�ĸ�����
		obj = new Koo();
	}
}
class Foo /* extends Object */ {
}
class Koo{
}
