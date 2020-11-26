package main.ed_sis.domain.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.ed_sis.domain.controllers.CampusManipuladorArquivo;
import main.ed_sis.domain.models.Campus;

public class CadastroCampus extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEstado;
	private JTextField textFieldCEP;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldNumero;

	public CadastroCampus() {
		setTitle("Cadastro de Campus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 5, 105, 15);
		contentPane.add(btnVoltar);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textFieldNome.getText() == null || textFieldNome.getText().isEmpty())
						|| (textFieldEstado.getText() == null || textFieldEstado.getText().isEmpty())
						|| (textFieldCEP.getText() == null || textFieldCEP.getText().isEmpty())
						|| (textFieldRua == null || textFieldRua.getText().isEmpty())
						|| (textFieldBairro.getText() == null || textFieldBairro.getText().isEmpty())
						|| (textFieldNumero.getText() == null || textFieldNumero.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					Campus campus = new Campus();
					campus.setNome(textFieldNome.getText());
					campus.setEstado(textFieldEstado.getText());
					campus.setCEP(textFieldCEP.getText());
					campus.setRua(textFieldRua.getText());
					campus.setBairro(textFieldBairro.getText());
					campus.setNumero(Integer.parseInt(textFieldNumero.getText()));

					CampusManipuladorArquivo manipula = new CampusManipuladorArquivo();
					try {
						manipula.insertCampus(campus);
						JOptionPane.showMessageDialog(null, "Campus cadastrado com sucesso.");
						CloseFrame();
					} catch (IOException e1) {

						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro. Revise seus dados e tente novamente");
					}

				}
			}
		});
		btnNewButton.setBounds(316, 230, 117, 29);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(24, 33, 61, 16);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(95, 28, 338, 26);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel labelNome = new JLabel("Estado (Sigla)");
		labelNome.setBounds(24, 74, 148, 16);
		contentPane.add(labelNome);

		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(130, 69, 50, 26);
		contentPane.add(textFieldEstado);

		JLabel labelCEP = new JLabel("CEP");
		labelCEP.setBounds(190, 74, 61, 16);
		contentPane.add(labelCEP);

		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(220, 69, 210, 26);
		contentPane.add(textFieldCEP);

		JLabel labelRua = new JLabel("Rua");
		labelRua.setBounds(24, 122, 168, 16);
		contentPane.add(labelRua);

		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(100, 117, 330, 26);
		contentPane.add(textFieldRua);

		JLabel labelBairro = new JLabel("Bairro");
		labelBairro.setBounds(24, 170, 168, 16);
		contentPane.add(labelBairro);

		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(100, 170, 180, 26);
		contentPane.add(textFieldBairro);

		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(300, 170, 168, 16);
		contentPane.add(labelNumero);

		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(370, 170, 60, 26);
		contentPane.add(textFieldNumero);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();

			}
		});

	}

	public void CloseFrame() {
		super.dispose();
		new MenuAdmin().setVisible(true);
	}

}