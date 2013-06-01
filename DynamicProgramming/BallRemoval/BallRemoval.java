import java.util.ArrayList;
import java.util.Hashtable;


public class BallRemoval {
	public static ArrayList<Character> b=new ArrayList<Character>();
  
	public static void main(String[] args) {
		
		String a;
		
		a="<<>";
		System.out.println(canLeave(a));
		a=">>><<";
		System.out.println(canLeave(a));
		a="<><<><>";
		System.out.println(canLeave(a));
		a=">>><<<>>>>><<<>";
		System.out.println(canLeave(a));
		
	}
	
	public static String canLeave(String label){

	   String retorno;
	   b.clear();
	   ArrayList<Character> a=new ArrayList<Character>();
	   ArrayList<Integer> c=new ArrayList<Integer>();
	   Hashtable<String, ArrayList<Character> > hash= new Hashtable<String, ArrayList<Character> >(); 
		   
	   for (int i = 0; i < label.length(); i++) {
		  a.add(label.charAt(i));
		  c.add(i);
		  b.add('.');
	   }
	   
	   canL(hash,a,c);
	   retorno=b.toString();
	   
	   retorno=retorno.replace("[","");
	   retorno=retorno.replace("]","");
	   retorno=retorno.replace(",","");
	   retorno=retorno.replace(" ","");
	   return retorno;
	   
   }


private static int canL( Hashtable<String, ArrayList<Character> > hash,ArrayList<Character> sub, ArrayList<Integer> left) {
	// TODO Auto-generated method stub
	int retorno=-1;	
	if(hash.containsKey(sub.toString()+left.toString())){
		b=hash.get(sub.toString()+left.toString());
	}else
	{	
		if(sub.size()==1){
		   b.set(left.get(0),'o');
		   
		}else{
		    char temp;
		    int tempi;
		    char temp2;
		    int tempi2;
		    int size=sub.size()-1;
		    for(int i=1; i<size;i++){
		    	temp=sub.get(i);
		    	tempi=left.get(i);
		    	if(temp=='>'){
		    	   temp2=sub.get(i+1);
		    	   tempi2=left.get(i+1);
		    	   sub.remove(i);
		    	   sub.remove(i);
		    	   left.remove(i);
		    	   left.remove(i);
		    	   canL(hash,sub,left);
		    	   sub.add(i,temp);
		    	   sub.add(i+1,temp2);
		    	   left.add(i,tempi);
		    	   left.add(i+1,tempi2);
		    	 	
		    	}else{
		    		
		    		temp2=sub.get(i-1);
			    	   tempi2=left.get(i-1);
			    	   sub.remove(i);
			    	   sub.remove(i-1);
			    	   left.remove(i);
			    	   left.remove(i-1);
			    	   canL(hash,sub,left);
				       sub.add(i-1,temp2);
			    	   sub.add(i,temp);
			    	   left.add(i-1,tempi2);
			    	   left.add(i,tempi);
				    	
		    	}
		    }
		    
		    hash.put(sub.toString()+left.toString(), b);
		
		}
	}
	return retorno;	
}



}
