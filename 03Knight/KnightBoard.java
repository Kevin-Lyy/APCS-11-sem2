public class KnightBoard{
    

    public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	private int[][] board ;
	for (int r = 0; r < startingRows; r++){
	    for(int c = 0; c < startingCols; c++){
		board[r][c] = 0;
	    }
	}

    }

    public String toString(){
	String Stringboard = "";
	

    }

    public boolean solve(int startingRow, int startingCol){

    }

    public int countSolutions(int startingRow, int startingCol){

    }

    private boolean solveH(int row, int col, int level){

    }
    //go in order by level    

}
