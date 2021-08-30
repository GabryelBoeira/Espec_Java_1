package excecao;

public class VeicExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2686832017542503817L;

	public VeicExistException(String tipo) {
		
		System.out.println("\n\nJá existe um veículo " + tipo + " com esta placa \n\n");
	}
}
