package LinkedList;
import java.util.List;
public class LinkedListExample {
	public static void main(String[] args) {
		
		List<Integer> list = new java.util.LinkedList<>();
		list.add(5);
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(50);
		
		for(Integer i : list) {
			System.out.println(i);
		}
		System.out.println("After Remove Operation..");
		// remove operation is fast..
		list.remove(4);
		list.remove(2);
		for(Integer i : list) {
			System.out.println(i);
		}
		// not that fast
		System.out.println("Index 0: "+list.get(0));
		
		//size
		System.out.println("size: "+list.size());
	}
}
