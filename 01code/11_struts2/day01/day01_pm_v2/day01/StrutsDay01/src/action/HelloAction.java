package action;

/**
 *	Struts2��HelloWorldʾ����
 *	ҵ���ڿ���̨���һ�仰��
 */
public class HelloAction {
	
	// ��������
	private String realName; //����
	
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
	
}
