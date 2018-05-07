public interface Frontier{ 

	public location next();
	public void add(Location n);
	public boolean hasNext();

	public class Location{
		private int x,y;
	    private Location previous;

	    public Location(int _x, int _y, Location prev){
	    }
	}

	
	}
}
