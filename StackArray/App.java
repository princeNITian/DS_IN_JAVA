package StackArray;

public class App {
	public static void main(String[] args) {
		Stack<Integer> mystack = new Stack<>();
		mystack.push(10);
		mystack.push(20);
		mystack.push(40);
		mystack.push(30);
		System.out.println("Size of Stack: "+mystack.size());
		System.out.println("Popped: "+mystack.pop());
	}
}
