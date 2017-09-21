package day02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 对象的反序列化 
 */
public class ObjectInputStreamDemo {
	public static void main(String[] args)
		throws Exception {
		ObjectInputStream in = 
		   new ObjectInputStream(
		   new BufferedInputStream(
		   new FileInputStream(
				   "obj.dat")));
		//从流中读取byte数据反序列化为对象
		Foo f = (Foo)in.readObject();
		String s=(String)in.readObject();
		System.out.println(f);
		System.out.println(s);
		in.close();
	}
}






