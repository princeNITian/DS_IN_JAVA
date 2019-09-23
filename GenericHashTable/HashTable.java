package GenericHashTable;

@SuppressWarnings("unchecked")
public class HashTable<Key,Value> {

	private Key[] keys;
	private Value[] values;
	private int noOfItems;
	private int capacity; // it is the maximum no of items in the list
	
	public HashTable() {
	// we can't instantiate generic array so we create object and cast it.
		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.noOfItems = 0;
	}
	
	public HashTable(int newCapacity) {
		this.keys = (Key[]) new Object[newCapacity];
		this.values = (Value[]) new Object[newCapacity];
		this.capacity = newCapacity;
		this.noOfItems = 0;
	}
	
	// O(1)
	public int size() {
		return this.noOfItems;
	}
	
	// O(1)
	public boolean isEmpty() {
		return this.noOfItems==0;
	}
	
	// remove method..
	public void remove(Key key) {
		if(key==null) return;
		int index = hash(key);
		while(!keys[index].equals(key)) {
			index = (index+1) % capacity;
		}
		keys[index] = null;
		values[index] = null;
		noOfItems--;
		
		while(keys[index] != null) {
			Key tempKey = keys[index];
			Value tempValue = values[index];
			
			keys[index] = null;
			values[index] = null;
			noOfItems--;
			put(tempKey,tempValue);
			
			index = (index+1)%capacity;
		}

		
		// resize the table
		if(noOfItems <= capacity/3) {
			System.out.println("Resizing the table halving the size..");
			resize(capacity/2);
		} 
		
	}
	
	public void put(Key key,Value value) {
		if(key == null || value == null) return;
		
		if(noOfItems >= capacity*0.75) {
			System.out.println("Doubling the size of hashtable..");
			resize(2*capacity);
		}
		int index = hash(key);
		
		while(keys[index] != null) {
			// update 
			if(keys[index].equals(key)) {
				values[index] = value;
				return;
			}
			index = (index+1) % capacity;
		}
		keys[index] = key;
		values[index] = value;
		noOfItems++;
	}
	
	private void resize(int newCapacity) {
		HashTable<Key,Value> newTable = new HashTable<>(newCapacity);
		
		for(int i=0;i<capacity;i++) {
			if(keys[i] != null) {
				newTable.put(keys[i],values[i]);
			}
		}
		keys = newTable.getKeys();
		values = newTable.getValues();
		capacity = newTable.getCapacity();
	}

	public Value get(Key key) {
		if(key == null) return null;
		int index = hash(key);
		
		while(keys[index]!=null) {
			if(keys[index].equals(key)) {
				return values[index];
			}
			index = (index+1)%capacity;
		}
		return null;
	}
	
	private int hash(Key key) {
		return Math.abs(hashCode()) % capacity;
	}

	public Key[] getKeys() {
		return keys;
	}

	public void setKeys(Key[] keys) {
		this.keys = keys;
	}

	public Value[] getValues() {
		return values;
	}

	public void setValues(Value[] values) {
		this.values = values;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
}
