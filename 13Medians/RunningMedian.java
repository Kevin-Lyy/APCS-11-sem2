import java.util.*;
public class RunningMedian{

	private double currentMedian;
	MyHeap<Double> lrg;
	MyHeap<Double> sml;
	public int size;
	@SuppressWarnings("unchecked")
	public RunningMedian(){
		lrg = new MyHeap(false);
		sml = new MyHeap();
	}

	public int size() {
		return size;
	}

	public void add(Double x) {
		if( lrg.size() == 0 && sml.size() == 0) sml.add(x);
		if(x > currentMedian) lrg.add(x);
		if(x < currentMedian) sml.add(x);

		if(lrg.size() > sml.size())currentMedian = lrg.peek();
		else if(lrg.size() > sml.size()+1) sml.add(lrg.remove());
		if(lrg.size < sml.size)currentMedian = sml.peek();
		else if(sml.size() > lrg.size()+1) lrg.add(sml.remove());

		size++;
	}

	public double getMedian() {
		if(size == 0) throw new NoSuchElementException() ;
		return currentMedian;
	}

}
