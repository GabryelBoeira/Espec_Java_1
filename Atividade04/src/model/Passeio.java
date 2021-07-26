package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Classname: Veiculo
 *
 * Version information: 1
 *
 * Date: 20/07/2021
 *
 * Created by: Gabryel J. Boeira
 */

public class Passeio extends Veiculo {
	
	private int qtdePassageiro;
	
	public Passeio() {
		
		super();
		this.qtdePassageiro = 0;
	}
	
	public Passeio(String placa, String marca, String modelo, int velocMax, int qtdPist, String cor, int qtdeRodas, int potencia, int qtdePassageiro) {
		
		super(placa, marca, modelo, velocMax, cor, qtdeRodas, qtdPist, potencia);
		this.qtdePassageiro = qtdePassageiro;
	}

	public int getQtdePassageiro() {
		return qtdePassageiro;
	}

	public void setQtdePassageiro(int qtdePassageiro) {
		this.qtdePassageiro = qtdePassageiro;
	}

	@Override
	public double calcVelocMax(int velocMax) {

		//Velocidade convertida de KM/H para CM/H	
		
		BigDecimal bd = new BigDecimal((velocMax / 3.6) * 100).setScale(2, RoundingMode.HALF_EVEN);

		return bd.doubleValue() ;
	}

	@Override
	public String toString() {		
		return "Passeio : [ "+ super.toString() + ", qtdePassageiro= " + qtdePassageiro + " ]";
	}
}
