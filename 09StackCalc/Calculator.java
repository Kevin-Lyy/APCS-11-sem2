import java.util.*;

public class Calculator{

  public static double eval(String s){
    Stack sta = new Stack();
    String[] splitS = s.split(" ");
    for(int c = 0; c < splitS.length;c++){
      if(!"+ - / * %".contains(splitS[c])){
        sta.push(Double.parseDouble(splitS[c]));
      }
      else{
        sta.push(evalHelp(sta.pop(),sta.pop(),splitS[c]));
      }
    }
    return sta.pop();
  }
  private static double evalHelp(double n1, double n2, String op){
    if(op.equals("+")){
      return n1+n2;
    }
    if(op.equals("-")){
      return n2 - n1;
    }
    if(op.equals("/")){
      return n1/n2;
    }
    if(op.equals("*")){
      return n1*n2;
    }
    if(op.equals("%")){
      return n1%n2;
    }
    return 0;
  }

  private static class Stack{
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
  public static void main(String[] args){
    System.out.println(Calculator.eval("2 10 -"));
    System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
    System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));

  }

}
