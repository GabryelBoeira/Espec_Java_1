package teste;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dal.BDVeiculos;
import model.Passeio;

public class JanelaExibirTodosVeiculosPasseio implements ActionListener {

	private BDVeiculos bdVeiculos;
	private static JFrame janVeiPasseioImprimir = new JFrame("Imprimir / Excluir Todos");

	private static String[] columnNames = { "Placa", "Marca", "Modelo", "Velocidade Maxima", "Cor", "Qtde de Rodas",
			"Qtde de Pistao", "Potencia", "Qtde de Passageiros" };
	private static int larg = 1000, alt = 450;

	private DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	private JTable passeioDados = new JTable(model);
	private JScrollPane barraRolagem = new JScrollPane(passeioDados);

	private JButton btnImprimirTodos = new JButton("Imprimir Todos");
	private JButton btnExcluirTodos = new JButton("Excluir Todos");
	private JButton btnSair = new JButton("Sair");
	
	public JanelaExibirTodosVeiculosPasseio(BDVeiculos bdVeiculos) {
		this.bdVeiculos = bdVeiculos;
		this.carregaJanela();
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {

		if (act.getSource().equals(btnImprimirTodos)) {

			imprimirVeiculosPasseio();

		} else if (act.getSource().equals(btnExcluirTodos)) {

			if (excluirTodosDados()) {

				JOptionPane.showMessageDialog(null, "Veiculos removidos com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model = new DefaultTableModel(columnNames, 0);
				passeioDados.setModel(model);
			}

		} else if (act.getSource().equals(btnSair)) {
			janVeiPasseioImprimir.dispose();
		}
	}

	public void carregaJanela() {
		
		janVeiPasseioImprimir = new JFrame("Imprimir / Excluir Todos");
		janVeiPasseioImprimir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janVeiPasseioImprimir.setLayout(new GridLayout(4, 1));
		janVeiPasseioImprimir.setSize(larg, alt);
		janVeiPasseioImprimir.setResizable(false);
		janVeiPasseioImprimir.setLocationRelativeTo(null);

		btnImprimirTodos.setMnemonic('I');
		btnImprimirTodos.addActionListener(this);

		btnExcluirTodos.setMnemonic('E');
		btnExcluirTodos.addActionListener(this);

		btnSair.setMnemonic('S');
		btnSair.addActionListener(this);

		janVeiPasseioImprimir.add(barraRolagem);
		janVeiPasseioImprimir.add(btnImprimirTodos);
		janVeiPasseioImprimir.add(btnExcluirTodos);
		janVeiPasseioImprimir.add(btnSair);

		janVeiPasseioImprimir.setVisible(true);
	}

	private void imprimirVeiculosPasseio() {

		List<Passeio> passeioList = bdVeiculos.listarTodosVeiculosPasseio();

		if (passeioList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há veiculos de passeio cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);

		} else {
			model = new DefaultTableModel(columnNames, 0);
		
			for (Passeio veiPasseio : passeioList) {

				String[] data =  { veiPasseio.getPlaca(), veiPasseio.getMarca(), veiPasseio.getModelo(),
						veiPasseio.getVelocMax().toString(), veiPasseio.getCor(), veiPasseio.getQtdeRodas().toString(),
						veiPasseio.getMotor().getQtdPist().toString(), veiPasseio.getMotor().getPotencia().toString(),
						veiPasseio.getQtdePassageiro().toString() };

				model.addRow(data);
			}

			passeioDados.setModel(model);
			janVeiPasseioImprimir.setLayout(new GridLayout(4, 1));
		}
	}

	public boolean excluirTodosDados() {

		List<Passeio> passeioList = bdVeiculos.listarTodosVeiculosPasseio();

		if (passeioList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há dados a serem removidos.", "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {

			bdVeiculos.removerTodosVeiculosPasseio(passeioList);
		}
		return true;
	}

}
