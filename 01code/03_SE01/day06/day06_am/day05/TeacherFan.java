package day05;
/**
 * 范老师
 * @author Administrator
 *
 */
public class TeacherFan extends Person{

	@Override
	public void hello() {
		System.out.println("大家好!");
		
	}

	@Override
	public void sayName() {
		System.out.println("我叫范老师");
		
	}

	@Override
	public void sayInfo() {
		System.out.println("我是一名老师");
		System.out.println("我喜欢毁人不倦");
	}

}
