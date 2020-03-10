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

public class Formulario2 extends JFrame {

	private JPanel contentPane;
	private JTextField autor;
	private JTextField numPaginas;
	private JTextField edicao;
	private JTextField editora;
	private JTextField ano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario2 frame = new Formulario2();
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
	public Formulario2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivroDeCaptulos = new JLabel("Livro de Cap\u00EDtulos");
		lblLivroDeCaptulos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLivroDeCaptulos.setBounds(150, 11, 157, 14);
		contentPane.add(lblLivroDeCaptulos);
		
		JLabel lblNewLabel = new JLabel("Autor");
		lblNewLabel.setBounds(24, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		autor = new JTextField();
		autor.setBounds(133, 33, 195, 20);
		contentPane.add(autor);
		autor.setColumns(10);
		
		JLabel lblQuantidadeDePginas = new JLabel("N\u00BA de p\u00E1ginas");
		lblQuantidadeDePginas.setBounds(24, 67, 94, 14);
		contentPane.add(lblQuantidadeDePginas);
		
		numPaginas = new JTextField();
		numPaginas.setBounds(133, 64, 86, 20);
		contentPane.add(numPaginas);
		numPaginas.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Edi\u00E7\u00E3o");
		lblNewLabel_1.setBounds(24, 101, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		edicao = new JTextField();
		edicao.setBounds(133, 98, 86, 20);
		contentPane.add(edicao);
		edicao.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(24, 132, 46, 14);
		contentPane.add(lblEditora);
		
		editora = new JTextField();
		editora.setBounds(133, 129, 157, 20);
		contentPane.add(editora);
		editora.setColumns(10);
		
		JLabel lblAnoPublicao = new JLabel("Ano publica\u00E7\u00E3o");
		lblAnoPublicao.setBounds(24, 167, 114, 14);
		contentPane.add(lblAnoPublicao);
		
		ano = new JTextField();
		ano.setBounds(133, 164, 86, 20);
		contentPane.add(ano);
		ano.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setTitulo = " ";
				try {
					setTitulo = UltimoID.getUltimoTitulo();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar titulo!");
				}
				String setAutor = autor.getText();
				int setNumPaginas = Integer.parseInt(numPaginas.getText());
				int setNumEdicao = Integer.parseInt(edicao.getText());
				String setEditora = editora.getText();
				int setAnoPubli = Integer.parseInt(ano.getText());
				
				boolean existeAutor = false;
		        List<Autor> autores = Pesquisas.getLista();
		        for (Autor autor : autores) {
		        	if(autor.getNome_autor() == (setAutor)){
				        existeAutor = true; 
		        	} 
		        }

		        if(!existeAutor) {
					try {
						InserirPublicacao.novoAutor(setAutor);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Erro ao inserir autor!");
					}
		        }

				try {
					InserirPublicacao.novoLivroCap(setTitulo, setAutor,setNumPaginas, setNumEdicao, setEditora, setAnoPubli);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao inserir livro!");
				}
				
				try {
					InserirPublicacao.novoAutorLivros(setAutor, setTitulo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao inserir livro!");
				}
				JOptionPane.showMessageDialog(null, "Sucesso!");

			}
		});
		btnNewButton.setBounds(290, 213, 89, 23);
		contentPane.add(btnNewButton);
	}
}
