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
	end = 5;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	array = (T[]) new Object[initialCapacity];
	size = 0;
	start = 0;
	end = initialCapacity/2;
    }
    
    public int size(){	
	return size;
    }
    
    public void addFirst(T value){
	if(value == null){
	    throw new NullPointerException();
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
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T first = array[start];	
	return first;	
    }
    
    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	T last = array[end];
	return last;
    }
    
    @SuppressWarnings("unchecked")
    public void resize() {
    	if(size < array.length-1) {
    		return ;
    	}
    	T[] temp = (T[]) new Object[(array.length-1)*2];
    	int nStart = start;
    	for(int c = 0; c< size;c++) {
    		temp[c] = array[nStart % array.length];
    		nStart++;
    	}
    	array = temp;
    	start = 0;
    	end = size -1;
    }
}