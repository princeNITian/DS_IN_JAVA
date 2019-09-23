package BinarySearchTree;

public class App {

	public static void main(String[] args) {
		
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(20);
		bst.insert(5);
		bst.insert(7);
		bst.insert(2);
		bst.insert(40);
		
		System.out.println("Min Value: "+ bst.getMinValue());
		System.out.println("Max Value: "+ bst.getMaxValue());
		bst.traversal();
		
//		System.out.println();
//		bst.delete(7);
//		bst.traversal();
		
		
//		Tree<String> t = new BinarySearchTree<>();
//		t.insert("Prince");
//		t.insert("Adam");
//		t.insert("Joe");
//		t.insert("Smith");
//		t.insert("Priyanka");
//		System.out.println("Min Value: "+ t.getMinValue());
//		System.out.println("Max Value: "+ t.getMaxValue());
//		t.delete("Joe");
//		t.traversal();
		
		
//		Tree<Person> bst = new BinarySearchTree<>();
//		bst.insert(new Person("Prince",22));
//		bst.insert(new Person("Chintu",24));
//		bst.insert(new Person("Raj",19));
//		bst.insert(new Person("Luv",16));
//		bst.insert(new Person("Ravi",25));
//		
//		bst.traversal();
		
		
		
//		Tree<Integer> bst = new BinarySearchTree<>();
//		bst.insert(10);
//		bst.insert(5);
//		bst.insert(15);
//		bst.insert(3);
//		bst.insert(20);
//		
//		bst.delete(15);
//		bst.traversal();
		
	}
}
