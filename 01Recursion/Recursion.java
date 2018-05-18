public class Recursion{


  //1.1a factorial
  public int fact(int n){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    if (n == 0){
      return 1;
    }
    return n * fact(n-1);

  }

  //1.1b Fibonacci in O(n)
  public int fib(int n){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    if (n == 0){
      return 0;
    }
    if (n == 1){
      return 1;
    }
    return fibhelp(1,1,2,n);
  }

  public int fibhelp(int bsum, int sum, int count, int n){
    if (count == n){
      return sum;
    }
    return fibhelp(sum, bsum+sum, count + 1, n);
  }

  /*
  public int fib2(int n){
  if (n < 0){
  throw new IllegalArgumentException();
}
if (n == 0){
return 0;
}
if (n == 1){
return 1;
}
return fib2(n-1) + fib(n-2);
}
*/

//1.1c Square Root

public static double sqrt(double n){
  if (n < 0){
    throw new IllegalArgumentException();
  }
  if (n == 0){
    return 0;
  }
  return sqrthelp(n,n/2);
}

public static double sqrthelp(double n, double g){
  if (Math.abs(g*g - n) < 0.0000001){
    return g;
  }
  return sqrthelp(n ,(n/ g + g)/2);
}

public static void main(String[] args){
  System.out.println("done");
}


}
