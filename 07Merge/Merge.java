import java.util.*;
public class  Merge{

    private static void merge(int[] data, int[] temp,int lo,int hi){
	mid = (lo + hi)/2;
	int start = lo;
	int midpoint = mid;
	int tStart = lo;

	while(start < mid && midpoint <= hi && l <= hi){
	    if(temp[start] < tempstart[midpoint]){
		data[tStart] = temp[start];
		start++;
		tStart++;
	    }
	    else{
		data[tStart] = temp[midpoint];
		midpoint++;
		tStart++;
	    }
	}
	while(start < mid && tStart <= hi){
	    data[tStart] = temp[start];
	    start++;
	    tStart++;
	}
	while(midpoint < hi && tStart <= hi){
	    data[tStart] = temp[midpoint];
	    midpoint++;
	    tStart++;
	}

    }


    public static void mergeSort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);

    }

    public static void msort(int[] data, int[] temp, int lo, int hi){
	int mid = (lo+hi)/2;
	if(lo >= hi){
	    return data;
	}
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid+1,hi);

	for(int c = lo; c < hi; c++){
	    temp[c] = data[c];
	}
    }
}

