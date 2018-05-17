
public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
    	board = new int[size][size];
    }

  private boolean addQueen(int r, int c){
      if (c >= board.length || r >= board[0].length || board[r][c] != 0) return false;

      for(int row = 0; row<board.length;row++){
        for(int col = 0; col < board[r].length;col++){
            if(row == r||col == c){
              board[row][col] += 1;
          }
        }
      }
      for(int diag = 1; diag < board.length; diag++){
        if((r+diag < board.length) && (c+diag < board.length)){
          board[r+diag][c+diag] += 1;
        }
        if((r-diag >=0) && (c+diag < board.length)){
          board[r-diag][c+diag] += 1;
        }
      }
      board[r][c] = -1;
      return true;

  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1) return false;

      for(int row = 0; row<board.length;row++){
        for(int col = 0; col < board[r].length;col++){
            if(row == r||col == c){
              board[row][col] -= 1;
          }
        }
      }
      for(int diag = 1; diag < board.length; diag++){
        if((r+diag < board.length) && (c+diag < board.length)){
          board[r+diag][c+diag] -= 1;
        }
        if((r-diag >=0) && (c+diag < board.length)){
          board[r-diag][c+diag] -= 1;
        }
      }
      board[r][c] = 0;
      return true;

  }

	public String toString(){
		String ans="";
		for (int r=0; r<board.length; r++){
			for (int c=0; c<board[r].length; c++){
				if (board[r][c]< 0 ){
					ans+="Q ";
				}
				if(board[r][c] >= 0){
					ans+="_ ";
				}
			}
			ans+="\n";
		}
		return ans;
	}

  public boolean solve(){
    for(int[] col: board){
      for(int place: col){
        if(place != 0)throw new IllegalStateException();
      }
    }

	     return helpSolve(0);
    }

    public boolean helpSolve(int col){
	     if(col > board[0].length-1){
	        return true;
	       }
	     for(int row = 0; row < board.length; row++){
	        if(addQueen(row,col)){
            if (helpSolve(col + 1)){
		          return true;
	      }
        else{
	       removeQueen(row,col);
       }
	      }
      }
	         return false;
    }

    public int countSolutions(){
      for(int[] col: board){
        for(int place: col){
          if(place != 0)throw new IllegalStateException();
        }
       }
	               return helpCount(0);
    }

    public int helpCount(int col){
	      if(col > board.length - 1){
	         return 1;
	        }
        int count = 0;
	       for(int row = 0; row < board.length; row++){
	          if(addQueen(row,col)){
		            count += helpCount(col +1);
	             }
               removeQueen(row,col);
	            }
	             return count;
             }



}
