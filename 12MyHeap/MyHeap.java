import java.util.*
public class MyHeap{
	Array<String> heap = new Array<String>;
	
	//empty max heap (use string first)
	public MyHeap(){
		for(c:heap) {
			if(heap[c].compareTo(heap[(c*2)+1]) < 0) {
				swap(c,c*2+1);
			}
			else if(heap[c].compareTo(heap[(c*2)+2]) < 0) {
				swap(c,c*2+1);
			}
		}
	}
	//max or min
	public MyHeap(boolean m) {
		if (!m) {
			
		}
		MyHeap();		
	}
	
	//methods 
	
	public void add(String s) {
		
	}
	
	public String remove() {
		
	}
	public String peek() {
		
	}
	public int size() {
		return heap.length();
	}

}
