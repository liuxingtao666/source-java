package day04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java中的栈
 * 使用双端队列实现
 * 实现方式为:
 * 只使用队列的一端进出，这样就实现了栈
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		
		Deque<String> stack
			= new LinkedList<String>();
		/*
		 * 双端队列为栈的实现单独提供的方法
		 * 压入 push
		 * 入栈方法
		 */
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		
		System.out.println(stack);
		
		/*
		 * 出栈方法
		 * pop
		 */
		for(int i=stack.size();i>0;i--){
			String e = stack.pop();
			System.out.println(e);
		}
		System.out.println(stack);
		/*
		 * 栈中若没有元素了，pop方法会抛出异常
		 */
//		String str = stack.pop();
		
		/*
		 * peek方法，引用栈顶元素，不会从栈中删除
		 */
	}
}



	