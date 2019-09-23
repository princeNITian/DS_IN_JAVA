package StackLinkedList;

public class Stack<T extends Comparable<T>> {
	
	private Node<T> root;
	private int count;
	
	public void push(T data) {
		
		this.count++;
		if(this.root == null) {
			this.root = new Node<>(data);
		}else{
			Node<T> oldRoot = this.root;
			this.root = new Node<>(data);
			this.root.setNextNode(oldRoot);
		}
	}
	public T peek() {
		return this.root.getData();
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean isEmpty() {
		return this.root==null;
	}
	
	public T pop() {
		T itemToPop = this.root.getData();
		this.root = this.root.getNextNode();
		this.count--;
		
		return itemToPop;
	}

}
