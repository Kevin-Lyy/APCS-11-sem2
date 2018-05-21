import java.util.*;
public class Sorts<T extends Comparable<T>>{

	public static void heapSort(Integer[] heap){
		MyHeap<Integer> heaped = new MyHeap<Integer>(false);
		for(int c = 0; c < heap.length;c++){
			heaped.add(heap[c]);
		}
		for(int i = 0; i < heap.length; i++){
			heap[i] = heaped.peek();
			heaped.remove();
		}
	}

	public static void main(String[] args) {
		Integer[] word= {10,9,8,7,6,5};
		heapSort(word);
	}
}
