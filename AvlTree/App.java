package AvlTree;

public class App {

	public static void main(String[] args) {
		Tree avl = new AvlTree();
		avl.insert(5);
		avl.insert(6);
		avl.insert(7);
		avl.insert(4);
		avl.insert(3);
		avl.insert(2);
		avl.delete(4);
		avl.traversal();
		System.out.println();
		System.out.println("Max Value: "+avl.getMaxValue());
		System.out.println("Min Value: "+avl.getMinValue());
	}
}
