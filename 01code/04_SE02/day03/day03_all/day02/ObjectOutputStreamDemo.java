package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * ��������л� 
 */
public class ObjectOutputStreamDemo {
	public static void main(String[] args) 
		throws Exception {
		Foo f = new Foo();
		ObjectOutputStream out=
			new ObjectOutputStream(
			new BufferedOutputStream(
			new FileOutputStream(
					"obj.dat")));
		out.writeObject(f);
		out.writeObject("�úõ�");
		out.close();
	}
}
class Foo implements Serializable{
	String name = "Tom";
	//transient ˲̬�ؼ��֣����Բ��ᱻ���л�
	transient String pwd = "123";
	int i=4;
	public String toString() {
		return name+","+i+","+pwd; 
	}
}