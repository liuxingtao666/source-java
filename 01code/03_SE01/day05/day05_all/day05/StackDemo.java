package day04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java�е�ջ
 * ʹ��˫�˶���ʵ��
 * ʵ�ַ�ʽΪ:
 * ֻʹ�ö��е�һ�˽�����������ʵ����ջ
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		
		Deque<String> stack
			= new LinkedList<String>();
		/*
		 * ˫�˶���Ϊջ��ʵ�ֵ����ṩ�ķ���
		 * ѹ�� push
		 * ��ջ����
		 */
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		
		System.out.println(stack);
		
		/*
		 * ��ջ����
		 * pop
		 */
		for(int i=stack.size();i>0;i--){
			String e = stack.pop();
			System.out.println(e);
		}
		System.out.println(stack);
		/*
		 * ջ����û��Ԫ���ˣ�pop�������׳��쳣
		 */
//		String str = stack.pop();
		
		/*
		 * peek����������ջ��Ԫ�أ������ջ��ɾ��
		 */
	}
}



	