import java.util.*;

public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") ArrayList<Integer>[] bucket = new ArrayList[10];
	@SuppressWarnings("unchecked") ArrayList<Integer>[] tempBucket = new ArrayList[10];
	@SuppressWarnings("unchecked") ArrayList<Integer>[] negBucket = new ArrayList[10];

	    Integer max = data.get(data.max());

	    if(data.size() <= 1){
		return ;
	    }

	    for(int c = 0; c < 21;c++){
		if(c <= 10){
		    bucket[c] = new ArrayList<Integer>();
		}
		else{
		    negBucket[c-11] = new ArrayList<Integer>();
		}
	    }
	    int maxDigits = 0;
	    while(max>0){
		max = max/10;
		maxDigits++;
	    }
	    //first sorted bucket
	    for(int d:data){
		if(d>0){
		    bucket[d%10].add(d);
		}
	    }
		
	    //moved to tempBucket
	    for(int c = 0;c <= 10; c++){
		for(int d:bucket[c]){
		    tempBucket[c].add(d);
		}
		bucket[c].clear();
	    }
	    
	    if(maxDigits > 1){
		for(int c = 2;c<=maxDigits;c++){
		    for(int cont = 0; cont <= 10; cont++){
			for(int d:tempBucket[cont]){
			    bucket[d%(int)Math.pow(10,(double)c)].add(d);
			}
			//clear out bucket
			for(int c2 = 0;c2 <= 10; c2++){
			    tempBucket[c2].clear();
			    for(int d2:bucket[c2]){			       
				tempBucket[c2].add(d2);
			    }
			    if(c<maxDigits){
				bucket[c2].clear();
			    }
			}
		    }
		}
	    }

	    //sort neg
	    negRadixSort(negBucket);
	    //extend
	    bucket.extend(negBucket);
    }

    
    public static void negRadixSort(ArrayList<Integer>[] data){
	
	    Integer min = data.get(data.min());
	    int minDigits = 0;
	    while(min>0){
		min = min/10;
		minDigits++;
	    }
	    
	    for(int d:data){
		if(d<0){
		    bucket[abs(d%10)].add(d);
		}
	    }

    }
	
	

    
}
