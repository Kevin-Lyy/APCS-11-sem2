public class MyHeap{
	private String[] heap;
	private int size;
	private boolean minOrMax;
	
	//empty max heap (use string first)
	public MyHeap(){
		minOrMax = true;
		heap = new String[size];		
	}
	//max or min
	public MyHeap(boolean max) {
		if (!max) {
			minOrMax = false;
			heap = new String[size];
		}
		else {
			minOrMax = true;
			heap = new String[size];
		}
	}
	//methods 
	public void swap(int a,int b, String[] ary){
		String temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	public void pushUpMax(String[] heapSingle, int index) {
		int parent = (index -1)/2;
		if(index == 0) {
			return ;
		}
		if(heapSingle[index].compareTo(heapSingle[parent]) > 0) {
			swap(index,parent,heapSingle);
			pushUpMax(heapSingle,parent);
		}
	}
	
	public void pushUpMin(String[] heapSingle, int index){
		int parent = (index -1)/2;
		if(index == 0) {
			return ;
		}
		if(heapSingle[index].compareTo(heapSingle[parent]) < 0) {
			swap(index,parent,heapSingle);
			pushUpMin(heapSingle,parent);
		}
	}
	
	public void add(String s) {
		heap[size-1] = s;
		size++;
		if(minOrMax){
			pushUpMax(heap,size-1);
			}
		else if(!minOrMax) pushUpMin(heap,size-1);
	}
	//add while loop if the children are out of bounds stop
	public String remove() {
		String first = heap[0];
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

            
	public String peek() {
		return heap[0];
	}
	
	public int size() {
		return size;
	}
}
