package StackLinkedList;

public class App {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(20);
		stack.push(30);
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.size());
		System.out.println("Peek: "+stack.peek());
		
		// built in Stack ADT
		java.util.Stack<Integer> mystack = new java.util.Stack<>();
		mystack.push(555);
		mystack.push(666);
		mystack.push(777);
		
		System.out.println("Peek: "+mystack.peek());
		System.out.println("Size: "+mystack.size());
		for(Integer i : mystack) {
			System.out.println(i);
		}
		
	}
}
