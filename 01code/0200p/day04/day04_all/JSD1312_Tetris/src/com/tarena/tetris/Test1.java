package com.tarena.tetris;
/**
 * ��Ԫ����, ���� 
 */
public class Test1 {
	public static void main(String[] args) {
		//randomOne() ��Ϊ�򹤳�����
		//�򵥹�����������һ������
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
