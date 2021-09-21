package leitura;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Leitura{

	public String inData(String rotulo){

		System.out.println(rotulo);

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);

		String s  = "";

		try{
			s = buff.readLine();	
		}
		catch(IOException ioe){
			System.out.println("\n Erro no sistema ou na JVM");
		}
		
		return s;
	}

}
