package action;

/**
 *	Struts2��HelloWorldʾ����
 *	ҵ���ڿ���̨���һ�仰��
 */
public class HelloAction {
	
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
		//���ص��ַ��������ҵ���Ӧ��JSP
		return "ok";
	}

}
