package teste;

import dal.BDVeiculos;
import excecao.VeicExistException;
import excecao.VelocException;
import model.Carga;
import model.Passeio;
import service.Leitura;

/*
 * Classname: Teste
 *
 * Version information: 1
 *
 * Date: 29/08/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class Teste {

	private static BDVeiculos bdVeiculos = new BDVeiculos();
	private static Leitura leitura = new Leitura();

	public static void main(String[] args) {

		int opcao = 0;

		do {
			try {

				System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
				System.out.println("\n");
				System.out.println("1 - Cadastrar Veículo de Passeio");
				System.out.println("2 - Cadastrar Veículo de Carga");
				System.out.println("3 - Imprimir Todos os Veículos de Passeio");
				System.out.println("4 - Imprimir Todos os Veículos de Carga");
				System.out.println("5 - Imprimir Veículo de Passeio pela Placa");
				System.out.println("6 - Imprimir Veículo de Carga pela Placa");
				System.out.println("7 - Excluir Veículo de Passeio pela Placa");
				System.out.println("8 - Excluir Veículo de Carga pela Placa");

				System.out.println("9 - Sair do Sistema");

				opcao = Integer.parseInt(leitura.entDados("\nSelecione uma opção: "));

				switch (opcao) {
					case 1:
						
						String sairOpcao1 = "";
						do {
							System.out.println("===== Cadastrado Veículo de Passeio ======");
		
							try {
		
								cadastrarVeiculoPasseio();
							} catch (VeicExistException e) {
		
								break;
							}
							
							while (!sairOpcao1.equalsIgnoreCase("n") && !sairOpcao1.equalsIgnoreCase("s")) {
								sairOpcao1 = leitura.entDados("\nDeseja realizar um novo cadastro? (S)im/(N)ão>");
							}
							
						} while (sairOpcao1.equalsIgnoreCase("s") );
						
						break;
					case 2:

						String sairOpcao2 = "";
						do {
							
							System.out.println("===== Cadastrado Veículo de Carga ======");
							try {
	
								cadastrarVeiculoCarga();
							} catch (VeicExistException e) {
								break;
							}
	

							while (!sairOpcao2.equalsIgnoreCase("n") && !sairOpcao2.equalsIgnoreCase("s")) {
								sairOpcao2 = leitura.entDados("\nDeseja realizar um novo cadastro? (S)im/(N)ão>");
							}
							
						} while (sairOpcao2.equalsIgnoreCase("s"));
							
						break;
					case 3:
						
						System.out.println("\n");
						System.out.println("Lista com todos os  Veículos de Passeio : ");
						listarTodosVeiculosPasseio();
						System.out.println("\n");
						break;
					case 4:
						
						System.out.println("\n");
						System.out.println("Lista com todos os  Veículos de Carga");
						listarTodosVeiculosCarga();
						System.out.println("\n");
						break;
					case 5:
						
						System.out.println("\n===== Procurar veiculo de passeio pela placa =====");
						procurarVeiculosPasseioPorPlaca(leitura.entDados("\nDigite a placa para Realizar a busca: "));
						System.out.println("\n");
						break;
					case 6:
						
						System.out.println("\n===== Procurar veiculo de Carga pela placa =====");
						procurarVeiculosCargaPorPlaca(leitura.entDados("\nDigite a placa para Realizar a busca: "));
						System.out.println("\n");
						break;
					case 7:
						
						System.out.println("\n===== Procurar veiculo de passeio pela placa =====");
						excluirVeiculoPasseioPorPlaca(leitura.entDados("\nDigite a placa para realizar a remoção do sistema: "));
						System.out.println("\n");
						break;
					case 8:
						
						System.out.println("\n===== Procurar veiculo de Carga pela placa =====");
						excluirVeiculoCargaPorPlaca(leitura.entDados("\nDigite a placa para realizar a remoção do sistema: "));
						System.out.println("\n");
						break;
					case 9:
						
						System.out.println("Fim");
						break;
					default:
						
						System.out.println("Opção não encontrada");
						break;
				}

			} catch (Exception e) {
				System.out.println("Opção inválida, tente novamente - Press Enter");
				leitura.entDados("");
				System.out.println("\n");
			}

		} while (opcao != 9);

	}

	public static void cadastrarVeiculoPasseio() throws VeicExistException, VelocException {

		Passeio newPasseio = new Passeio();

		newPasseio.setModelo(leitura.entDados("\nModelo do Veiculo: "));
		newPasseio.setMarca(leitura.entDados("\nMarca do Veiculo: "));
		newPasseio.setCor(leitura.entDados("\nCor do Veiculo: "));
		newPasseio.setPlaca(leitura.entDados("\nPlaca do Veiculo: "));

		if (bdVeiculos.listarTodosVeiculosPasseio().stream()
				.filter(i -> i.getPlaca().equalsIgnoreCase(newPasseio.getPlaca())).findFirst().isPresent()) {

			throw new VeicExistException("veiculo de passeio");
		}

		try {

			newPasseio.setVelocMax(Integer.parseInt(leitura.entDados("\nVelocidade Maxima do veiculo: ")));
		} catch (VelocException e) {

			newPasseio.setVelocMax(100);
		}

		newPasseio.setQtdeRodas(Integer.parseInt(leitura.entDados("\nQtde de rodas do Veiculo: ")));
		newPasseio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("\nPotencia do veiculo: ")));
		newPasseio.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("\nQtde de pistao do veiculo: ")));
		newPasseio.setQtdePassageiro(Integer.parseInt(leitura.entDados("\nQtde de passageiros do Veiculo: ")));

		bdVeiculos.addPasseio(newPasseio);
	}

	public static void cadastrarVeiculoCarga() throws VeicExistException, VelocException {

		Carga newCarga = new Carga();

		newCarga.setModelo(leitura.entDados("\nModelo do Veiculo: "));
		newCarga.setMarca(leitura.entDados("\nMarca do Veiculo: "));
		newCarga.setCor(leitura.entDados("\nCor do Veiculo: "));
		newCarga.setPlaca(leitura.entDados("\nPlaca do Veiculo: "));

		if (bdVeiculos.listarTodosVeiculosCarga().stream()
				.filter(i -> i.getPlaca().equalsIgnoreCase(newCarga.getPlaca())).findFirst().isPresent()) {

			throw new VeicExistException("veiculo de carga");
		}

		try {

			newCarga.setVelocMax(Integer.parseInt(leitura.entDados("\nVelocidade Maxima do veiculo: ")));

		} catch (VelocException e) {

			newCarga.setVelocMax(90);
		}

		newCarga.setQtdeRodas(Integer.parseInt(leitura.entDados("\nQtde de rodas do Veiculo: ")));
		newCarga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("\nPotencia do veiculo: ")));
		newCarga.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("\nQtde de pistao do veiculo: ")));
		newCarga.setCargaMax(Integer.parseInt(leitura.entDados("\nCarga Maxima do Veiculo: ")));
		newCarga.setTara(Integer.parseInt(leitura.entDados("\nTara do Veiculo: ")));

		bdVeiculos.addCarga(newCarga);
	}

	public static void listarTodosVeiculosCarga() {

		int total = 1;

		for (Carga carga : bdVeiculos.listarTodosVeiculosCarga()) {

			System.out.println("\n===== Veiculo de Carga nº: " + total + " ======");
			System.out.println(carga.toString());
			System.out.println("\nSoma de todos os valores de atributos numéricos: " + carga.calcular());
			System.out.println("\nVelocidade do Veiculo de Carga: " + carga.calcVelocMax(carga.getVelocMax()) + "CM/H");

			total += total;
		}
	}

	public static void listarTodosVeiculosPasseio() {

		int total = 1;

		for (Passeio passeio : bdVeiculos.listarTodosVeiculosPasseio()) {

			System.out.println("\n===== Veiculo de Passeio nº: " + total + " ======");
			System.out.println(passeio.toString());
			System.out.println("\nSoma das quantidades de letras existentes em todos os atributos do tipo String: "
					+ passeio.calcular());
			System.out.println(
					"\nVelocidade do Veiculo de Passeio: " + passeio.calcVelocMax(passeio.getVelocMax()) + "M/H");

			total += total;
		}
	}

	public static void procurarVeiculosPasseioPorPlaca(String placa) {

		Passeio findPasseio = bdVeiculos.listarTodosVeiculosPasseio().stream()
				.filter(i -> i.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);

		if (findPasseio != null) {

			System.out.println("\n===== Placa Procurada: " + placa + " ======");
			System.out.println(findPasseio.toString());
			System.out.println("\nSoma das quantidades de letras existentes em todos os atributos do tipo String: "
					+ findPasseio.calcular());
			System.out.println("\nVelocidade do Veiculo de Passeio: "
					+ findPasseio.calcVelocMax(findPasseio.getVelocMax()) + "M/H");
		} else {

			System.out.println("\n===== Não a veiculo de passeio com placa: " + placa + " ======");
		}

	}

	public static void procurarVeiculosCargaPorPlaca(String placa) {

		Carga findCarga = bdVeiculos.listarTodosVeiculosCarga().stream()
				.filter(i -> i.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);

		if (findCarga != null) {

			System.out.println(findCarga.toString());
			System.out.println("\nSoma de todos os valores de atributos numéricos: " + findCarga.calcular());
			System.out.println(
					"\nVelocidade do Veiculo de Carga: " + findCarga.calcVelocMax(findCarga.getVelocMax()) + "CM/H");
		} else {

			System.out.println("\n===== Não a veiculo de carga com placa: " + placa + " ======");
		}
	}
	
	public static void excluirVeiculoPasseioPorPlaca(String placa) {

		Passeio findPasseio = bdVeiculos.listarTodosVeiculosPasseio().stream()
				.filter(i -> i.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);

		if (findPasseio != null) {

			bdVeiculos.removerVeiculoPasseio(findPasseio);
			System.out.println("\n===== Veiculo de passeio com placa: " + placa + " removido com sucesso ======");
		} else {

			System.out.println("\n===== Não a veiculo de passeio com placa: " + placa + " ======");
		}

	}

	public static void excluirVeiculoCargaPorPlaca(String placa) {

		Carga findCarga = bdVeiculos.listarTodosVeiculosCarga().stream()
				.filter(i -> i.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);

		if (findCarga != null) {
			
			bdVeiculos.removerVeiculoCarga(findCarga);
			System.out.println("\n===== Veiculo de carga com placa: " + placa + " removido com sucesso ======");
		} else {
			System.out.println("\n===== Não a veiculo de carga com placa: " + placa + " ======");
		}
	}
}
