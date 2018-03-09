import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate; //false
    public int[][] movement = {{1,0},{-1,0},{0,1},{0,-1}};

    public String toString(){
	String str = "";
	for(int r = 0; r <maze.length;r++){
	    for(int c = 0; c < maze[0].length; c++){
		if(maze[r][c] == '@') str += " @ ";
		else if (maze[r][c] == '#')str += " # ";
		else if (maze[r][c] == '.')str += " . ";
		if (c == maze[0].length -1){
		    str += "\n";
		}
	    }
	}
	return str;

    }

    public Maze(String filename) throws FileNotFoundException,IllegalStateException{
	Scanner filereader = new Scanner(new File(filename));
	int rows = 0;
	int cols = 0;
	String fileread = "";
	while(filereader.hasNextLine()){
	    fileread = filereader.nextLine();
	    rows++;
	}
	cols = fileread.length();
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

	if (startOrStop != 1) throw new IllegalStateException("false maze" + startOrStop);	
	
		
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


    
    public int solve(){
	for(int r = 0; r < maze.length; r++){
	for(int c = 0; c < maze[0].length; c++){
		if(maze[r][c] =='S'){
		    return solve(r,c,0);
		}
	    }
	}
	return -1;

    }
    private int solve(int row, int col,int level){
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	if(maze[row][col] == 'E')return level;
	for(int[]move:movement){
	    int coln = col + move[1];
	    int rown = row + move[0];
	    char loc = maze[rown][coln];
	    if(loc == ' ' || loc == 'E'){
		maze[row][col] = '@';
		int solv = solve(rown, coln, level + 1);
		if(solv == -1) maze[rown][coln] = '.';
		else return solv;
	    }
	}
		

	return -1;
    }
    


}
