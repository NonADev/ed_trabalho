package main.ed_sis.domain.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.ed_sis.domain.controllers.DocumentoManipuladorArquivo;
import main.ed_sis.domain.models.Documento;

public class VisualizaDocumentos extends JFrame {

	private JPanel contentPane;
	private Documento[] documentoLista;
	private Integer idEdital;
	private JTable table;
	private static boolean canOpen = true;

	public VisualizaDocumentos(){}

	public void mostrarDocumentos(Integer idEdital) throws IOException{
		if (!canOpen) return;
		canOpen = false;
		JFrame f = new JFrame();

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				canOpen = true;
			}
		});

		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		f.setTitle("Documentos ");

		DocumentoManipuladorArquivo manipulaDocumento = new DocumentoManipuladorArquivo();
		documentoLista = manipulaDocumento.findByEditalId(idEdital);
		String[][] data = new String[documentoLista.length][4];
		for (int i = 0; i < documentoLista.length; i++) {
			data[i][0] = documentoLista[i].getId().toString();
			data[i][1] = documentoLista[i].getNome();
			data[i][2] = documentoLista[i].getValor();
			data[i][3] = documentoLista[i].getId_usuario().toString();
		}

		String[] columnNames = { "ID", "Nome", "Valor", "id_aluno" };

		// Initializing the JTable
		JTable j = new JTable(data, columnNames);
		j.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		f.setVisible(true);

		new VisualizaDocumentos(idEdital);
	}

	public VisualizaDocumentos(Integer idEdital) throws IOException {
		if (!canOpen) return;
		canOpen = false;
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		f.setTitle("Documentos ");

		DocumentoManipuladorArquivo manipulaDocumento = new DocumentoManipuladorArquivo();
		documentoLista = manipulaDocumento.findByEditalId(idEdital);
		String[][] data = new String[documentoLista.length][4];
		for (int i = 0; i < documentoLista.length; i++) {
			data[i][0] = documentoLista[i].getId().toString();
			data[i][1] = documentoLista[i].getNome();
			data[i][2] = documentoLista[i].getValor();
			data[i][3] = documentoLista[i].getId_usuario().toString();
		}

		String[] columnNames = { "ID", "Nome", "Valor", "id_aluno" };

		// Initializing the JTable
		JTable j = new JTable(data, columnNames);
		j.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		f.setVisible(true);

		new VisualizaDocumentos(idEdital);
	}
	public VisualizaDocumentos(Integer idEdital, boolean a) {
		this.idEdital = idEdital;
		DocumentoManipuladorArquivo manipulaDocumento = new DocumentoManipuladorArquivo();
		try {
			documentoLista = manipulaDocumento.findByEditalId(idEdital);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar Documentos");
			e.printStackTrace();
		}
		setTitle("Visualiza documentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 5, 105, 15);
		contentPane.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();

			}
		});

		String[] columnNames = { "ID", "Nome", "Valor", "id_aluno" };
		String[][] aux = new String[documentoLista.length][4];
		for (int i = 0; i < documentoLista.length; i++) {
			aux[i][0] = documentoLista[i].getId().toString();
			aux[i][1] = documentoLista[i].getNome();
			aux[i][2] = documentoLista[i].getValor();
			aux[i][3] = documentoLista[i].getId_usuario().toString();
		}
		
	    String data[][]={ {documentoLista[0].getId().toString(), documentoLista[0].getNome(), documentoLista[0].getValor(), documentoLista[0].getId_usuario().toString()},    
                };             
		 JTable jt=new JTable(data,columnNames);    
		    jt.setBounds(10,10,200,300);          
		    JScrollPane sp=new JScrollPane(jt);    
		    contentPane.add(sp);          
	}

	public void CloseFrame() {
		super.dispose();
		new SelecionaDocumento().setVisible(true);
	}
}
