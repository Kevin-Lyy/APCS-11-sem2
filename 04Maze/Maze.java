import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate; //false
  public int[][] movement = {{1,0},{-1,0},{0,1},{0,-1}};


  public Maze(String filename) throws FileNotFoundException{
    //COMPLETE CONSTRUCTOR
    File text = new File(filename);
    Scanner fileM = new Scanner(text);
    int rows=0;
    int cols=0;
    while(fileM.hasNextLine()){
      rows+=1;
      String line = fileM.nextLine();
      cols=line.length();
    }
    Scanner read = new Scanner(text);
    maze= new char[rows][cols];
    int currentRow=0;
    for (int r=0;r<rows;r++){
      String line=read.nextLine();
      for (int c=0;c<cols;c++){
        maze[r][c]=line.charAt(c);
      }
    }
    int start=0;
    int end=0;
    for (int row=0; row<maze.length; row++){
      for (int col=0; col<maze[0].length; col++){
        if (maze[row][col]=='S'){
          start+=1;
        }
        if (maze[row][col]=='E'){
          end+=1;
        }
      }
    }
    if (start!=1 || end!=1){
      throw new IllegalStateException();
    }
  }

  private void wait(int millis){
    try{
      Thread.sleep(millis);
    }
    catch (InterruptedException e){
    }
  }


  public void setAnimate(boolean b){
    animate = b;
  }


  public void clearTerminal(){
    System.out.println("\033[2J\033[1;1H");
  }


  public String toString(){
    String str = "";
    for(int r = 0; r <maze.length;r++){
      for(int c = 0; c < maze[0].length; c++){
        str += maze[r][c];
      }
      str += "\n";
    }
    return str;
  }


  public int solve(){
    for(int r = 0; r < maze.length; r++){
      for(int c = 0; c < maze[0].length; c++){
        if(maze[r][c] =='S'){
          return solveHelp(r,c,0);
        }
      }
    }
    return -1;
  }


  private int solveHelp(int row, int col,int level){
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }

    if (maze[row][col] == 'E') return level;

    for (int x = 0; x < movement.length; x++) {

      int tempRow = row + movement[x][1];
      int temoCol = col + movement[x][0];

      maze[row][col] = '@';

      if (maze[tempRow][temoCol] == ' ' || maze[tempRow][temoCol] == 'E'){
        int ans = solveHelp(tempRow, temoCol, level + 1);
        if (ans != -1){
          return ans;
        }
      }

      maze[row][col] = '.';
    }

    return -1;
  }



}
