package com.tarena.tetris;

import java.util.Random;

/**
 * 4�񷽿��� 
 *
 */
public abstract class Tetromino {
	/** 4�����ӣ���������ʹ�õ����� protected*/
	protected Cell[] cells = new Cell[4];
	/** �������7�ַ���֮һ */
	public static Tetromino randomOne(){
		Random random = new Random(); 
		int type = random.nextInt(7);
		switch (type) {
		case 0: return new T();
		case 1: return new S();
		case 2: return new Z();
		case 3: return new I();
		case 4: return new L();
		case 5: return new J();
		case 6: return new O();
		}
		return null;
	}
	public void softDrop(){
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			cell.drop();
		}
	}
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			cell.moveLeft();
		}
	}
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			cell.moveRight();
		}
	}
}
/** T �ͷ��飬������ */
class T extends Tetromino{
	public T() {
		cells[0] = new Cell(0,4,null);
		cells[1] = new Cell(0,3,null);
		cells[2] = new Cell(0,5,null);
		cells[3] = new Cell(1,4,null);
	}
}
class S extends Tetromino{
	public S() {
		cells[0] = new Cell(0,4,null);
		cells[1] = new Cell(0,5,null);
		cells[2] = new Cell(1,3,null);
		cells[3] = new Cell(1,4,null);
	}
}
class L extends Tetromino{
	public L() {
		cells[0] = new Cell(0,4,null);
		cells[1] = new Cell(0,3,null);
		cells[2] = new Cell(0,5,null);
		cells[3] = new Cell(1,3,null);
	}
}
class J extends Tetromino{
	public J() {
		cells[0] = new Cell(0,4,null);
		cells[1] = new Cell(0,3,null);
		cells[2] = new Cell(0,5,null);
		cells[3] = new Cell(1,5,null);
	}
}
class Z extends Tetromino{
	public Z() {
		cells[0] = new Cell(1,4,null);
		cells[1] = new Cell(1,5,null);
		cells[2] = new Cell(0,3,null);
		cells[3] = new Cell(0,4,null);
	}
}
class O extends Tetromino{
	public O() {
		cells[0] = new Cell(0,4,null);
		cells[1] = new Cell(0,5,null);
		cells[2] = new Cell(1,4,null);
		cells[3] = new Cell(1,5,null);
	}
}
class I extends Tetromino{
	public I() {
		cells[0] = new Cell(0,4,null);
		cells[1] = new Cell(0,3,null);
		cells[2] = new Cell(0,5,null);
		cells[3] = new Cell(0,6,null);
	}
}




