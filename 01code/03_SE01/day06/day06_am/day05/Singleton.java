package day05;
/**
 * 单例模式
 * @author Administrator
 *
 */
public class Singleton {
	/*
	 * 第二步:创建一个私有的静态的当前类型的属性
	 *       并且实例化
	 * 目的:创建唯一的一个实例
	 */
	private static Singleton instance 
						= new Singleton();
	
	/*
	 * 第一步:私有化构造方法
	 * 目的:阻止外界通过new关键字实例化当前类型
	 */
	private Singleton(){
		
	}
	
	/*
	 * 第三步:声明一个静态的，
	 * 公有的获取当前类型实例的方法
	 * 目的:使外界可以获取该类型实例
	 */
	public static Singleton getInstance(){
		return instance;
	}
}




