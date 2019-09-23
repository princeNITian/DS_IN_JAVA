package LinkedList;

public class App {
	public static void main(String[] args) {
		  List<Integer> list = new LinkedList<Integer>();
	        list.insert(10);
	        list.insert(2);
	        list.insert(-5);
	        list.insert(40);

	        list.traverseList();
	        System.out.println();
	        List<Person> p1 = new LinkedList<Person>();
	        p1.insert(new Person(5,"Ram"));
	        p1.insert(new Person(20,"Shyam"));
	        p1.insert(new Person(15,"Kevin"));
	        p1.insert(new Person(30,"Peter"));
	        
	        p1.traverseList();
	}
}
