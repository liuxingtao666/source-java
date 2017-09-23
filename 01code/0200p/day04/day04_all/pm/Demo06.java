package day04.pm;

public class Demo06 {
	public static void main(String[] args) {
		Mama ma = new Mama("�����P");
		Mama sun = new Mama("��ٳ");
		Person b1 = ma.birth("����");
		Person b2 = ma.birth("С����");
		
		Person b3 = sun.birth("С��");
		Person b4 = sun.birth("С��");
		System.out.println(b2.getMamaName());
		System.out.println(b4.getMamaName());
	}
}

interface Person {
	String getName();
	String getMamaName();
}
class Mama implements Person {
	String name;
	public Mama(String name){this.name = name;}
	public String getName() {return name;}
	public String getMamaName(){return "����";}
	public Person birth(String babyName) {
		Baby baby = this.new Baby();
		baby.name = babyName;
		return baby;
	}
	private class Baby implements Person {
		String name;
		public String getName(){return name;}
		public String getMamaName() {
			return Mama.this.name;
		}
	}
}
