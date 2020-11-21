package main.ed_sis.domain.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	public MenuAdmin() {
		setTitle("Menu Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * JButton btnVoltar = new JButton("Voltar"); btnVoltar.setBounds(10, 10, 109,
		 * 23); contentPane.add(btnVoltar);
		 * 
		 * JButton btnQuestoes = new JButton("Questões"); btnQuestoes.setBounds(170, 35,
		 * 109, 23); contentPane.add(btnQuestoes);
		 * 
		 * 
		 * JButton btnMateria = new JButton("Matéria"); btnMateria.setBounds(170, 91,
		 * 109, 23); contentPane.add(btnMateria);
		 * 
		 * 
		 * JButton btnDisciplina = new JButton("Disciplina");
		 * btnDisciplina.setBounds(170, 147, 109, 23); contentPane.add(btnDisciplina);
		 * 
		 * 
		 * 
		 * btnQuestoes.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CloseFrame(); new
		 * CadastroQuestao().setVisible(true); } });
		 * 
		 * btnMateria.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CloseFrame(); new
		 * CadastroMateria().setVisible(true); } });
		 * 
		 * btnDisciplina.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CloseFrame(); new
		 * CadastroDisciplina().setVisible(true); } });
		 * 
		 * btnVoltar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CloseFrame(); new
		 * TelaDeLogin().setVisible(true);
		 * 
		 * } });
		 */
	}

	public void CloseFrame() {
		super.dispose();
	}
}