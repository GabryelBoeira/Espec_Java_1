package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dal.BDVeiculos;
import model.Passeio;

/*
 * Classname: JanelaProcurarsVeiculoPasseio
 *
 * Version information: 1
 *
 * Date: 19/09/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class JanelaProcurarVeiculoPasseio implements ActionListener {

	private static int larg = 1000, alt = 350;
	private static String[] columnNamesVeiPasseio = { "Placa", "Marca", "Modelo", "Velocidade Maxima", "Cor",
			"Qtde de Rodas", "Qtde de Pistao", "Potencia", "Qtde de Passageiros" };

	private BDVeiculos bdVeiculos;
	private static Passeio resultadoVeiculoPasseio = null;

	private static JFrame janVeiPasseioProcurar = new JFrame("Consultar / Excluir pela placa");
	private DefaultTableModel model = new DefaultTableModel(columnNamesVeiPasseio, 0);
	private JTable passeioDados = new JTable(model);
	private JScrollPane barraRolagem = new JScrollPane(passeioDados);

	private JButton btnConsultar = new JButton("Consultar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnSair = new JButton("Sair");
	private JTextField conPlacaValue = new JTextField(10);

	public JanelaProcurarVeiculoPasseio(BDVeiculos bdVeiculos) {

		this.inicializar();
		this.bdVeiculos = bdVeiculos;
	}

	@Override
	public void actionPerformed(ActionEvent act) {

		if (act.getSource().equals(btnConsultar)) {

			procurarVeiculoPasseioPorPlaca();

		} else if (act.getSource().equals(btnExcluir)) {

			if (excluirVeiculoPasseio()) {

				JOptionPane.showMessageDialog(null, "Veiculo removido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model = new DefaultTableModel(columnNamesVeiPasseio, 0);
				conPlacaValue.setText("");
				passeioDados.setModel(model);
			}

		} else if (act.getSource().equals(btnSair)) {
			janVeiPasseioProcurar.dispose();
		}
	}

	public void inicializar() {

		janVeiPasseioProcurar = new JFrame("Consultar / Excluir pela placa");
		janVeiPasseioProcurar.setDefaultCloseOperation(janVeiPasseioProcurar.DISPOSE_ON_CLOSE);
		janVeiPasseioProcurar.setSize(larg, alt);
		janVeiPasseioProcurar.setLayout(new GridLayout(7, 1));
		janVeiPasseioProcurar.setResizable(false);
		janVeiPasseioProcurar.setLocationRelativeTo(null);

		JLabel conPlacaLabel = new JLabel("Informe a placa para consulta: ");
		conPlacaValue.setText("");
		janVeiPasseioProcurar.add(conPlacaLabel);
		janVeiPasseioProcurar.add(conPlacaValue);

		btnConsultar.setMnemonic('C');
		btnConsultar.addActionListener(this);

		btnExcluir.setMnemonic('E');
		btnExcluir.addActionListener(this);

		btnSair.setMnemonic('S');
		btnSair.addActionListener(this);

		janVeiPasseioProcurar.add(barraRolagem);
		janVeiPasseioProcurar.add(btnConsultar);
		janVeiPasseioProcurar.add(btnExcluir);
		janVeiPasseioProcurar.add(btnSair);

		janVeiPasseioProcurar.setVisible(true);
	}

	private boolean excluirVeiculoPasseio() {

		if (conPlacaValue.getText().isBlank()) {

			JOptionPane.showMessageDialog(null, "Informe uma placa para busca", "Aviso", JOptionPane.WARNING_MESSAGE);
		} else {

			if (resultadoVeiculoPasseio != null && resultadoVeiculoPasseio.getPlaca().equals(conPlacaValue.getText())) {

				if (bdVeiculos.removerVeiculoPasseio(resultadoVeiculoPasseio)) {

					return true;
				}
			} else {

				Passeio passeio = bdVeiculos.listarTodosVeiculosPasseio().stream()
						.filter(i -> i.getPlaca().equals(conPlacaValue.getText())).findFirst().orElse(null);

				if (passeio == null) {

					JOptionPane.showMessageDialog(null, "Não a veiculo para a placa informada: " + conPlacaValue.getText(), "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (bdVeiculos.removerVeiculoPasseio(passeio)) {

						return true;
					}
				}
			}
		}
		return false;
	}

	private void procurarVeiculoPasseioPorPlaca() {

		if (conPlacaValue.getText().isBlank()) {

			JOptionPane.showMessageDialog(null, "Informe uma placa para busca", "Aviso", JOptionPane.WARNING_MESSAGE);
		} else {

			model = new DefaultTableModel(columnNamesVeiPasseio, 0);
			resultadoVeiculoPasseio = bdVeiculos.listarTodosVeiculosPasseio().stream()
					.filter(i -> i.getPlaca().equals(conPlacaValue.getText())).findFirst().orElse(null);

			if (resultadoVeiculoPasseio != null) {

				String[] data = { resultadoVeiculoPasseio.getPlaca(), resultadoVeiculoPasseio.getMarca(),
						resultadoVeiculoPasseio.getModelo(), resultadoVeiculoPasseio.getVelocMax().toString(),
						resultadoVeiculoPasseio.getCor(), resultadoVeiculoPasseio.getQtdeRodas().toString(),
						resultadoVeiculoPasseio.getMotor().getQtdPist().toString(),
						resultadoVeiculoPasseio.getMotor().getPotencia().toString(),
						resultadoVeiculoPasseio.getQtdePassageiro().toString() };

				passeioDados.setModel(model);
				model.addRow(data);
			} else {

				JOptionPane.showMessageDialog(null, "Não a veiculo de passeios com placa: " + conPlacaValue.getText(),
						"Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
