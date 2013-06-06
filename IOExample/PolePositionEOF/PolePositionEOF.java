import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PolePositionEOF {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (br.ready()) {
      String line = br.readLine().trim();
      int N = Integer.parseInt(line);
      int[][] carpos = new int[2][N];
      for(int i = 0; i < N ; i++){
        String[] pair = br.readLine().trim().split(" ");
        carpos[0][i] = Integer.parseInt(pair[0]);
        carpos[1][i] = Integer.parseInt(pair[1]);
      }
      solve(N,carpos);
    }
    br.close();
  }

  public static String solve(int n, int[][] carpos) {
    String r = null;
    System.out.println(n);
    System.out.println(Arrays.toString(carpos[0]));
    System.out.println(Arrays.toString(carpos[1]));
    return r;
  } 
}
