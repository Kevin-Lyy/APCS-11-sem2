import java.util.*;
import java.io,*;

public class Maze{

    private char[][]maze;
    private boolean animate; //false
    public int[][] movement = {{1,0},{-1,0},{0,1},{0,-1}};

    public String toString(){
	str = "";
	for(int r = 0; r <maze.length;r++){
	    for(int c = 0; c < maze[0].length; c++){
		if(maze[r][c] == '@') str += " @ ";
		else if (maze[r][c] == "#")str += " # ";
		else if (maze[r][c] == ".")str += " . ";
		if (c == maze[0].length -1){
		    str += "\n";
		}
	    }
	}
	return str;

    }

    public Maze(String filename) throws FileNotFoundException,IllegalStateException{

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

    }

    private int solve(int row, int col){

	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}

	return -1;
    }


}
