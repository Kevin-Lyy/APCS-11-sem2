public class Location implements Comparable<Location>{
  private int x, y, dist, priority;
  private Location prev;
  private boolean aStar;

  public Location(int _x,int _y, Location prevs,int dists, boolean aStarq){
    x = _x;
    y = _y;
    prev = prevs;
    dist = dists;
    aStar = aStarq;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public Location getPrev(){
    return prev;
  }

  public String toString(){
    return x + " " + y;
  }

  public int getPriority(){
    return priority;
  }

  public int getDist(){
    return dist;
  }

  public int compareTo(Location l){
    return getPriority() - l.getPriority();
  }

}
