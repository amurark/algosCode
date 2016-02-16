import java.math.*;
import java.util.*;

/**
 * HeapSort Algorithm
 * @author Ankit
 * 02-15-2016
 * Description: First argument is 'min' or 'max' depending on the sort order, second argument is the array length followed by the array elements.
 */
public class HeapSort {
	private static String type = new String();
	public static void main(String[] args) {
		/**
		 * Store the unsorted array
		 */
		List<Long> arr = new ArrayList<Long>();
		/**
		 * Store the type of sorting min or max
		 */
		type = args[0];
		int length = Integer.parseInt(args[1]);
		for(int i = 0; i < length; i++) {
			arr.add(Long.parseLong(args[i+2]));
		}
		heapSort(arr);
	}
	
	/**
	 * Heap Sort method.
	 * @param arr
	 */
	public static void heapSort(List<Long> arr) {
		/**
		 * Call the buildMaxOrMinHeap function to make every subtree in the array a minimum or maximum Heap.
		 */
		buildMaxOrMinHeap(arr);
		for(int i = arr.size()-1; i > 0; i--) {
			long temp = arr.get(i);
			System.out.print(arr.get(0)+" ");
			arr.set(i, arr.get(0));
			arr.set(0, temp);
			arr.remove(arr.size()-1);
			if(type.equals("min")) {
				minHeapify(arr,0);
			} else {
				maxHeapify(arr,0);
			}
			
		}
	}
	
	/**
	 * Rearrange the heap so that each subheap is a maxHeap or minHeap
	 * @param arr
	 */
	public static void buildMaxOrMinHeap(List<Long> arr) {
		int startNum = (int)Math.floor(arr.size()/2); 
		for(int i = startNum-1; i>=0; i--){
			//System.out.println(i);
			if(type.equals("min")) {
				minHeapify(arr,i);
			} else {
				maxHeapify(arr,i);
			}
			
		}
	}
	
	/**
	 * Max Heapify the tree whose root is at the Ith node in the tree
	 * @param arr
	 * @param i
	 */
	public static void maxHeapify(List<Long> arr, int i){
		int l = left(i);
		int r = right(i);
		int largest;
		if(l < arr.size() && arr.get(l) > arr.get(i)) {
			largest = l;
		} else {
			largest = i;
		}
		
		if(r < arr.size() && arr.get(r) > arr.get(largest)) {
			largest = r;
		}
		if(largest != i) {
			long temp = arr.get(largest);
			arr.set(largest,arr.get(i));
			arr.set(i, temp);
			//System.out.println(largest);
			maxHeapify(arr,largest);
		}
		
	}
	
	/**
	 * Min Heapify the tree whose root is at the Ith node in the tree
	 * @param arr
	 * @param i
	 */
	public static void minHeapify(List<Long> arr, int i){
		int l = left(i);
		int r = right(i);
		int smallest;
		if(l < arr.size() && arr.get(l) < arr.get(i)) {
			smallest = l;
		} else {
			smallest = i;
		}
		
		if(r < arr.size() && arr.get(r) < arr.get(smallest)) {
			smallest = r;
		}
		if(smallest != i) {
			long temp = arr.get(smallest);
			arr.set(smallest,arr.get(i));
			arr.set(i, temp);
			minHeapify(arr,smallest);
		}
		
	}
	
	/**
	 * Get the parent node of the node located at the index 'i'.
	 * @param i
	 * @return
	 */
	public static int parent(int i) {
		return (int) Math.ceil(i/2-1);
	}
	
	/**
	 * Get the left child node of the node located at the index 'i'.
	 * @param i
	 * @return
	 */
	public static int left(int i) {
		return 2*i+1;
	}
	
	/**
	 * Get the right child node of the node located at the index 'i'.
	 * @param i
	 * @return
	 */
	public static int right(int i) {
		return 2*i+2;
	}
	
}
