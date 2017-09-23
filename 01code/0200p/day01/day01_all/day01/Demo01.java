package day01;

public class Demo01 {
	public static void main(String[] args) {
		//c1是局部变量
		Cell c1 = new Cell();
		c1.row = 0;
		c1.col = 3;
		Cell c2 = new Cell();
		c2.row = 0;
		c2.col = 4;
		System.out.println(c1.row);
		Cell c3 = new Cell();
		Cell c4 = new Cell();
		//方法调用
		c1.drop();//修改了c1引用的对象的row 
		c2.drop();//修改了c2引用的对象的row
		System.out.println(c1.row);//1
		System.out.println(c2.row);//1
		c1.drop(5);//调用 drop(int) 方法
		System.out.println(c1.row);//6
	}
}
class Cell{
	int row;//属性 实例变量==对象的变量==东西的属性
	int col;//属性
	public void drop(){//不要使用static
		row++;
	}
	// moveRight  moveLeft
	public void drop(int step){
		row+=step;
	}
}






