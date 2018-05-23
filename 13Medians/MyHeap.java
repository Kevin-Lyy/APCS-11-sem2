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
		if((index-1)/2 >= 0){
			int parent = (index -1)/2;
			if(index == 0) {
				return ;
			}
			else if(heapSingle[index].compareTo(heapSingle[parent]) > 0) {
				swap(index,parent,heapSingle);
				pushUpMax(heapSingle,parent);
			}
		}
	}

	public void pushUpMin(T[] heapSingle, int index){
		if((index-1)/2 >= 0){
			int parent = (index -1)/2;
			if(index == 0) {
				return ;
			}
			else if(heapSingle[index].compareTo(heapSingle[parent]) < 0) {
				swap(index,parent,heapSingle);
				pushUpMin(heapSingle,parent);
			}
		}
	}

	public void add(T s) {
		if(size() == heap.length -1) resize();
		if(size() == 0)heap[0] = s;
		else{
			heap[size()] = s;
			if(trueMax){
				pushUpMax(heap,size);
			}
			else{ pushUpMin(heap,size);
			}
		}
		size++;
	}

	public void pushDownMax(int index){
		int tempChild1 = index * 2 + 1;
		int tempChild2 = index * 2 + 2;
		if(tempChild1 < size() && tempChild2 < size()){
			if(heap[tempChild1].compareTo(heap[tempChild2]) > 0){
				swap(index,tempChild1,heap);
				pushDownMax(tempChild1);
			}
			else {
				swap(index,tempChild2,heap);
				pushDownMax(tempChild2);
			}
		}
	}

	public void pushDownMin(int index){
		int tempChild1 = (index * 2) + 1;
		int tempChild2 = (index * 2) + 2;

		if(tempChild1 < size() && heap[index].compareTo(heap[tempChild1]) > 0
		&& (tempChild2 >= size() || heap[tempChild2].compareTo(heap[tempChild1]) >= 0)) {
				swap(index,tempChild1,heap);
				pushDownMin(tempChild1);
			}
			else if(tempChild2 < size() && heap[index].compareTo(heap[tempChild2]) > 0 &&
			(tempChild1 >= size() || heap[tempChild1].compareTo(heap[tempChild2]) >= 0)) {
				swap(index,tempChild2,heap);
				pushDownMin(tempChild2);
			}
	}


	public T remove() {
		T first = peek();
		swap(0,size - 1,heap);
		size--;
		if(trueMax) pushDownMax(0);
		else {
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
