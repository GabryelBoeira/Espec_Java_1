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

	private Integer tara;
	private Integer cargaMax;

	public Carga(Integer tara, Integer cargaMax, String placa, String marca, String modelo, Integer velocMax, String cor,
			Integer qtdeRodas, Integer qtdPist, Integer potencia) {

		super(placa, marca, modelo, velocMax, cor, qtdeRodas, qtdPist, potencia);
		this.tara = tara;
		this.cargaMax = cargaMax;
	}

	public Carga() {

		super();
		this.tara = 0;
		this.cargaMax = 0;
	}

	public final Integer getCargaMax() {
		return cargaMax;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public final Integer getTara() {
		return tara;
	}

	public final void setTara(Integer tara) {
		this.tara = tara;
	}

	@Override
	public final Integer calcular() {
		
		return this.tara + this.cargaMax + getVelocMax() + getQtdeRodas() + getMotor().getPotencia() + getMotor().getQtdPist();
	}

	@Override
	public final Integer calcVelocMax(Integer velocMax) {
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
