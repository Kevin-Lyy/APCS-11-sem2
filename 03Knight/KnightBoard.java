public class KnightBoard{

  public int[][] board;
  public static int[][] addKnight = {{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1}};
  public int rows;
  public int cols;

  public KnightBoard(int startingRows, int startingCols){
    if(startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }

    board= new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
  }

  public String toString(){

    String StringBoard = "\n";
    for(int x = 0; x < board.length ;x++){
      for(int y = 0; y < board[x].length; y++){
        if(board[x][y] == 0) {
          StringBoard += "_";
        }
        else if(board[x][y] < 10) {
          StringBoard += " " + board[x][y] + " ";
        }
        else {
          StringBoard += board[x][y] + " ";
        }
      }
      StringBoard += "\n";
    }
    return StringBoard;

  }

  public boolean solve(int startingRow, int startingCol){
    if(startingRow < 0 || startingCol < 0)throw new IllegalArgumentException();
    if(startingRow > board.length || startingCol > board[0].length)throw new IllegalArgumentException();

    for(int[] x: board){
      for(int y:x){
        if(y!=0) throw new IllegalStateException();
      }
    }
    return solveH(startingRow,startingCol,1);
  }

  private boolean solveH(int row, int col, int level){
    if(level == rows*cols){
      board[row][col] = level;
      return true;
    }

    for(int aKnight[]: addKnight){
      int temprow = row + aKnight[0];
      int tempcol = col + aKnight[1];
      if(temprow >=0 && temprow < rows && tempcol >= 0 && tempcol < cols && board[temprow][tempcol] == 0){
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
    if(level == rows*cols){
      return 1;
    }

    for(int aKnight[]: addKnight){
      int temprow = row + aKnight[0];
      int tempcol = col + aKnight[1];
      if(temprow >=0 && temprow < rows && tempcol >= 0 && tempcol < cols && board[temprow][tempcol] == 0){
        board[row][col] = level;
        solutions += countH(temprow,tempcol,level+1);
        board[row][col] = 0;
      }
    }
    return solutions;
  }


}
