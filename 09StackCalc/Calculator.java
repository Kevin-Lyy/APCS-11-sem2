import java.util.*;

public class Calculator{
    
    public static double eval(String s){
	Stack sta = new Stack;
	String[] splitS = s.split(" ");
	for(int c = 0; c < splitS.length();c++){
	    

    }
    
    private class Stack{
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


