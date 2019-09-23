package AvlTree;

public class AvlTree implements Tree{

	private Node root;
	@Override
	public void traversal() {
		// TODO Auto-generated method stub
		if(root == null) return;
		inOrderTraversal(root);
		
	}

	private void inOrderTraversal(Node node) {
		// TODO Auto-generated method stub
		if(node.getLeftNode() != null)
			inOrderTraversal(node.getLeftNode());
		System.out.print(node+" ");
		if(node.getRightNode() != null)
			inOrderTraversal(node.getRightNode());
		
	}
	
	private int height(Node node) {
		if(node == null) return -1;
		
		return node.getHeight();
		
	}
	
	private int getBalance(Node node) {
		if(node == null) return 0;
		
		return height(node.getLeftNode()) - height(node.getRightNode());
	}
	
	private Node rightRotation(Node node) {
		System.out.println("Rotating to the right on node..."+node);
		Node tempLeftNode = node.getLeftNode();
		Node t = tempLeftNode.getRightNode();
		
		tempLeftNode.setRightNode(node);
		node.setLeftNode(t);
		
		node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode()))
				+1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()),height(tempLeftNode.getRightNode()))
				+1);
		return tempLeftNode;
	}
	
	private Node leftRotation(Node node) {
		System.out.println("Rotating to the left on node..."+node);
		Node tempRightNode = node.getRightNode();
		Node t = tempRightNode.getLeftNode();
		
		tempRightNode.setLeftNode(node);
		node.setRightNode(t);
		
		node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode()))
				+1);
		tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()),height(tempRightNode.getRightNode()))
				+1);
		return tempRightNode;
	}

	@Override
	public void insert(int data) {
		// TODO Auto-generated method stub
		root = insert(root,data);
		
	}

	private Node insert(Node node, int data) {
		// TODO Auto-generated method stub
		if(node == null) 
			return new Node(data);
		if(data<node.getData()) {
			node.setLeftNode(insert(node.getLeftNode(),data));
		}else {
			node.setRightNode(insert(node.getRightNode(),data));
		}
		node.setHeight( Math.max( height(node.getLeftNode()), height(node.getRightNode()) )+1 );
		node = settleViolations(data,node);
		return node;
	}

	private Node settleViolations(int data, Node node) {
		// TODO Auto-generated method stub
		int balance = getBalance(node);
		
		 //case 1: left left heavy situation
	        if( balance>1 && data < node.getLeftNode().getData()) {
	            System.out.println("Left Left heavy situation");
	            return rightRotation(node);
	        }
	        //case 2: Right right heavy situation
	        if( balance<-1 && data > node.getRightNode().getData()){
	            System.out.println("Right right heavy situation");
	            return leftRotation(node);
	        }
	        //case 3: Left Right heavy situation
	        if( balance>1 && data>node.getLeftNode().getData()) {
	            System.out.println("Left right heavy situation");
	            node.setLeftNode(leftRotation(node.getLeftNode()));
	            return rightRotation(node);
	        }
	        //case 4: Right Left heavy situation
	        if( balance<-1 && data<node.getLeftNode().getData()) {
	            System.out.println("Right left heavy situation");
	            node.setRightNode(rightRotation(node.getRightNode()));
	            return leftRotation(node);
	        }
		
		return node;
	}

	@Override
	public void delete(int data) {
		// TODO Auto-generated method stub
		if(root != null) 
			root = deleteNode(root,data);
		
	}

	private Node deleteNode(Node node, int data) {
		// TODO Auto-generated method stub
		if(node == null) return node;
		
		if(data < node.getData()) {
			node.setLeftNode(deleteNode(node.getLeftNode(),data));
		}else if(data > node.getData()) {
			node.setRightNode(deleteNode(node.getRightNode(),data));
		}else {
			// this is the node to be removed..
			if(node.getLeftNode() == null && node.getRightNode() == null) {
				System.out.println("Removing a Leaf Node..");
				return null;
			}
			if(node.getLeftNode() == null) {
				System.out.println("Removing node with single right child..");
				Node tempNode = node.getRightNode();
				node = null;
				return tempNode;
			}else if(node.getRightNode() == null) {
				System.out.println("Removing node with single left child..");
				Node tempNode = node.getLeftNode();
				node = null;
				return tempNode;
			}
			// this is the node with two children..
			System.out.println("Removing node with two children..");
			Node tempNode = getPredecessor(node.getLeftNode());
			
			node.setData(tempNode.getData());
			node.setLeftNode(deleteNode(node.getLeftNode(),tempNode.getData()));
		}
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		
		// check whether tree is balanced or not on every deletion operation
		
		return settleDeletion(node);
	}

	private Node settleDeletion(Node node) {
		// TODO Auto-generated method stub
		int balance = getBalance(node);
		
		if(balance > 1) {
			// this is left heavy situation so left rotation on parent node 
			if(getBalance(node.getLeftNode())<0) {
				node.setLeftNode(leftRotation(node.getLeftNode()));
			}
			// this is right rotation on grandparent if it is left left heavy situation
			
			return rightRotation(node);
		}
		
		if(balance < -1) {
			// right left heavy situation so right rotation on parent node
			if(getBalance(node.getRightNode())>0) {
				node.setRightNode(rightRotation(node.getRightNode()));
			}
			// this is left rotation on grandparent if it is right right heavy situation.
			return leftRotation(node);
		}
		
		return node;
	}

	private Node getPredecessor(Node node) {
		// TODO Auto-generated method stub
		Node predecessor = node;
		while(predecessor.getRightNode()!=null)
			predecessor = predecessor.getRightNode();
		return predecessor;
	}

	@Override
	public int getMaxValue() {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		
		return getMax(root);
	}

	private int getMax(Node node) {
		// TODO Auto-generated method stub
		if(node.getRightNode()!=null) {
			getMax(node.getRightNode());
		}
		return node.getData();
	}

	@Override
	public int getMinValue() {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		
		return getMin(root);
	}

	private int getMin(Node node) {
		// TODO Auto-generated method stub
		if(node.getLeftNode()!=null) {
			getMin(node.getLeftNode());
		}
		return node.getData();
	}

}
