package day03.pm;

import java.util.Random;

public class Demo11 {
	public static void main(String[] args) {
		Tetromino t = Tetromino.randomOne();
		System.out.println(t); 
	}
}
class Tetromino{
	protected Cell[] cells = new Cell[4];
	/**工厂方法*/
	public static Tetromino randomOne(){
		Random r = new Random();
		int type = r.nextInt(7);
		switch(type){
		case 0: return new T();
//		case 1: return new I();
//		case 2: return new J();
//		case 3: return new L();
//		case 4: return new S();
//		case 5: return new Z();
//		case 6: return new O();
		}
		return null;
	}
}
class T extends Tetromino{
	
}
class Cell{
}