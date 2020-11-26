package main.ed_sis.domain.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.ed_sis.domain.models.Usuario;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;

	public MenuUsuario(Usuario usuario) {
		
		this.usuario = usuario;
		
		setTitle("Menu Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 130, 23);
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar em Edital");
		btnCadastrar.setBounds(130, 110, 180, 50);
		contentPane.add(btnCadastrar);

	

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new CadastroCampus().setVisible(true);
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
		new CadastroDocumento(usuario).setVisible(true);
	}
}