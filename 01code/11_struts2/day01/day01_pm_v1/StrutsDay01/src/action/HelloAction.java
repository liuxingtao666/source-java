package action;

/**
 *	Struts2的HelloWorld示例。
 *	业务：在控制台输出一句话。
 */
public class HelloAction {
	
	public HelloAction() {
		System.out.println("实例化HelloAction...");
	}
	
	/**
	 * 业务方法，用于实现输出一句话的业务。
	 * 1.方法是public的
	 * 2.该方法不需要任何参数
	 * 3.该方法必须返回String
	 */
	public String sayHello() {
		//实现业务，即输出一句话
		System.out.println("Hello,Action.");
		//返回的字符串用于找到对应的JSP
		return "ok";
	}

}
