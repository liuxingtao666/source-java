package day01;

public class Demo01 {
	public static void main(String[] args) {
		//c1�Ǿֲ�����
		Cell c1 = new Cell();
		c1.row = 0;
		c1.col = 3;
		Cell c2 = new Cell();
		c2.row = 0;
		c2.col = 4;
		System.out.println(c1.row);
		Cell c3 = new Cell();
		Cell c4 = new Cell();
		//��������
		c1.drop();//�޸���c1���õĶ����row 
		c2.drop();//�޸���c2���õĶ����row
		System.out.println(c1.row);//1
		System.out.println(c2.row);//1
		c1.drop(5);//���� drop(int) ����
		System.out.println(c1.row);//6
	}
}
class Cell{
	int row;//���� ʵ������==����ı���==����������
	int col;//����
	public void drop(){//��Ҫʹ��static
		row++;
	}
	// moveRight  moveLeft
	public void drop(int step){
		row+=step;
	}
}






