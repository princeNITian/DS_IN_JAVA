package AvlTree;

public interface Tree{

	public void traversal();
	public void insert(int data);
	public void delete(int data);
	public int getMaxValue();
	public int getMinValue();
}
