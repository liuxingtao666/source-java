package day01;

public class Demo06 {
	public static void main(String[] args) {
		String str = "What is Java!好";
		System.out.println(str.length());//14
		//查找字符串的最后一个字符
		char c = str.charAt(str.length()-1);
		System.out.println(c); //好
		//查找"好"在字符串中的位置，
		//如果没有找到返回负数
		int index = str.indexOf("a");
		System.out.println(index); 
		index = str.indexOf("a", 3);
		System.out.println(index); 
		
		//检查一个字符串命令是否是get开头的
		String cmd = "get photo.png";//"put p.png"
		if(cmd.startsWith("get ")){
			System.out.println("这是一个下载命令"); 
		}
		//检查一个文件名是否是 .png 图片文件
		String file = "T.png";
		if(file.endsWith(".png")){
			System.out.println("这是一个图片"); 
		}
		//toUpperCase()改变内容时候返回新字符串
		//原字符串内容不变
		String s = str.toUpperCase();
		System.out.println(s);//新字符串
		System.out.println(str); 
		//如果没有改变内容，返回的“可能”是原字符串
		//没有创建新对象，“性能好！”
		String ss = s.toUpperCase();
		System.out.println(ss);
		System.out.println(ss==s);//true是同一个对象
		
		//去掉输入用户名可能的两端空白
		String name = " \r  Tom  \t \n";
		name = name.trim().toLowerCase();
		System.out.println(name); 
		
		//
		String email = "liucangsong@gmail.com";
		name = email.substring(0,11);
		String host = email.substring(12);
		System.out.println(name + ","+host); 
		
		name=email.substring(0,email.indexOf('@'));
		host=email.substring(email.indexOf('@')+1);
		System.out.println(name + ","+host); 
	}
}






