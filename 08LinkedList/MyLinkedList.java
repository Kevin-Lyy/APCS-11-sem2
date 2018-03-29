public class MyLinkedList{
    private Node start,end;
    private int size;
    
    private class Node{
    Node next,prev;
    int data;

	public Node(){

	}

	public Node getNext(){
	    return next;
	}

	public void setNext(Node n){
	    next = n;
	    this.next = next;
	}

	public Node getPrev(){
	    return prev;
	}

	public void setPrev(Node p){
	    prev = p;
	    this.prev = prev;
	}

	public int getValue(){
	    return data;
	}

	public void setValue(int d){
	    data = d;
	    this.data = data;
	}

	public String toString(){
	    String nodeStr = ""
		while node != null{
		    }
	}

    }
	

    public MyLinkedList(){
	size = 0;
    }

    public boolean add(Integer newData){
	Node newNode = new Node(null,end,newData);
	end = newNode
	return true;
    }

    public void add(int index, Integer value){
	if(index > length){
	    throw new ArrayIndexOutOfBoundsException("index out of bounds");
	}

		
    }

    public int size(){
	return size;

    }

    public string toString(){

    }

    private void clear(){

    }
    

    public Integer get(int index){

    }

    public Integer set(int index, int newValue){

    }

}
