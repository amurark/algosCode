import java.util.Scanner;
/**
 * Binary Search Tree - search, show, insert.
 * Input Format: ArrayLength followed by array elements
 * @author Ankit
 * 02-16-2016
 */
public class DriverClass {

	public static void main(String[] args) {
		
		int length = Integer.parseInt(args[0]);
		int[] arr = new int[length];
		/**
		 * Initializing the tree.
		 */
		BinaryTree tree = new BinaryTree();
		/**
		 * Setting the first element in the array as the root of the tree.
		 */
		tree.setRoot(new Node(Integer.parseInt(args[1])));
		
		for(int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(args[i+1]);
		}
		
		/**
		 * Insert to tree
		 */
		for(int i = 0; i < length; i++) {
			tree.insert(arr[i]);
		}
		
		/**
		 * Show the tree in ascending order.
		 */
		tree.show();
		
		System.out.println("Enter the number you want to search");
		Scanner sc = new Scanner(System.in);
		int srch = sc.nextInt();
		tree.search(srch);
		
		
		sc.close();
		
	}

}
