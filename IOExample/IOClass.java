import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;


public class IOClass {
	public static InputStreamReader in= new InputStreamReader(System.in);
	public static BufferedReader reader= new BufferedReader(in);
	public static String line;
	public static String[] buff;
	public static String regex=" ";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		
		// Metodo 1: Buffered Reader 
			//Caso 1.1 leer linea entera 
			
			//buffer11();
		    
			//sCaso 1.2 Lectura por Buffer
			
			//buffer12();
			
		    // Metodo 2: Scanner
	    //	scan();	
		
		
		solve(/*Lista de parametros segun el problema*/);
		
		}catch(Exception e){
			
		}
		
	}

	private static void buffer12() throws IOException {
		// TODO Auto-generated method stub
		char[] c= new char[255];
		reader.read(c);
	    System.out.println(Arrays.toString(c));

	}

	private static void buffer11() throws IOException {
			
		line=reader.readLine();
			// separar la entrada por espacios o algun caracter especial 
			
			buff=line.split(regex);
			System.out.println(Arrays.toString(buff));
	
	}

	private static void scan() {
		 //Caso General 
		Scanner scan= new Scanner(System.in);
		    
	    while(scan.hasNext()){
	    	System.out.println(scan.next());
	    }
	   
	}

	private static void solve() {

	// Solucion del problema Aqui !! 
	
	}

}
