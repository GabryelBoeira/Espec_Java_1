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
	
	public Passeio(String placa, String marca, String modelo, int velocMax, int qtdPist, int potencia, int qtdePassageiro) {
		
		super(placa, marca, modelo, velocMax, qtdPist, potencia);
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

		//Velocidade convertida de km/h para cm/h	
		
		
		
		
		BigDecimal bd = new BigDecimal((velocMax / 3.6) * 100).setScale(2, RoundingMode.HALF_EVEN);

		return bd.doubleValue() ;
	}

	@Override
	public String toString() {
		return "Passeio [qtdePassageiro= " + qtdePassageiro + ", Placa= " + getPlaca() + ", Marca= " + getMarca()
				+ ", Modelo= " + getModelo() + ", VelocMax = " + getVelocMax() + ", Motor= " + getMotor() + "]";
	}
	
}
