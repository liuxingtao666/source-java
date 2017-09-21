package day02;
/**
 * 数学运算 
 */
public class Demo08 {
	public static void main(String[] args) {
	//正常现象
		int i = 5;
		long l = 6;
		//int y = i+l;//编译错误
		long x = i + l;
		System.out.println(x); 
		
		byte b1 = 3;
		byte b2 = 4;
		//byte b3 = b1+b2;//编译错误
		int b3 = b1+b2;
		System.out.println(b3); 
		
		byte b4 = 3+4;//7没有超过范围
		//byte b5 = 3+126;//超范围了！
		
		//运算的溢出现象
		i = Integer.MAX_VALUE;
		int n = i+1;//溢出了
		System.out.println(n); 
		
		l = i + 1;//溢出了！
		System.out.println(l); 
		
		l = i + 1L;//(long)i+1
		System.out.println(l); 
	}
}










