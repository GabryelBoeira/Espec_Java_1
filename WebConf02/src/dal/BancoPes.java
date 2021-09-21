package dal;

import java.util.ArrayList;
import java.util.List;

import leitura.Leitura;
import model.Pessoa;

public class BancoPes {

	private static Pessoa pessoa = new Pessoa();
	private static List<Pessoa> pessoaList = new ArrayList<>();
	private static Leitura l = new Leitura();

	public Boolean cadPessoa() {

		pessoa = new Pessoa();
		pessoa.setCod(Integer.parseInt(l.inData("\nCodigo: ")));
		pessoa.setNome(l.inData("Nome: "));

		if (consPesCod(pessoa) != null) {

			return false;
		}

		return pessoaList.add(pessoa);
	}

	public void impPessoa(Pessoa pessoaImprimir) {

		System.out.println("Codigo: " + pessoaImprimir.getCod() + " - Nome: " + pessoaImprimir.getNome());
	}

	public void impTodasPessoas() {

		if (pessoaList.isEmpty()) {

			l.inData("\nSem mais pessoas para imprimir!  - <press Enter> \n");
			return;
		}

		for (Pessoa p : pessoaList) {

			System.out.println("Codigo: " + p.getCod() + " - Nome: " + p.getNome());
		}
	}

	public Pessoa consPesCod(Pessoa pessoaConsulta) {

		for (Pessoa p : pessoaList) {

			if (p.getCod() == pessoa.getCod()) {
				return p;
			}
		}

		return null;
	}

	public Pessoa altPesCod(Pessoa pessoaAtualizar) {

		this.impPessoa(pessoaAtualizar);

		for (Pessoa p : pessoaList) {

			if (p.getCod() == pessoaAtualizar.getCod()) {

				pessoa = new Pessoa();
				pessoa.setCod(Integer.parseInt(l.inData("\nCodigo: ")));
				pessoa.setNome(l.inData("Nome: "));
				
				if (consPesCod(pessoa) == null) {

					int index = pessoaList.indexOf(p);
					pessoaList.add(index, pessoa);

					return pessoaList.get(index);
				} else {

					l.inData("\n\t\t ERRO DE ALTERACAO: Jah existe uma pessoa com este codigo - <press ENTER> ");
					return null;
				}
			}
		}

		return null;
	}

	public Pessoa excluiPesCod(Pessoa pessoaRemover) {

		pessoa = consPesCod(pessoaRemover);

		if (pessoa != null) {

			pessoaList.remove(pessoa);
			return pessoa;
		}

		return null;
	}
}
