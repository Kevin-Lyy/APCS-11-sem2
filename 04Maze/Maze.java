import java.util.*;
import java.io,*;

public class Maze{

    private char[][]maze;
    private boolean animate; //false

    public Maze(String filename) throws FileNotFoundException{

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
