package day02;
/**
 * StringBuilder
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		StringBuilder buf = new StringBuilder();
		buf.append("HI").append("您好")
			.append("再见").insert(4, "你是谁")
			.delete(7, 7+2);
		//可以利用toString 转化为字符串
		String str = buf.toString();
		System.out.println(str); 
	}
}
