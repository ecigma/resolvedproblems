import java.util.Hashtable;


public class NiceOrUgly {
       
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(describe("HELLOWORLD"));
         System.out.println(describe("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
         System.out.println(describe("HELLOW?RLD"));
         System.out.println(describe("H??LOWOR??"));
         System.out.println(describe("EE?FFFF"));
	}
	public static String describe(String s) {
		// TODO Auto-generated method stub
		Hashtable<String,String>hash= new Hashtable<String,String>();
		
		return d(hash,s);
	}
	private static String d(Hashtable<String, String> hash, String s){
	 String retorno="";
	if(hash.containsKey(s)){
		retorno=hash.get(s);
	}else{
	 if(!s.contains("?")){
		 retorno=UglyOrNice(s);
	 }else{
		retorno=d(hash, s.replaceFirst("\\?","A"))+d(hash, s.replaceFirst("\\?", "Z")); 
		if(retorno.contains("NICE") && !retorno.contains("UGLY")){
			retorno="NICE";
		}else if(!retorno.contains("NICE") && retorno.contains("UGLY")){
			retorno="UGLY";
		}else if(retorno.contains("NICE") && retorno.contains("UGLY")){
			retorno="42";
		}
	   }
	  hash.put(s , retorno);
	 }
	 return retorno;
	}
	
	
	
	private static String UglyOrNice(String s) {
		// TODO Auto-generated method stub
		Boolean b=false;
		for (int i = 0; i < s.length()-4 && !b; i++) {
			int v=0;
			int c=0;
			for (int j = 0; j < 5; j++) {
				 if((s.charAt(i+j)=='A' || s.charAt(i+j)=='E' || s.charAt(i+j)=='I' || s.charAt(i+j)=='O' || s.charAt(i+j)=='U')&& j<3){
					 v+=1;
					 c=0;
				 }else if(!(s.charAt(i+j)=='A' || s.charAt(i+j)=='E' || s.charAt(i+j)=='I' || s.charAt(i+j)=='O' || s.charAt(i+j)=='U') && v<3 ){
					 c+=1;
					 v=0;
				 }
				
			}
			if(c==5||v==3){
				b=true;
			}
		}
	  return (b)?"UGLY":"NICE";
	}

}
