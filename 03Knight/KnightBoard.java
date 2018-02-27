public class KnightBoard{
    
    public int[][] board;
    public static int[][] addKnight = {{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
    public int rows,cols;
    
    public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	
	for (int r = 0; r < startingRows; r++){
	    for(int c = 0; c < startingCols; c++){
		board[r][c] = 0;
	    }
	}
	rows = startingRows;
	cols = startingCols;

    }

    public String toString(){
	String StringBoard = "/n";
	for(int y = 0; y < rows;y++){
	    for(int x = 0; x < cols+1; x++){
		if(x+y < 6){
		    if(x == cols+1){
			StringBoard += "/n";
		    }
		    StringBoard += board[y][x];
		}
		if(x+y > 6){
		    if(x == cols+1){
			StringBoard += "/n";
		    }
		    if(board[y][x] < 10){
			StringBoard += "_" + board[y][x];
		    }
		    StringBoard += board[y][x];
		}
	    }
	}
	return StringBoard;

    }

    public boolean solve(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0)throw new IllegalArgumentException();
	for(int[] x: board){
	    for(int y:x){
		if(y!=0) throw new IllegalStateException();
	    }
	}
	return solveH(startingRow,startingCol,1);
    }

    private boolean solveH(int row, int col, int level){
	if(level == row*col){
	    board[row][col] = level;
	    return true;
	}

	for(int aKnight[]: addKnight){
	    int temprow = row + aKnight[0];
	    int tempcol = col + aKnight[1];
	    if(board[row][col] == 0 && temprow >=0 && temprow < row
	       && tempcol >= 0 && tempcol < col){
		board[row][col] = level;
		if(solveH(temprow,tempcol,level+1)){
			return true;
		    }
		board[row][col] = 0;
	    }
	}
	return false;		   		
    }

    public int countSolutions(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0)throw new IllegalArgumentException();
	for(int[] x:board){
	    for(int y:x){
		if(y!=0) throw new IllegalStateException();
	    }
	}
	return countH(startingRow,startingCol, 1);
    }

    public int countH(int row, int col, int level){
	int solutions = 0;
	
	if(level == row*col){
	    board[row][col] = level;
	    return 1;
	}

	for(int aKnight[]: addKnight){
	    int temprow = row + aKnight[0];
	    int tempcol = col + aKnight[1];
	    if(board[row][col] == 0 && temprow >=0 && temprow < row
	       && tempcol >= 0 && tempcol < col){
		board[row][col] = level;
		solutions += countH(temprow,tempcol,level+1);
		board[row][col] = 0;
	    }
	}
	return solutions;		   		
    }

}
