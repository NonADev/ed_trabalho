package main.ed_sis.domain.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	public MenuAdmin() {
		setTitle("Menu Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 130, 23);
		contentPane.add(btnVoltar);

		JButton btnCampus = new JButton("Campus");
		btnCampus.setBounds(170, 35, 130, 23);
		contentPane.add(btnCampus);

		JButton btnCurso = new JButton("Curso");
		btnCurso.setBounds(170, 91, 130, 23);
		contentPane.add(btnCurso);

		JButton btnEdital = new JButton("Edital");
		btnEdital.setBounds(170, 147, 130, 23);
		contentPane.add(btnEdital);
		
		JButton btnDoc = new JButton("Documentos");
		btnDoc.setBounds(170, 200, 130, 23);
		contentPane.add(btnDoc);


		btnCampus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new CadastroCampus().setVisible(true);
			}
		});

		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new CadastroCurso().setVisible(true);
			}
		});

		btnEdital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new CadastroEdital().setVisible(true);
			}
		});
		
		btnDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new SelecionaDocumento().setVisible(true);
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new TelaDeLogin().setVisible(true);

			}
		});

	}

	public void CloseFrame() {
		super.dispose();
	}
}