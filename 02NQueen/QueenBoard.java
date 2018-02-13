public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	for(int row = 0;row < size;row++){
	    for(int col = 0; col < size; col++){
		num[row][col] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c){
	if(board[r][c] ==0){
	    board[r][c] = -1;
	    for(int i = 0;c < data.length-r;i++ ){
		board[r+i][c+i] = 1;
		board[r+i][c] = 1;
		board[r+i][c-i] = 1;
		board[r-i][c+i] = 1;
		board[r-i][c] =1;
		board[r-i][c-i]=1;
		if(c< data.length -c){
  		board[r][c+i] = 1;
		board[r][c] = 1;
		board[r][c-i] =1;
		}
	    }
	}
    }
[		
	    return true;
	}
	return false
    }
    private boolean removeQueen(int r, int c){
	board[r][c] = 0;
  	    for(int i = 0;c < data.length-r;i++ ){
		board[r+i][c+i] = 0;
		board[r+i][c] = 0;
		board[r+i][c-i] = 0;
		board[r-i][c+i] = 0;
		board[r-i][c] =0;
		board[r-i][c-i]=0;
		if(c< data.length -c){
  		board[r][c+i] = 0;
		board[r][c] = 0;
		board[r][c-i] =0;
		}
	    }
	
	return true;

    public String toString(int size){
	String StringBoard = "";
        for(int row = 0; row < data.length; row++){
	    for(int col = 0; col < data.length+1; col++){
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
    

    public boolean solve(){}

    public int countSolutions(){}

}
