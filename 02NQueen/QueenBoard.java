public class QueenBoard{
    private int[][]board;
    private int size;

    public QueenBoard(int size){
	this.size = size;
	for(int row = 0;row < size;row++){
	    for(int col = 0; col < size; col++){
		board[row][col] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c){
	if(board[r][c] ==0){
	    board[r][c] = -1;
	    for(int i = 0;c < size-r;i++ ){
	       if(c< size -c){
		   board[r+i][c+i] = 1;
		   board[r+i][c] = 1;
		   board[r+i][c-i] = 1;
		   board[r-i][c+i] = 1;
		   board[r-i][c] =1;
		   board[r-i][c-i]=1;
		   board[r][c+i] = 1;
		   board[r][c] = 1;
		   board[r][c-i] =1;
	       }
	    }		
	    return true;
	}
	return false;
    }
    private boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    board[r][c] = 0;
	    for(int i = 0;c < size-r;i++ ){
		if(c< size -c){
		    board[r+i][c+i] = 0;
		    board[r+i][c] = 0;
		    board[r+i][c-i] = 0;
		    board[r-i][c+i] = 0;
		    board[r-i][c] =0;
		    board[r-i][c-i]=0;
		    board[r][c+i] = 0;
		    board[r][c] = 0;
		    board[r][c-i] =0;
		}
	    }
	    return true;
	}
	return false;
    }
    
    public String toString(int size){
	String StringBoard = "";
        for(int row = 0; row < size; row++){
	    for(int col = 0; col < size +1; col++){
		if (board[row][col] == -1){
		    StringBoard += "Q ";
		}
		if(col == size +1){
		    StringBoard += "/n";
		}
		else if(board[row][col] >= 0){
		    StringBoard += "_ ";
		}
	    }
	}
	return StringBoard;
    }
    

    public boolean solve(){
	for (int[] x:board){
	    for (int y : x){
		if(y != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return helpSolve(0);
    }
    public boolean helpSolve(int row){
	if(row == size){
	    return true;
	}
	for(int col = 0; col < size; col++){
	    if(addQueen(row,col) && helpSolve(row + 1)){
		return true;
	    }
	    removeQueen(row,col);
	}
	return false;
    }
    
    public int countSolutions(){
	for (int[] x:board){
	    for (int y : x){
		if(y != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return helpCount(0);	
    }

    public int helpCount(int row){
	int count = 0;
	if(row == size){
	    return 1;
	}
	for(int col = 0; col < size; col++){
	    if(addQueen(row,col)){
		count += helpCount(row +1);
		removeQueen(row,col);
	    }
	}
	return count;
    }

}
