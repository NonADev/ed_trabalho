package main.ed_sis.domain.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.ed_sis.domain.controllers.CampusManipuladorArquivo;
import main.ed_sis.domain.controllers.CursoManipuladorArquivo;
import main.ed_sis.domain.controllers.EditalManipuladorArquivo;
import main.ed_sis.domain.models.Campus;
import main.ed_sis.domain.models.Curso;
import main.ed_sis.domain.models.Edital;

public class CadastroCurso extends JFrame {

	private JPanel contentPane;
	private Campus[] campusLista;
	private JTextField JTextFieldNome;
	private JTextField JTextFieldSemestre;



	public CadastroCurso() {
		CampusManipuladorArquivo manipulaCampus = new CampusManipuladorArquivo();
		try {
			campusLista = manipulaCampus.getAllCampus().toArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Cadastro de Curso	");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 5, 105, 15);
		contentPane.add(btnVoltar);

		

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(24, 33, 150, 16);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);

		JTextFieldNome = new JTextField();
		JTextFieldNome.setBounds(24, 60, 375, 26);
		contentPane.add(JTextFieldNome);
		JTextFieldNome.setColumns(10);

		JLabel labelSemestre = new JLabel("Semestre");
		labelSemestre.setBounds(24, 95, 148, 16);
		contentPane.add(labelSemestre);

		JTextFieldSemestre = new JTextField();
		JTextFieldSemestre.setColumns(10);
		JTextFieldSemestre.setBounds(24, 115, 150, 26);
		contentPane.add(JTextFieldSemestre);

		JComboBox comboBox_campus = new JComboBox();
		comboBox_campus.setBounds(190, 115, 225, 27);
		for (Campus campus : campusLista) {
			comboBox_campus.addItem(campus.getNome());
		}
		contentPane.add(comboBox_campus);

		JLabel lblCampus = new JLabel("Escolha um Campus");
		lblCampus.setBounds(190, 95, 162, 16);

		contentPane.add(lblCampus);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((JTextFieldNome.getText() == null || JTextFieldNome.getText().isEmpty())
						|| (JTextFieldSemestre.getText() == null || JTextFieldSemestre.getText().isEmpty())
						|| (comboBox_campus.getSelectedIndex() == -1)) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					Curso curso = new Curso();
					curso.setNome(JTextFieldNome.getText());
					curso.setSemestre(Integer.parseInt(JTextFieldSemestre.getText()));
					
					Integer idCampus = null;
					for (Campus campus : campusLista) {
						if (campus.getNome().equals(comboBox_campus.getSelectedItem().toString())) {
							idCampus = campus.getId();
						}
					}
					curso.setId_campus(idCampus);
					CursoManipuladorArquivo manipula = new CursoManipuladorArquivo();
					try {
						manipula.insertCurso(curso);
						JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso.");
						CloseFrame();
					} catch (IOException e1) {

						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro. Revise seus dados e tente novamente");
					}

				}
			}
		});
		btnNewButton.setBounds(300, 170, 117, 29);
		contentPane.add(btnNewButton);
		
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
