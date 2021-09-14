package teste;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import dal.BDVeiculos;
import excecao.VeicExistException;
import excecao.VelocException;
import model.Carga;
import model.Passeio;

/*
 * Classname: Teste
 *
 * Version information: 1
 *
 * Date: 14/0/2021
 *
 * Created by: Gabryel J. Boeira
 */
public class Teste {

	private static BDVeiculos bdVeiculos = new BDVeiculos();
	private static JFrame jan1 = new JFrame("Gestão de Veiculos");
	private static JFrame janCarga = new JFrame("Gestão de Veiculos de Carga");
	private static JFrame janPasseio = new JFrame("Gestão de Veiculos de Passeio");
	private static JPanel panel = new JPanel();

	private static JButton btVeiculoCarga = new JButton("Veiculos de Carga");
	private static JButton btVeiculoPasseio = new JButton("Veiculos de Passeio");
	private static int larg = 400, alt = 250;

	private static JButton btnVeiCargaCadastrar = new JButton("Cadastrar");
	private static JButton btnVeiCargaProcurar = new JButton("Consultar / Excluir pela placa");
	private static JButton btnVeiCargaImprimir = new JButton("Imprimir / Excluir Todos");
	private static JButton btnVeiCargaSair = new JButton("Voltar");

	private static JFrame janVeiCargaCadastrar = new JFrame("Cadastrar");
	private static JFrame janVeiCargaProcurar = new JFrame("Consultar / Excluir pela placa");
	private static JFrame janVeiCargaImprimir = new JFrame("Imprimir / Excluir Todos");

	private static JButton btnVeiPasseioCadastrar = new JButton("Cadastrar");
	private static JButton btnVeiPasseioProcurar = new JButton("Consultar / Excluir pela placa");
	private static JButton btnVeiPasseioImprimir = new JButton("Imprimir / Excluir Todos");
	private static JButton btnVeiPasseioSair = new JButton("Voltar");

	private static JFrame janVeiPasseioCadastrar = new JFrame("Cadastrar");
	private static JFrame janVeiPasseioProcurar = new JFrame("Consultar / Excluir pela placa");
	private static JFrame janVeiPasseioImprimir = new JFrame("Imprimir / Excluir Todos");

	public static void main(String[] args) {

		jan1.setResizable(false);
		jan1.setSize(larg, alt);
		jan1.setLocationRelativeTo(null);
		jan1.setDefaultCloseOperation(jan1.EXIT_ON_CLOSE);
		jan1.add(btVeiculoCarga);
		jan1.add(btVeiculoPasseio);
		jan1.setLayout(new FlowLayout());

		btVeiculoCarga.setBackground(Color.GREEN);
		btVeiculoCarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				janCarga.setDefaultCloseOperation(janCarga.EXIT_ON_CLOSE);
				janCarga.setResizable(false);
				janCarga.setSize(larg, alt);
				janCarga.setLocationRelativeTo(null);
				janCarga.setLayout(new FlowLayout());

				btnVeiCargaCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

						cadastrarVeiculoCarga();
					}
				});

				btnVeiCargaProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

					}
				});
				btnVeiCargaImprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

					}
				});

				btnVeiCargaSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						janCarga.dispose();

					}
				});

				janCarga.add(btnVeiCargaCadastrar);
				janCarga.add(btnVeiCargaProcurar);
				janCarga.add(btnVeiCargaImprimir);
				janCarga.add(btnVeiCargaSair);

				janCarga.setVisible(true);
			}
		});

		btVeiculoPasseio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				janPasseio.setDefaultCloseOperation(janPasseio.EXIT_ON_CLOSE);
				janPasseio.setResizable(false);
				janPasseio.setSize(larg, alt);
				janPasseio.setLocationRelativeTo(null);
				janPasseio.setVisible(true);
				janPasseio.setLayout(new FlowLayout());

				btnVeiPasseioCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

						cadastrarVeiculoPasseio();
					}
				});

				btnVeiPasseioProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

					}
				});

				btnVeiPasseioImprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

					}
				});

				btnVeiPasseioSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

						janPasseio.dispose();
					}
				});

				janPasseio.add(btnVeiPasseioCadastrar);
				janPasseio.add(btnVeiPasseioProcurar);
				janPasseio.add(btnVeiPasseioImprimir);
				janPasseio.add(btnVeiPasseioSair);
			}
		});

		jan1.setVisible(true);
	}

	public static void cadastrarVeiculoPasseio() {

		try {
			janVeiPasseioCadastrar.setContentPane(new Container());
			janVeiPasseioCadastrar.setDefaultCloseOperation(janVeiPasseioCadastrar.EXIT_ON_CLOSE);
			janVeiPasseioCadastrar.setResizable(false);
			janVeiPasseioCadastrar.setSize(larg, alt);
			janVeiPasseioCadastrar.setLocationRelativeTo(null);
			janVeiPasseioCadastrar.setLayout(new FlowLayout());

			JButton btnCadastrar = new JButton("Cadastrar");
			JButton btnLimpar = new JButton("Limpar");
			JButton btnNovo = new JButton("Novo");
			JButton btnSair = new JButton("Sair");

			Container container = janVeiPasseioCadastrar.getContentPane();
			JPanel panelVeic = new JPanel();
			panelVeic.setLayout(new BoxLayout(panelVeic, BoxLayout.Y_AXIS));

			JLabel modeloLabel = new JLabel("Modelo do Veiculo: ");
			JTextField modeloValue = new JTextField(10);
			panelVeic.add(modeloLabel);
			panelVeic.add(modeloValue);

			JLabel marcaLabel = new JLabel("Marca do Veiculo: ");
			JTextField marcaValue = new JTextField(10);
			panelVeic.add(marcaLabel);
			panelVeic.add(marcaValue);

			JLabel corLabel = new JLabel("Cor do Veiculo: ");
			JTextField corValue = new JTextField(10);
			panelVeic.add(corLabel);
			panelVeic.add(corValue);

			JLabel placaLabel = new JLabel("Placa do Veiculo: ");
			JTextField placaValue = new JTextField(10);
			panelVeic.add(placaLabel);
			panelVeic.add(placaValue);

			JLabel velMaxLabel = new JLabel("Velocidade Maxima do veiculo: ");
			JFormattedTextField velMaxValue = numberFormat();
			panelVeic.add(velMaxLabel);
			panelVeic.add(velMaxValue);

			JLabel qtdeRodasLabel = new JLabel("Qtde de rodas do Veiculo: ");
			JFormattedTextField qtdeRodasValue = numberFormat();
			panelVeic.add(qtdeRodasLabel);
			panelVeic.add(qtdeRodasValue);

			JLabel potenciaLabel = new JLabel("Potencia do veiculo: ");
			JFormattedTextField potenciaValue = numberFormat();
			panelVeic.add(potenciaLabel);
			panelVeic.add(potenciaValue);

			JLabel qtdePistaoLabel = new JLabel("Qtde de pistao do veiculo: ");
			JFormattedTextField qtdePistaoValue = numberFormat();
			panelVeic.add(qtdePistaoLabel);
			panelVeic.add(qtdePistaoValue);

			JLabel qtdePassageiroLabel = new JLabel("Qtde de passageiros do Veiculo: ");
			JFormattedTextField qtdePassageiroValue = numberFormat();
			panelVeic.add(qtdePassageiroLabel);
			panelVeic.add(qtdePassageiroValue);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					Passeio newPasseio = new Passeio(placaValue.getText(), marcaValue.getText(), modeloValue.getText(),
							100, Integer.parseInt(qtdePistaoValue.getText()), corValue.getText(),
							Integer.parseInt(qtdeRodasValue.getText()), Integer.parseInt(potenciaValue.getText()),
							Integer.parseInt(qtdePassageiroValue.getText()));

					try {

						if (bdVeiculos.listarTodosVeiculosPasseio().stream()
								.filter(i -> i.getPlaca().equalsIgnoreCase(placaValue.getText())).findFirst()
								.isPresent()) {

							throw new VeicExistException();
						}

						newPasseio.setVelocMax(Integer.parseInt(velMaxValue.getText()));

					} catch (VelocException e) {

						JOptionPane.showMessageDialog(null, e.mensagemErro(), "Aviso", JOptionPane.WARNING_MESSAGE);
					} catch (VeicExistException e) {

						JOptionPane.showMessageDialog(null, e.mensagemErro(), "Erro", JOptionPane.ERROR_MESSAGE);
						janVeiPasseioCadastrar.dispose();
					}

					if (bdVeiculos.addPasseio(newPasseio)) {

						int resultado = JOptionPane.showConfirmDialog(null,
								"Veiculo de carga criado, deseja adicionar mais? ", "Adicionar mais",
								JOptionPane.YES_NO_OPTION);

						if (resultado == 0) {

							btnNovo.doClick();
						} else {

							janVeiCargaCadastrar.dispose();
						}
					} else {

						JOptionPane.showMessageDialog(null, "Erro ao tentar cadastra o veiculo de passageiro", "Erro",
								JOptionPane.ERROR_MESSAGE);
						janVeiPasseioCadastrar.dispose();
					}
				}
			});

			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					janVeiPasseioCadastrar.dispose();
				}
			});

			btnNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					modeloValue.setText("");
					marcaValue.setText("");
					placaValue.setText("");
					corValue.setText("");
					velMaxValue.setText("0");
					qtdePistaoValue.setText("0");
					qtdeRodasValue.setText("0");
					potenciaValue.setText("0");
					qtdePassageiroValue.setText("0");
				}
			});

			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					modeloValue.setText("");
					marcaValue.setText("");
					placaValue.setText("");
					corValue.setText("");
					velMaxValue.setText("0");
					qtdePistaoValue.setText("0");
					qtdeRodasValue.setText("0");
					potenciaValue.setText("0");
					qtdePassageiroValue.setText("0");
				}
			});

			container.add(panelVeic);
			// janVeiPasseioCadastrar.setContentPane(container);
			janVeiPasseioCadastrar.add(btnCadastrar);
			janVeiPasseioCadastrar.add(btnLimpar);
			janVeiPasseioCadastrar.add(btnNovo);
			janVeiPasseioCadastrar.add(btnSair);

			janVeiPasseioCadastrar.pack();
			janVeiPasseioCadastrar.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações informadas invalidas", "Erro", JOptionPane.ERROR_MESSAGE);
			janVeiPasseioCadastrar.dispose();
		}
	}

	public static void cadastrarVeiculoCarga() {

		try {
			janVeiPasseioCadastrar.setContentPane(new Container());
			janVeiCargaCadastrar.setDefaultCloseOperation(janVeiCargaCadastrar.DISPOSE_ON_CLOSE);
			janVeiCargaCadastrar.setResizable(false);
			janVeiCargaCadastrar.setSize(larg, alt);
			janVeiCargaCadastrar.setLocationRelativeTo(null);
			janVeiCargaCadastrar.setLayout(new FlowLayout());

			JButton btnCadastrar = new JButton("Cadastrar");
			JButton btnLimpar = new JButton("Limpar");
			JButton btnNovo = new JButton("Novo");
			JButton btnSair = new JButton("Sair");

			Container container = janVeiCargaCadastrar.getContentPane();
			JPanel panelVeic = new JPanel();
			panelVeic.setLayout(new BoxLayout(panelVeic, BoxLayout.Y_AXIS));

			JLabel modeloLabel = new JLabel("Modelo do Veiculo: ");
			JTextField modeloValue = new JTextField(10);
			panelVeic.add(modeloLabel);
			panelVeic.add(modeloValue);

			JLabel marcaLabel = new JLabel("Marca do Veiculo: ");
			JTextField marcaValue = new JTextField(10);
			panelVeic.add(marcaLabel);
			panelVeic.add(marcaValue);

			JLabel corLabel = new JLabel("Cor do Veiculo: ");
			JTextField corValue = new JTextField(10);
			panelVeic.add(corLabel);
			panelVeic.add(corValue);

			JLabel placaLabel = new JLabel("Placa do Veiculo: ");
			JTextField placaValue = new JTextField(10);
			panelVeic.add(placaLabel);
			panelVeic.add(placaValue);

			JLabel velMaxLabel = new JLabel("Velocidade Maxima do veiculo: ");
			JFormattedTextField velMaxValue = numberFormat();
			panelVeic.add(velMaxLabel);
			panelVeic.add(velMaxValue);

			JLabel qtdeRodasLabel = new JLabel("Qtde de rodas do Veiculo: ");
			JFormattedTextField qtdeRodasValue = numberFormat();
			panelVeic.add(qtdeRodasLabel);
			panelVeic.add(qtdeRodasValue);

			JLabel potenciaLabel = new JLabel("Potencia do veiculo: ");
			JFormattedTextField potenciaValue = numberFormat();
			panelVeic.add(potenciaLabel);
			panelVeic.add(potenciaValue);

			JLabel qtdePistaoLabel = new JLabel("Qtde de pistao do veiculo: ");
			JFormattedTextField qtdePistaoValue = numberFormat();
			panelVeic.add(qtdePistaoLabel);
			panelVeic.add(qtdePistaoValue);

			JLabel qtdePassageiroLabel = new JLabel("Carga Maxima do Veiculo: ");
			JFormattedTextField qtdePassageiroValue = numberFormat();
			panelVeic.add(qtdePassageiroLabel);
			panelVeic.add(qtdePassageiroValue);

			JLabel taraLabel = new JLabel("Tara do Veiculo: ");
			JFormattedTextField taraValue = numberFormat();
			panelVeic.add(taraLabel);
			panelVeic.add(taraValue);

			container.add(panelVeic);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					Carga newCarga = new Carga(Integer.parseInt(taraValue.getText()), 0, placaValue.getText(),
							marcaValue.getText(), modeloValue.getText(), 90, corValue.getText(),
							Integer.parseInt(qtdeRodasValue.getText()), Integer.parseInt(qtdePistaoValue.getText()),
							Integer.parseInt(potenciaValue.getText()));

					try {
						if (bdVeiculos.listarTodosVeiculosCarga().stream()
								.filter(i -> i.getPlaca().equalsIgnoreCase(placaValue.getText())).findFirst()
								.isPresent()) {

							throw new VeicExistException();
						}

						newCarga.setVelocMax(Integer.parseInt(velMaxValue.getText()));
					} catch (VelocException e) {

						JOptionPane.showMessageDialog(null, e.mensagemErro(), "Aviso", JOptionPane.WARNING_MESSAGE);
					} catch (VeicExistException e) {

						JOptionPane.showMessageDialog(null, e.mensagemErro(), "Erro", JOptionPane.ERROR_MESSAGE);
						janVeiCargaCadastrar.dispose();
					}

					if (bdVeiculos.addCarga(newCarga)) {

						int resultado = JOptionPane.showConfirmDialog(null,
								"Veiculo de carga criado, deseja adicionar mais? ", "Adicionar mais",
								JOptionPane.YES_NO_OPTION);

						if (resultado == 0) {
							btnNovo.doClick();
						} else {
							janVeiCargaCadastrar.dispose();
						}

					} else {

						JOptionPane.showMessageDialog(null, "Erro ao tentar cadastra o veiculo de carga", "Erro",
								JOptionPane.ERROR_MESSAGE);
						janVeiCargaCadastrar.dispose();
					}
				}
			});

			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					janVeiCargaCadastrar.dispose();
				}
			});

			btnNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					modeloValue.setText("");
					marcaValue.setText("");
					placaValue.setText("");
					corValue.setText("");
					velMaxValue.setText("0");
					qtdePistaoValue.setText("0");
					qtdeRodasValue.setText("0");
					potenciaValue.setText("0");
					qtdePassageiroValue.setText("0");
				}
			});

			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					modeloValue.setText("");
					marcaValue.setText("");
					placaValue.setText("");
					corValue.setText("");
					velMaxValue.setText("0");
					qtdePistaoValue.setText("0");
					qtdeRodasValue.setText("0");
					potenciaValue.setText("0");
					qtdePassageiroValue.setText("0");
				}
			});

			janVeiCargaCadastrar.setContentPane(container);
			janVeiCargaCadastrar.add(btnCadastrar);
			janVeiCargaCadastrar.add(btnLimpar);
			janVeiCargaCadastrar.add(btnNovo);
			janVeiCargaCadastrar.add(btnSair);

			janVeiCargaCadastrar.pack();
			janVeiCargaCadastrar.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações informadas invalidas", "Erro", JOptionPane.ERROR_MESSAGE);
			janVeiCargaCadastrar.dispose();
		}
	}

	private static JFormattedTextField numberFormat() {

		NumberFormat numberInstance = NumberFormat.getNumberInstance();

		NumberFormatter numberFormatter = new NumberFormatter(numberInstance);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(999);

		JFormattedTextField numberFormat = new JFormattedTextField(numberFormatter);
		numberFormat.setColumns(10);
		numberFormat.setText("0");

		return numberFormat;
	}

}
