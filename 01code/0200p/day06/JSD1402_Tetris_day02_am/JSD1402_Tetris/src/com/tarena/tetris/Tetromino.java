package com.tarena.tetris;

import java.util.Arrays;
import java.util.Random;

/**
 * 4格方块类 
 *
 */
public abstract class Tetromino {
	/** 4个格子，留给子类使用的属性 protected*/
	protected Cell[] cells = new Cell[4];
	/** 随机参数7种方块之一 */
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
	@Override
	public String toString() {
		return Arrays.toString(cells);
	}
}
/** T 型方块，包内类 */
class T extends Tetromino{
	public T() {
		cells[0] = new Cell(0,4,Tetris.T);
		cells[1] = new Cell(0,3,Tetris.T);
		cells[2] = new Cell(0,5,Tetris.T);
		cells[3] = new Cell(1,4,Tetris.T);
	}
}
class S extends Tetromino{
	public S() {
		cells[0] = new Cell(0,4,Tetris.S);
		cells[1] = new Cell(0,5,Tetris.S);
		cells[2] = new Cell(1,3,Tetris.S);
		cells[3] = new Cell(1,4,Tetris.S);
	}
}
class L extends Tetromino{
	public L() {
		cells[0] = new Cell(0,4,Tetris.L);
		cells[1] = new Cell(0,3,Tetris.L);
		cells[2] = new Cell(0,5,Tetris.L);
		cells[3] = new Cell(1,3,Tetris.L);
	}
}
class J extends Tetromino{
	public J() {
		cells[0] = new Cell(0,4,Tetris.J);
		cells[1] = new Cell(0,3,Tetris.J);
		cells[2] = new Cell(0,5,Tetris.J);
		cells[3] = new Cell(1,5,Tetris.J);
	}
}
class Z extends Tetromino{
	public Z() {
		cells[0] = new Cell(1,4,Tetris.Z);
		cells[1] = new Cell(1,5,Tetris.Z);
		cells[2] = new Cell(0,3,Tetris.Z);
		cells[3] = new Cell(0,4,Tetris.Z);
	}
}
class O extends Tetromino{
	public O() {
		cells[0] = new Cell(0,4,Tetris.O);
		cells[1] = new Cell(0,5,Tetris.O);
		cells[2] = new Cell(1,4,Tetris.O);
		cells[3] = new Cell(1,5,Tetris.O);
	}
}
class I extends Tetromino{
	public I() {
		cells[0] = new Cell(0,4,Tetris.I);
		cells[1] = new Cell(0,3,Tetris.I);
		cells[2] = new Cell(0,5,Tetris.I);
		cells[3] = new Cell(0,6,Tetris.I);
	}
}




