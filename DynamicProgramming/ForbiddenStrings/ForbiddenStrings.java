import java.util.Hashtable;


public class ForbiddenStrings {
     
	
	 static int tam;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countNotForbidden(2));
		System.out.println(countNotForbidden(3));
		System.out.println(countNotForbidden(4));

		System.out.println(countNotForbidden(15));
	}
	
	public static long countNotForbidden(int n){
		long retorno=-1;
		tam=n;
		Hashtable<String, Long > hash=new Hashtable<String, Long >();
		retorno=countNotF(hash,"","");
		
		
		return retorno;
	}

	private static long countNotF(Hashtable<String, Long> hash, String posibilidad, String regex) {
		// TODO Auto-generated method stub
		long retorno=-1;
	   String key=posibilidad+"--"+regex;
	  if(hash.containsKey(key)){
		retorno=hash.get(key); 
	  }else{	
		if(posibilidad.length()==tam && nt(regex)){
		 	retorno=1;
		}else{
		   if(nt(regex)){
		       if(regex.length()==3)regex=""+regex.charAt(1)+regex.charAt(2);
			   retorno=countNotF(hash, posibilidad+"A", regex+"A")+countNotF(hash, posibilidad+"B", regex+"B")+countNotF(hash, posibilidad+"C", regex+"C");
		   }else{
			   retorno=0;
		   }
		 }
		hash.put(key, retorno);
	 }
		
		return retorno;
	}

	private static boolean nt(String regex) {
		// TODO Auto-generated method stub
		boolean nt=true;
		if(regex.length()==3){
			nt=!(regex.contains("A")&& regex.contains("B")&&regex.contains("C"));
		
		}
		
		return nt;
	}

}
