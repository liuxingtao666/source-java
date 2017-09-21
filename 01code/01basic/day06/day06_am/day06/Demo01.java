package day06;

public class Demo01 {
	public static void main(String[] args) {
		int a = get(new int[] { 2, 3, 4 });
		a = get(new int[3]);
		//a = get(null);
		a = get(new int[1]);//运行异常
	}
	public static int get(int[] ary) {
		//ary变量在运行期间先后引用了不同的数组
		//Java编译器是不能确定引用哪个数组的
		// 更不能确定数组的长度
		//所以Java编译器不能确定数组越界是编译错误
		// ary 的长度？
		// ary 有[1]元素吗
		return ary[1];
	}
}
