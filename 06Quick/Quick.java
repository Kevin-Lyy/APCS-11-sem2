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
	    
	    if(data[small] < pivot){
		small++;
	    }
	    if(data[small] > pivot ]){
	    swap(data,small,large);
		large--;
	    }
	swap(data,large,start);   
	return large;
	       
    }
    public static swap(int[] data,int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }

	 
	    

    public static int quickSelect(int[]ary,int k){


    }

    public static int dutchPartition(int[] data, int start, int end){
	
	    

    public static void quickSort(int[]ary){

    }




	



} 
