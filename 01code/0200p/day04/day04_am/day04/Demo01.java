package day04;

public class Demo01 {
	public static void main(String[] args) {
		Foo f = new Foo();
		String a = null;
		f.test(a);
		//f.test(null);//�������޷�ȷ�����Ǹ�����
	}
}
class Foo{
	public void test(int[] ary){
		System.out.println("test int[]");
	}
	public void test(String s){
		System.out.println("test String");
	}
}