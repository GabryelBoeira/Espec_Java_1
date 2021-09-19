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

public final class Passeio extends Veiculo implements Calc {

	private Integer qtdePassageiro;

	public Passeio() {

		super();
		this.qtdePassageiro = 0;
	}

	public Passeio(String placa, String marca, String modelo, Integer velocMax, Integer qtdPist, String cor, Integer qtdeRodas,
			Integer potencia, Integer qtdePassageiro) {

		super(placa, marca, modelo, velocMax, cor, qtdeRodas, qtdPist, potencia);
		this.qtdePassageiro = qtdePassageiro;
	}
	
	public Integer getQtdePassageiro() {
		return qtdePassageiro;
	}
	
	public void setQtdePassageiro(int qtdePassageiro) {
		this.qtdePassageiro = qtdePassageiro;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("\nPlaca = " + getPlaca());
		builder.append("\nMarca = " + getMarca());
		builder.append("\nModelo = " + getModelo());
		builder.append("\nVelocidade Maxima = "+ getVelocMax());
		builder.append("\nCor = " + getCor());
		builder.append("\nQtde de Rodas = " + getQtdeRodas());
		builder.append("\nQtde de Pistao = " + getMotor().getQtdPist());
		builder.append("\nPotencia = " + getMotor().getPotencia());
		builder.append("\nQtde de Passageiros = " + getQtdePassageiro());
		
		return builder.toString();
	}

	
	@Override
	public Integer calcVelocMax(Integer velocMax) {

		return velocMax * 10000;
	}

	@Override
	public Integer calcular() {
		
		return getPlaca().length() + getMarca().length() + getModelo().length() + getCor().length();
	}

	
}
