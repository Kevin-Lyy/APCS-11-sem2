import java.util.*;
public class Sorts{

    	@SuppressWarnings("unchecked")public static void radixsort(MyLinkedListImproved<Integer> data){
	    MyLinkedListImproved[] bucket = new MyLinkedListImproved[10];
	    MyLinkedListImproved[] nbucket = new MyLinkedListImproved[10];
	    ArrayList<Integer>[] tempBucket = new ArrayList[10];
	    ArrayList<Integer>[] negBucket = new ArrayList[10];
	    ArrayList<Integer>[] shuffle = new ArrayList[10];

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
		    tempBucket[c] = new ArrayList<Integer>();
		    negBucket[c] = new ArrayList<Integer>();
	    }

	    //first sorted bucket, seperates pos and neg
	    for(int d:data){
		if(d>0){
		    tempBucket[d%10].add(d);
		}
		else{
		    negBucket[-1 * d%10].add(d);
		}
	    }
	    //move values into shuffle
	    for(int i = 0; i <= 10; i++){
		for(int d:tempBucket[i]){
		    shuffle[i].add(d);
		    tempBucket[i].clear();
		}
	    }

	    //sort pos
	    for (int c = 2; c<= maxDigits; c++){
		for(int cont = 0; cont <= 10; cont++){
		    for(int d:shuffle[cont]){
			tempBucket[d% (int)Math.pow(10, (double)c)].add(d);
		    }
		    //clear out bucket to resort
		    for(int c2 = 0; c2 <= 10; c2++){
			shuffle[c2].clear();
			for(int d2:tempBucket[c2]){
			    shuffle[c2].add(d2);
			}
			if(c < maxDigits){
			    tempBucket[c2].clear();
			}
		    }
		}
	    }
	    //move neg values into shuffle
	    for(int i = 0; i <= 10; i++){
		for(int d:negBucket[i]){
		    shuffle[i].clear();
		    shuffle[i].add(d);
		    negBucket[i].clear();
		}
	    }

	    for(int c = 2;c<=minDigits;c++){
		for(int cont = 0; cont <= 10; cont++){
		    for(int d:shuffle[cont]){
			negBucket[-1 * d%(int)Math.pow(10,(double)c)].add(d);
		    }
		    //clear out bucket
		    for(int c2 = 0;c2 <= 10; c2++){
			shuffle[c2].clear();
			for(int d2:negBucket[c2]){
			    shuffle[c2].add(d2);
			}
			if(c<minDigits){
			    negBucket[c2].clear();
			}
		    }
		}
	    }

	    for(int i = 0; i <= 10;i++){
		for(int d:negBucket[i]){
		    nbucket[i].add(d);
		}
		for(int d2:tempBucket[i]){
		    bucket[i].add(d2);
		}
	    }

	    //extend
	    data.clear();
	    for(int c = 9; c >= 0;c++){
		data.extend(nbucket[c]);
	    }
	    for(int c = 0; c < 10;c++){
		data.extend(bucket[c]);
	    }

	}
    public static void radixsortincludingNegatives(MyLinkedListImproved<Integer> data){
	return;
    }
}
