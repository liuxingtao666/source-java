package day02;
/**
 * 字符串连接性能比较 
 */
public class Demo08 {
	public static void main(String[] args) {
		System.out.println(test1(100000));
		System.out.println(test2(100000));
	}
	public static long test1(int n){
		long start = System.currentTimeMillis();
		String s = "";
		for(int i=0; i<n; i++){	s += "a";	}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long test2(int n){
		long start = System.currentTimeMillis();
		StringBuilder buf = new StringBuilder();
		for(int i=0;i<n;i++){	buf.append("a");}
		String s = buf.toString();
		long end = System.currentTimeMillis();
		return end - start;
	}
}
