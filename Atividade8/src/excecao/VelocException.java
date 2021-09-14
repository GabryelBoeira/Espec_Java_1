package excecao;

public class VelocException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 583187036256617304L;
	
	public String mensagemErro() {

		return "A velocidade máxima está fora dos limites brasileiros";
	}
}
