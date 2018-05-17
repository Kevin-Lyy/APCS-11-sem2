import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate; //false
    public int[][] movement = {{1,0},{-1,0},{0,1},{0,-1}};

/*
  public Maze(String filename) throws FileNotFoundException,IllegalStateException{
	   Scanner filereader = new Scanner(new File(filename));
	   int rows = 0;
	   int cols = 0;
	   String fileread = "";
	   while(filereader.hasNextLine()){
	    fileread = filereader.nextLine();
	    rows++;
	    cols = fileread.length();
    }
	    maze = new char[rows][cols];
	     Scanner checkfile = new Scanner(new File(filename));
	     int startOrStop = 0;
	     int r = 0;
	     while(checkfile.hasNextLine()){
	        String checkFileRead = checkfile.nextLine();
	         for(int c = 0;c < checkFileRead.length(); c++){
		           if (maze[r][c] == 'S' || maze[r][c] == 'E')startOrStop++;
	           }
	          r++;
	       }
	        if (startOrStop != 1) throw new IllegalStateException("false maze " + startOrStop);
    }
*/
    public Maze(String filename) throws FileNotFoundException{
            //COMPLETE CONSTRUCTOR
          	File text = new File(filename);
          	Scanner inf = new Scanner(text);
          	int rows=0;
          	int cols=0;
          	while(inf.hasNextLine()){
          		rows+=1;
          		String line = inf.nextLine();
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
    	String ans="";
    	for (int r=0;r<maze.length;r++){
    		for (int c=0;c<maze[0].length;c++){
    			ans+=maze[r][c];
    		}
    		ans+="\n";
    	}
    	return ans;
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
	    if(maze[row][col] == 'E')return level;

	    for(int[] move:movement){
        int rown = row + move[0];
	       int coln = col + move[1];
	        char loc = maze[rown][coln];
	    if(loc == ' ' || loc == 'E'){
		      maze[row][col] = '@';
		       int solv = solveHelp(rown, coln, level + 1);
		       if(solv == -1) maze[rown][coln] = '.';
	         else return solv;
	    }
	}
	return -1;
    }
    public static void main(String[] args){
     try{
       Maze a = new Maze("data1.dat");
       a.setAnimate(false);
       System.out.println(a);
       System.out.println(a.solve());
       System.out.println(a);
     }
     catch(FileNotFoundException e){
       System.out.println("Error");
     }
   }

}
