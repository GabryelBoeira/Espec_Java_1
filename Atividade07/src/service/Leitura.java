package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Leitura {

	public String entDados(String rotulo) {
		
		System.out.println(rotulo);
		
		InputStreamReader tecla = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(tecla);
		
		String retorno = "";
		
		try {
			retorno = buffer.readLine();
		} catch (Exception e) {
			System.out.println("\n Erro no sistema");
		}
		
		return retorno;
	}
}
