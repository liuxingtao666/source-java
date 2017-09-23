package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.Emp;
import entity.User;

/**
 *	Struts2��HelloWorldʾ����
 *	ҵ���ڿ���̨���һ�仰��
 */
public class HelloAction 
	implements ModelDriven<Emp> {
	
	// ��������
	private String realName; //����
	// ��ģ��
	private User user; //�û�
	// ģ������
	private Emp emp = new Emp(); //Ա��
	
	public HelloAction() {
		System.out.println("ʵ����HelloAction...");
	}
	
	/**
	 * ҵ�񷽷�������ʵ�����һ�仰��ҵ��
	 * 1.������public��
	 * 2.�÷�������Ҫ�κβ���
	 * 3.�÷������뷵��String
	 */
	public String sayHello() {
		//ʵ��ҵ�񣬼����һ�仰
		System.out.println("Hello,Action.");
		
		// �����������
		System.out.println("������" + realName);
		// �����ģ��ע��Ĳ���
		System.out.println("�û�����" 
				+ user.getUserName());
		System.out.println("���룺" 
				+ user.getPassword());
		// ���ģ������ע��Ĳ���
		Emp e = getModel();
		System.out.println("Ա������"
				+ e.getEmpName());
		System.out.println("���ʣ�"
				+ e.getSalary());
		
		//���ص��ַ��������ҵ���Ӧ��JSP
		return "ok";
	}

	/**
	 * ҵ�񷽷������"���,Action"
	 */
	public String sayNihao() {
		System.out.println("��ã�Action");
		return "ok";
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
		System.out.println("ע��realName...");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		System.out.println("ע��user...");
	}

	/* 
	 * ʵ��ModelDriven�ӿڵķ�����Ҫ�󷵻�
	 * ��װ�����ݵĶ���
	 */
	public Emp getModel() {
		System.out.println("getModel...");
		return emp;
	}
	
}
