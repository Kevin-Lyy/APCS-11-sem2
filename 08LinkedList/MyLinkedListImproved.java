public class MyLinkedListImproved<T>{
    private Node start,end;
    private int size;
    
    private class Node{
    Node next,prev;
    int data;

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

	public T getValue(){
	    return data;
	}

	public void setValue(int d){
	    data = d;
	}

	public String toString(){
	    return data +"";
	}

    }

    
    private Node getNode(int index){
	Node nodeN = start;
	int c = 0;

	while (nodeN != null){
	    if(c == index){
		return nodeN;
	    }
	    c++;
	    nodeN = nodeN.getNext();
	}
	return nodeN;
    }
	

    public MyLinkedList(){
	size = 0;
    }

    public int size(){
	return size;

    }
    
    private void clear(){
	size = 0;

    }
    
    public boolean add(T newData){
	if(size() == 0){
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
    

    public void add(int index, T value){
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	Node newNode = new Node(value);
	Node Nindex = start;
	int c = 0;
	while(c <= index){
	    if(c == index){
		if(index == 0){
		    newNode.setNext(Nindex);
		    Nindex.setPrev(newNode);
		    start = newNode;
		}
		else if(index == (size()-1)){
		    newNode.setPrev(end);
		    Nindex.setNext(newNode);
		    end = newNode;
		}
		else{
		    newNode.setNext(Nindex);
		    newNode.setPrev(Nindex.getPrev());
		    Nindex.setPrev(newNode);
	    }
	    c++;
	    Nindex = Nindex.getNext();
	    }
	}
    }

    public int indexOf(Integer value){
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


    public T get(int index){
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	int c = 0;
	Node value = start;
	while(value != null){
	    if(c == index){
		return value.getValue();		   
		}
	    c++;
	    value = value.getNext();
	}
	return value.getValue();

    }

    public T set(int index, T newValue){
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	
	int c = 0;
	int old = 0;
	Node value = start;
	while(value != null){
	    if(c == index){
		old = value.getValue();
		value.setValue(newValue);
		return old;
		}
	    c++;
	    value = value.getNext();
	}
	return old;

    }

    
    public boolean remove(Integer value){
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
	
    public T remove(int index){
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	int c = 0;
	Node Nindex = start;
	while(c <= index){
	    if(c == index){
		if(index ==0){
		    start = Nindex.getNext();
		}
		else if(index == (size()-1)){
		    end = Nindex.getPrev();
		    end.setNext(null);
		}
		else{
		    Nindex.getNext().setPrev(Nindex.getPrev());
		    Nindex.getPrev().setNext(Nindex.getNext());
		}
		size--;
		return Nindex.getValue();
	    }
	    c++;
	}
	return Nindex.getValue();
    }
 
}

