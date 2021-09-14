package excecao;

public class VeicExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2686832017542503817L;
	
	public String mensagemErro() {

		return "Já existe um veículo com esta placa!";
	}
}
