public class FrontierPriorityQueue implements Frontier{
	private MyHeap<Location> pQueue;
	public FrontierPriorityQueue{
		pQueue = new MyHeap<Location>(false;)
	}


	public void add(Location l){
		pQueue.add(l);
	}

	public Location next() {
		return pQueue.remove();
	}

	public boolean hasNext(){
		return pQueue.size()>0;
	}
}
