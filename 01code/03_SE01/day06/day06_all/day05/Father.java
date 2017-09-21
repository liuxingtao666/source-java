package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 * 用于测试子类重写父类带有异常抛出声明方法时的
 * 注意事项
 * @author Administrator
 *
 */
public class Father {
	public void test()throws Exception{
		
	}
	
	
	public void test1()
		throws IOException,
			   ParseException{
		
	}
	
	public void test2()
		throws RuntimeException{
		
	}
	
	public void test3()
		throws IOException{
		
	}
	
	public void test4()
		throws FileNotFoundException{
		
	}
}




