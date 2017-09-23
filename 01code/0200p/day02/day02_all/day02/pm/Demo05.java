package day02.pm;


public class Demo05 {
	public static void main(String[] args) {
		Integer i = new Integer(5);
		Double d = new Double(5.5);
		Number n = i;
		// Integer x = n;//编译错误
		Integer x = (Integer) n;
		//Double y = (Double) n;// 没有编译错误，运行异常
		test(i);
		test(d);
	}
	public static void test(Number n){
		//先检查对象的类型，再转换
		//n instanceof Double n引用的对象是否是
		// Double 类型的，是返回true，否则false
		if(n instanceof Double){
			Double d = (Double)n;
			System.out.println("浮点数"+d); 
		}else if(n instanceof Integer){
			Integer i = (Integer)n;
			System.out.println("整数"+i);
		}
	}
}
