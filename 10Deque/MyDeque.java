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

  @SuppressWarnings("unchecked")
  public void resize() {
    if(size < array.length-1) return ;

    T[] temp = (T[]) new Object[array.length*2+1];
    for(int c = 0; c < size();c++) {
      temp[c] = array[(start+c)% array.length];
    }
    this.start = 0;
    this.end = size() -1;
    this.array = temp;
  }

  public void addFirst(T value){
    if(value == null) throw new NullPointerException();

    if(array[start] == null ){
      array[start] = value;
      size++;
      return ;
    }
    resize();
    if(start == 0) start = array.length-1;
    else start--;
    array[start] = value;
    size++;
  }

  public void addLast(T value){
    if(value == null) throw new NullPointerException();

    if(array[end] == null ){
      array[end] = value;
      size++;
      return ;
    }

    resize();
    if(end == array.length-1) end = 0;
    else end++;

    array[end] = value;
    size++;
  }

  public T removeFirst(){
    if (size() < 1) throw new NoSuchElementException();

    T first = array[start];
    array[start] = null;

    if(start == array.length-1) start = 0;
    else start++;

    size--;
    return first;
  }

  public T removeLast(){
    if (size() < 0) throw new NoSuchElementException();

    T last = array[end];
    array[end] = null;

    if(end == 0)end = array.length-1;
    else end--;
    size--;
    return last;
  }


  public T getFirst(){
    if (size() == 0) throw new NoSuchElementException();
    return array[start];
  }

  public T getLast(){
    if (size() == 0) throw new NoSuchElementException();
    return array[end];
  }

}
