package day01;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * ������д����
 * @author Administrator
 *
 */
public class RandomAccessFileDemo7 {
	public static void main(String[] args) throws Exception {
		/*
		 * name 
		 * money
		 * hp
		 * mp
		 * exp
		 * lv
		 */
		
		int money = 999999;
		byte lv = 55;
		short hp = 20000;
		short mp = 30000;
		long exp = 300000;
		String name = "��С��";
		
		RandomAccessFile raf
			= new RandomAccessFile(
				"data.sav","rw"
			);
		
		//��Ǯд��浵
		System.out.println(Integer.toBinaryString(money));
		/*
		 * void writeInt(int d)
		 * ����д��4���ֽڣ���������intֵд��
		 */
		raf.writeInt(money);
		//д�ȼ�
		raf.write(lv);
		//дhp
		raf.writeShort(hp);
		//дmp
		raf.writeShort(mp);
		//д����ֵ
		raf.writeLong(exp);
		//д����
		/*
		 * void writeUTF(String str)
		 * ���������ַ�������UTF-8����ת��Ϊ
		 * �ֽں�д����
		 */
		raf.writeUTF(name);
		
		
		//��ȡ����
		raf.seek(0);
		
		//��Ǯ
		/*
		 * int readInt()
		 * ������ȡ4���ֽڣ���ת��Ϊ��Ӧ��intֵ
		 * ���ء�
		 * ע�⣬����������ȡ4���ֽڵĹ����з���
		 * ��ȡ�����ļ�ĩβ���÷������׳��쳣
		 * EOFException,�������Ƿ���-1
		 */
		int m = raf.readInt();
		System.out.println("money:"+m);
		
		int l = raf.readByte();
		System.out.println("lv:"+l);
		
		short hh = raf.readShort();
		System.out.println("hp:"+hh);
		
		short mm = raf.readShort();
		System.out.println("mp:"+mm);
		
		long e = raf.readLong();
		System.out.println("exp:"+e);
		raf.close();
	}
}





