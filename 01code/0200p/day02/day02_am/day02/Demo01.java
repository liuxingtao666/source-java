package day02;
/**
 * Ĭ�Ϲ��������� 
 */
public class Demo01 {
	public static void main(String[] args) {
		Foo f = new Foo();//����Ĭ�Ϲ�����
		//Koo k = new Koo();//�������û�й�����
		//Koo() 
		//ѡ�����н����
		//A.������� B.�����쳣 C.�� D.Koo(int)
		Koo k = new Koo(8);
		//A.������� B.�����쳣 C.8 D.Koo(int)
	}
}
class Foo{
}
class Koo{
	public Koo(int a){
		System.out.println("Koo(int)"); 
	}
}



