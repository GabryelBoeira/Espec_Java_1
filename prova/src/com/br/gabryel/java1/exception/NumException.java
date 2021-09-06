package com.br.gabryel.java1.exception;


/*
 * Classname: NumException
 *
 * Version information: 1
 *
 * Date: 05/09/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class NumException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void impMsg() {
		
		System.out.println("ERRO: Não pode haver Número Negativo para conta!");
	}

}
