package HashMapLinearProbing;
public class HashTable {

	private HashItem[] hashTable;
	private int putFull = 0;
	
	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public void put(int key,int value) {
		int generatedIndex = hash(key);
		System.out.println("put() method called with value: "+key+" and generatedIndex: "+generatedIndex);
		if(putFull==Constants.TABLE_SIZE-1) {
			System.out.println("Hash Table is Full..");
			return;
		}
		while(hashTable[generatedIndex] != null) {
			generatedIndex = (generatedIndex+1) % Constants.TABLE_SIZE;
			System.out.println("Collision ->NextIndex: "+generatedIndex);
			// breaking when the array is full otherwise it will not stop
			putFull++;
			if(putFull==Constants.TABLE_SIZE-1) {
				System.out.println("No further addition possible..");
				return;
			}
		}
		System.out.println("Inserted finally with index: "+generatedIndex);
		hashTable[generatedIndex] = new HashItem(key,value);
		
	}
	
	public int get(int key) {
		if(key>Constants.TABLE_SIZE) {
			System.out.println("Key can't be greater than: "+Constants.TABLE_SIZE);
			return -1;
		}
		int generatedIndex = hash(key);
		while(hashTable[generatedIndex] != null && hashTable[generatedIndex].getKey()!=key) {
			generatedIndex = (generatedIndex+1) % Constants.TABLE_SIZE;
			System.out.println("Hopping to the next Item: "+generatedIndex);
		}
		if(hashTable[generatedIndex] == null) {
			return -1;
		}else {
			return hashTable[generatedIndex].getValue();
		}
	}

	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
	}
}
