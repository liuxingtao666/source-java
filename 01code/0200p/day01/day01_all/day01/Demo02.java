package day01;

public class Demo02 {
	public static void main(String[] args) {
		Cell c1 = new Cell();
		c1.row=0; c1.col=3;
		Cell c2 = new Cell();
		c2.row=1;c2.col=3;
		c1.drop();// µº ÷¥––£∫drop(c1)
		c2.drop();//drop(c2)
	}
}
class Cell1{
	int row; int col;
	public void drop(/*Cell this*/){
		this.row++;
	}
}