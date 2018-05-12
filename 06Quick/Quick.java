import java.util.*;
public class Quick{


    public static int partition(int[] data, int start, int end){
	int pivotIndex = (int)(Math.random()*(end-start))+start;
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
	return -1;
    }
    
    private static void swap(int[] data,int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }

    public static int[] dutchPartition(int[] data, int start, int end){
	int pivotIndex = (int)(Math.random()*(end-start))+start;
	int pivot = data[pivotIndex];
	int small = start;
	int large = end;
	int i = start;
	int lt = start;
	int gt = end;


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
		else {
		    swap(data,gt,i);
		    gt--;
		}
	    }
	}
	int tl[] = {lt,i};
	return tl;	
    }

 
    public static int quickSelect(int[]ary,int k){
	quickSort(ary);
	return ary[k];
    }

    
    public static void quickSort(int[]ary){
	int s = 0;
	int e = ary.length-1;
	quickSort(ary,s,e);
    }

    public static void quickSort(int[] ary, int start, int end){
	if(start < end){
	    int[] pivot = dutchPartition(ary,start,end);
	    quickSort(ary,start,pivot[0]-1);
	    quickSort(ary,pivot[1],end);
	}
    }
/*
	public static void main(String[] ary){
		int[] data = {4, -10, 18, 6, 16, -8, 3, -1, 9, -12};
		quickSort(data);
		

	System.out.println(data);
	*/

	}
}




