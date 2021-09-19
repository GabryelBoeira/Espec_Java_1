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

public class Motor {

	private Integer qtdPist;
	private Integer potencia;

	public Motor() {
		this.qtdPist = 0;
		this.potencia = 0;
	}

	public Motor(Integer qtdPist, Integer potencia) {
		this.qtdPist = qtdPist;
		this.potencia = potencia;
	}

	public Integer getQtdPist() {
		return qtdPist;
	}

	public final void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public final void setPotencia(int potencia) {
		this.potencia = potencia;
	}
}
