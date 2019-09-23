package Queue;

public class App {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(5);
		queue.enqueue(10);
		queue.enqueue(199);
		queue.enqueue(500);
		System.out.println("Size: "+queue.size());
		System.out.println("FirstNode: "+queue.peek());
		queue.dequeue();
		System.out.println("Size: "+queue.size());
		System.out.println("FirstNode: "+queue.peek());
	}
}
