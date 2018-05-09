public class Sorts<T extends Comparable<T>>{
	
	public void HeapSort(T[] heap){
		heaped(heap);
		int tempIndex = 0;
		while(tempIndex* 2 + 1 < heap.length) {
			T startOfSort = heap[0];
			int child1 = tempIndex *2 +1;
			int child2 = tempIndex *2 +2;
			if(heap[child1].compareTo(heap[child2]) > 0) {
				swap(tempIndex,child1,heap);
				tempIndex = child1;
			}
			if(heap[child1].compareTo(heap[child2]) < 0) {
				swap(tempIndex,child2,heap);
				tempIndex = child2;
			}
			heap[heap.length] = startOfSort;
		}
	}
	
	public void heaped(T[] given) {
		int parent = 0;
		while(parent*2+1 < given.length) {
			int child1 = parent*2+1;
			int child2 = parent*2+2;
			if(given[child1].compareTo(given[child2]) > 0) {
				swap(child1,parent,given);
				parent = child1;
			}
			swap(child2,parent,given);
			parent = child2;
		}
	}
	
	public void swap(int a,int b, T[] ary){
		T temp = ary[a];
		ary[a] = ary[b];
		ary[b] = temp;
	}
	public static void main(String[] args) {
		int[] word= {10,9,8,7,6,5};
		HeapSort(word);
	}
}
