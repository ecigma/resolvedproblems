import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;


public class IOClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		InputStreamReader in= new InputStreamReader(System.in);
		BufferedReader reader= new BufferedReader(in);
		Scanner scan= new Scanner(System.in);
		String line;
		String[] buff;
		String regex=" ";
		
		// Metodo 1: Buffered Reader 
			//Caso 1.1 leer linea entera 
			/*
		    line=reader.readLine();
				// separar la entrada por espacios o algun caracter especial 
			buff=line.split(regex);
			System.out.println(Arrays.toString(buff));
			*/
			//Caso 1.2 Lectura por Buffer
			/*
			char[] c= new char[255];
			reader.read(c);
		    System.out.println(Arrays.toString(c));
			*/
	// Metodo 2: Scanner
		    //Caso General 
	         
		    while(scan.hasNext()){
		    	System.out.println(scan.next());
		    }
		    
		
		solve(/*Lista de parametros segun el problema*/);
		
		}catch(Exception e){
			
		}
		
	}

	private static void solve() {

	// Solucion del problema Aqui !! 
	
	}

}
