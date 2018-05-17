import java.util.*;
public class  Merge{

  private static void merge(int[] data, int[] temp,int lo,int end1, int start2, int hi){
	int tStart = lo;
	while(lo < end1 && start2 <= hi){
	    if(temp[lo] < temp[start2]){
		      data[tStart] = temp[lo];
          lo++;
	    }
	    else{
		      data[tStart] = temp[start2];
          start2++;
	    }
        tStart++;
	}
	while(lo <= end1){
	    data[tStart] = temp[lo];
	    lo++;
	    tStart++;
	}
	while(start2 <= hi){
	    data[tStart] = temp[start2];
	    start2++;
	    tStart++;
	}

    }


  public static void mergeSort(int[] data){
	   int[] temp = new int[data.length];
	    msort(data,temp,0,data.length-1);
    }

  public static void msort(int[] data, int[] temp, int lo, int hi){
    if(lo >= hi){
      return ;
    }
    for(int c = lo; c <= hi; c++){
      temp[c] = data[c];
    }

	int mid = (lo+hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,mid+1,hi);


    }

}
