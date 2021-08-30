package dal;

import java.util.ArrayList;
import java.util.List;

import model.Carga;
import model.Passeio;

public class BDVeiculos {

	private static List<Passeio> passeioList = new ArrayList<>();
	private static List<Carga> cargaList = new ArrayList<>();

	public int passeioListTotal() {
		return passeioList.size();
	}

	public int cargaListTotal() {
		return cargaList.size();
	}

	public void addPasseio(Passeio newPasseio) {

		passeioList.add(newPasseio);
	}

	public void addCarga(Carga newCarga) {

		cargaList.add(newCarga);
	}

	public List<Carga> listarTodosVeiculosCarga() {

		return cargaList;
	}

	public List<Passeio> listarTodosVeiculosPasseio() {

		return passeioList;
	}
}