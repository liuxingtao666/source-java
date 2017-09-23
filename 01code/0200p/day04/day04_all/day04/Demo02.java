package day04;

public class Demo02 {
	public static void main(String[] args) {
		Super s = new Sub();
		s.test();//重写调用
		//s.t();//看不到t
		s.t1();
	}
}
class Super{
	public void t1(/*Super this*/){
		//this 的变量类型：Super
		//this 引用的对象类型，运行期间确定
		this.test();
		this.t();
	}
	public void test(){
		System.out.println("Super test");
	}
	private void t(){
		System.out.println("Super t");
	}
}
class Sub extends Super{ 
	public void test() {//重写的方法
		System.out.println("Sub test"); 
	}
	public void t(){
		System.out.println("Sub t");
	}	
}


