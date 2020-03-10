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

public class Formulario6 extends JFrame {

	private JPanel contentPane;
	private JTextField local;
	private JTextField ano;
	private JTextField mes;
	private JTextField autor;
	private JTextField instituicao;
	private JTextField codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario6 frame = new Formulario6();
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
	public Formulario6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivroDeCaptulos = new JLabel("Monografia");
		lblLivroDeCaptulos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLivroDeCaptulos.setBounds(165, 11, 157, 14);
		contentPane.add(lblLivroDeCaptulos);
		
		JLabel lblEditora = new JLabel("Local");
		lblEditora.setBounds(24, 95, 46, 14);
		contentPane.add(lblEditora);
		
		local = new JTextField();
		local.setBounds(130, 92, 157, 20);
		contentPane.add(local);
		local.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setTitulo = " ";
				try {
					setTitulo = UltimoID.getUltimoTitulo();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar titulo!");
				}
				
				String setAno = ano.getText();
				String setMes = mes.getText();
				String setLocal = local.getText();
				String setAutor = autor.getText();
				String setInstituicao = instituicao.getText();
				
				try {
					InserirPublicacao.novaMonografia(setTitulo, setAno, setMes, setLocal, setAutor, setInstituicao);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao inserir monografia!");
				}
				
				JOptionPane.showMessageDialog(null, "Sucesso!");

			}
		});
		btnNewButton.setBounds(290, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblvolume = new JLabel("Ano");
		lblvolume.setBounds(24, 39, 99, 14);
		contentPane.add(lblvolume);
		
		ano = new JTextField();
		ano.setBounds(130, 36, 96, 20);
		contentPane.add(ano);
		ano.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("M\u00EAs");
		lblNewLabel.setBounds(24, 70, 139, 14);
		contentPane.add(lblNewLabel);
		
		mes = new JTextField();
		mes.setBounds(130, 61, 96, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(24, 120, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		autor = new JTextField();
		autor.setBounds(130, 123, 167, 20);
		contentPane.add(autor);
		autor.setColumns(10);
		
		instituicao = new JTextField();
		instituicao.setBounds(130, 154, 167, 20);
		contentPane.add(instituicao);
		instituicao.setColumns(10);
		
		codigo = new JTextField();
		codigo.setBounds(130, 187, 96, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
	}
}
