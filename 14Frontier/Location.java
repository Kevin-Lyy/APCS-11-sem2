Public class Location impletments Comparable<Location>{
  private int x, y, dist, priority ;
  Location prev;
  boolean aStar;

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

  public String to String(){
    return x + " " + y;
  }

  public int getPriority(){
    return priority;
  }

  public int getDist(){
    return dist;
  }

}
