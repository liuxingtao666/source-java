package day04;

public class Demo02 {
	public static void main(String[] args) {
		Super s = new Sub();
		s.test();//��д����
		//s.t();//������t
		s.t1();
	}
}
class Super{
	public void t1(/*Super this*/){
		//this �ı������ͣ�Super
		//this ���õĶ������ͣ������ڼ�ȷ��
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
	public void test() {//��д�ķ���
		System.out.println("Sub test"); 
	}
	public void t(){
		System.out.println("Sub t");
	}	
}


