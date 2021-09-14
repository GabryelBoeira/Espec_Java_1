package dal;

import java.util.ArrayList;
import java.util.List;

import model.Carga;
import model.Passeio;

public class BDVeiculos {

	private static final List<Passeio> passeioList = new ArrayList<>();
	private static final List<Carga> cargaList = new ArrayList<>();


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
	
	public void removerVeiculoCarga(Carga carga) {

		cargaList.remove(carga);
	}
	
	public void removerVeiculoPasseio(Passeio passeio) {

		passeioList.remove(passeio);
	}
}