package RedBlackTree;

public class Node{
    private int data;
    private NodeColor color;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeColor getColor() {
		return this.color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	public Node getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}


  	public  Node(int data){
        this.data = data;
        this.color = NodeColor.RED;
    }

    @Override
    public String toString(){
        return "" + this.data;
    }
}
