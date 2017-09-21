package day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于对象序列化的输出流
 * ObjectOutputStream
 * 
 * 基本类型数据序列化:
 *   将基本类型数据转换为字节序列的过程
 * 对象序列化
 *   将对象转换为字节序列的过程  
 *   
 * 将对象序列化后写入磁盘的过程称为持久化。  
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
		
		list.add("电动");
		list.add("旅游");
		list.add("模型");
		
		Person person = new Person("范传奇",22,1,list);
		
		oos.writeObject(person);
		
		oos.close();
		
		
		FileInputStream fis
			= new FileInputStream(
					"person.obj");
		
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();
		
		/*
		 *	内容一致 
		 */
		System.out.println(p.equals(person));
		/*
		 *  不是同一个对象
		 */
		System.out.println(p == person);
		
		System.out.println(p);
		
		ois.close();
	}
}











