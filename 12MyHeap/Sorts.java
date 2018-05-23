import java.util.*;
public class Sorts extends MyHeap{

	public static void heapsort(int[] heap){
		MyHeap<Integer> heaped = new MyHeap<Integer>(false);
		for(int c = 0; c < heap.length;c++){
			heaped.add(heap[c]);
		}
		for(int i = 0; i < heap.length; i++){
			heap[i] = heaped.peek();
			heaped.remove();
		}
	}

	public static void main(String[] args){
 	int[] d1 = new int[10];
 	int[] d2 = new int[10];
 	for (int i = 0; i < 10; i++){
 	    int num = (int)(Math.random() * 1000);
 	    d1[i] = num;
 	    d2[i] = num;
 	}

 	System.out.println(Arrays.toString(d1));
 	System.out.println(Arrays.toString(d2));

 	Arrays.sort(d1);
 	heapsort(d2);

 	for (int i = 0; i < 10; i++){
 	    if (d1[i] != d2[i]){
 		System.out.println("error at "+ i);
 		System.out.println(Arrays.toString(d1));
 		System.out.println(Arrays.toString(d2));
 		System.exit(1);
 	    }
 	}

 	System.out.println("no error");
     }

}
