package day02;
/**
 * ����������ʽ����ع���
 * @author Administrator
 * 
 */
public class RexDemo {
	
	public static void main(String[] args) {
		
		/*
		 * fancq@tarena.com.cn
		 * 
		 * \w+@\w+(\.com|\.cn|\.com\.cn)
		 * ������ʽ����֤�ַ���ʱ
		 * ֻ��ע��ʽ�Ƿ���ȷ�������������Ƿ���Ч
		 */
//		String regex 
//			= "\\w+@\\w+(\\.com|\\.cn|\\.com\\.cn)";
//		System.out.println(regex);
//		
//		String mail = "fancq@tarena.com.cn";
//		System.out.println(
//				"�Ƿ�������:" + 
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
		
		String info = "���SB����ô����ô2B��NND��MLGB��";
		
		info = info.replaceAll(regex, "***");
		System.out.println(info);
	}
	
	
}






