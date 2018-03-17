import java.io.*;
import java.util.*;

public class USACO{

    //BRONZE
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

    //SILVER
    public static int silver(String filename){
	try{
	    Scanner travel = new Scanner(new File(filename));
	    int rows = travel.nextInt();
	    int cols = travel.nextInt();
	    char[][] map = new char[rows][cols];
	    int[][] now = new int[rows][cols];
	    int[][] then = new int[rows][cols];
	    int time = travel.nextInt();

	    System.out.println(travel.nextLine());

	    for(int r = 0; r < rows; r++){
		String s = travel.nextLine();
		for(int c = 0; c < cols; c++){
		    map[r][c] = s.charAt(c);
		}
	    }

	    int sRow = travel.nextInt() - 1;
	    int sCol = travel.nextInt() - 1;
	    int eRow = travel.nextInt() - 1;
	    int eCol = travel.nextInt() - 1;
	    now[sRow][sCol] = 1;
	    for(int count = 0; count < time; count++){
		then = now;
		now = new int[rows][cols];
		
		for(int r = 0; r < rows; r++){
		    for(int c = 0; c < cols; c++){
			int total = 0;
			
			if(map[r][c] != '*' && then[r][c] == 0){
			    if(r+1 > rows && map[r+1][c] != '*'){
				total += then[r+1][c];
			    }
			    
			    if(r-1 > -1 && map[r-1][c] != '*'){
				total += then[r-1][c];
			    }

			    if(c+1 < cols && map[r][c+1] != '*'){
				total += then[r][c+1];
			    }

			    if(c-1 > -1 && map[r][c-1] != '*'){
				total += then[r][c-1];
			    }
			}

			now[r][c] = total;
		    }
		}
	    }

	    return now[eRow][eCol];
	}
	catch(FileNotFoundException e){
	    System.out.println("wya");
	}
	return -1;
    }
		    
}

    
