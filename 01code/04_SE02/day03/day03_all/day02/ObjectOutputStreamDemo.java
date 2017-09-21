package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 对象的序列化 
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
		out.writeObject("好好的");
		out.close();
	}
}
class Foo implements Serializable{
	String name = "Tom";
	//transient 瞬态关键字，属性不会被序列化
	transient String pwd = "123";
	int i=4;
	public String toString() {
		return name+","+i+","+pwd; 
	}
}