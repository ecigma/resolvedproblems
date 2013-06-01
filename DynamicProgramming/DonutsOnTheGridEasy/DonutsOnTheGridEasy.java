import java.util.Hashtable;


public class DonutsOnTheGridEasy {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]aa={"0000000"
					,"0.....0"
					,"0.00000"
					,"0.0..00"
					,"0.00000"
					,"0.....0"
					,"0000000"};
	
		System.out.println(calc(aa));
		
		String[]bb={"000"
					,"0.0"
					,"000"};
	
		System.out.println(calc(bb));
		
		
		
		String[]a={"..."
					,"..."
					,"..."};
		
		System.out.println(calc(a));
		
		String[]b={"00.000"
				,"00.000"
				,"0.00.0"
				,"000.00"};
        
        System.out.println(calc(b));
		
          String[]c={"0000000....",
        		  "0000000....",
        		  "0000000.000",
        		  "0000000.0.0",
        		  "0000000.000",
        		  "0000000....",
        		  "0000000...."};
          
          System.out.println(calc(c));
	}
	public static int calc(String[] grid){
		
		int acumulador=0;
		int posi=0;
		int posj=0;
		int largo=grid.length;
		int ancho=grid[0].length();
		int posiA=-1;
		int posjA=-1;
		int largoA=+1;
		int anchoA=+1;
		Hashtable<String,Integer> hash=new  Hashtable<String,Integer>(); 
		
		return cal(hash,grid,acumulador,posi,posj,largo,ancho,false,posiA,posjA,largoA,anchoA);
	}
	private static int cal(Hashtable<String, Integer> hash, String[] grid, int acumulador, int posi, int posj,
			int largo, int ancho, boolean donutA, int posiA, int posjA, int largoA, int anchoA) {
		// TODO Auto-generated method stub
		int retorno=-1;

		String key=acumulador+","+posi+","+posj+","+largo+","+ancho+","+donutA+","+posiA+","+posjA+","+largoA+","+anchoA;
		if(hash.containsKey(key)){
			retorno=hash.get(key);
		}
		else{
		if(largo<3 || ancho <3 ||posi==grid.length || posj==grid[0].length()){
			
			
			retorno= acumulador;
				
		}else{
		
			boolean donut=true;
			boolean anch=false;
			int a=-1,b=-1,c=-1,d=-1,e=-1;
			if(!donutA){
			anch=posj+ancho-1<grid[0].length() && posi+largo-1<grid.length;
			}else{
            anch=posj+ancho-1<=posjA+anchoA-1 && posi+largo-1<=posiA+largoA-1 && posj>posjA & posi>posiA;				
			  
			}
			if(anch){
				
				// si es donut 
					// muro superior y muro inferior
				for (int i =posj ; i < posj+ancho && donut; i++) {
					   if( grid[posi].charAt(i)!='0' || grid[posi+largo-1].charAt(i)!='0'){
						   donut=false;
					   }
				}
				
				for (int i =posi ; i < posi+largo && donut; i++) {
					   if(grid[i].charAt(posj)!='0' || grid[i].charAt(posj+ancho-1)!='0'){
						   donut=false;
					   }
				}
				
			}else{
				donut=false;
			   
					
			}
			
			   
			if(donut){
				a=cal(hash, grid, acumulador+1, posi+1, posj+1, largo-2, ancho-2, true, posi, posj, largo, ancho);
				
			
			  }
			  b=cal(hash, grid, acumulador, posi+1, posj, largo, ancho, donutA, posiA, posjA, largoA, anchoA);
			  c=cal(hash, grid, acumulador, posi, posj+1, largo, ancho, donutA, posiA, posjA, largoA, anchoA);
			  d=cal(hash, grid, acumulador, posi, posj, largo-1, ancho, donutA, posiA, posjA, largoA, anchoA);
			  e=cal(hash, grid, acumulador, posi, posj, largo, ancho-1, donutA, posiA, posjA, largoA, anchoA);
			  
			  retorno=Math.max(Math.max(Math.max(c, d),Math.max(a, b)),e);
		}
		
		      hash.put(key,retorno);   
		}
		return retorno;
	}

}
