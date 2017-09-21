package day05;
/**
 * 定义和初始化数组变量 
 */
public class Demo02 {
	public static void main(String[] args) {
		int[] ary;
		//System.out.println(Army);//编译错
		ary = null;//是初始化 
		//有数组变量ary但是没有被引用的数组
		System.out.println(ary);//null，变量的值
		//如果一个数组变量的值是null，没有数组
		//时候，读(写)取了数组的元素则发生空指针异常
		System.out.println(ary[0]);
		//选择执行结果
		//A.编译错误  B.运行异常  C.0  D.null
	}
}


