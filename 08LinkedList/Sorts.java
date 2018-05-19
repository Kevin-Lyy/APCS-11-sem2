import java.util.*;

public class Sorts extends MyLinkedListImproved{

  @SuppressWarnings("unchecked")public static void radixsort(MyLinkedListImproved<Integer> data){
    MyLinkedListImproved<Integer> bucket = new MyLinkedListImproved<>();
    MyLinkedListImproved<Integer> nbucket = new MyLinkedListImproved<>();

    if(data.size() <= 1){
      return ;
    }

    //first sorted bucket, seperates pos and neg
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

  ////////////////////////////////////////////////////////////////////////////////////
  public static void main(String[] args) {
	//-----------SORTING POSITIVES-----------
	System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
	MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
	int[] correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	long end,start = System.currentTimeMillis();
	radixsortIncludingNegatives(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	boolean hasError = false;
	int index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with all positive integers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING NEGATIVES-----------
	System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
	data.clear();
	correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    temp *= -1;
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	start = System.currentTimeMillis();
	radixsortIncludingNegatives(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with all negative numbers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING POSITIVES AND NEGATIVES-----------
	System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
	data.clear();
	correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    if((int)(Math.random() * 1000) % 2 == 0){
		temp *= -1;
	    }
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	start = System.currentTimeMillis();
	radixsortIncludingNegatives(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING EMPTY LISTS-----------
	System.out.println("SORTING ON EMPTY LISTS");
	data.clear();
	correctData = new int[0];

	start = System.currentTimeMillis();
	radixsortIncludingNegatives(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your empty LinkedList is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
	System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
	data.clear();
	correctData = new int[1];

	int temp = (int)(Math.random() * 1000);
	data.add(temp);
	correctData[0] = temp;

	start = System.currentTimeMillis();
	radixsortIncludingNegatives(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with one positive element is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
	System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
	data.clear();
	correctData = new int[1];

	temp = (int)(Math.random() * 1000) * -1;
	data.add(temp);
	correctData[0] = temp;

	start = System.currentTimeMillis();
	radixsortIncludingNegatives(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with one negative element is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
  }


}
