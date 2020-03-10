package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPesquisar = new JButton("Pesquisar Publica\u00E7\u00F5es");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				new Listagens().setVisible(true); 
			}
		});
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnPesquisar.setBounds(90, 118, 248, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnInserirNovaPublicao = new JButton("Inserir Nova Publica\u00E7\u00E3o");
		btnInserirNovaPublicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				new Formulario().setVisible(true); 
			}
		});
		btnInserirNovaPublicao.setBounds(90, 61, 248, 23);
		contentPane.add(btnInserirNovaPublicao);
		
		JLabel lblBiblioteca = new JLabel("Biblioteca");
		lblBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBiblioteca.setBounds(170, 24, 180, 15);
		contentPane.add(lblBiblioteca);
	}
}
