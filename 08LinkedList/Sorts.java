import java.util.*;

Public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
	    @SuppressWarnings("unchecked") ArrayList<Integer>[] bucket = new ArrayList[10];


	    Integer max = data.get(data.max());

	    for(int c = 0; c < 21;c++){
		if(c <= 10){
		    bucket[c] = new ArrayList<Integer>();
		}
		else{
		    negBucket[c-11] = new ArrayList<Integer>();
    }

    // public static void negRadixsort(){};
    
}
