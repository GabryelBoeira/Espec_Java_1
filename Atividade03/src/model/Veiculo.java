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

public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;	
	private int velocMax;	
	private Motor motor;
	
	public Veiculo() {
		this.placa = " ";
		this.marca = " ";
		this.modelo = " ";
		this.velocMax = 0;
		this.motor = new Motor();
	}
	
	public Veiculo(String placa, String marca, String modelo, int velocMax, int qtdPist, int potencia) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.velocMax = velocMax;
		this.motor = new Motor(qtdPist, potencia);
	}

	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getVelocMax() {
		return velocMax;
	}
	
	public void setVelocMax(int velocMax) {
		this.velocMax = velocMax;
	}
	
	public Motor getMotor() {
		return motor;
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	abstract double calcVelocMax(int velocMax);
	
	@Override
	public String toString() {
		return "[placa = " + placa + ", marca = " + marca + ", modelo = " + modelo + ", velocMax = " + velocMax + "] \n" +
				motor.toString();
	}
}
