package day04;

public class Demo01 {
	public static void main(String[] args) {
		int score = 85;
		String level;
		switch(score/10){
		case 10:
		case 9: level = "����"; break;
		case 8: level = "����"; break;
		case 7: level = "�е�"; break;
		case 6: level = "����"; break;
		default: level = "������"; 
		}
		System.out.println(level); 
	}
}
