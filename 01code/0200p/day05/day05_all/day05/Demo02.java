package day05;

public class Demo02 {
	public static void main(String[] args) {
		Person liang = new Person("����");
		liang.accept(new Task(){
			public String getName() {
				return "ι��";
			}
			public void execute() {
				System.out.println("��Ա���"); 
			}
		});
		//task�����������ص�ִ�С�,����ִ��
	}
}
class Person{
	String name;
	public Person(String name){this.name=name;}
	public void accept(Task task){
		System.out.println(
				name+"��ʼ"+task.getName());
		task.execute();
		System.out.println(
				name+"����"+task.getName());
	}
}
interface Task{
	String getName();
	void execute();
}





