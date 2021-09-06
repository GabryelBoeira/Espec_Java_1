package com.br.gabryel.java1;

import com.br.gabryel.java1.exception.NumException;
import com.br.gabryel.java1.model.PessoaJuridica;

public class TstConta {

	public static void main(String[] args) {

		// Entradas de dados:

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		// PessoaJuridica:
		try {

			pessoaJuridica.setNumeroConta(44);
		} catch (NumException ne) {

			ne.impMsg();
		}

		pessoaJuridica.setCnpj(12345);
		pessoaJuridica.getEnder().setRua("Rua teste Java I");

		// PessoaFisica:
		pessoaJuridica.getResponsavel().setCpf(30);
		pessoaJuridica.getResponsavel().setNome("Jose teste gerente");

		// Saídas de dados:

		System.out.println("\nNúmero da Conta: " + pessoaJuridica.getNumeroConta());
		pessoaJuridica.validar();
		System.out.println("\nCnpj: " + pessoaJuridica.getCnpj());
		System.out.println("\nRua: " + pessoaJuridica.getEnder().getRua());

		System.out.println("\nCPF do Responsável pela Conta: " + pessoaJuridica.getResponsavel().getCpf());
		pessoaJuridica.getResponsavel().verifDoc();
		System.out.println("\nNome do Responsável pela Conta: " + pessoaJuridica.getResponsavel().getNome());
		pessoaJuridica.verifDoc();

	}
}
