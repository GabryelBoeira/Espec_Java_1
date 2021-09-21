package main;

import dal.BancoPes;
import leitura.Leitura;
import model.Pessoa;

public class TstCol {

	private static Leitura l = new Leitura();
	private static BancoPes bancoPes = new BancoPes();
	private static Pessoa pessoa = new Pessoa();

	public static void main(String arg[]) {

		int opcao = 0;
		boolean vai = true;

		while (vai) {

			System.out.println("\n ========== MENU PRINCIPAL  ========== ");
			System.out.println("\t ( 1 ) Cadastrar uma Pessa");
			System.out.println("\t ( 2 ) Imprimir todas as Pessoas");
			System.out.println("\t ( 3 ) Consultar Pessoa pelo Codigo");
			System.out.println("\t ( 4 ) Alterar Pessoa pelo Codigo");
			System.out.println("\t ( 5 ) Excluir Pessoa pelo Codigo");
			System.out.println("\t ( 6 ) Sair");

			try {
				opcao = Integer.parseInt(l.inData("\nEscolha uma opcao"));
			} catch (NumberFormatException nfe) {
				l.inData("\n O valor de ser um inteiro!");
				continue; // break
			}

			switch (opcao) {

				case 1:
					System.out.println("\t ===== CADASTRO DE PESSOAS =====");
	
					if (bancoPes.cadPessoa()) {
						
						l.inData("\n\t\tPessoa cadastrada com sucesso!  - <press Enter> \n");
					} else {
						
						l.inData("\n\t\tJah existe uma pessoa com este codigo!  - <press Enter> \n");
					}
	
					break;
	
				case 2:
	
					System.out.println("\t ===== IMPRESSAO DE TODAS AS PESSOAS =====");
	
					bancoPes.impTodasPessoas();
	
					break;
				case 3:
	
					System.out.println("\t ===== CONSULTA DE PESSOA PELO CODIGO =====");
	
					pessoa = new Pessoa();
	
					pessoa.setCod(Integer.parseInt(l.inData("\n Informe o CODIGO da Pessoa que vai ser al: ")));
	
					pessoa = bancoPes.consPesCod(pessoa);
	
					if (pessoa != null) {
						bancoPes.impPessoa(pessoa);
					} else {
						l.inData("\nNão existe pessoa com este codigo!  - <press Enter> /n");
					}
	
					break;
	
				case 4:
					System.out.println("\t ===== ALTERAR DE PESSOA PELO CODIGO =====");
	
					pessoa = new Pessoa();
	
					pessoa.setCod(Integer.parseInt(l.inData("\n Informe o CODIGO da Pessoa: ")));
	
					pessoa = bancoPes.altPesCod(pessoa);
	
					if (pessoa != null) {
	
						l.inData("\nPessoa alterada com sucesso!  - <press Enter> /n");
					} else {
	
						l.inData("\nNão existe pessoa com este codigo!  - <press Enter> /n");
					}
	
					break;
	
				case 5:
					System.out.println("\t ===== EXCLUI DE PESSOA PELO CODIGO =====");
	
					pessoa = new Pessoa();
	
					pessoa.setCod(Integer.parseInt(l.inData("\n Informe o CODIGO da Pessoa: ")));
	
					pessoa = bancoPes.excluiPesCod(pessoa);
	
					if (pessoa != null) {
						
						l.inData("\nPessoa excluida com sucesso!  - <press Enter> /n");
					} else {
						
						l.inData("\nNão existe pessoa com este codigo!  - <press Enter> /n");
					}
	
					break;
	
				case 6:
					System.exit(0);
					break;
	
				default:
					l.inData("\n Deve escolher uma opcao entre 1 e 6 !");
					break;

			}
		}
	}
}