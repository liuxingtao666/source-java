package day04;

import java.io.Serializable;
import java.util.List;
/**
 * 用于测试序列化的类
 * @author Administrator
 *
 */
public class Person implements Serializable{
	private String name;
	private int age;
	private int sex;
	private transient List<String> other;
	public Person(String name, int age, int sex, List<String> other) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.other = other;
	}
	
	@Override
	public String toString() {
		return "name="+name+","+
			   "age=" +age +","+
			   "sex=" +sex +","+
			   "other="+other;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + sex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	
}



