package day01.hw;

public class Demo03 {
	public static void main(String[] args) {
		T t = new T();
		System.out.println(t.cells[0].row); 
		System.out.println(t.cells[0].col);
		System.out.println(t.cells[1].row); 
		System.out.println(t.cells[1].col);
		//...
	}
}
//»¹ÓÐ S J L Z O I
class T{
	Cell[] cells = new Cell[4];
	public T() {
		cells[0] = new Cell(0,4);
		cells[1] = new Cell(0,3);
		cells[2] = new Cell(0,5);
		cells[3] = new Cell(1,4);
	}
	public void drop(){
		cells[0].drop();
		cells[1].drop();
		cells[2].drop();
		cells[3].drop();
	}
	// moveLeft()  moveRight()
}
class Cell{
	int row;
	int col;
	public Cell(int row, int col) {
		this.col = col;
		this.row = row;
	}
	public void drop(){
		this.row++;
	}
	public void moveLeft(){
		col--;
	}
}





