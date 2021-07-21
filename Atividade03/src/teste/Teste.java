package teste;

import java.util.ArrayList;
import java.util.List;

import model.Carga;
import model.Passeio;

/*
 * Classname: Veiculo
 *
 * Version information: 1
 *
 * Date: 20/07/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class Teste {

	public static void main(String[] args) {
		
		
		List<Carga> veiculoCargaList = new ArrayList<>();

		Carga veiculoCarga1 = new Carga(4000, 9000 ,"BRA0S10", "Mercedes-Bens", "L-312", 100 , 6, 112);
		veiculoCargaList.add(veiculoCarga1);
		
		Carga veiculoCarga2 = new Carga(7000, 30000 ,"BRA0S11", "Volkswagen", "Constellation 24.250", 150 , 12, 250);
		veiculoCargaList.add(veiculoCarga2);
		
		Carga veiculoCarga3 = new Carga(8500, 17200 ,"BRA0S12", "Ford", " Ford F-14000", 140 , 6, 170);
		veiculoCargaList.add(veiculoCarga3);
		
		Carga veiculoCarga4 = new Carga(8400, 15000 ,"BRA0S10", "Mercedes-Bens", "1113", 120 , 6, 130);
		veiculoCargaList.add(veiculoCarga4);
		
		Carga veiculoCarga5 = new Carga(9000, 47000 ,"BRA0S11", "Volkswagen", "Constellation 19.320", 150 , 12, 320);
		veiculoCargaList.add(veiculoCarga5);
		
		List<Passeio> veiculoPasseioList = new ArrayList<>();
		
		Passeio veiculoPasseio1 = new Passeio("BRA0S12", "Toyota", "Corola", 210 , 4, 154, 5);
		veiculoPasseioList.add(veiculoPasseio1);
		
		Passeio veiculoPasseio2 = new Passeio("BRA0S10", "Honda", "Civic", 202, 4, 155, 5);
		veiculoPasseioList.add(veiculoPasseio2);
		
		Passeio veiculoPasseio3 = new Passeio("BRA0S11", "Chevrolet", "Cruze", 197, 4, 150, 5);
		veiculoPasseioList.add(veiculoPasseio3);
		
		Passeio veiculoPasseio4 = new Passeio("BRA0S13", "Volkswagen", "Jetta GTI", 210, 4, 211, 5);
		veiculoPasseioList.add(veiculoPasseio4);
		
		Passeio veiculoPasseio5 = new Passeio("BRA0S14", "Caoa Chery", "Arrizo 6", 220, 4, 150, 5);
		veiculoPasseioList.add(veiculoPasseio5);
		
		for(Passeio passeio : veiculoPasseioList) {

			System.out.println("\n");
			System.out.println(passeio.toString());
			System.out.println("Velocidade maxima do veiculo em KM/h para CM/H : " + passeio.calcVelocMax(passeio.getVelocMax()));
		}
		
		for(Carga carga : veiculoCargaList) {

			System.out.println("\n");
			System.out.println(carga.toString());
			System.out.println("Velocidade maxima do veiculo em KM/h para CM/H : " + carga.calcVelocMax(carga.getVelocMax()));
		}

		
	}		

}
