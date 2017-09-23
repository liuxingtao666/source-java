package day05;
import java.util.Arrays;
import java.util.Comparator;
/**
 * Comparator �Ƚ������ǱȽϹ���ӿ�
 * Լ����αȽ���������Ĵ�С 
 * Լ���ķ����У�compare(o1, o2)
 * ����0 ��ʾ o1 �� o2 ���
 * ���ظ��� ��ʾ o1 С�� o2 
 * �������� ��ʾ o1 ���� o2
 */
public class Demo03 {
	public static void main(String[] args) {
		//�����ַ����ĳ��ȱȽϴ�С
		// ����һ�� = 0     
		// o1 �� �� o2 = ����
		// o1 �� �� o2 = ����
		// �����㷨�� o1.length() - o2.length()
		//<String> ���ͣ������ʾ���Ƚϵ�����
		Comparator<String> byLength = 
			new Comparator<String>(){
			public int compare(
					String o1, String o2) {
				//return o1.length()-o2.length();
				return o1.charAt(1)-o2.charAt(1);
			}
		};
		System.out.println(
				byLength.compare("A","BBB")); 
		String[] ary={"AAAA","BB","ax","abc"};
		//sort ��������byLength ��������
		Arrays.sort(ary, byLength);
		//���Զ���Ƚϴ�С�ķ�����ί�и�������㷨
		//ִ�У��ͻ�õ��Զ����������
		System.out.println(Arrays.toString(ary)); 
	}

}



