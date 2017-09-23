package day05;

public class Demo02 {
	public static void main(String[] args) {
		Person liang = new Person("张亮");
		liang.accept(new Task(){
			public String getName() {
				return "喂猪";
			}
			public void execute() {
				System.out.println("猪吃饱了"); 
			}
		});
		//task任务被张亮“回调执行”,任务被执行
	}
}
class Person{
	String name;
	public Person(String name){this.name=name;}
	public void accept(Task task){
		System.out.println(
				name+"开始"+task.getName());
		task.execute();
		System.out.println(
				name+"结束"+task.getName());
	}
}
interface Task{
	String getName();
	void execute();
}





