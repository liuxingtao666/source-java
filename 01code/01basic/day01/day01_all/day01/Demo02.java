package day01;
/**
 * 变量的语法 
 */
public class Demo02 {
	public static void main(String[] args) {
		//System.out.println(age);//编译错误
		int age;//声明/定义 变量age age年龄
		//System.out.println(age);//编译错误
		//A.编译错误 B.运行异常  C.0  D.null
		age = 5;//初始化，第一次赋值
		System.out.println(age);//5
		age = 6;//赋值
		System.out.println(age);//6
		//int a9e = 8;
		//System.out.println(a9e);
		{
			int score = 4;//声明直接初始化 分数
			System.out.println(score);//4
			//int age = 8;//重复定义
			//int score = 4;//重复定义
		}//是score 的作用域
		//System.out.println(score);//score不存在
		//int age = 8;//age重复定义了
		int score = 8;
		System.out.println(score);
	}

}
