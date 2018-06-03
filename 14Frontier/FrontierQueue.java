import java.util.*;
public class FrontierQueue implements Frontier{
	private LinkedList<Location> queue = new LinkedList<>();
	public FrontierQueue(){}

	public void add(Location l){
		queue.add(l);
	}

	public Location next(){
		return queue.remove();
	}

	public boolean hasNext(){
		return queue.peek() != null;

	}
}
