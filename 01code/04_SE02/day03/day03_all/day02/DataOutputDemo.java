package day02;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 数据输出流 
 * 
 */
public class DataOutputDemo {
	public static void main(String[] args) 
		throws IOException {
		DataOutputStream out = 
			new DataOutputStream(
			new BufferedOutputStream(
			new FileOutputStream("d.dat")));
		/* 将整数拆成4byte写入到文件 */
		out.writeInt(0);
		out.writeInt(4);
		/* 将double拆成8byte写入到文件 */
		out.writeDouble(3.14);
		out.close();
	}
}


