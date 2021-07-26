package teste;

import java.util.Scanner;

/*
 * Classname: Veiculo
 *
 * Version information: 1
 *
 * Date: 25/07/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class Teste {

	public static void main(String[] args) {

		int opcao = 0;

		do {

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.println("Sistema de Gest�o de Ve�culos - Menu Inicial");
			System.out.println("\n");
			System.out.println("1. Cadastrar Ve�culo de Passeio");
			System.out.println("2. Cadastrar Ve�culo de Carga");
			System.out.println("3. Imprimir Todos os Ve�culos de Passeio");
			System.out.println("4. Imprimir Todos os Ve�culos de Carga");
			System.out.println("5. Imprimir Ve�culo de Passeio pela Placa");
			System.out.println("6. Imprimir Ve�culo de Carga pela Placa");
			System.out.println("7. Sair do Sistema");
			System.out.println("\n");
			System.out.println("Selecione uma op��o: ");

			try {
				opcao = scanner.nextInt();

				switch (opcao) {

					case 1:
						System.out.println("Op��o 1");
						break;
					case 2:
						System.out.println("Op��o 2");
						break;
					case 3:
						System.out.println("Op��o 3");
						break;
					case 4:
						System.out.println("Op��o 4");
						break;
					case 5:
						System.out.println("Op��o 5");
						break;
					case 6:
						System.out.println("Op��o 6");
						break;
					case 7:
						System.out.println("Fim");
						break;
					default:					
						System.out.println("Op��o n�o encontrada");
						break;
				}
			
			} catch (Exception e) {
				System.out.flush();
				System.out.println("Op��o inv�lida");
				System.out.println("\n");
			}
						
		} while (opcao != 7);
	}
}
