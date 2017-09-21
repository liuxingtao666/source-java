package day04;

public class Demo01 {
	public static void main(String[] args) {
		int score = 85;
		String level;
		switch(score/10){
		case 10:
		case 9: level = "优秀"; break;
		case 8: level = "良好"; break;
		case 7: level = "中等"; break;
		case 6: level = "及格"; break;
		default: level = "不及格"; 
		}
		System.out.println(level); 
	}
}
