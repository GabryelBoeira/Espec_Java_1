package excecao;

public class VeicExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2686832017542503817L;
	
	public String mensagemErro() {

		return "J� existe um ve�culo com esta placa!";
	}
}
