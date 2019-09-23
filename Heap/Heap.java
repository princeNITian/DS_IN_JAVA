package Heap;

public class Heap {

	private Integer[] heap;
	private int currentPosition = -1;
	
	public Heap(int size) {
		this.heap = new Integer[size];
	}
	
	public void insert(int data) {
		if(isFull()) {
			throw new RuntimeException("Heap is Full");
		}
		this.heap[++currentPosition] = data;
		fixUp(currentPosition);
	}

	private void fixUp(int index) {
		// TODO Auto-generated method stub
		int parentIndex = (index-1)/2;
		while( parentIndex>=0 && this.heap[parentIndex] < this.heap[index]) {
			//int tempIndex = parentIndex;
			int tempData = this.heap[parentIndex];
			this.heap[parentIndex] = heap[index];
			this.heap[index] = tempData;
			index = parentIndex;
			parentIndex = (index-1)/2;
		}
		
	}
	
	public int getMax() {
		int result = this.heap[0];
		
		this.heap[0] = this.heap[currentPosition--];
		this.heap[currentPosition+1] = null;
		fixDown(0,-1);
		return result;
		
	}
	
	private void fixDown(int index, int upto) {
		// TODO Auto-generated method stub
		if(upto < 0) upto = currentPosition;
		
		while(index<=upto) {
			int leftChild = 2*index + 1;
			int rightChild = 2*index + 2;
			
			if(leftChild<= upto) {
				int childToSwap;
				
				if(rightChild>upto) {
					childToSwap = leftChild;
				}else {
					childToSwap = ((heap[leftChild]>heap[rightChild]) ? leftChild : rightChild);
				}
				
				if(heap[index]<heap[childToSwap]) {
					int tempData = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = tempData;
				}else {
					break;
				}
				index = childToSwap;
				
			}else {
				break;
			}
		}
		
	}
	
	public void heapsort() {
		for(int i = 0;i<=currentPosition;i++) {
			int temp = heap[0];
			System.out.println(temp+" ");
			heap[0] = heap[currentPosition-i];
			heap[currentPosition-i]=temp;
			fixDown(0,currentPosition-i-1);
			
		}
	}

	public void traverse() {
		for(int i=0;i<heap.length;i++) {
			System.out.println(heap[i]+" ");
		}
	}

	private boolean isFull() {
		// TODO Auto-generated method stub
		return this.currentPosition == this.heap.length;
	}
	
	
}
