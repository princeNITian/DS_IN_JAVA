package PriorityQueue;

public class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	public Person() {
		super();
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person : "+this.name+" "+this.age;
	}

	@Override
	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		return Integer.compare(this.age,person.age);
		//return this.name.compareTo(person.getName());
	}
	
	
}
