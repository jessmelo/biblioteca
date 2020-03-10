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

public class Formulario5 extends JFrame {

	private JPanel contentPane;
	private JTextField editora;
	private JTextField primeirovolume;
	private JTextField ultimovolume;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario5 frame = new Formulario5();
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
	public Formulario5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivroDeCaptulos = new JLabel("Peri\u00F3dico");
		lblLivroDeCaptulos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLivroDeCaptulos.setBounds(165, 11, 157, 14);
		contentPane.add(lblLivroDeCaptulos);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(24, 119, 46, 14);
		contentPane.add(lblEditora);
		
		editora = new JTextField();
		editora.setBounds(130, 116, 157, 20);
		contentPane.add(editora);
		editora.setColumns(10);
		
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
				String setPrimeiroVolume = primeirovolume.getText();
				String setUltimoVolume = ultimovolume.getText();
				
				try {
					InserirPublicacao.novoPeriodico(setTitulo, setPrimeiroVolume, setUltimoVolume, setEditora);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao inserir livro!");
				}
				
				JOptionPane.showMessageDialog(null, "Sucesso!");

			}
		});
		btnNewButton.setBounds(290, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblvolume = new JLabel("Primeiro Volume");
		lblvolume.setBounds(24, 39, 99, 14);
		contentPane.add(lblvolume);
		
		primeirovolume = new JTextField();
		primeirovolume.setBounds(130, 36, 96, 20);
		contentPane.add(primeirovolume);
		primeirovolume.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u00DAltimo Volume");
		lblNewLabel.setBounds(24, 80, 139, 14);
		contentPane.add(lblNewLabel);
		
		ultimovolume = new JTextField();
		ultimovolume.setBounds(130, 77, 96, 20);
		contentPane.add(ultimovolume);
		ultimovolume.setColumns(10);
	}
}
