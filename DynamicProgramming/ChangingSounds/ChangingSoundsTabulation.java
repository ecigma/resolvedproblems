
public class ChangingSoundsTabulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a= {5, 3, 7};
		System.out.println(ChangingSoundsTabulation.maxFinal(a, 5, 10));
		int[] b= {15, 2, 9, 10};
		System.out.println(ChangingSoundsTabulation.maxFinal(b, 8, 20));
		int[] c={74,39,127,95,74,39,127,95,63,140,99,96,154,18,137,162,14,88,74,39,127,95,63,140,99,96,154,18,137,162,14,88,74,39,127,95,63,140,99,96,154,18,137,162,14,88,63,140,99,96,154,18,137,162,14,88,74,39,127,95,63,140,99,96,154,18,137,162,14,88};
		System.out.println(ChangingSoundsTabulation.maxFinal(c, 40, 243));
		int[] d={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(ChangingSoundsTabulation.maxFinal(d, 20, 60));
	}
	
	public static int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel){
		int N = changeIntervals.length;
		int mem[][] = new int[N+1][maxLevel+1];
		
		int n = N, v = 0;
		while(n == N){
			if (v == maxLevel+1){
				n -= 1;
				v = 0;
			}
			else{
				mem[n][v] = v;
				v += 1;
			}
		}
		assert v == 0 && n == N-1;

		while(n >= 0){
			if (v == maxLevel+1){
				n -= 1;
				v = 0;
			}
			else{
				if (v + changeIntervals[n] <= maxLevel &&
						v - changeIntervals[n] >= 0){
					mem[n][v] = Math.max(mem[n+1][v+changeIntervals[n]],mem[n+1][v-changeIntervals[n]]);	
				}
				else if (v + changeIntervals[n] <= maxLevel &&
						v - changeIntervals[n] < 0){
					mem[n][v] = mem[n+1][v+changeIntervals[n]];				
				}
				else if (v + changeIntervals[n] > maxLevel &&
						v - changeIntervals[n] >= 0){
					mem[n][v] = mem[n+1][v-changeIntervals[n]];				
				}
				else {
					mem[n][v] = -1;
				}
				v += 1;
			}
		}
		
		return mem[0][beginLevel];
	}
	
	public static int maxFinalRec(int[] changeIntervals, int beginLevel, int maxLevel, int song){
		int r = -2;
		if (song == changeIntervals.length){
			r = beginLevel;
		}
		else{
			if (beginLevel + changeIntervals[song] <= maxLevel &&
					beginLevel - changeIntervals[song] >= 0){
				r = Math.max(maxFinalRec(changeIntervals, beginLevel+changeIntervals[song], maxLevel, song+1),
						maxFinalRec(changeIntervals, beginLevel-changeIntervals[song], maxLevel, song+1));				
			}
			else if (beginLevel + changeIntervals[song] <= maxLevel &&
					beginLevel - changeIntervals[song] < 0){
				r = maxFinalRec(changeIntervals, beginLevel+changeIntervals[song], maxLevel, song+1);
			}
			else if (beginLevel + changeIntervals[song] > maxLevel &&
					beginLevel - changeIntervals[song] >= 0){
				r = maxFinalRec(changeIntervals, beginLevel-changeIntervals[song], maxLevel, song+1);
			}
			else {
				r = -1;
			}
		}
		
		return r;
	}
	

}
