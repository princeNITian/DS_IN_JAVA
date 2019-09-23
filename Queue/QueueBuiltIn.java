package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBuiltIn {
	
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.add("Ram");
		queue.add("Shyam");
		queue.add("Mohan");
		queue.add("Hema");
		
		
		System.out.println(queue.size());
		
		for(String s: queue) {
			System.out.println(s);
		}
	
		System.out.println(queue.remove());
		System.out.println(queue.element());
	}
}
