package day02;
/**
 * 检查一个字符串是否符合 正则表达规则 
 */
public class Demo04 {
	public static void main(String[] args) {
		String str = "0,4|0,3|0,5|1,4";
		//注意 \ 需要转义为 \\
		String rule = "^(\\d,\\d\\|){3}\\d,\\d$";
		//rule:规则
		//检查str符合rule定义的正则规则
		boolean pass = str.matches(rule);
		System.out.println(pass);//true
	}

}
