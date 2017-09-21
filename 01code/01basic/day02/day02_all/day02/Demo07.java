package day02;

public class Demo07 {
	public static void main(String[] args) {
		//自动转换
		int i = -2;
		long l = i;
		System.out.println(l);//64位的-2
		//强制类型转换
		l = -6L;
		//i = l;//编译错,不能直接赋值
		i = (int)l;
		System.out.println(i);//-6 32位的-6
		//溢出现象
		l = 0x12abef00000005L;
		i = (int)l;//削去高的32位 "12abef"
		System.out.println(i);
		System.out.println(l);
		System.out.println(Long.toBinaryString(l));
		
		//float 的范围超过了long的范围
		float p = 3.1415926535897F * 
				100000000000000000000F;
		System.out.println(p); 
		float f = Long.MAX_VALUE;
		System.out.println(f); 
		//精度损失
		double d = 3.1415926535897D;
		float x = (float)d;
		System.out.println(d);
		System.out.println(f);
		
		//实现小数（浮点数）到整数的4舍5入
		double price = 4.56;
		long val = (long)(price + 0.5);
		System.out.println(val);//5
	}
}




