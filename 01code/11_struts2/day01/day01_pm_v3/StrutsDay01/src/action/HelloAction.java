package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.Emp;
import entity.User;

/**
 *	Struts2的HelloWorld示例。
 *	业务：在控制台输出一句话。
 */
public class HelloAction 
	implements ModelDriven<Emp> {
	
	// 基本属性
	private String realName; //姓名
	// 域模型
	private User user; //用户
	// 模型驱动
	private Emp emp = new Emp(); //员工
	
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
		
		// 输出基本属性
		System.out.println("姓名：" + realName);
		// 输出域模型注入的参数
		System.out.println("用户名：" 
				+ user.getUserName());
		System.out.println("密码：" 
				+ user.getPassword());
		// 输出模型驱动注入的参数
		Emp e = getModel();
		System.out.println("员工名："
				+ e.getEmpName());
		System.out.println("工资："
				+ e.getSalary());
		
		//返回的字符串用于找到对应的JSP
		return "ok";
	}

	/**
	 * 业务方法：输出"你好,Action"
	 */
	public String sayNihao() {
		System.out.println("你好，Action");
		return "ok";
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
		System.out.println("注入realName...");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		System.out.println("注入user...");
	}

	/* 
	 * 实现ModelDriven接口的方法，要求返回
	 * 封装表单数据的对象。
	 */
	public Emp getModel() {
		System.out.println("getModel...");
		return emp;
	}
	
}
