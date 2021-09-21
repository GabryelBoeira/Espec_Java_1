package model;
public class Pessoa{ 

	private int cod;  
	private String nome;

	public Pessoa(){
		cod = 0;
		nome = "";
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setNome(String nome){ 
		this.nome = nome;
	}


	public int getCod(){
		return cod;
	}

	public String getNome(){
		return nome;
	}
}
