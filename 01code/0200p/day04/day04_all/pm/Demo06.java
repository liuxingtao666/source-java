package day04.pm;

public class Demo06 {
	public static void main(String[] args) {
		Mama ma = new Mama("ÂíÒÁ¬P");
		Mama sun = new Mama("ËïÙ³");
		Person b1 = ma.birth("°®Âê");
		Person b2 = ma.birth("Ğ¡ÎÄÕÂ");
		
		Person b3 = sun.birth("Ğ¡µË");
		Person b4 = sun.birth("Ğ¡³¬");
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
	public String getMamaName(){return "ÀÑÀÑ";}
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
