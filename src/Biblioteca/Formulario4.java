package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Formulario4 extends JFrame {

	private JPanel contentPane;
	private JTextField editora;
	private JTextField pais;
	private JTextField cidade;
	private JTextField estado;
	private JTextField volume;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario4 frame = new Formulario4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivroDeCaptulos = new JLabel("Livro de Anais");
		lblLivroDeCaptulos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLivroDeCaptulos.setBounds(150, 11, 157, 14);
		contentPane.add(lblLivroDeCaptulos);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(24, 39, 46, 14);
		contentPane.add(lblEditora);
		
		editora = new JTextField();
		editora.setBounds(133, 36, 157, 20);
		contentPane.add(editora);
		editora.setColumns(10);
		
		JLabel lblpais = new JLabel("Pa\u00EDs");
		lblpais.setBounds(24, 151, 114, 14);
		contentPane.add(lblpais);
		
		pais = new JTextField();
		pais.setBounds(133, 148, 157, 20);
		contentPane.add(pais);
		pais.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setTitulo = " ";
				try {
					setTitulo = UltimoID.getUltimoTitulo();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar titulo!");
				}
				
				String setEditora = editora.getText();
				String setCidade = cidade.getText();
				String setEstado = estado.getText();
				String setPais = pais.getText();
				int setVolume = Integer.parseInt(volume.getText());
				
				try {
					InserirPublicacao.novoLivroAnais(setTitulo, setEditora,setCidade, setEstado, setPais, setVolume);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao inserir livro!");
				}
				
				JOptionPane.showMessageDialog(null, "Sucesso!");

			}
		});
		btnNewButton.setBounds(290, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblcidade = new JLabel("Cidade");
		lblcidade.setBounds(24, 74, 48, 14);
		contentPane.add(lblcidade);
		
		cidade = new JTextField();
		cidade.setBounds(133, 71, 157, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		JLabel lblestado = new JLabel("Estado");
		lblestado.setBounds(24, 110, 48, 14);
		contentPane.add(lblestado);
		
		estado = new JTextField();
		estado.setBounds(133, 107, 157, 20);
		contentPane.add(estado);
		estado.setColumns(10);
		
		JLabel lblvolume = new JLabel("Volume");
		lblvolume.setBounds(24, 191, 48, 14);
		contentPane.add(lblvolume);
		
		volume = new JTextField();
		volume.setBounds(133, 188, 96, 20);
		contentPane.add(volume);
		volume.setColumns(10);
	}
}
