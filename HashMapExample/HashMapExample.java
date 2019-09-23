package HashMapExample;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>();
		map.put("Prince",22);
		map.put("Raj",15);
		map.put("Peter",33);
		map.put("Kim", 44);
		
		System.out.println(map.get("Peter"));
		
		Map<String,String> map1 = new HashMap<>();
		map1.put("Ileana", "ileana@gmail.com");
		map1.put("Kely", "kely@yahoo.com");
		map1.put("Priyanka", "priyanka@sify.com");
		
		System.out.println(map1.get("Ileana"));
		// HashMap allows one null key and many null value but HashTable doesn't
		// HashMap is not synchronized hence it is faster than HashTable which is synchronized.
		System.out.println(map1.get(null));
		System.out.println(map1.get("Prince"));
	}
}
