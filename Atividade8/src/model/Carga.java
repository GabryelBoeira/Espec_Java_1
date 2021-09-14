package model;

/*
 * Classname: Veiculo
 *
 * Version information: 1
 *
 * Date: 25/07/2021
 *
 * Created by: Gabryel J. Boeira
 */

public final class Carga extends Veiculo implements Calc {

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

	public final int getCargaMax() {
		return cargaMax;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public final int getTara() {
		return tara;
	}

	public final void setTara(int tara) {
		this.tara = tara;
	}

	@Override
	public final int calcular() {
		
		return this.tara + this.cargaMax + getVelocMax() + getQtdeRodas() + getMotor().getPotencia() + getMotor().getQtdPist();
	}

	@Override
	public final int calcVelocMax(int velocMax) {
		return velocMax * 1000;
	}

	@Override
	public final String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("\nPlaca = " + getPlaca());
		builder.append("\nMarca = " + getMarca());
		builder.append("\nModelo = " + getModelo());
		builder.append("\nVelocidade Maxima = "+ getVelocMax());
		builder.append("\nCor = " + getCor());
		builder.append("\nQtde de Rodas = " + getQtdeRodas());
		builder.append("\nQtde de Pistao = " + getMotor().getQtdPist());
		builder.append("\nPotencia = " + getMotor().getPotencia());
		builder.append("\nCarga Maxima = " + getCargaMax());
		builder.append("\nTara = " + getTara());
		
		return builder.toString();
	}

}
