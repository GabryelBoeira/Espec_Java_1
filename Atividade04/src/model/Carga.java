package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Classname: Veiculo
 *
 * Version information: 1
 *
 * Date: 25/07/2021
 *
 * Created by: Gabryel J. Boeira
 */

public class Carga extends Veiculo {

	private int tara;
	private int cargaMax;

	public Carga(int tara, int cargaMax, String placa, String marca, String modelo, int velocMax, String cor,
			int qtdeRodas, int qtdPist, int potencia) {

		super(placa, marca, modelo, velocMax, cor, qtdeRodas, qtdPist, potencia);
		this.tara = tara;
		this.cargaMax = cargaMax;
	}

	public Carga() {

		super();
		this.tara = 0;
		this.cargaMax = 0;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	@Override
	public double calcVelocMax(int velocMax) {

		// Velocidade convertida de KM/H para M/H
		BigDecimal bd = new BigDecimal(velocMax / 3.6).setScale(2, RoundingMode.HALF_EVEN);

		return bd.doubleValue();
	}

	@Override
	public String toString() {
		return " Carga : [ "+ super.toString() + ", tara= " + tara + ", cargaMax= " + cargaMax + " ]";
	}

}
