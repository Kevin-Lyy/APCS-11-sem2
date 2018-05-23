import java.util.*;
public class Sorts extends MyHeap{

	public static void heapsort(int[] heap){
		MyHeap<Integer> heaped = new MyHeap<Integer>(false);
		for(int c = 0; c < heap.length;c++){
			heaped.add(heap[c]);
		}
		for(int i = 0; i < heap.length; i++){
			heap[i] = heaped.peek();
			heaped.remove();
		}
	}

}
