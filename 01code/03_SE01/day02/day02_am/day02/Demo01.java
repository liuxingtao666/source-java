package day02;
/**
 * ¾²Ì¬×Ö·û´®ÏÖÏó 
 */
public class Demo01 {
	public static final String S = "123ABC";
	public static final String SS = "ABC";
	public static void main(String[] args) {
		String s1 = "123ABC";
		String s2 = 123 + SS;
		String s3 = 123 + "ABC";
		String s4 = 1+2+3+ "ABC";
		String s5 = "1"+2+3+ "ABC";
		String s6 = '1'+2+3+ "ABC";
		String s7 = "ABC";
		String s8 = 123+s7;
		String s9 = new String("123ABC");
		String s10 = "123abc".toUpperCase();
	}
}
