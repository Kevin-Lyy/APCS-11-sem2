import java.io.*;
import java.util.*;

public class USACO{


    public static int bronze(String filename){
	int total = 0;
	try{
	    Scanner lake = new Scanner(new File(filename));
	    int nRow = lake.nextInt();
	    int nCol = lake.nextInt();
	    int e = lake.nextInt();
	    int n = lake.nextInt();
	    int[][] field = new int[nRow][nCol];

	    for (int row = 0; row < nRow; row++){
		for(int col = 0; col < nCol; col++){
		    field[row][col] = lake.nextInt();
		}
	    }

	    for(int group = 0; group < n; group++){
		int cRow = lake.nextInt();
		int cCol = lake.nextInt();
		int D_s = lake.nextInt();
		int max = 0;

		for(int r = 0; r < 3; r++){
		    for(int c = 0; c < 3; c++){
			if(cRow + r < nRow && cCol + c < nCol && field[cRow + r][cCol + c] > max){
			    max = field[cRow + r][cCol + c];
			}
		    }
		}
	 
		int newValue = max - D_s;
		for(int r = 0; r < 3; r++){
		    for(int c = 0; c < 3; c++){
			if(cRow + r < nRow && cCol + c < nCol && field[cRow + r][cCol + c] > newValue){
			    newValue = field[cRow + r][cCol + c];
			}
		    }
		}
	    }

		for (int r = 0; r < nRow; r++){
		    for(int c = 0; c < nCol; c++){
			if(field[r][c] < e){
			    total += e - field[r][c];
			}
		    }
		}
	    }
	    catch(FileNotFoundException e){
		System.out.println("wya");
	    }
	return total * 72 * 72;
    }



	//    public static int silver(String filename){

		    // }

}

    
