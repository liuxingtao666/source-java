package day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������
 * @author Administrator
 *
 */
public class IterateQueue {
	public static void main(String[] args) {
		Queue<String> queue
			= new LinkedList<String>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		queue.add("E");
		queue.add("F");
		System.out.println(queue);
		
//		for(int i=0;i<queue.size();i++){
//			String e = queue.poll();
//			System.out.println(e);
//		}
//		System.out.println(queue);
		
		for(int i = queue.size();i>0;i--){
			String e = queue.poll();
			System.out.println(e);
		}
		System.out.println(queue);
		
		
		/*
		 * poll������һ���ص�
		 * ������Ϊ��ʱ��poll��������null
		 */
//		String e = null;
//		while((e = queue.poll())!= null){
//			System.out.println(e);
//		}
//		System.out.println(queue);
		
		
	}
}



