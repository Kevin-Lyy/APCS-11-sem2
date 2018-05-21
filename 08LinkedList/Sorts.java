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

    //extend
    if(nbucket.size > 0 && bucket.size > 0){
      helpPos(bucket);
      helpNeg(nbucket);
      nbucket.extend(bucket);
      data.start = nbucket.start;
      data.end = nbucket.end;
    }

    if(nbucket.size() == 0){
      helpPos(data);
      return ;
    }
    if(bucket.size() == 0){
      helpNeg(data);
      return ;
    }
  }

  private static void helpPos(MyLinkedListImproved<Integer> bucket){
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] tempbucket = new MyLinkedListImproved[10];

    for(int c = 0; c < 10;c++){
      tempbucket[c] = new MyLinkedListImproved<Integer>();
    }
    int count = 0;
    int max = bucket.get(bucket.max());
    while(max > 0){
      max /= 10;
      count++;
    }
    for (int c = 0; c < count; c++){
      for (Integer x : bucket){
        int tbucket = (x / ((int)java.lang.Math.pow(10, c))) % 10;
        tempbucket[tbucket].add(x);
      }

      bucket.clear();
      bucket.add(0);
      for(int i = 0;i < 10; i++){
        if(tempbucket[i].size() != 0){
          bucket.extend(tempbucket[i]);
        }
      }
      bucket.remove(0);
    }
  }


  private static void helpNeg(MyLinkedListImproved<Integer> nbucket){
    //sort negative
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] tempnbucket = new MyLinkedListImproved[10];
    for(int c = 0; c < 10;c++){
      tempnbucket[c] = new MyLinkedListImproved<Integer>();
    }
    int count = 0;
    int max = -1 * nbucket.get(nbucket.min());
    while(max > 0){
      max /= 10;
      count++;
    }
    for (int c = 0; c < count; c++){
      for (Integer x : nbucket){
        int tnbucket = (-1 * x / ((int)java.lang.Math.pow(10, c))) % 10;
        tempnbucket[tnbucket].add(x);
      }
      nbucket.clear();
      nbucket.add(0);
      for (int i = 9; i >= 0; i--){
        if (tempnbucket[i].size() != 0){
          nbucket.extend(tempnbucket[i]);
        }
      }
      nbucket.remove(0);
    }
  }


  public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
    radixsort(data);
  }
/*
  public static void main(String[] args){
    MyLinkedListImproved<Integer> data = new MyLinkedListImproved<Integer>();
    for (int x = 0; x < 10; x++){
      int i = (int)(Math.random() * 1000) * -1 ;
      data.add(new Integer(i));
    }
      for (int x = 0; x < 10; x++){
        int i = (int)(Math.random() * 1000)   ;
        data.add(new Integer(i));
    }
    System.out.println(data);
    radixsort(data);
    System.out.println(data);
  }
*/
}
