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

public class SelecionaDocumento extends JFrame {

	private JPanel contentPane;
	private Campus[] campusLista;
	private Curso[] cursoLista;
	private Edital[] editalLista;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelecionaDocumento frame = new SelecionaDocumento();
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
	public SelecionaDocumento() {
		CampusManipuladorArquivo manipulaCampus = new CampusManipuladorArquivo();
		CursoManipuladorArquivo manipulaCurso = new CursoManipuladorArquivo();
		EditalManipuladorArquivo manipulaEdital = new EditalManipuladorArquivo();
		try {
			campusLista = manipulaCampus.getAllCampus().toArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Seleciona Documento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 5, 105, 15);
		contentPane.add(btnVoltar);

		JComboBox comboBox_campus = new JComboBox();
		comboBox_campus.setBounds(140, 90, 225, 27);
		for (Campus campus : campusLista) {
			comboBox_campus.addItem(campus.getNome());
		}
		contentPane.add(comboBox_campus);

		JLabel lblCampus = new JLabel("Escolha um Campus");
		lblCampus.setBounds(140, 60, 162, 16);

		contentPane.add(lblCampus);

		JLabel lblCurso = new JLabel("Escolha um Curso");
		lblCurso.setBounds(140, 130, 162, 16);
		contentPane.add(lblCurso);

		JComboBox comboBox_curso = new JComboBox();
		comboBox_curso.setBounds(140, 160, 225, 27);
		contentPane.add(comboBox_curso);

		JLabel lblEdital = new JLabel("Escolha um Edital");
		lblEdital.setBounds(140, 190, 162, 16);
		contentPane.add(lblEdital);

		JComboBox comboBox_edital = new JComboBox();
		comboBox_edital.setBounds(140, 220, 225, 27);
		contentPane.add(comboBox_edital);

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

		comboBox_curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (comboBox_curso.getSelectedItem() != null) {

					for (Curso curso : cursoLista) {
						if (curso.getNome().equals(comboBox_curso.getSelectedItem().toString())) {
							try {
								editalLista = manipulaEdital.getAllEditalByCursoId(((int) (long) curso.getId()))
										.toArray();

								comboBox_edital.removeAllItems();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "Erro. Não foi possivel carregar cursos");
								e.printStackTrace();
							}
							for (Edital edital : editalLista) {

								comboBox_edital.addItem(edital.getDefinicao_curso());
							}
						}
					}

				} else {
					comboBox_edital.removeAllItems();
				}
			}
		});

		JButton btnNewButton = new JButton("Visualizar Documentos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_edital.getSelectedIndex() == -1 || comboBox_curso.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Erro. Selecione um edital para visualizar documentos");
				} else {

					Integer idEdital = null;
					for (Edital edital : editalLista) {
						if (edital.getDefinicao_curso().equals(comboBox_edital.getSelectedItem().toString())) {
							idEdital = edital.getId();
						}
					}
					try {
						OpenDoc(idEdital);
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(150, 290, 200, 29);
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

	public void OpenDoc(Integer idEdital) throws IOException {
//		super.dispose();
//		new VisualizaDocumentos(idEdital).setVisible(true);
		new VisualizaDocumentos().mostrarDocumentos(idEdital);
	}
}
