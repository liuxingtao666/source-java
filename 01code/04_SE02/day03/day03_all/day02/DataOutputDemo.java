package day02;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * ��������� 
 * 
 */
public class DataOutputDemo {
	public static void main(String[] args) 
		throws IOException {
		DataOutputStream out = 
			new DataOutputStream(
			new BufferedOutputStream(
			new FileOutputStream("d.dat")));
		/* ���������4byteд�뵽�ļ� */
		out.writeInt(0);
		out.writeInt(4);
		/* ��double���8byteд�뵽�ļ� */
		out.writeDouble(3.14);
		out.close();
	}
}


