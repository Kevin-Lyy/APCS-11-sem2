import java.util.*;
@SuppressWarnings("unchecked")
public class RunningMedian extends MyHeap{

	private MyHeap<Double> lrg;
	private MyHeap<Double> sml;
	private int size;

	public RunningMedian(){
		lrg = new MyHeap<Double>(false);
		sml = new MyHeap<Double>();
		size = 0;
	}

	public int size() {
		return size;
	}

	public void add(double x){
		if (size() == 0 || x > lrg.peek()) lrg.add(x);
		else sml.add(x);
		if (lrg.size() - sml.size() > 1) sml.add(lrg.remove());
		if (sml.size() - lrg.size() > 1) lrg.add(sml.remove());
		size++;
	}

	public double getMedian() {
		if(size() == 0) throw new NoSuchElementException() ;
		if(sml.size() > lrg.size()) return sml.peek();
		if(lrg.size() > sml.size()) return lrg.peek();
		return (sml.peek() + lrg.peek()) / 2.0;
	}

}
