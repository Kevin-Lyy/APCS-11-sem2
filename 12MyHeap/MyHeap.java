import java.util.*;

public class MyHeap<T extends Comparable<T>>{
	private T[] heap;
	private int size;
	private boolean trueMax;

	//empty max heap (use string first)
	@SuppressWarnings("unchecked")
	public MyHeap(){
		trueMax = true;
		heap = (T[])new Comparable[10];
	}

	//max or min
	@SuppressWarnings("unchecked")
	public MyHeap(boolean max) {
		if (!max) {
			trueMax = false;
			heap = (T[])new Comparable[10];
		}
		else {
			trueMax = true;
			heap = (T[])new Comparable[10];
		}
	}
	//methods
	public void swap(int a,int b, T[] ary){
		T temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	public void pushUpMax(T[] heapSingle, int index) {
		int parent = (index -1)/2;
		if(index == 0) {
			return ;
		}
		if(heapSingle[index].compareTo(heapSingle[parent]) > 0) {
			swap(index,parent,heapSingle);
			pushUpMax(heapSingle,parent);
		}
	}

	public void pushUpMin(T[] heapSingle, int index){
		int parent = (index -1)/2;
		if(index == 0) {
			return ;
		}
		if(heapSingle[index].compareTo(heapSingle[parent]) < 0) {
			swap(index,parent,heapSingle);
			pushUpMin(heapSingle,parent);
		}
	}

	public void add(T s) {
		resize();
		heap[size] = s;
		size++;
		if(trueMax){
			pushUpMax(heap,size);
		}
		else if(!trueMax) pushUpMin(heap,size);
	}

	public void pushDownMax(int index){
			int tempChild1 = index * 2 + 1;
			int tempChild2 = index * 2 + 2;

			if(heap[tempChild1].compareTo(heap[tempChild2]) > 0){
				swap(index,tempChild1,heap);
				pushDownMax(tempChild1);
			}
			else {
				swap(index,tempChild2,heap);
				pushDownMax(tempChild2);
			}
		heap[index] = null;
	}

	public void pushDownMin(int index){
			int tempChild1 = index * 2 + 1;
			int tempChild2 = index * 2 + 2;
			if(heap[tempChild1].compareTo(heap[tempChild2]) < 0){
				swap(index,tempChild1,heap);
				pushDownMin(tempChild1);
			}
			else {
				swap(index,tempChild2,heap);
				pushDownMin(tempChild2);
			}
		heap[index] = null;
	}

	public T remove() {
		T first = peek();
		swap(0,size - 1,heap);
		size--;
		if(trueMax){
			pushDownMax(0);
		}
		else if (!trueMax){
			pushDownMin(0);
		}
		return first;
}

	@SuppressWarnings("unchecked")
	public void resize(){
		T[] temp = (T[])new Comparable[heap.length * 2];
		for(int c = 0; c < size(); c++){
			temp[c] = heap[c];
		}
		heap = temp;
	}

	public T peek() {
		return heap[0];
	}

	public int size() {
		return size;
	}

	public String toString(){
		String str = "[";
		for(int c = 0; c < size(); c++){
			str += heap[c] + ", ";
		}
		str += "]";
		return str;
	}


}
