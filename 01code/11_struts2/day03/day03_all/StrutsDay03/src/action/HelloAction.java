package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;

import entity.Emp;
import entity.User;

/**
 *	Struts2��HelloWorldʾ����
 *	ҵ���ڿ���̨���һ�仰��
 */
public class HelloAction {
	
	//��������
	private int id = 6;
	private String name = "Tarena";
	//ʵ�����
	private User user = new User();
	//��ʼ������/����
	private List<String> langList = 
		new ArrayList<String>();
	private String[] langArray = 
		new String[] {"Java","php","c#"};
	//��ʼ��Map
	private Map<String, String> empMap = 
		new HashMap<String, String>();
	
	//ʵ�����ļ���
	private List<Emp> emps = 
		new ArrayList<Emp>();
	
	//ѭ�������
	private int from = 1;
	//ѭ�����յ�
	private int to = 3;
	
	public String sayHello() {
		//��ʼ��ʵ���������
		user.setUserName("Zhangsan");
		user.setPassword("abc");
		//��ʼ����������
		langList.add("Java");
		langList.add("php");
		langList.add("c#");
		//��ʼ��Map����
		empMap.put("zhangsan", "Java");
		empMap.put("lisi", "php");
		empMap.put("wangwu", "c#");
		//��ʼ��Ա������
		Emp e1 = new Emp();
		e1.setEmpName("����");
		e1.setSalary(3000.00);
		emps.add(e1);
		Emp e2 = new Emp();
		e2.setEmpName("����");
		e2.setSalary(4000.00);
		emps.add(e2);
		return "ok";
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Map<String, String> getEmpMap() {
		return empMap;
	}

	public void setEmpMap(Map<String, String> empMap) {
		this.empMap = empMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getLangArray() {
		return langArray;
	}

	public void setLangArray(String[] langArray) {
		this.langArray = langArray;
	}

	public List<String> getLangList() {
		return langList;
	}

	public void setLangList(List<String> langList) {
		this.langList = langList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ҵ�񷽷������"���,Action"
	 */
	public String sayNihao() {
		System.out.println("��ã�Action");
		return "ok";
	}
	
}
