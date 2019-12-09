package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtuloDaPublicao = new JLabel("T\u00EDtulo da Publica\u00E7\u00E3o");
		lblTtuloDaPublicao.setBounds(25, 14, 156, 14);
		contentPane.add(lblTtuloDaPublicao);

		textField = new JTextField();
		textField.setBounds(191, 11, 171, 20);
		contentPane.add(textField);
		textField.setColumns(10);
				
		JLabel lblTipoDePublicao = new JLabel("Tipo de Publica\u00E7\u00E3o");
		lblTipoDePublicao.setBounds(25, 49, 109, 14);
		contentPane.add(lblTipoDePublicao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "LIVROCAP", "LIVROART", "LIVROANAIS", "PERIODICO", "MONOGRAFIA", "ARTDELIVRO", "ARTDEANAIS", "ARTDEPERIODICO"}));
		comboBox.setBounds(191, 42, 171, 22);
		contentPane.add(comboBox);
		
		JLabel lblNFolder = new JLabel("N\u00BA Folder");
		lblNFolder.setBounds(25, 85, 81, 14);
		contentPane.add(lblNFolder);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 82, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDigital = new JLabel("Digital");
		lblDigital.setBounds(25, 121, 48, 14);
		contentPane.add(lblDigital);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sim");
		chckbxNewCheckBox.setBounds(191, 117, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		JLabel lblArmrio = new JLabel("Arm\u00E1rio");
		lblArmrio.setBounds(25, 160, 48, 14);
		contentPane.add(lblArmrio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 157, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
				
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinuar.setBounds(191, 204, 128, 23);
		contentPane.add(btnContinuar);
	}
}
