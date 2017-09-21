package day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ڶ������л��������
 * ObjectOutputStream
 * 
 * ���������������л�:
 *   ��������������ת��Ϊ�ֽ����еĹ���
 * �������л�
 *   ������ת��Ϊ�ֽ����еĹ���  
 *   
 * ���������л���д����̵Ĺ��̳�Ϊ�־û���  
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args)throws Exception {
		FileOutputStream fos
			= new FileOutputStream("person.obj");
		
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		List<String> list
			= new ArrayList<String>();
		
		list.add("�綯");
		list.add("����");
		list.add("ģ��");
		
		Person person = new Person("������",22,1,list);
		
		oos.writeObject(person);
		
		oos.close();
		
		
		FileInputStream fis
			= new FileInputStream(
					"person.obj");
		
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();
		
		/*
		 *	����һ�� 
		 */
		System.out.println(p.equals(person));
		/*
		 *  ����ͬһ������
		 */
		System.out.println(p == person);
		
		System.out.println(p);
		
		ois.close();
	}
}











