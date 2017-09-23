package com.tarena.tetris;
/**
 * 单元测试, 案例 
 */
public class Test1 {
	public static void main(String[] args) {
		//randomOne() 称为简工厂方法
		//简单工厂方法生产一个对象
		Tetromino t = Tetromino.randomOne();
		System.out.println(t);
		t.softDrop();
		System.out.println(t);
		t.moveLeft();
		System.out.println(t);
		t.softDrop();
		System.out.println(t);
		t.moveRight();
		System.out.println(t);
	}
}
