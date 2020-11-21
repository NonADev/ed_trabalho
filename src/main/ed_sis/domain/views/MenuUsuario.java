package main.ed_sis.domain.views;

import main.ed_sis.domain.models.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;

	private Usuario usuario;

	public MenuUsuario(Usuario usuario) {
		this.usuario = usuario;
		setTitle("Menu Usuario");
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
		 * JButton btnProva = new JButton("Prova"); btnProva.setBounds(170, 60, 109,
		 * 23); contentPane.add(btnProva);
		 * 
		 * JButton btnRanking = new JButton("Ranking"); btnRanking.setBounds(170, 120,
		 * 109, 23); contentPane.add(btnRanking);
		 * 
		 * btnProva.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CloseFrame(); new
		 * GerarProva(aluno).setVisible(true); } });
		 * 
		 * btnRanking.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CloseFrame(); new
		 * TelaDeRanking(aluno).setVisible(true); } });
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