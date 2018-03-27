import java.util.*;
public class Quick{


    public static int partition(int[] data, int start, int end){
	int pivotIndex = (int)(Math.random()*(end-start)+start);
	int pivot = data[pivotIndex];
	int small = start;
	int large = end;
	int temp = data[start];
	
	data[start] = pivot;
	data[pivotIndex] = temp;

	while(small <= large){
	    
	    if(data[small] <= pivot){
		small++;
	    }
	  
	    if(data[small] > pivot){
	    swap(data,small,large);
		large--;
	    }
	swap(data,large,start);   
	return large;
	       
	}
    }
    
    private static swap(int[] data,int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }

    public static int dutchPartition(int[] data, int start, int end){
	int pivotIndex = (int)(Math.random()*(end-start)+start);
	int pivot = data[pivotIndex];
	int small = start;
	int large = end;
	int i = start;
	int lt = start;
	int gt = end;

	swap(data,start,pivotIndex);

	while (i <= gt){
	    if(data[i] == pivot){
		i++;
	    }

	    else{
		if(data[i] < pivot){
		    swap(data,lt,i);
		    lt++;
		    i++;
		}
		if(data[i] > pivot){
		    swap(data,gt,i);
		    gt--;
		}
	    }
	}
	return lt;	
    }

 
    public static int quickSelect(int[]ary,int k){
	quickSort(ary);
    
	return ary[k];
    }

    
    public static void quickSort(int[]ary){
	int s = 0;
	int e = ary.length-1;
	return quickSort(ary,s,e);
    }

    public static void quickSort(int[] ary, int star,t int end){
	while(start <= end){
	    pivot = dutchPartition(ary,start,end);
	    quickSort(ary,start,pivot);
	    start++;
	    quickSort(ary,pivot+1,end);
	    end--;
	}
}




