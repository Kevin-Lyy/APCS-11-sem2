import java.util.*;
public class FrontierStack implements Frontier{
	private Stack<Location> stack;

	public FrontierStack(){
		stack = new Stack<Location>();
	}

	public void add(Location l){
		stack.add(l);
	}

	public Location next(){
		return stack.pop();
	}

	public boolean hasNext(){
		return stack.size > 0;
	}

}
