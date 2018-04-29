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
		else MyHeap();		
	}
	//methods 
	public void swap(int a,int b, String[] ary){
		String temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	public void pushUpMax(String heap, int index) {
		int parent = (index -1)/2;
		if(index == 0) {
			return ;
		}
		if(heap[index].compareTo(heap[parent]) > 0) {
			swap(index,parent,heap);
			return pushUpMax(heap,parent);
		}
	}
	
	public void pushUpMin(String heap, int index){
		int parent = (index -1)/2
		if(index == 0) {
			return ;
		}
		if(heap[index].compareTo(heap[parent]) < 0) {
			swap(index,parent,heap);
			return pushUpMin(heap,parent);
		}
	}
	
	public void add(String s) {
		
	}
	public String remove() {
		
	}
	public String peek() {
		
	}
	public int size() {
		return size;
	}
}
