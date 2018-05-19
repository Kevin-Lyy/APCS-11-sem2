import java.util.*;
public class MyDeque<T>{
  private T[] array;
  private int start;
  private int end;
  private int size;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    array =(T[]) new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    array = (T[]) new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public void addFirst(T value){
    if(value == null){
      throw new NullPointerException();
    }
    if(array[start] == null ){
      array[start] = value;
      size++;
      return ;
    }
    resize();
    if(start == 0){
      start = array.length-1;
    }
    else{
      start--;
    }
    array[start] = value;
    size++;
  }

  public void addLast(T value){
    if(value == null){
      throw new NullPointerException();
    }
    if(array[end] == null ){
      array[end] = value;
      size++;
      return ;
    }
    resize();
    if(end == array.length-1){
      end = 0;
    }
    else{
      end++;
    }
    array[end] = value;
    size++;
  }

  public T removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    T first = array[start];
    array[start] = null;
    size--;
    if(start == array.length-1){
      start = 0;
    }
    else{
      start++;
    }
    return first;
  }

  public T removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    T last = array[end];
    array[end] = null;
    size--;
    if(end == 0){
      end = array.length-1;
    }
    else{
      end--;
    }
    return last;
  }

  public T getFirst(){
    if (size() == 0){
      throw new NoSuchElementException();
    }
    return array[start];
  }

  public T getLast(){
    if (size() == 0){
      throw new NoSuchElementException();
    }
    return array[end];
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    T[] temp = (T[]) new Object[array.length*2+1];
    for(int c = 0; c < size;c++) {
      temp[c] = array[(start+c)% array.length];
    }
    this.start = 0;
    this.end = size() -1;
    this.array = temp;

  }
  public String toString(){
  	String ans = "[";
  	if(start < end){
  	    for (int i = start; i <= end; i++){
  		ans += array[i] + " , ";
  	    }
  	}
  	else{
  	    for(int i = start; i < array.length; i++){
  		ans += array[i] + ", ";
  	    }
  	    for(int i = 0; i <= end; i++){
  		ans += array[i] + ", ";
  	    }
  	}
  	ans = ans.substring(0, ans.length() - 2) + "]";
  	return ans;
      }

      public static void main(String[] args) {
          MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
  	ArrayList<String> b = new ArrayList<>();

  	int size = Integer.parseInt(args[0]);
  	for(int i = 0; i < size; i++){
  	    int temp = (int)(Math.random() * 1000);
  	    if(temp % 2 == 0){
  		a.addFirst("" + temp);
  		a1.addFirst("" + temp);
  		b.add(0, "" + temp);
  	    }
  	    else{
  		a.addLast("" + temp);
  		a1.addLast("" + temp);
  		b.add("" + temp);
  	    }
  	}

  	int index = 0;
  	boolean hasError = false;
  	String errorEvaluation = "Errors found at these indices: ";
  	for (String x : b){
  	    if (!(x.equals(a.getFirst()))){
  		System.out.println("The getFirst() function is incorrect at index " + index);
  		hasError = true;
  	    }
  	    if (!(x.equals(a.removeFirst()))){
  		System.out.println("There is an error at index " + index);
  		errorEvaluation += index + ", ";
  		hasError = true;
  	    }
  	    index++;
  	}


  	if(hasError){
  	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
  	    System.out.println(errorEvaluation);
  	    System.out.println("MyDeque: " + a1);
  	    System.out.println("Actual Deque: " + b);
  	}
  	else{
  	    System.out.println("Your deque is bug-free!");
  	}
      }

  }
