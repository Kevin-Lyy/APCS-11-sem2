import java.util.Iterator;
import java.util.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
  private Node start,end;
  private int size;

  private class Node{
    Node next,prev;
    T data;

    public Node(T value){
      data = value;
    }

    public Node getNext(){
      return next;
    }

    public void setNext(Node n){
      next = n;
    }

    public Node getPrev(){
      return prev;
    }

    public void setPrev(Node p){
      prev = p;
    }

    public T getValue(){
      return data;
    }

    public void setValue(T d){
      data = d;
    }

    public String toString(){
      return data +"";
    }
  }


  //returns node at given index
  private Node getNode(int index){
    Node nodeN = start;
    for(int c = 0;c <= index;c++){
      if(c == index){
        return nodeN;
      }
      nodeN = nodeN.getNext();
    }
    return nodeN;
  }

  /*
  public MyLinkedList(){
  size = 0;
}
*/

public int size(){
  return size;
}

public void clear(){
  start = null;
  end = null;
  size = 0;
}

//adds at end of the list
public boolean add(T newData){
  if(size == 0){
    start = new Node(newData);
    end = start;
  }
  else {
    Node newNode = new Node(newData);
    end.setNext(newNode);
    newNode.setPrev(end);
    end = newNode;
  }
  size++;
  return true;
}

//adds value at index
public void add(int index, T value){
  Node newNode = new Node(value);
  Node Nindex = start;
  if(index >= size || index < 0){
    throw new IndexOutOfBoundsException();
  }

  if(index == 0){
    start.setPrev(newNode);
    newNode.setNext(start);
    start = newNode;
    size++;
  }
  else if(index == size){
    add(value);
  }
  else{
    for(int c = 0; c < index;c++){
      Nindex = Nindex.getNext();
    }
    newNode.setNext(Nindex);
    Nindex.getPrev().setNext(newNode);
    newNode.setPrev(Nindex.getPrev());
    Nindex.setPrev(newNode);
    size++;
  }
}

public int indexOf(T value){
  int c = 0;
  Node index = start;
  while(index != null){
    if(index.getValue() == value){
      return c;
    }
    c++;
    index = index.getNext();
  }
  return -1;
}


public String toString(){
  if(size == 0){
    return "[]";
  }

  String str = "[ ";
  Node index = start;
  while(index != null){
    if(index.getNext() != null){
      str = str + index.getValue() + " , ";
    }
    else {
      str = str + index.getValue() + " ] ";
    }
    index = index.getNext();
  }
  return str;

}


//returns value of index
public T get(int index){
  if(index >= size || index < 0){
    throw new IndexOutOfBoundsException();
  }
  Node value = start;
  for(int c = 0;c<=index;c++){
    if(c == index){
      return value.getValue();
    }
    value = value.getNext();
  }
  return value.getValue();
}

//channges value at indext into new value
public T set(int index, T newValue){
  if(index >= size || index < 0){
    throw new IndexOutOfBoundsException();
  }

  T old = newValue;
  Node value = start;
  for(int c = 0; c <=index; c++){
    if(c == index){
      old = value.getValue();
      value.setValue(newValue);
      return old;
    }
    value = value.getNext();
  }
  return old;
}


public boolean remove(T value){
  Node index = start;
  while(index != null){
    if(index.getValue() == value){
      if(index.equals(start)){
        start = index.getNext();
      }
      else if(index.equals(end)){
        end = end.getPrev();
        end.setNext(null);
      }
      else{
        index.getNext().setPrev(index.getPrev());
        index.getPrev().setNext(index.getNext());
      }
      size--;
      return true;
    }
    index = index.getNext();
  }
  return false;
}
//removes value at index
public T remove(int index){
  if(index >= size || index < 0){
    throw new IndexOutOfBoundsException();
  }
  Node Nindex = start;
  if(index ==0){
    start = Nindex.getNext();
  }
  else if(index == (size()-1)){
    end = Nindex.getPrev();
    end.setNext(null);
  }
  for(int c = 0;c <= index;c++){
    if(c == index){
      Nindex.getNext().setPrev(Nindex.getPrev());
      Nindex.getPrev().setNext(Nindex.getNext());
    }
  }
  size--;
  return Nindex.getValue();
}


public int max(){
  if(size == 0){
    return -1;
  }

  T tempMax = start.getValue();
  for(T index:this){
    if(tempMax.compareTo(index) > 0){
      tempMax = index;
    }
  }
  return indexOf(tempMax);
}


public int min(){
  if(size == 0){
    return -1;
  }
  T tempMin = start.getValue();
  for(T index:this){
    if(tempMin.compareTo(index) < 0){
      tempMin = index;
    }
  }
  return indexOf(tempMin);
}

//take out all of other list and move to linkedlist, attach to end
//other is now empty

public void extend(MyLinkedListImproved<T> other){
  this.end.setNext(other.start);
  end = other.end;
  size = size + other.size;
  other.size = 0;

}

public class MyLLIterator implements Iterator<T>{
  private Node next;

  public MyLLIterator(Node start){
    next = start;
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }

  public boolean hasNext(){
    return next != null;
  }
  public T next(){
    Node index = next;
    if (hasNext()){
      next = next.getNext();
    }
    else{
      throw new NoSuchElementException();
    }
    return index.getValue();
  }
}

public Iterator<T> iterator(){
  return new MyLLIterator(start);
}
}
