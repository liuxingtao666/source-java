package day05;
/**
 * 3种创建数组的方法 
 */
public class Demo03 {
	public static void main(String[] args) {
		int[] ary1 = new int[]{3,4,5};
		int[] ary2 = new int[3000];//12*1000Byte
		int[] ary3 = {4,5,6};
		System.out.println(ary1[0]);//3
		System.out.println(ary2[2999]);//0
		System.out.println(ary3[2]);//6
		double[] ary4 = new double[3000];
		System.out.println(ary4[2999]);//0.0
		String[] ary5 = new String[3000];
		System.out.println(ary5[2999]);//null
		System.out.println("字符数组");
		char[] chs = new char[5];
		System.out.println((int)chs[0]);// 
	}
}




