package day03;

public class Demo01 {
	public static void main(String[] args) {
		T8000 t = new T8000();
		t=null;
		System.gc();//����ǿ�������ռ������ٶ���
	}
}
class T8000{
	public T8000() {
		System.out.println("Create Object");
	}
	protected void finalize() throws Throwable {
		super.finalize();//Ҫ����ø��෽��
		System.out.println("I will be back!"); 
	}
}
