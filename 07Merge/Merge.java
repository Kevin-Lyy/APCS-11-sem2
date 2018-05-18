import java.util.*;
public class  Merge{

    private static void merge(int[] data, int[] temp, int lo, int mid, int midUp, int hi){
      int tStart = lo;

      while (lo <= mid && midUp <= hi){
        if (temp[lo] < temp[midUp]){
          data[tStart] = temp[lo];
          lo++;
        }
        else {
          data[tStart] = temp[midUp];
          midUp++;
        }
        tStart++;
        }

        while (lo <= mid){
          data[tStart] = temp[lo];
          tStart++;
          lo++;
        }

        while (midUp <= hi){
          data[tStart] = temp[midUp];
          tStart++;
          midUp++;
        }
      }


  public static void mergesort(int[] data){
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

    public static String toString(int[] data){
  String ans = "[";
  for (int x = 0; x < data.length; x++){
   if (x == data.length - 1){
 ans = ans + data[x] + "]";
   }
   else {
 ans = ans + data[x] + ", ";
   }

 }
  return ans;
  }


}
