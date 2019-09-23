package HashMapChaining;

public class HashTable {

	private HashItem[] hashTable;
	
	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
		//return 1;
	}
	
	public void put(int key,int value) {
		int hashArrayIndex = hash(key);
		
		if(hashTable[hashArrayIndex] == null) {
			System.out.println("No Collision simple insertion..");
			hashTable[hashArrayIndex] = new HashItem(key,value);
		}else {
			System.out.println("Collision when inserting with key "+key);
			HashItem hashItem = hashTable[hashArrayIndex];
			
			while(hashItem.getNextHashItem()!=null) {
				hashItem = hashItem.getNextHashItem();
				System.out.println("Considering the next item in linked list: "+hashItem.getValue());
			}
			System.out.println("Finally we have found a place to insert.. "+value);
			hashItem.setNextHashItem(new HashItem(key,value));
		}
		
	}
	
	// get method
	public int get(int key) {
		int generatedArrayIndex = hash(key);
		
		if(hashTable[generatedArrayIndex] == null) {
			return -1;
		}else {
			HashItem hashItem = hashTable[generatedArrayIndex];
			while(hashItem != null && hashItem.getKey() != key) {
				hashItem = hashItem.getNextHashItem();
			}
			
			if(hashItem == null) {
				return -1;
			}else {
				return hashItem.getValue();
			}
			
		}
	}
}
