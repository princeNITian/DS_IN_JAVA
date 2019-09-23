package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue {

	public static void main(String [] args) {
		Queue<Person> queue = new PriorityQueue<>();
		
		queue.add(new Person("Kelvin",22));
		queue.add(new Person("Perter",30));
		queue.add(new Person("Harry",21));
		
		queue.add(new Person("Kely",42));
		queue.add(new Person("Prem",39));
		queue.add(new Person("Harsh",29));
		
		while(queue.peek() != null) {
			System.out.println(queue.poll());
		}
		
		
	}
}
