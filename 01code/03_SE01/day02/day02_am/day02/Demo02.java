package day02;
/**
 * 字符串的替换操作 
 */
public class Demo02 {
	public static void main(String[] args) {
		String str = "那一年我去了她家，" +
				"她说:我了个去";
		String s = str.replaceAll(
				"(我[去草])|(我了个去)", "XX");
		System.out.println(s); 
	}

}
