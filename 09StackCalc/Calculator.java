import java.util.*;

public class Calculator{
    
    public static double eval(String s){

    }
    private class functions{
	private LinkedList<Double> l = new LinkedList<>();
	
	public double pop(){
	    double newL = l.getLast();
	    l.removeLast();
	    return newL;
	}
	public double peek(){
	    return l.getLast();
	}
	public void push(double value){
	    l.add(value);
	}

    }

    

    
}


