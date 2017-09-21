package day05;
/**
 * 模板模式  模板类应该是个抽象类
 * 定义流程骨架
 * @author Administrator
 *
 */
public abstract class Person {
	/**
	 * 模板方法，该方法用于完成介绍自己
	 */
	public void sayHello(){
		
		//1先打招呼
		hello();
		
		//2说自己的名字
		sayName();
		
		//3介绍自己的情况
		sayInfo();
		
		//4说再见
		System.out.println("再见");
	}
	//打招呼方法
	public abstract void hello();
	
	//说自己的名字
	public abstract void sayName();
	
	//介绍自己
	public abstract void sayInfo();
	
}





