
import java.util.*;

public class Sorts extends MyLinkedListImproved{

  @SuppressWarnings("unchecked")public static void radixsort(MyLinkedListImproved<Integer> data){
    MyLinkedListImproved<Integer> bucket = new MyLinkedListImproved<>();
    MyLinkedListImproved<Integer> nbucket = new MyLinkedListImproved<>();

    if(data.size() <= 1){
      return ;
    }

    //start sorted bucket, seperates pos and neg
    for(Integer d:data){
      if(d>0){
        bucket.add(d);
      }
      else{
        nbucket.add(d);
      }
    }
    //sort positive
    if(bucket.size > 0){
      MyLinkedListImproved<Integer>[] tempbucket = new MyLinkedListImproved[10];
      for(int c = 0; c < 10;c++){
        tempbucket[c] = new MyLinkedListImproved<Integer>();
      }
      int count = 0;
      int max = bucket.get(bucket.max());
      while(max > 0){
        max /= 10;
        count++;
      }
      for(int c = 0;c < count; c++){
        for(Integer x : data){
          int tbucket = (x / ((int)java.lang.Math.pow(10, count))) % 10;
          tempbucket[tbucket].add(x);
        }
        bucket.clear();
        bucket.add(0);
        for(int i = 0;i < 10; i++){
          if(tempbucket[c].size() != 0){
            bucket.extend(tempbucket[c]);
          }
        }
        bucket.remove(0);
      }
    }
    //sort negative
    if(nbucket.size > 0){
      MyLinkedListImproved<Integer>[] tempnbucket = new MyLinkedListImproved[10];
      for(int c = 0; c < 10;c++){
        tempnbucket[c] = new MyLinkedListImproved<Integer>();
      }
      int count = 0;
      int max = nbucket.get(nbucket.max());
      while(max > 0){
        max /= 10;
        count++;
      }
      for(int c = 0;c < count; c++){
        for(Integer x : data){
          int tnbucket = (x / ((int)java.lang.Math.pow(10, count))) % 10;
          tempnbucket[tnbucket].add(x);
        }
        nbucket.clear();
        nbucket.add(0);
        for(int i = 0;i < 10; i++){
          if(tempnbucket[c].size() != 0){
            nbucket.extend(tempnbucket[c]);
          }
        }
        nbucket.remove(0);
      }
    }

    //extend
    if(nbucket.size > 0 && bucket.size > 0){
      nbucket.extend(bucket);
      data.start = nbucket.start;
      data.end = nbucket.end;
    }
  }

  public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
    radixsort(data);
  }
  
public static void main(String[] args){
 MyLinkedListImproved<Integer> data = new MyLinkedListImproved<Integer>();
 for (int x = 0; x < 10; x++){
     int i = (int)(Math.random() * 1000);
     data.add(new Integer(i));
 }
 System.out.println(data);
 radixsort(data);
 System.out.println(data);
   }

}
