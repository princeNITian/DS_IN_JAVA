package StackArray;

public class Stack<T> {

	private T[] stack;
	private int noOfItems;
	
	public Stack() {
		this.stack = (T[]) new Object[1];
	}
	public void push(T newData) {
		if(noOfItems == this.stack.length) {
			resize(2*this.stack.length);
		}
		this.stack[noOfItems++] = newData;
	}
	public T pop() {
		T itemToPop = this.stack[--noOfItems];
		if(this.noOfItems > 0 && this.noOfItems == this.stack.length/4) {
			resize(this.stack.length/2);
		}
		return itemToPop;
	}
	public boolean isEmpty() {
		return this.noOfItems==0;
	}
	public int size() {
		return this.noOfItems;
	}
	private void resize(int capacity) {
		T[] stackCopy = (T[]) new Object[capacity];
		for(int  i =0;i<noOfItems;i++)
			stackCopy[i] = stack[i];
		this.stack = stackCopy;
	}
}
