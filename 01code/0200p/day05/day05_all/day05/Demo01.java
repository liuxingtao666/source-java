package day05;
/**
 * ������ 
 */
public class Demo01 {
	public static void main(String[] args) {
		Foo foo = new Foo(){};//�����ڲ���
		//Koo koo = new Koo();//�������
		Koo koo = new Koo(){};//����Koo�ӿڵ�
		//������ʵ�����Ƕ�Koo�ӿڵı��ʵ��
		Koo[] ks = new Koo[1];
		//�������飬Ԫ��Koo���͵Ķ���
		//Goo goo=new Goo(){};//�����û��ʵ�ַ���
		Goo goo=new Goo(){
			public void test() {
				System.out.println("test");
			}
		};
		goo.test();
	}
}
interface Goo{
	void test();
}
interface Koo{
}
class Foo{
}


