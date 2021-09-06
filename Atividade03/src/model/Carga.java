package model;


/*
 * Classname: Veiculo
 *
 * Version information: 1
 *
 * Date: 20/07/2021
 *
 * Created by: Gabryel J. Boeira
 */

public class Carga extends Veiculo {
	
	private int tara;
	private int cargaMax;
	
	public Carga(int tara, int cargaMax, String placa, String marca, String modelo, int velocMax, int qtdPist, int potencia) {
		
		super(placa, marca, modelo, velocMax, qtdPist, potencia);
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

		return velocMax * 0.6214;
	}

	@Override
	public String toString() {
		return "Carga [tara=" + tara + ", cargaMax=" + cargaMax + ", Placa= " + getPlaca() + ", Marca= "
				+ getMarca() + ", Modelo= " + getModelo() + ", VelocMax= " + getVelocMax() + ", Motor= "
				+ getMotor() + "]";
	}
	
}
