package day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����
 * ��ȡԪ����ѭ�Ƚ��ȳ�ԭ��
 * ͬ���Ķ���Ҳ֧�ַ��ͣ�����Լ��Ԫ������
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		//java.util.Queue
		Queue<String> queue
			= new LinkedList<String>();
		
		//����������Ԫ��  ���
		/*
		 * offer����:����������Ԫ��
		 */
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		System.out.println(queue);
		
		/*
		 * �Ӷ����Ƴ������ظ�Ԫ��  ����
		 * poll
		 */
		String e = queue.poll();
		System.out.println("����"+e);
		System.out.println(queue);
		
		/*
		 * peek()����:
		 * ���ö���Ԫ�أ��ò������Ὣ����Ԫ���Ƴ�
		 */
		e = queue.peek();
		System.out.println("�µĶ���:"+e);
		System.out.println(queue);
		//�������Ԫ������
		System.out.println(queue.size());
	}
}




