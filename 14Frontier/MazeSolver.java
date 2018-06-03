public class MazeSolver{
	private Maze maze;
	private Frontier frontier;
	private boolean animate = true;

	public MazeSolver(String mazeText){
		maze = new Maze (mazeText);
	}

	public boolean solve(){
		return solve(0);
	}

	//mode: required to allow for alternate solve modes.
	//0: BFS
	//1: DFS
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	public boolean solve(int mode){
		if(mode == 0) frontier = new FrontierQueue();
		if(mode == 1) frontier = new FrontierStack();
		if(mode == 2) frontier = new FrontierPriorityQueue();
		//astar
		else{
			frontier = new FrontierPriorityQueue();
			maze.setAstar(true);
		}
		frontier.add(maze.getStart());
		while(frontier.hasNext()){
			if(animate){
				clearTerminal();
				System.out.println(this);
				wait(20);
			}
			Location now = frontier.next();
			Location[] neighbors = maze.getNeighbors(now);
			for(int c = 0; c < 4; c++){
				if(neighbors[c] != null){
					if(neighbors[c].getX() == maze.getEnd().getX() &&	neighbors[c].getY() == maze.getEnd().getY()){
						while(now.getPrev() != null){
							maze.set(now.getX(),now.getY(),'@');
							now = now.getPrev();
						}
						maze.set(maze.getStart().getX(),maze.getStart().getY(),'S');
						maze.set(maze.getEnd().getX(),maze.getEnd().getY(),'E');
						return true;
					}
					frontier.add(neighbors[c]);
				}
			}
		}
		return false;
	}

	public String toString(){
		return maze.toString();
	}

	private void wait(int millis){
      	try {
	    Thread.sleep(millis);
      	}
      	catch (InterruptedException e) {
      	}
    }

		public void clearTerminal(){
			 //erase terminal, go to top left of screen.
			 System.out.println("\033[2J\033[1;1H");
	 }


}
