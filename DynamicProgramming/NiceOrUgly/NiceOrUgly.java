public class NiceOrUgly {

  public static void main(String[] args){
    System.out.println(describe("HELLOWORLD"));
    System.out.println(describe("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    System.out.println(describe("HELLOW?RLD"));
    System.out.println(describe("H??LOWOR??"));
    System.out.println(describe("EE?FFFF"));

  }

  public static boolean isVowel(char a) {
    return a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
  }

  //*************************************//
  // Recursive solution WITH memoization //
  // in the for of a 3D matrix ...       //
  // guess why those dimensions          //
  //*************************************//
  public static String describe(String s) {
    String r = null;
    char[] sc = s.toCharArray();
    int[][][] memo = new int[sc.length+1][4][6];
    boolean nice = canItBeNice(sc, 0, 0, 0, memo);
    memo = new int[sc.length+1][4][6];
    boolean ugly = canItBeUgly(sc, 0, 0, 0, memo);
    if (nice && ugly) {
      r = "42";
    }
    else if (nice) {
      r = "NICE";
    }
    else {
      r = "UGLY";
    }
    return r;
  }

  public static boolean canItBeUgly(char[] s, int index, int v, int c, int[][][] memo) {
    boolean r = false;
    if (memo[index][v][c] != 0) {
      r = (memo[index][v][c] == 1)? true : false;
    }
    else {
      if (v == 3 || c == 5) {
        r = true;
      }
      else if (index == s.length) {
        r = false;
      }
      else {
        if (s[index] == '?') {
          r = canItBeUgly(s, index+1, v+1, 0, memo) || canItBeUgly(s, index+1, 0, c+1, memo);
        }
        else if (isVowel(s[index])) {
          r = canItBeUgly(s, index+1, v+1, 0, memo);
        }
        else {
          r = canItBeUgly(s, index+1, 0, c+1, memo);
        }
      }
      memo[index][v][c] = r? 1 : -1;
    }
    return r;
  }


  public static boolean canItBeNice(char[] s, int index, int v, int c, int[][][] memo) {
    boolean r = false;

    if (memo[index][v][c] != 0) {
      r = (memo[index][v][c] == 1)? true : false;
    }
    else {
      if (v == 3 || c == 5) {
        r = false;
      }
      else if (index == s.length) {
        r = true;
      }
      else {
        if (s[index] == '?') {
          r = canItBeNice(s, index+1, v+1, 0, memo) || canItBeNice(s, index+1, 0, c+1, memo);
        }
        else if (isVowel(s[index])) {
          r = canItBeNice(s, index+1, v+1, 0, memo);
        }
        else {
          r = canItBeNice(s, index+1, 0, c+1, memo);
        }
      }
      memo[index][v][c] = r? 1 : -1;
    }

    return r;
  }



  //*******************************************************//
  // Recursive solution without memoization nor tabulation //
  //*******************************************************//
  public static String describeRec(String s) {
    String r = null;
    char[] sc = s.toCharArray();
    boolean nice = canItBeNiceRec(sc, 0, 0, 0);
    boolean ugly = canItBeUglyRec(sc, 0, 0, 0);
    if (nice && ugly) {
      r = "42";
    }
    else if (nice) {
      r = "NICE";
    }
    else {
      r = "UGLY";
    }
    return r;
  }

  public static boolean canItBeUglyRec(char[] s, int index, int v, int c) {
    boolean r = false;
    if (v == 3 || c == 5) {
      r = true;
    }
    else if (index == s.length) {
      r = false;
    }
    else {
      if (s[index] == '?') {
        r = canItBeUglyRec(s, index+1, v+1, 0) || canItBeUglyRec(s, index+1, 0, c+1);
      }
      else if (isVowel(s[index])) {
        r = canItBeUglyRec(s, index+1, v+1, 0);
      }
      else {
        r = canItBeUglyRec(s, index+1, 0, c+1);
      }
    }
    return r;
  }

  public static boolean canItBeNiceRec(char[] s, int index, int v, int c) {
    boolean r = false;
    if (v == 3 || c == 5) {
      r = false;
    }
    else if (index == s.length) {
      r = true;
    }
    else {
      if (s[index] == '?') {
        r = canItBeNiceRec(s, index+1, v+1, 0) || canItBeNiceRec(s, index+1, 0, c+1);
      }
      else if (isVowel(s[index])) {
        r = canItBeNiceRec(s, index+1, v+1, 0);
      }
      else {
        r = canItBeNiceRec(s, index+1, 0, c+1);
      }
    }
    return r;
  }
}
