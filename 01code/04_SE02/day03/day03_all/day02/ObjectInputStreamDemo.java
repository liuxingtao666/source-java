package day02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * ����ķ����л� 
 */
public class ObjectInputStreamDemo {
	public static void main(String[] args)
		throws Exception {
		ObjectInputStream in = 
		   new ObjectInputStream(
		   new BufferedInputStream(
		   new FileInputStream(
				   "obj.dat")));
		//�����ж�ȡbyte���ݷ����л�Ϊ����
		Foo f = (Foo)in.readObject();
		String s=(String)in.readObject();
		System.out.println(f);
		System.out.println(s);
		in.close();
	}
}






