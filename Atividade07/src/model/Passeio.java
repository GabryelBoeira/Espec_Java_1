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

public class Passeio extends Veiculo implements Calc {

	private int qtdePassageiro;

	public Passeio() {

		super();
		this.qtdePassageiro = 0;
	}

	public Passeio(String placa, String marca, String modelo, int velocMax, int qtdPist, String cor, int qtdeRodas,
			int potencia, int qtdePassageiro) {

		super(placa, marca, modelo, velocMax, cor, qtdeRodas, qtdPist, potencia);
		this.qtdePassageiro = qtdePassageiro;
	}

	public final int getQtdePassageiro() {
		return qtdePassageiro;
	}
	
	public final void setQtdePassageiro(int qtdePassageiro) {
		this.qtdePassageiro = qtdePassageiro;
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
		builder.append("\nQtde de Passageiros = " + getQtdePassageiro());
		
		return builder.toString();
	}

	
	@Override
	public final int calcVelocMax(int velocMax) {

		return velocMax * 10000;
	}

	@Override
	public final int calcular() {
		
		return getPlaca().length() + getMarca().length() + getModelo().length() + getCor().length();
	}

	
}
