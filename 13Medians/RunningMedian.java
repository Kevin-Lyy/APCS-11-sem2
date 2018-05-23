import java.util.*;
public class RunningMedian extends MyHeap{

	private double currentMedian;
	MyHeap<Double> lrg;
	MyHeap<Double> sml;
	public int size;

	public RunningMedian(){
		lrg = new MyHeap<Double>(false);
		sml = new MyHeap<Double>();
		size = 0;
	}

	public int size() {
		return size;
	}

	public void add(Double x) {
		if(size() == 0 || x > sml.peek() == 0) lrg.add(x);
		else sml.add(x);

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
