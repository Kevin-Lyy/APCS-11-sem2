import java.util.*
public class MyHeap{
	private string[] heap;
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
		MyHeap();		
	}
	//methods 
	public void swap(int a,int b, String[] ary){
		String temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	public void pushUpMax() {
		for(c:heap) {
			if(heap[c].compareTo(heap[(c*2)+1]) < 0) {
				swap(c,c*2+1,heap);
			}
			else if(heap[c].compareTo(heap[(c*2)+2]) < 0) {
				swap(c,c*2+1,heap);
			}
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
