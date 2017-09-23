package day04;

public class Demo04 {
	public static void main(String[] args) {
		FlyingObject obj = new Bomb(2, 3, 4);
		System.out.println(obj.shootBy(1, 1));
		if(obj instanceof Enemy){
			Enemy e = (Enemy)obj;
			System.out.println("得分"+e.getScore());
		}
		if(obj instanceof Award){
			Award a = (Award)obj;
			if(a.getType()==Award.LIFE){
				System.out.println("加命一条"); 
			}
		}
		
	}
}

abstract class FlyingObject {
	int x, y;

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract boolean shootBy(int x, int y);
}
//class Bee extends FlyingObject
//	implements  Award{
//	
//}

class Bomb extends FlyingObject 
	implements Enemy, Award{
	
	int r;

	public Bomb(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public int getScore() {
		return FULL;
	}
	public int getType() {
		return LIFE;
	}

	public boolean shootBy(int x, int y) {
		int a = this.x - x;
		int b = this.y - y;
		return Math.sqrt(a * a + b * b) < r;
	}
}

// 敌人
interface Enemy {
	int FULL = 100;
	/* public static final */int HALF = 50;
	/* public abstract */int getScore();
}

// 奖励
interface Award {
	int LIFE = 1;
	int getType();// 奖励类型
}
