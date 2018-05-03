import java.util.*;

public class Sorts<T extends Comparable<T>>{
//use int to store greatest s
	public void HeapSort(T[] heap){
		int tempIndex = 0;
		while(tempIndex* 2 + 1 < heap.length) {
			T startOfSort = heap[0];
			int child1 = tempIndex *2 +1;
			int child2 = tempIndex *2 +2;
			if(heap[child1].compareTo(heap[child2]) > 0) {
				swap(startOfSort,child1,heap);
				tempIndex = tempChild1;
			}
			if(heap[child1].compareTo(heap[child2]) < 0) {
				swap(startOfSort,child2,heap);
				tempIndex = tempChild2;
			}
			heap[heap.length] = startOfSort;
		}
	}
	public void swap(int a,int b, T[] ary){
		T temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
}
