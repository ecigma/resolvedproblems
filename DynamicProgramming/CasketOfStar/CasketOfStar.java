import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Solution to CasketOfStar
 * See <a href="http://community.topcoder.com/stat?c=problem_statement&pm=11781">problem statement</a>
 * @author <a href="mailto:camilo.rocha@gmail.com">Camilo Rocha</a>
 * @version 1.0
 */
public class CasketOfStar{

  public static int maxEnergy(int[] weight){
    ArrayList<Integer> s = new ArrayList<Integer>();
    for(int i = 0; i < weight.length; i++){
      s.add(weight[i]);
    }
    Hashtable<String,Integer> mem = new Hashtable<String,Integer>();
    return cosm(s,mem);
  }

  public static int cos(ArrayList<Integer> s){
    int r = -1;
    if(s.size() <= 2){
      r = 0;
    }
    else{
      for(int i = 1; i <= s.size()-2; i++){
        int tmp = s.get(i);
        s.remove(i);
        r = Math.max(r,s.get(i-1)*s.get(i) + cos(s));
        s.add(i,tmp);
      }
    }
    return r;
  }

  public static int cosm(ArrayList<Integer> s, Hashtable<String,Integer> mem){
    String k = s.toString();
    int r = -1;
    if (mem.containsKey(k)){
      r = mem.get(k);
    }
    else{
      if(s.size() <= 2){
        r = 0;
      }
      else{
        for(int i = 1; i <= s.size()-2; i++){
          int tmp = s.get(i);
          s.remove(i);
          r = Math.max(r,s.get(i-1)*s.get(i) + cosm(s,mem));
          s.add(i,tmp);
        }
      }
      mem.put(s.toString(),r);
    }
    return r;
  }
}
