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

public class CadastroEdital extends JFrame {

	private JPanel contentPane;
	private Campus[] campusLista;
	private Curso[] cursoLista;
	private JTextField JTextFieldDefCurso;
	private JTextField JTextFieldPubAlvo;
	private JTextField JTextFieldPeriodoInsc;
	private JTextField JTextFieldQntdVagasAmplas;
	private JTextField JTextFieldQntdVagasAfirmativas;
	private JTextField JTextFieldQntdVagasDef;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CadastroEdital frame = new CadastroEdital();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CadastroEdital() {
		CampusManipuladorArquivo manipulaCampus = new CampusManipuladorArquivo();
		CursoManipuladorArquivo manipulaCurso = new CursoManipuladorArquivo();
		try {
			campusLista = manipulaCampus.getAllCampus().toArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Cadastro de Edital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 5, 105, 15);
		contentPane.add(btnVoltar);

		

		JLabel lblNewLabel = new JLabel("Definicao do Curso:");
		lblNewLabel.setBounds(24, 33, 150, 16);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);

		JTextFieldDefCurso = new JTextField();
		JTextFieldDefCurso.setBounds(24, 60, 375, 26);
		contentPane.add(JTextFieldDefCurso);
		JTextFieldDefCurso.setColumns(10);

		JLabel labelPubAlvo = new JLabel("Publico Alvo:");
		labelPubAlvo.setBounds(24, 95, 148, 16);
		contentPane.add(labelPubAlvo);

		JTextFieldPubAlvo = new JTextField();
		JTextFieldPubAlvo.setColumns(10);
		JTextFieldPubAlvo.setBounds(24, 115, 150, 26);
		contentPane.add(JTextFieldPubAlvo);

		JLabel labelPeriodo = new JLabel("Periodo de Inscrição");
		labelPeriodo.setBounds(190, 95, 150, 16);
		contentPane.add(labelPeriodo);

		JTextFieldPeriodoInsc = new JTextField();
		JTextFieldPeriodoInsc.setColumns(10);
		JTextFieldPeriodoInsc.setBounds(190, 115, 210, 26);
		contentPane.add(JTextFieldPeriodoInsc);

		JLabel labelVagas = new JLabel("Qntd. vagas:");
		labelVagas.setBounds(24, 150, 168, 16);
		contentPane.add(labelVagas);
		
		JLabel labelAmplas = new JLabel("Amplas:");
		labelAmplas.setBounds(24, 175, 168, 16);
		contentPane.add(labelAmplas);

		JTextFieldQntdVagasAmplas = new JTextField();
		JTextFieldQntdVagasAmplas.setColumns(10);
		JTextFieldQntdVagasAmplas.setBounds(120, 175, 50, 26);
		contentPane.add(JTextFieldQntdVagasAmplas);

		JLabel labelAfirmativas = new JLabel("Afirmativas");
		labelAfirmativas.setBounds(24, 215, 168, 16);
		contentPane.add(labelAfirmativas);

		JTextFieldQntdVagasAfirmativas = new JTextField();
		JTextFieldQntdVagasAfirmativas.setColumns(10);
		JTextFieldQntdVagasAfirmativas.setBounds(120, 215, 50, 26);
		contentPane.add(JTextFieldQntdVagasAfirmativas);

		JLabel labelDeficientes = new JLabel("Deficientes");
		labelDeficientes.setBounds(24, 255, 168, 16);
		contentPane.add(labelDeficientes);

		JTextFieldQntdVagasDef = new JTextField();
		JTextFieldQntdVagasDef.setColumns(10);
		JTextFieldQntdVagasDef.setBounds(120, 255, 50, 26);
		contentPane.add(JTextFieldQntdVagasDef);

		JComboBox comboBox_campus = new JComboBox();
		comboBox_campus.setBounds(190, 185, 225, 27);
		for (Campus campus : campusLista) {
			comboBox_campus.addItem(campus.getNome());
		}
		contentPane.add(comboBox_campus);

		JLabel lblCampus = new JLabel("Escolha um Campus");
		lblCampus.setBounds(190, 160, 162, 16);
		
		contentPane.add(lblCampus);

		JLabel lblCurso = new JLabel("Escolha um Curso");
		lblCurso.setBounds(190, 225, 162, 16);
		contentPane.add(lblCurso);

		JComboBox comboBox_curso = new JComboBox();
		comboBox_curso.setBounds(190, 255, 225, 27);
		contentPane.add(comboBox_curso);
		
		comboBox_campus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				for (Campus campus : campusLista) {
					if (campus.getNome().equals(comboBox_campus.getSelectedItem().toString())) {
						try {
							cursoLista = manipulaCurso.findByCampusId(((int) (long) campus.getId()));
							for (Curso curso : cursoLista) {
								System.out.println(curso);
							}
							comboBox_curso.removeAllItems();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Erro. Não foi possivel carregar cursos");
							e.printStackTrace();
						}
						for (Curso curso : cursoLista) {
							System.out.println(curso.getNome());
							comboBox_curso.addItem(curso.getNome());
						}
					}
				}

			}
		});
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((JTextFieldDefCurso.getText() == null || JTextFieldDefCurso.getText().isEmpty())
						|| (JTextFieldPubAlvo.getText() == null || JTextFieldPubAlvo.getText().isEmpty())
						|| (JTextFieldPeriodoInsc.getText() == null || JTextFieldPeriodoInsc.getText().isEmpty())
						|| (JTextFieldQntdVagasAmplas == null || JTextFieldQntdVagasAmplas.getText().isEmpty())
						|| (JTextFieldQntdVagasAfirmativas.getText() == null
								|| JTextFieldQntdVagasAfirmativas.getText().isEmpty())
						|| (JTextFieldQntdVagasDef.getText() == null || JTextFieldQntdVagasDef.getText().isEmpty()) 
						|| (comboBox_campus.getSelectedIndex() == -1) || (comboBox_curso.getSelectedIndex() == -1)) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					Edital edital = new Edital();
					edital.setDefinicao_curso(JTextFieldDefCurso.getText());
					edital.setPublico_alvo(JTextFieldPubAlvo.getText());
					edital.setPeriodo_inscricao(JTextFieldPeriodoInsc.getText());
					edital.setQtd_vagas_ampla(Integer.parseInt(JTextFieldQntdVagasAmplas.getText()));
					edital.setQtd_vagas_afirmativas(Integer.parseInt(JTextFieldQntdVagasAfirmativas.getText()));
					edital.setQtd_vagas_deficientes(Integer.parseInt(JTextFieldQntdVagasDef.getText()));

					Integer idCampus = null;
					for (Campus campus : campusLista) {
						if (campus.getNome().equals(comboBox_campus.getSelectedItem().toString())) {
							idCampus = campus.getId();
						}
					}
					
					Integer idCurso = null;
					for (Curso curso : cursoLista) {
						if (curso.getNome().equals(comboBox_curso.getSelectedItem().toString())) {
							idCurso = curso.getId();
						}
					}
					edital.setId_campus(idCampus);
					edital.setId_curso(idCurso);
					
					EditalManipuladorArquivo manipula = new EditalManipuladorArquivo();
					try {
						manipula.insertEdital(edital);
						JOptionPane.showMessageDialog(null, "Edital cadastrado com sucesso.");
						CloseFrame();
					} catch (IOException e1) {

						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro. Revise seus dados e tente novamente");
					}

				}
			}
		});
		btnNewButton.setBounds(300, 320, 117, 29);
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
