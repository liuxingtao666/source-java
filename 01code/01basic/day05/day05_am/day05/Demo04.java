package day05;
import java.util.Arrays;
/**
 * 数组的迭代
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] ary1=new int[] { 3, 5, 7, 2, 6 };
		//输出的ary1.toString()结果，没有意义
		System.out.println(ary1);//不能输出数组内容
		// 0 1 2 3 4 长度5
		// 访问数组元素 ary1[i] i = 0 1 2 3 4
		for (int i = 0; i < 5; i++) {
			// i = 0 1 2 3 4
			System.out.print(ary1[i] + " ");
		}
		System.out.println();
		//可以使用API 简化输出数组内容
		System.out.println(
				Arrays.toString(ary1)); 
	}

}
