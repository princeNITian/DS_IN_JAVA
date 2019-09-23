package BinarySearchTree;

public class Person implements Comparable<Person>{

	private int age;
	private String name;
	
	
	public Person(String name,int age) {
		//super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name + "-"+this.age;
	}
	@Override
	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		return name.compareTo(person.getName());
		//return age - person.getAge();
		//return -Integer.compare(this.age, person.getAge());
	}
	
	
	
}
