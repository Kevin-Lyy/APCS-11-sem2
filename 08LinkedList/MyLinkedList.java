public class MyLinkedList{
    private Node start,end;
    private int size;
    
    private class Node{
    Node next,prev;
    Integer data;

	public Node(Integer value){
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

	public Integer getValue(){
	    return data;
	}

	public void setValue(Integer d){
	    data = d;
	}

	public String toString(){
	    return data +"";
	}

    }

    public MyLinkedList(){
	size = 0;
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

    public int size(){
	return size;
    }
    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    //adds at end of the list 
    public boolean add(Integer newData){
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
    public void add(int index, Integer value){
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


    //returns the index of the first time value appears
    public int indexOf(Integer value){
	int c = 0;
	Node index = start;
	while(index != null){
	    if(index.getValue().equals(value)){
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
    public Integer get(int index){
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
	return -1;
    }

    //channges value at indext into new value
    public Integer set(int index, int newValue){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	int old = 0;
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

    //deletes value(first appearence)
    public boolean remove(Integer value){
	Node index = start;
	if(index.equals(start)){
	    start = index.getNext();
	    	size--;
		return true;
	}
	else if(index.equals(end)){
	    end = end.getPrev();
	    end.setNext(null);
	    size--;
	    return true;	    
	}
	
	for(int c =0; c < size;c++){
	    if(index.getValue().equals(value)){
		    index.getNext().setPrev(index.getPrev());
		    index.getPrev().setNext(index.getNext());
		    size--;
		    return true;		   
		}   
	    index = index.getNext();
	}
	return false;
    }
    
    //removes value at index
    public Integer remove(int index){
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

    /*
public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
   }
    */
    
 
}
