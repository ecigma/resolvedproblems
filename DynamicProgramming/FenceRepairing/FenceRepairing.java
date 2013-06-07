/**
* Solution by 
*  Carlos Antonio Pinzón
*  caph1993@gmail.com
*/

import java.util.*;
import java.lang.Math;

public class FenceRepairing {

  public static void main(String [] args){
    String[] b0 = {"X.X...X.X"};
    System.out.println(calculateCost(b0));
    String[] b1 = {"X.X.....X"};
    System.out.println(calculateCost(b1));
    String[] b2 = {"X.......", "......XX", ".X......", ".X...X.."};
    System.out.println(calculateCost(b2));
    String[] b3 = {".X.......X", "..........", "...X......", "...X..X...", "..........","..........", "..X....XX.", ".........X", "XXX", ".XXX.....X"};
    System.out.println(calculateCost(b3));
  }
  public static double calculateCost(String[] Board){
    Hashtable<String,Double> memo = new Hashtable<String,Double>();
    int a,b,c=0,cX=0;
    ArrayList<Integer> Lista = new ArrayList<Integer>(); 
    for(a=0;a<Board.length;a++)
      for(b=0;b<Board[a].length();b++){
        if(Board[a].charAt(b)=='X'){
          Lista.add(c+1);
          cX++;
        }
        c++;
      }
    int[] B = new int[cX];
    for(a=0;a<cX;a++) B[a]=Lista.get(a);
    return costoOp(B,0,cX-1,memo);
  }
  public static double costoOp(int[] B,int a,int b,Hashtable<String,Double> memo){
    if(a==b) return 1;
    String mem_B = B.toString()+","+a+"-"+b;
    if(memo.containsKey(mem_B)) return memo.get(mem_B);
    Double out = Math.sqrt(B[b]-B[a]+1);
    for(int x=a;x<b;x++)
      out=Math.min(out,costoOp(B,a,x,memo)+costoOp(B,x+1,b,memo));
    memo.put(mem_B,out);
    return memo.get(mem_B);
  }
}

