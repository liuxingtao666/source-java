package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Son extends Father{
	/**
	 * 重写父类方法时，可以不再声明异常的抛出
	 */
	public void test(){
		
	}
	/**
	 * 重写父类方法时，可以只声明抛出父类方法
	 * 抛出的部分异常
	 */
	public void test1()
				throws ParseException{
		
	}
	/**
	 * 重写父类方法是，可以只声明抛出父类抛出
	 * 的异常的子类异常
	 */
	public void test2()
		  throws ClassCastException{
		
	}
	/**
	 * 子类在重写父类方法时，不能抛出额外的异常
	 * 非检查异常例外，因为编译器忽略非检查异常
	 */
//	public void test3()
//		  throws IOException,ParseException{
//		
//	}
	
	/**
	 * 重写父类方法时，不能抛出父类方法声明抛出
	 * 异常的父类异常
	 */
	public void test4()
			throws Exception{
		
	}
}




