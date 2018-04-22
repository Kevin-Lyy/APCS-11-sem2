import java.util.*
public class MyDeque<T>{
    private T[] array;
    private int start;
    private int end;
    private int size;

    @SupressWarnings("unchecked")
    public MyDeque(){
	array =(T[]) new Object[10];
	size = 0;
	start = 0;
	end = 5;
    }

    @SupressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initalCapacity < 0){
	    throw new IllegalArgumentException;
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
	if(T == null){
	    throw new NullPointerException;
	}

    }

    public void addLast(T value){
	if(T == null){
	    throw new NullPointerException;
	}

    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException;
	}

    }
    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException;
	}

    }
    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException;
	}
	
    }
    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException;
	}
    }   
}

