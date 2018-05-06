public class MyHeap<T extends Comparable<T>>{
	private T[] heap;
	public int size;
	private boolean minOrMax;
	
	//empty max heap (use string first)
	@SuppressWarnings("unchecked")
	public MyHeap(){
		minOrMax = true;
		heap = (T[])new Comparable[10];	
	}
	//max or min
	@SuppressWarnings("unchecked")
	public MyHeap(boolean max) {
		if (!max) {
			minOrMax = false;
			heap = (T[])new Comparable[10];
		}
		else {
			minOrMax = true;
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
		heap[size-1] = s;
		size++;
		if(minOrMax){
			pushUpMax(heap,size-1);
			}
		else if(!minOrMax) pushUpMin(heap,size-1);
	}
	//add while loop if the children are out of bounds stop
	public T remove() {
		T first = heap[0];
		int tempIndex = 0;
		
		if(minOrMax){
			while(tempIndex*2 + 1 < size) {
				int tempChild1 = tempIndex * 2 + 1;
				int tempChild2 = tempIndex * 2 + 2;
				
				if(heap[tempChild1].compareTo(heap[tempChild2]) > 0){ 
					swap(tempIndex,tempChild1,heap);
					tempIndex = tempChild1;
				}
				else {
					swap(tempIndex,tempChild2,heap);
					tempIndex = tempChild2;
				}
			}
			heap[tempIndex] = null;
		}
		if(!minOrMax) {
			while(tempIndex*2 + 1 < size) {
				int tempChild1 = tempIndex * 2 + 1;
				int tempChild2 = tempIndex * 2 + 2;
				if(heap[tempChild1].compareTo(heap[tempChild2]) < 0){ 
					swap(tempIndex,tempChild1,heap);
					tempIndex = tempChild1;
				}
				else {
					swap(tempIndex,tempChild2,heap);
					tempIndex = tempChild2;
				}
			}
			heap[tempIndex] = null;
		}
		return first;
	}

            
	public T peek() {
		return heap[0];
	}
	
	public int size() {
		return size;
	}
}
