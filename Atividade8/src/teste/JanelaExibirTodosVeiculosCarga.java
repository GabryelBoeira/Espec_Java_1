package teste;

import java.awt.Dimension;
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
import model.Carga;

public class JanelaExibirTodosVeiculosCarga implements ActionListener {

	private static String[] columnNames = { "Placa", "Marca", "Modelo", "Velocidade Maxima", "Cor", "Qtde de Rodas",
			"Qtde de Pistao", "Potencia", "Tara", "Carga Maxima" };
	private static int larg = 1000, alt = 450;

	private DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	private JTable cargaDados = new JTable(model);
	private JScrollPane barraRolagem = new JScrollPane(cargaDados);

	private JButton btnImprimirTodos = new JButton("Imprimir Todos");
	private JButton btnExcluirTodos = new JButton("Excluir Todos");
	private JButton btnSair = new JButton("Sair");

	private BDVeiculos bdVeiculos;
	private static JFrame janVeiCargaImprimir = new JFrame();

	public JanelaExibirTodosVeiculosCarga(BDVeiculos bdVeiculos) {
		this.bdVeiculos = bdVeiculos;
		this.carregaJanela();
	}

	@Override
	public void actionPerformed(ActionEvent act) {

		if (act.getSource().equals(btnImprimirTodos)) {

			imprimirVeiculosCarga();

		} else if (act.getSource().equals(btnExcluirTodos)) {

			if (excluirTodosDados()) {

				JOptionPane.showMessageDialog(null, "Veiculos removidos com sucesso", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model = new DefaultTableModel(columnNames, 0);
				cargaDados.setModel(model);
			}

		} else if (act.getSource().equals(btnSair)) {
			janVeiCargaImprimir.dispose();
		}
	}

	public void carregaJanela() {
		janVeiCargaImprimir = new JFrame("Imprimir / Excluir Todos");
		janVeiCargaImprimir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janVeiCargaImprimir.setLayout(new GridLayout(4, 1));
		janVeiCargaImprimir.setSize(larg, alt);
		janVeiCargaImprimir.setResizable(false);
		janVeiCargaImprimir.setLocationRelativeTo(null);

		btnImprimirTodos.setMnemonic('I');
		btnImprimirTodos.addActionListener(this);

		btnExcluirTodos.setMnemonic('E');
		btnExcluirTodos.addActionListener(this);
		btnExcluirTodos.setPreferredSize(new Dimension(10, 10));

		btnSair.setMnemonic('S');
		btnSair.addActionListener(this);

		janVeiCargaImprimir.add(barraRolagem);
		janVeiCargaImprimir.add(btnImprimirTodos);
		janVeiCargaImprimir.add(btnExcluirTodos);
		janVeiCargaImprimir.add(btnSair);

		janVeiCargaImprimir.setVisible(true);
	}

	private void imprimirVeiculosCarga() {

		List<Carga> cargaList = bdVeiculos.listarTodosVeiculosCarga();
		if (cargaList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há veiculos de carga cadastrados.", "Erro",
					JOptionPane.ERROR_MESSAGE);

		} else {
			model = new DefaultTableModel(columnNames, 0);

			for (Carga veiCarga : cargaList) {

				String[] data = { veiCarga.getPlaca(), veiCarga.getMarca(), veiCarga.getModelo(),
						veiCarga.getVelocMax().toString(), veiCarga.getCor(), veiCarga.getQtdeRodas().toString(),
						veiCarga.getMotor().getQtdPist().toString(), veiCarga.getMotor().getPotencia().toString(),
						veiCarga.getTara().toString(), veiCarga.getCargaMax().toString() };

				model.addRow(data);
			}

			janVeiCargaImprimir.setLayout(new GridLayout(4, 1));
			cargaDados.setModel(model);
		}
	}

	public boolean excluirTodosDados() {

		List<Carga> cargaList = bdVeiculos.listarTodosVeiculosCarga();

		if (cargaList.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não há dados a serem removidos.", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {

			bdVeiculos.removerTodosVeiculosCarga(cargaList);
		}

		return true;
	}
}
