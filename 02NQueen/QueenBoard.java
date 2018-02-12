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
	board[r][c] = -1;
	return true;
    }
    private boolean removeQueen(int r, int c){
	board[r][c] = 0;
	return true;

    public String toString(int size){
	String StringBoard = "";
        for(int row = 0; row < size; row++){
	    for(int col = 0; col < size+1; col++){
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
