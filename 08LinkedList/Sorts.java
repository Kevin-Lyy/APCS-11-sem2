import java.util.*;
public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") ArrayList<MyLinkedListImproved<Integer>>[] bucket = new ArrayList[10];
	@SuppressWarnings("unchecked") ArrayList<MyLinkedListImproved<Integer>>[] tempBucket = new ArrayList[10];
	@SuppressWarnings("unchecked") ArrayList<MyLinkedListImproved<Integer>>[] negBucket = new ArrayList[10];

	    Integer max = data.get(data.max());
	    Integer min = data.get(data.min());
	    

	    if(data.size() <= 1){
		return ;
	    }

	    for(int c = 0; c < 21;c++){
		if(c <= 10){
		    bucket[c] = new MyLinkedListImproved<Integer>();
		}
		else{
		    negBucket[c-11] = new MyLinkedListImproved<Integer>();
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
	    for(int c = 0;c<=10;c++){
		for(int d:bucket[c]){
		    if(d<0){
			negBucket[d%10 * -1].add(d);
		    }
		}
	    }
	    int minDigits = 0;
	    while(min>0){
		min = min/10;
		minDigits++;
	    }
	    
	    for(int c = 0;c <= 10; c++){
		for(int d:negBucket[c]){
		    tempBucket[c].add(d);
		}
		negBucket[c].clear();
	    }
	    if(minDigits > 1){
		for(int c = 2;c<=minDigits;c++){
		    for(int cont = 0; cont <= 10; cont++){
			for(int d:tempBucket[cont]){
			    negBucket[-1 * d%(int)Math.pow(10,(double)c)].add(d);
			}
			//clear out bucket
			for(int c2 = 0;c2 <= 10; c2++){
			    tempBucket[c2].clear();
			    for(int d2:negBucket[c2]){			       
				tempBucket[c2].add(d2);
			    }
			    if(c<minDigits){
				negBucket[c2].clear();
			    }
			}
		    }
		}
	    }

    
	    //extend
	    data.clear();
	    for(int c = 9; c >= 0;c++){
		data.extend(negBucket[c]);
	    }
		    
	    for(int c = 0; c < 10;c++){
		data.extend(bucket[c]);
	    }
	    
	    
    }
	    

	    
    public static void radixsortincludingNegatives(MyLinkedListImproved<Integer> data){
	return;

    }

    
}
