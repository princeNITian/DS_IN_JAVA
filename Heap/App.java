package Heap;

public class App {

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(5);
		heap.insert(40);
		heap.insert(30);
		heap.insert(2);
		heap.insert(55);
		heap.insert(50);
		heap.insert(90);
		heap.insert(20);
		heap.insert(-4);
		heap.insert(32);
		heap.heapsort();
		
		//heap.traverse();
		//System.out.println(heap.getMax());
	}
}
