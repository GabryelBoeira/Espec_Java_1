package com.br.gabryel.java1.model;

/*
 * Classname: PessoaFisica
 *
 * Version information: 1
 *
 * Date: 05/09/2021
 *
 * Created by: Gabryel J. Boeira
 */
public final class PessoaFisica extends ClienteBanco {

	private int cpf = 0;

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Override
	public void verifDoc() {

		if (10 <= this.cpf && this.cpf <= 20) {
			
			System.out.println("CPF válido");
		} else {
			
			System.out.println("CPF inválido");
		}
	}
}
