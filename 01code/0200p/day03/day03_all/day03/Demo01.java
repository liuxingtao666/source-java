package day03;

public class Demo01 {
	public static void main(String[] args) {
		T8000 t = new T8000();
		t=null;
		System.gc();//尽快强制垃圾收集，销毁对象
	}
}
class T8000{
	public T8000() {
		System.out.println("Create Object");
	}
	protected void finalize() throws Throwable {
		super.finalize();//要求调用父类方法
		System.out.println("I will be back!"); 
	}
}
