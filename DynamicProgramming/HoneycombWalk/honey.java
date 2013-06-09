import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * Solution to Honeycomb Walk
 * See <a href="http://poj.org/problem?id=3036">problem statement</a>
 * @author <a href="mailto:camilo.rocha@gmail.com">Camilo Rocha</a>
 * @version 1.0
 */
public class honey {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Hashtable<String,Long> memo = new Hashtable<String,Long>();
    int n = Integer.parseInt(bf.readLine());
    while (n > 0) {
      int steps = Integer.parseInt(bf.readLine());
      System.out.println(solve(steps,0,0,memo));
      n--;
    }
  }

  public static long solve(int n, int x, int y, Hashtable<String,Long> memo) {
    long r = 0l;
    String key = n + "," + x + "," + y;
    if (memo.containsKey(key)) {
      r = memo.get(key);
    }
    else {
      if (n == 0) {
        r = (x==0 && y==0)? 1 : 0;
      }
      else {
        r = solve(n-1, x, y+2, memo) 
          + solve(n-1, x, y-2, memo) 
          + solve(n-1, x+1, y+1, memo) 
          + solve(n-1, x+1, y-1, memo) 
          + solve(n-1, x-1, y+1, memo) 
          + solve(n-1, x-1, y-1, memo);
      }
      memo.put(key, r);
    }
    return r;
  }

  public static long solveRec(int n, int x, int y) {
    long r = 0;
    if (n == 0) {
      r = (x==0 && y==0)? 1 : 0;
    }
    else {
      r = solveRec(n-1, x, y+2) + solveRec(n-1, x, y-2) + solveRec(n-1, x+1, y+1) + solveRec(n-1, x+1, y-1) + solveRec(n-1, x-1, y+1) + solveRec(n-1, x-1, y-1);
    }
    return r;
  }
}
