package day01;
/**
 * 字符串对象不变
  3) 字符串对象是不可改变的对象。
  4) 字符串引用变量的值可以改变。 
      "江山易改本性难移"
 */
public class Demo05 {
	public static void main(String[] args) {
		String s1 = "What is ";
		System.out.println("s1:"+s1);
		String s2 = s1;
		s1 = s1+"Java!";
		System.out.println("s2:"+s2);
		System.out.println("s1:"+s1);
		//s1 （变量的值）变了呀！
	}
}




