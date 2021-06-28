package model;

/*
 * Classname: Motor
 * 
 * Version information: 1
 *
 * Date: 27/06/2021
 * 
 * Created by: Gabryel J. Boeira
 */
public class Motor {

	private int qtdPist;
	
	private int potencia;

	Motor() {
		this.qtdPist = 0;
		this.potencia = 0;
	}
	
	Motor(int qtdPist, int potencia) {
		this.qtdPist = qtdPist;
		this.potencia = potencia;
	}

	public int getQtdPist() {
		return qtdPist;
	}

	public void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Motor : [qtdPist = " + qtdPist + ", potencia = " + potencia + "]";
	}

}
