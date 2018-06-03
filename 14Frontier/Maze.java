import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze{
  private static final String CLEAR_SCREEN =  "\033[2J";
  private static final String HIDE_CURSOR =  "\033[?25l";
  private static final String SHOW_CURSOR =  "\033[?25h";
  Location start,end;
  private char[][]maze;
  public boolean AStar = false;


  /*
  YOU MUST COMPLETE THIS METHOD!!!
  YOU MUST COMPLETE THIS METHOD!!!
  YOU MUST COMPLETE THIS METHOD!!!
  */

  public Location[] getNeighbors(Location L){
    int x = L.getX();
    int y = L.getY();
    int endX = end.getX();
    int endY = end.getY();
    maze[x][y] = '.';
    Location[] neighbors = new Location[4];
    int right = x+1;
    int left = x-1;
    int up = y+1;
    int down = y-1;
    if(maze[right][y] == ' ' || maze[right][y] == 'E'){
      array[0] = new Location(right,y,L,Math.abs(right-endX)+Math.abs(y-endY),AStar);
      maze[right][y] = '?';
    }
    if(maze[left][y] == ' ' || maze[left][y] == 'E'){
      array[1] = new Location(left,y,L,Math.abs(left-endX)+Math.abs(y-endY),AStar);
      maze[left][y] = '?';
    }
    if(maze[x][up] == ' ' || maze[x][up] == 'E'){
      array[2] = new Location(up,y,L,Math.abs(x-endX)+Math.abs(up-endY),AStar);
      maze[x][up] = '?';
    }
    if(maze[x][down] == ' ' || maze[x][down] == 'E'){
      array[3] = new Location(down,y,L,Math.abs(x-endX)+Math.abs(down-endY),AStar);
      maze[x][down] = '?';
    }


  }

  public Location getStart(){
    return start;
  }
  public Location getEnd(){
    return end;
  }


  private static String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
  }
  private static String color(int foreground,int background){
    return ("\033[0;" + foreground + ";" + background + "m");
  }

  public void clearTerminal(){
    System.out.println(CLEAR_SCREEN+"\033[1;1H");
  }

  public Maze(String filename){
    ArrayList<char[]> lines = new ArrayList<char[]>();
    int startr=-1, startc=-1;
    int endr=-1,endc=-1;
    try{
      Scanner in = new Scanner(new File(filename));
      while(in.hasNext()){
        lines.add(in.nextLine().toCharArray());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: "+filename);
      System.exit(1);
    }
    maze = new char[lines.size()][];
    for(int i = 0; i < maze.length; i++){
      maze[i]=lines.get(i);
    }
    for(int r=0; r<maze.length;r++){
      for(int c=0; c<maze[r].length;c++){
        if(maze[r][c]=='S'){
          if(startr == -1){
            startr=r;
            startc=c;
          }else{
            System.out.println("Multiple 'S' found!");
            System.exit(0);
          }
        }

        if(maze[r][c]=='E'){
          //erase E
          //maze[r][c]=' ';
          if(endr == -1){
            endr=r;
            endc=c;
          }else{
            System.out.println("Multiple 'E' found!");
            System.exit(0);
          }
        }
      }
    }
    if(startr == -1 || endr == -1){
      System.out.println("Missing 'S' or 'E' from maze.");
      System.exit(0);

    }

    /*
    THIS IS AN IMPORTANT PART BECAUSE YOU WILL NEED TO CHANGE IT LATER!
    The start/end Locations may need more information later when we add
    other kinds of frontiers!
    */
    end = new Location(endr,endc,null,0,AStar);
    start = new Location(startr,startc,null,0,AStar);
  }

  public String toStringColor(){
    return toStringColor(50);
  }

  public String toStringColor(int delay){
    try{
      Thread.sleep(delay);
    }catch(InterruptedException e){

    }
    return HIDE_CURSOR+CLEAR_SCREEN+go(1,1)+colorize(toString())+SHOW_CURSOR;
  }

  public String toString(){
    int maxr = maze.length;
    int maxc = maze[0].length;
    String ans = "";
    for(int i = 0; i < maxr * maxc; i++){
      int row = i/maxc;
      int col = i%maxc;

      char c =  maze[row][col];
      ans+=c;
      if( col == maxc-1 ){
        ans += "\n";
      }

    }
    return ans + "\n";
  }

  public char get(int row,int col){
    return maze[row][col];
  }
  public void set(int row,int col, char n){
    maze[row][col] = n;
  }
  public static String colorize(String s){
    String ans = "";
    Scanner in = new Scanner(s);
    while(in.hasNext()){
      String line ="";
      for(char c : in.nextLine().toCharArray()){
        if(c == '#'){
          line+= color(37,47)+c;
        }
        else if(c == '@'){
          line+= color(33,40)+c;
        }
        else if(c == '?'){
          line+= color(37,42)+c;
        }
        else if(c == '.'){
          line+= color(36,40)+c;
        }
        else if(c == ' '){
          line+= color(35,40)+c;
        }else{
          line+=color(37,40)+c;
        }

      }
      ans += line+color(37,40)+"\n";
    }
    return ans;
  }
  public void setAstart(boolean b){
    AStar = b;
  }
}
