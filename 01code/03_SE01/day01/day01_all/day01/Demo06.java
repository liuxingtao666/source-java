package day01;

public class Demo06 {
	public static void main(String[] args) {
		String str = "What is Java!��";
		System.out.println(str.length());//14
		//�����ַ��������һ���ַ�
		char c = str.charAt(str.length()-1);
		System.out.println(c); //��
		//����"��"���ַ����е�λ�ã�
		//���û���ҵ����ظ���
		int index = str.indexOf("a");
		System.out.println(index); 
		index = str.indexOf("a", 3);
		System.out.println(index); 
		
		//���һ���ַ��������Ƿ���get��ͷ��
		String cmd = "get photo.png";//"put p.png"
		if(cmd.startsWith("get ")){
			System.out.println("����һ����������"); 
		}
		//���һ���ļ����Ƿ��� .png ͼƬ�ļ�
		String file = "T.png";
		if(file.endsWith(".png")){
			System.out.println("����һ��ͼƬ"); 
		}
		//toUpperCase()�ı�����ʱ�򷵻����ַ���
		//ԭ�ַ������ݲ���
		String s = str.toUpperCase();
		System.out.println(s);//���ַ���
		System.out.println(str); 
		//���û�иı����ݣ����صġ����ܡ���ԭ�ַ���
		//û�д����¶��󣬡����ܺã���
		String ss = s.toUpperCase();
		System.out.println(ss);
		System.out.println(ss==s);//true��ͬһ������
		
		//ȥ�������û������ܵ����˿հ�
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






