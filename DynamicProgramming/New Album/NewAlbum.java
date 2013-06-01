
public class NewAlbum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		System.out.println(leastAmountOfCDs(7, 2, 6));
        System.out.println(leastAmountOfCDs(20, 1, 100));
        System.out.println(leastAmountOfCDs(26, 3, 51));

        System.out.println(leastAmountOfCDs(67,271,1000));
        System.out.println(leastAmountOfCDs(27, 1, 27));
       
        System.out.println(leastAmountOfCDs(27, 27, 27));
	
	}
	
	public static 	int leastAmountOfCDs(int nSongs, int length, int cdCapacity){
		
		int n=-1;
		length+=1;
		int l= cdCapacity/length;
		if(l%13==0 && cdCapacity/(length-1)>1){
			l-=1;
			
		}
		
		if(l!=0){
		n= (nSongs/l) + ((nSongs%l==0)?0:1);
		if(nSongs/l==0 && nSongs%13==0)n+=1;
		
		}else{
			if(cdCapacity/(length-1)==1){
				n=nSongs;
			}else{
				n=0;
				}
		}
		
		
		
		return n;
	}
	

}
