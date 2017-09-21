package day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列
 * 存取元素遵循先进先出原则
 * 同样的队列也支持泛型，用于约束元素类型
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		//java.util.Queue
		Queue<String> queue
			= new LinkedList<String>();
		
		//向队列中添加元素  入队
		/*
		 * offer方法:向队列中添加元素
		 */
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		System.out.println(queue);
		
		/*
		 * 从队首移除并返回该元素  出队
		 * poll
		 */
		String e = queue.poll();
		System.out.println("队首"+e);
		System.out.println(queue);
		
		/*
		 * peek()方法:
		 * 引用队首元素，该操作不会将队首元素移除
		 */
		e = queue.peek();
		System.out.println("新的队首:"+e);
		System.out.println(queue);
		//输出队列元素数量
		System.out.println(queue.size());
	}
}




