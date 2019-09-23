package Queue;

public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
	public int size() {
		return this.count;
	}
	
	public void enqueue(T data) {
		this.count++;
		// another way to do the same
		Node<T> oldLastNode = this.lastNode;
		this.lastNode = new Node<>(data);
		this.lastNode.setNextNode(null);
		
		if(this.firstNode == null) {
			this.firstNode = this.lastNode;
		}else {
			oldLastNode.setNextNode(this.lastNode);
		}
	}
	
	public T dequeue() {
		this.count--;
		T dataToDeque = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();
		if(isEmpty()) {
			this.lastNode = null;
		}
		return dataToDeque;
	}
	
	public T peek() {
		return this.firstNode.getData();
	}
}
