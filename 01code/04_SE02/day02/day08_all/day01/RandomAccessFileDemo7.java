package day01;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 其它读写方法
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
		String name = "苍小松";
		
		RandomAccessFile raf
			= new RandomAccessFile(
				"data.sav","rw"
			);
		
		//将钱写入存档
		System.out.println(Integer.toBinaryString(money));
		/*
		 * void writeInt(int d)
		 * 连续写入4个字节，将给定的int值写入
		 */
		raf.writeInt(money);
		//写等级
		raf.write(lv);
		//写hp
		raf.writeShort(hp);
		//写mp
		raf.writeShort(mp);
		//写经验值
		raf.writeLong(exp);
		//写名字
		/*
		 * void writeUTF(String str)
		 * 将给定的字符串按照UTF-8编码转换为
		 * 字节后写出。
		 */
		raf.writeUTF(name);
		
		
		//读取进度
		raf.seek(0);
		
		//读钱
		/*
		 * int readInt()
		 * 连续读取4个字节，并转换为对应的int值
		 * 返回。
		 * 注意，若在连续读取4个字节的过程中发现
		 * 读取到了文件末尾，该方法会抛出异常
		 * EOFException,而并不是返回-1
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





