import java.util.Arrays;
import java.util.Hashtable;

/**
 * Solution to RandomSort
 * See <a href="http://community.topcoder.com/stat?c=problem_statement&pm=8590">problem statement</a>
 * @author <a href="mailto:camilo.rocha@gmail.com">Camilo Rocha</a>
 * @version 1.0
 */
public class RandomSort {

  public static void main(String[] args) {
    int[] a0 = {1,3,2};
    System.out.println(getExpected(a0));
    int[] a1 = {4,3,2,1};
    System.out.println(getExpected(a1));
    int[] a2 = {1};
    System.out.println(getExpected(a2));
    int[] a3 = {2,5,1,6,3,4};
    System.out.println(getExpected(a3));
  }

  public static double getExpected(int[] permutation) {
    return getExpectedAux(permutation, new Hashtable<String,Double>());
  }

  public static double getExpectedAux(int[] permutation, Hashtable<String,Double> memo) {
    double r = 0d;
    String key = Arrays.toString(permutation);
    if (memo.containsKey(key)) {
      r = memo.get(key);
    }
    else {
      int n = permutation.length;
      int pairs = 0;
      for(int i = 0; i < n-1; i++){
        for(int j = i+1; j < n; j++){
          if (permutation[i] > permutation[j]) {
            pairs++;
            int vi = permutation[i], vj = permutation[j];
            permutation[i] = vj;
            permutation[j] = vi;
            r += 1+getExpectedAux(permutation,memo);
            permutation[j] = vj;
            permutation[i] = vi;
          }
        }
      }
      if (pairs > 0) {
        r /= pairs;
      }
      memo.put(key, r);
    }
    return r;
  }
  

  public static double getExpectedRec(int[] permutation) {
    double r = 0d;
    int n = permutation.length;
    int pairs = 0;
    
    // compute all possible swaps and recursively compute the
    // expected values associated to each swap while accumulating
    // one unit for each swap
    for(int i = 0; i < n-1; i++){
      for(int j = i+1; j < n; j++){
        if (permutation[i] > permutation[j]) {
          pairs++;
          int vi = permutation[i], vj = permutation[j];
          permutation[i] = vj;
          permutation[j] = vi;
          // accumulate 1 and compute the expected value of sorting
          // the resulting permutation
          r += 1+getExpectedRec(permutation);
          permutation[j] = vj;
          permutation[i] = vi;
        }
       }
    }
    // if there where swaps, then one needs to avarage the result because
    // all swaps have the same probability
    if (pairs > 0) {
      r /= pairs;
    }
    return r;
  }

}
