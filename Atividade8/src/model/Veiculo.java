package model;

import excecao.VelocException;

/*
 * Classname: Veiculo
 * 
 * Version information: 1
 *
 * Date: 25/07/2021
 * 
 * Created by: Gabryel J. Boeira
 */

abstract class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private int velocMax;
	private String cor;
	private int qtdeRodas;
	private Motor motor;

	public Veiculo() {
		this.placa = " ";
		this.marca = " ";
		this.modelo = " ";
		this.velocMax = 0;
		this.cor = " ";
		this.qtdeRodas = 0;
		this.motor = new Motor();
	}

	public Veiculo(String placa, String marca, String modelo, int velocMax, String Cor, int qtdeRodas, int qtdPist,
			int potencia) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.velocMax = velocMax;
		this.motor = new Motor(qtdPist, potencia);
	}

	public final String getPlaca() {
		return placa;
	}

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdeRodas() {
		return qtdeRodas;
	}

	public final void setQtdeRodas(int qtdeRodas) {
		this.qtdeRodas = qtdeRodas;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(int velocMax) throws VelocException {

		if (80 <= velocMax && velocMax <= 110) {

			this.velocMax = velocMax;
		} else {
			throw new VelocException();
		}
	}

	public Motor getMotor() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}

	abstract int calcVelocMax(int velocMax);

}
