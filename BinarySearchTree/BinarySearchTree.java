package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{
	private Node<T> root;

	@Override
	public void insert(T data) {
		if(root == null) {
			root = new Node<T>(data);
		}else {
			insertNode(data,root);
		}
	}
	@Override
	public void traversal() {
		// TODO Auto-generated method stub
		if(root != null) {
			inOrderTraversal(root);
		}
		
	}

	
	private void inOrderTraversal(Node<T> node) {
		// TODO Auto-generated method stub
		if(node.getLeftChild()!=null) {
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node+"  ");
		if(node.getRightChild()!=null) {
			inOrderTraversal(node.getRightChild());
		}
	}
	private void insertNode(T newData,Node<T> node) {
		// TODO Auto-generated method stub
		if(newData.compareTo(node.getData())<0) {
			if(node.getLeftChild() != null) {
				insertNode(newData,node.getLeftChild());
			}else {
				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		}else {
			if(node.getRightChild()!=null) {
				insertNode(newData,node.getRightChild());
			}else {
				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
		
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		if(root != null) {
			root = deleteNode(root,data);
		}
		
	}
	
	private Node<T> deleteNode(Node<T> node,T data) {
		// TODO Auto-generated method stub
		if(node == null) return node;
		
		if(data.compareTo(node.getData())<0) {
			node.setLeftChild(deleteNode(node.getLeftChild(),data));
		}else if(data.compareTo(node.getData())>0) {
			node.setRightChild(deleteNode(node.getRightChild(),data));
		}else {
			// we found the node that we want to remove
			if(node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("Removing leaf node...");
				return null;
			}
			if(node.getLeftChild() == null) {
				// Removing node with single right child
				System.out.println("Remvoing the right child...");
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			}else if(node.getRightChild() == null) {
				// Removing node with single left child
				System.out.println("Remvoing the left child...");
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}
			// this is the node with two children 
			System.out.println("Removing node with two children..");
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteNode(node.getLeftChild(),tempNode.getData()));
		}
		return node;
	}
	private Node<T> getPredecessor(Node<T> node) {
		// TODO Auto-generated method stub
		//Node<T> targetNode = node;
		if(node.getRightChild()!=null) {
			return getPredecessor(node.getRightChild());
		}
		System.out.println("Predecessor is: "+node.getData());
		return node;
	}
	@Override
	public T getMaxValue() {
		if(root == null) return null;
		
		return getMax(root);
	}

	
	private T getMax(Node<T> node) {
		// TODO Auto-generated method stub
		if(node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		
		return node.getData();
	}
	
	@Override
	public T getMinValue() {
		if(root == null) return null;
		
		return getMin(root);
		
	}

	
	private T getMin(Node<T> node) {
		// TODO Auto-generated method stub
		if(node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}
	

}
