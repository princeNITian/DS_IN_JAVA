package GenericHashTable;

public class App {

	public static void main(String[] args) {
		HashTable<String,Integer> hashTable = new HashTable<>();
		
		hashTable.put("Prince", 21);
		hashTable.put("Raj", 13);
		hashTable.put("Priyanshu", 32);
		hashTable.put("Pratic", 18);
		System.out.println(hashTable.get("Raj"));
	}
}
