package dal;

import java.util.ArrayList;
import java.util.List;

import model.Carga;
import model.Passeio;

public class BDVeiculos {

	private static final List<Passeio> passeioList = new ArrayList<>();
	private static final List<Carga> cargaList = new ArrayList<>();

	public BDVeiculos() {

		cargaList.add(new Carga(4000, 9000, "BRA0S10", "Mercedes-Bens", "L-312", 100, "black piano", 6, 112, 0));
		cargaList.add(new Carga(7000, 30000, "BRA0S11", "Volkswagen", "Constellation 24.250", 150, "black piano", 12,
				250, 0));
		cargaList.add(new Carga(8500, 17200, "BRA0S12", "Ford", " Ford F-14000", 140, "black piano", 6, 170, 0));
		cargaList.add(new Carga(8400, 15000, "BRA0S10", "Mercedes-Bens", "1113", 120, "black piano", 6, 130, 0));
		cargaList.add(new Carga(9000, 47000, "BRA0S11", "Volkswagen", "Constellation 19.320", 150, "black piano", 12,
				320, 0));

		passeioList.add(new Passeio("BRA0S12", "Toyota", "Corola", 210, 4, "black piano", 4, 154, 5));
		passeioList.add(new Passeio("BRA0S10", "Honda", "Civic", 202, 4, "black piano", 4, 155, 5));
		passeioList.add(new Passeio("BRA0S11", "Chevrolet", "Cruze", 197, 4, "black piano", 4, 150, 5));
		passeioList.add(new Passeio("BRA0S13", "Volkswagen", "Jetta GTI", 210, 4, "black piano", 4, 211, 5));
		passeioList.add(new Passeio("BRA0S14", "Caoa Chery", "Arrizo 6", 220, 4, "black piano", 4, 150, 5));
	}

	public Boolean addPasseio(Passeio newPasseio) {

		return passeioList.add(newPasseio);
	}

	public Boolean addCarga(Carga newCarga) {

		return cargaList.add(newCarga);
	}

	public List<Carga> listarTodosVeiculosCarga() {

		return cargaList;
	}

	public List<Passeio> listarTodosVeiculosPasseio() {

		return passeioList;
	}

	public Boolean removerVeiculoCarga(Carga carga) {

		return cargaList.remove(carga);
	}

	public Boolean removerVeiculoPasseio(Passeio passeio) {

		return passeioList.remove(passeio);
	}

	public Boolean removerTodosVeiculosCarga(List<Carga> cargaRemoveList) {

		return cargaList.removeAll(cargaRemoveList);
	}

	public Boolean removerTodosVeiculosPasseio(List<Passeio> passeioRemoveList) {

		return passeioList.removeAll(passeioRemoveList);
	}
}