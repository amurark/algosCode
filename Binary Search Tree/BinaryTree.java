
public class BinaryTree {
	private Node root;
	
	private Node foundNode;
	private Node parentNode;
	private String side = null;
	
	private Node parNode;
	
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
}
