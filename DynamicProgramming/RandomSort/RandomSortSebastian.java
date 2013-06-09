import java.util.Arrays;
import java.util.Hashtable;


public class RandomSort {
  	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int [] a={1,3,2};
		
		System.out.println(getExpected(a));
	
		int [] b={4,3,2,1};
		
		System.out.println(getExpected(b));
		
		int [] c={2,5,1,6,3,4};
		System.out.println(getExpected(c));
		
		int [] d={1};
		System.out.println(getExpected(d));
		
	}
	public static double getExpected(int[] permutation){
		Hashtable<String,Double> a= new Hashtable<String,Double>();
		return getE(permutation,a);
	}
	private static double getE(int[] permutation, Hashtable<String, Double> a){
		// TODO Auto-generated method stub
		double r = 0d;
		double c=0d;
		String k= Arrays.toString(permutation);
	if(a.containsKey(k)){
		r=a.get(k);
	}else{
		for (int i = 0; i < permutation.length-1; i++) {
			for (int j = i+1; j < permutation.length; j++) {
				
				if(permutation[i]>permutation[j]){
					c+=1;
					int tempi,tempj;
					
					tempi=permutation[i];
					tempj=permutation[j];
					permutation[i]=tempj;
					permutation[j]=tempi;
					r+=getE(permutation, a);
					permutation[i]=tempi;
					permutation[j]=tempj;
					
				}
				
			}
			
		}
		
		if(c!=0){
			 r = r*(1/c)+1;
		}
	   a.put(k, r);	
	}
	
	return r;
  }
	
}
