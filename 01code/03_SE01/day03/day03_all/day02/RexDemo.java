package day02;
/**
 * 测试正则表达式的相关功能
 * @author Administrator
 * 
 */
public class RexDemo {
	
	public static void main(String[] args) {
		
		/*
		 * fancq@tarena.com.cn
		 * 
		 * \w+@\w+(\.com|\.cn|\.com\.cn)
		 * 正则表达式在验证字符串时
		 * 只关注格式是否正确，不关心内容是否有效
		 */
//		String regex 
//			= "\\w+@\\w+(\\.com|\\.cn|\\.com\\.cn)";
//		System.out.println(regex);
//		
//		String mail = "fancq@tarena.com.cn";
//		System.out.println(
//				"是否是邮箱:" + 
//				mail.matches(regex));
		
		
		/*
		 * String[] split(String regex)
		 */
//		String imgName = "123.jpg";
//		String[] names = imgName.split("\\.");
//		System.out.println(names.length);
//		long d = System.currentTimeMillis();
//		String newName = d + "." + names[1];
//		System.out.println(newName);
	
		
		/*
		 * replaceAll(String Regex,String rep)
		 */
		String regex = "(SB|2B|MB|213|JB|MLGB|NND)";
		
		String info = "你个SB！怎么能这么2B！NND！MLGB！";
		
		info = info.replaceAll(regex, "***");
		System.out.println(info);
	}
	
	
}






