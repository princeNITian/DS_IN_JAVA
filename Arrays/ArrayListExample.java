package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(10);
		list.add("PRINCE");
		list.add("Raj");
		list.add("Hello");
		
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list.size());
		for(String s: list) {
			System.out.println(s);
		}
		System.out.println();
		Object[] array = list.toArray();
		for(Object s: array) {
			System.out.println(s);
		}
		
		
	}
}
