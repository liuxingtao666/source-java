package day03;
/**
 * 符合赋值运算
 */
public class Demo04 {
	public static void main(String[] args) {
		int a = 1;
		int c;
		//a = a+5.5;
		c = a += 5.5; // 相当于 a = (int)(a+5.5)
		System.out.println(a);//6
		byte b1=1;
		//b1 = b1+1;//编译错误
		b1 += 1;// b1=(byte)(b1+1)
	}

}
