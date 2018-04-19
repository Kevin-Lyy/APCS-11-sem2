import java.util.*;
public class Sorts{
    
    	@SuppressWarnings("unchecked")public static void radixsort(MyLinkedListImproved<Integer> data){
	    MyLinkedListImproved[] bucket = new MyLinkedListImproved[10];
	    MyLinkedListImproved[] tempBucket = new MyLinkedListImproved[10];
	    MyLinkedListImproved[] negBucket = new MyLinkedListImproved[10];	    
	    
	    if(data.size() <= 1){
		return ;
	    }

	    Integer max = data.get(data.max());
	    Integer min = data.get(data.min());
	    
	    int maxDigits = 0;
	    while(max>0){
		max = max/10;
		maxDigits++;
	    }
	    int minDigits = 0;
	    while(min>0){
		min = min/10;
		minDigits++;
	    }

	    
	    //creating neg and reg bucket  
	    for(int c = 0; c <= 10;c++){
		    bucket[c] = new MyLinkedListImproved<Integer>();
		    negBucket[c] = new MyLinkedListImproved<Integer>();
	    }
	    
	    //first sorted bucket, seperates pos and neg
	    for(int d:data){
		if(d>0){
		    bucket[d%10].add(d);
		}
		else{
		    negBucket[-1 * d%10].add(d);
		}
	    }



	    //sort pos
	    for(int c = 2;c <= maxDigits;c++){
		for(int cont = 0;cont <=10;cont++){
		    for (int d:bucket){
			tempBucket[d%(int)Math.pow(10,c)].add(d);
		    }
		}
	    }
				   
				   
	   
	    //sort neg

		    
	    /*broken rn
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
	    */

    
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
