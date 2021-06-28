package teste;

import java.util.ArrayList;
import java.util.List;

import model.Veiculo;

/*
 * Classname: Teste
 * 
 * Version information: 1
 *
 * Date: 27/06/2021
 * 
 * Created by: Gabryel J. Boeira
 */
public class Teste {

	public static void main(String[] args) {
		

		List<Veiculo> veiculoList = new ArrayList<>();
				
		Veiculo veiculo1 = new Veiculo("BRA0S10", "Honda", "Civic", 202, 4, 155);
		veiculoList.add(veiculo1);
		
		Veiculo veiculo2 = new Veiculo("BRA0S11", "Chevrolet", "Cruze", 197, 4, 150);
		veiculoList.add(veiculo2);
		
		Veiculo veiculo3 = new Veiculo("BRA0S12", "Toyota", "Corola", 210 , 4, 154);
		veiculoList.add(veiculo3);
		
		Veiculo veiculo4 = new Veiculo("BRA0S13", "Volkswagen", "Jetta GTI", 210, 4, 211);
		veiculoList.add(veiculo4);
		
		Veiculo veiculo5 = new Veiculo("BRA0S14", "Caoa Chery", "Arrizo 6", 220, 4, 150);
		veiculoList.add(veiculo5);
		
		for(Veiculo veiculo : veiculoList) {
			
			int index = veiculoList.indexOf(veiculo) + 1;
			
			System.out.println("\n");
			System.out.println("Veiculo "+ index +" : " + veiculo.toString());
		}		
	}
}
