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
import model.Carga;

/*
 * Classname: JanelaProcurarsVeiculoCarga
 *
 * Version information: 1
 *
 * Date: 19/09/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class JanelaProcurarVeiculoCarga implements ActionListener {

	private static int larg = 1000, alt = 350;
	private static String[] columnNamesVeiCarga = { "Placa", "Marca", "Modelo", "Velocidade Maxima", "Cor",
			"Qtde de Rodas", "Qtde de Pistao", "Potencia", "Tara", "Carga Maxima" };

	private static Carga resultadoVeiculoCarga = null;
	private BDVeiculos bdVeiculos;

	private static JFrame janVeiCargaProcurar = new JFrame("Consultar / Excluir pela placa");
	private DefaultTableModel model = new DefaultTableModel(columnNamesVeiCarga, 0);
	private JTable cargaDados = new JTable(model);
	private JScrollPane barraRolagem = new JScrollPane(cargaDados);

	private JButton btnConsultar = new JButton("Consultar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnSair = new JButton("Sair");
	private JTextField conPlacaValue = new JTextField(10);

	public JanelaProcurarVeiculoCarga(BDVeiculos bdVeiculos) {

		this.inicializar();
		this.bdVeiculos = bdVeiculos;
	}

	@Override
	public void actionPerformed(ActionEvent act) {

		if (act.getSource().equals(btnConsultar)) {

			procurarVeiculoCargaPorPlaca();
		} else if (act.getSource().equals(btnExcluir)) {

			if (excluirVeiculoCarga()) {

				JOptionPane.showMessageDialog(null, "Veiculo removido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model = new DefaultTableModel(columnNamesVeiCarga, 0);
				cargaDados.setModel(model);
			}

		} else if (act.getSource().equals(btnSair)) {

			janVeiCargaProcurar.dispose();
		}
	}

	public void inicializar() {

		janVeiCargaProcurar = new JFrame("Consultar / Excluir pela placa");
		janVeiCargaProcurar.setDefaultCloseOperation(janVeiCargaProcurar.DISPOSE_ON_CLOSE);
		janVeiCargaProcurar.setSize(larg, alt);
		janVeiCargaProcurar.setLayout(new GridLayout(7, 1));
		janVeiCargaProcurar.setResizable(false);
		janVeiCargaProcurar.setLocationRelativeTo(null);

		JLabel conPlacaLabel = new JLabel("Informe a placa para consulta: ");
		conPlacaValue.setText("");
		janVeiCargaProcurar.add(conPlacaLabel);
		janVeiCargaProcurar.add(conPlacaValue);

		btnConsultar.setMnemonic('C');
		btnConsultar.addActionListener(this);

		btnExcluir.setMnemonic('E');
		btnExcluir.addActionListener(this);

		btnSair.setMnemonic('S');
		btnSair.addActionListener(this);

		janVeiCargaProcurar.add(barraRolagem);
		janVeiCargaProcurar.add(btnConsultar);
		janVeiCargaProcurar.add(btnExcluir);
		janVeiCargaProcurar.add(btnSair);

		janVeiCargaProcurar.setVisible(true);
	}

	private boolean excluirVeiculoCarga() {

		if (conPlacaValue.getText().isBlank()) {

			JOptionPane.showMessageDialog(null, "Informe uma placa para busca", "Aviso", JOptionPane.WARNING_MESSAGE);
		} else {

			if (resultadoVeiculoCarga != null && resultadoVeiculoCarga.getPlaca().equals(conPlacaValue.getText())) {

				if (bdVeiculos.removerVeiculoCarga(resultadoVeiculoCarga)) {

					return true;
				}
			} else {

				Carga carga = bdVeiculos.listarTodosVeiculosCarga().stream()
						.filter(i -> i.getPlaca().equals(conPlacaValue.getText())).findFirst().orElse(null);

				if (carga == null) {

					JOptionPane.showMessageDialog(null, "Não a veiculo para a placa informada: " + conPlacaValue.getText(), "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (bdVeiculos.removerVeiculoCarga(carga)) {

						return true;
					}
				}
			}
		}

		return false;
	}

	private void procurarVeiculoCargaPorPlaca() {

		if (!conPlacaValue.getText().isBlank()) {

			resultadoVeiculoCarga = bdVeiculos.listarTodosVeiculosCarga().stream()
					.filter(i -> i.getPlaca().equals(conPlacaValue.getText())).findFirst().orElse(null);

			if (resultadoVeiculoCarga != null) {

				model = new DefaultTableModel(columnNamesVeiCarga, 0);

				String[] data = { resultadoVeiculoCarga.getPlaca(), resultadoVeiculoCarga.getMarca(),
						resultadoVeiculoCarga.getModelo(), resultadoVeiculoCarga.getVelocMax().toString(),
						resultadoVeiculoCarga.getCor(), resultadoVeiculoCarga.getQtdeRodas().toString(),
						resultadoVeiculoCarga.getMotor().getQtdPist().toString(),
						resultadoVeiculoCarga.getMotor().getPotencia().toString(),
						resultadoVeiculoCarga.getTara().toString(), resultadoVeiculoCarga.getCargaMax().toString() };

				model.addRow(data);
				janVeiCargaProcurar.setLayout(new GridLayout(4, 1));
				cargaDados.setModel(model);
			} else {

				JOptionPane.showMessageDialog(null, "Não a veiculo de passeios com placa: " + conPlacaValue.getText(),
						"Aviso", JOptionPane.WARNING_MESSAGE);
			}
		} else {

			JOptionPane.showMessageDialog(null, "Informe uma placa para busca", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
	}

}
