import java.util.ArrayList;
import java.util.Hashtable;


public class ChangingSoundsMemoization {

	public static void main(String[] args) {
		int[] a= {5, 3, 7};
		System.out.println(ChangingSoundsMemoization.maxFinal(a, 5, 10));
		int[] b= {15, 2, 9, 10};
		System.out.println(ChangingSoundsMemoization.maxFinal(b, 8, 20));
		int[] c={74,39,127,95,63,140,99,96,154,18,137,162,14,88};
		System.out.println(ChangingSoundsMemoization.maxFinal(c, 40, 243));
		int[] d={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(ChangingSoundsTabulacion.maxFinal(d, 20, 60));
	
		
	}
	
	public static int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel){
		
		int retorno;
		ArrayList<Integer> p=new ArrayList<Integer>();
		Hashtable<String,Integer> hash= new Hashtable<String,Integer>();
		
		for (int i = 0; i < changeIntervals.length; i++) {
			p.add(changeIntervals[i]);
		    
		}
		
		retorno=maxF(hash,p,beginLevel,maxLevel,0);
		
		
		
		return retorno;
		
	}

	private static int maxF(Hashtable<String, Integer> hash, ArrayList<Integer> p, int beginLevel, int maxLevel,int i) {
		// TODO Auto-generated method stub
		  int retorno=-1;
		if(hash.containsKey(""+beginLevel+","+i)){
			retorno=hash.get(""+beginLevel+","+i);
		}else{
			retorno=-1;
			i=i+1;
			if(i<=p.size()){
			 int a;
			 int b;
			 if(beginLevel+(p.get(i-1))>maxLevel){
				 a=-1;
			 }else{
				 a=maxF(hash,p, beginLevel+(p.get(i-1)), maxLevel, i);
			 }
			 if(beginLevel-(p.get(i-1))<0){
				 b=-1;
			 }else{
				 b=maxF(hash,p, beginLevel-(p.get(i-1)), maxLevel, i);
			 }
			 retorno=Math.max(a,b);

			}else{
				if(beginLevel>maxLevel || beginLevel<0){
					beginLevel=-1;
				}
				retorno=beginLevel;
	    	}
			hash.put(""+beginLevel+","+i, retorno);
		}
			return retorno;
	   }
	}
