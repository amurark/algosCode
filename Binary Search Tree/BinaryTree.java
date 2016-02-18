
public class BinaryTree {
	private Node root;
	
	private Node foundNode;
	private Node parentNode;
	private String side = null;
	
	private Node cutOffPar;
	
	public BinaryTree() {
		this.root = null;
	}
	
	void setRoot(Node r) {
		this.root = r;
	}
	
	Node getRoot(){
		return root;
	}
	
	void insert(int key) {
		Node n = new Node(key);
		root = recInsert(root, n);
	}
	
	Node recInsert(Node r, Node n) {
		if(r == null){
			r = n;
			return r;
		} else {
			if(n.getKey() < r.getKey()) {
				r.setLeft(recInsert(r.getLeft(), n));
				
			} else if(n.getKey() > r.getKey()) {
				r.setRight(recInsert(r.getRight(),n));
			}
			return r;
		}
	}
	
	void show() {
		showRec(root);
	}
	
	void showRec(Node n) {
		if(n.getLeft() != null) {
			showRec(n.getLeft());
		}
		System.out.println(n.getKey());
		if(n.getRight() != null) {
			showRec(n.getRight());
		}
	}
	
	void search(int srch) {
		int level = 0;
		level = searchNum(root, srch, level);
		if(level < 0) {
			System.out.println("Not found");
		} else {
			System.out.println("Found at level "+level);
		}
		
	}
	
	int searchNum(Node r, int srch, int level) {
		if(r == null) {
			parentNode = null;
			return -1;
		} else {
			if(r.getKey() == srch) {
				foundNode = r;
				return ++level;
			} else {
				parentNode = r;
				if(r.getKey() > srch) {
					side = "left";
					level = searchNum(r.getLeft(), srch, ++level);
				} else if(r.getKey() < srch){
					side = "right";
					level = searchNum(r.getRight(), srch, ++level);
				}
				
			}
		}
		return level;
	}
	
	
	void delete(int del) {
		searchNum(root, del, 0);
		if(foundNode == null) {
			System.out.println("notfound ");
		} else {
			if(foundNode.getLeft() == null && foundNode.getRight() == null) {
				if(side == "left") {
					parentNode.setLeft(null); 
				} else if(side == "right") {
					parentNode.setRight(null);
				}
			} else if(foundNode.getLeft() == null) {
				if(side == "left") {
					parentNode.setLeft(foundNode.getRight()); 
				} else if(side == "right") {
					parentNode.setRight(foundNode.getRight());
				}
			} else if(foundNode.getRight() == null) {
				if(side == "left") {
					parentNode.setLeft(foundNode.getLeft()); 
				} else if(side == "right") {
					parentNode.setRight(foundNode.getLeft());
				}
			} else {
				Node root = findPred(foundNode, foundNode.getLeft());
				Node lMost = getLeftMost(root);
				System.out.println(root.getKey()+" "+lMost.getKey());
				if(foundNode.getLeft().getKey() == root.getKey()) {
					foundNode.setLeft(null);
				} else if(foundNode.getRight().getKey() == root.getKey()) {
					foundNode.setRight(null);
				} else {
					removeDuplicate(foundNode, root);
				}
				
				if(parentNode != null) {
					if(side == "left") {
						parentNode.setLeft(root); 
					} else if(side == "right") {
						parentNode.setRight(root);
					}
				} else {
					this.root = root;
				}
				root.setRight(foundNode.getRight());
				lMost.setLeft(foundNode.getLeft());
				
			}
		}
		//System.out.println(foundNode.getLeft().getKey());
	}
	
	void removeDuplicate(Node r, Node root) {
		if(r.getRight() != null && r.getRight().getKey() == root.getKey()) {
			r.setRight(null);
		} else {
			removeDuplicate(r.getLeft(), root);
		}
	}
	
	Node findPred(Node parent, Node root) {
		if(root.getRight() == null) {
			return root;
		} else {
			root = findPred(root, root.getRight());
		}
		return root;
	}
	
	Node getLeftMost(Node r) {
		if(r.getLeft() == null) {
			return r;
		} else {
			r = getLeftMost(r.getLeft());
		} 
		return r;
	}
}
