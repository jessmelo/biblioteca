package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.print.attribute.AttributeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.io.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	protected static String titulolivro = null;
	private JPanel contentPane;
	private JTextField tituloPubli;
	private JTextField numFolder;
	private JTextField armarioPubli;
	private JTextField localPubli;

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

		tituloPubli = new JTextField();
		tituloPubli.setBounds(191, 11, 171, 20);
		contentPane.add(tituloPubli);
		tituloPubli.setColumns(10);
				
		tituloPubli.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (tituloPubli.getText().length() >= 250 ) 
		            e.consume(); 
		    }  
		});

		JLabel lblTipoDePublicao = new JLabel("Tipo de Publica\u00E7\u00E3o");
		lblTipoDePublicao.setBounds(25, 49, 109, 14);
		contentPane.add(lblTipoDePublicao);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "LIVROCAP", "LIVROART", "LIVROANAIS", "PERIODICO", "MONOGRAFIA", "ARTDELIVRO", "ARTDEANAIS", "ARTDEPERIODICO"}));
		comboBoxTipo.setBounds(191, 42, 171, 22);
		contentPane.add(comboBoxTipo);
		
	    DecimalFormat decformat = new DecimalFormat("#####");

		NumberFormatter numberFormatter = new NumberFormatter(decformat);
		numberFormatter.setValueClass(Number.class); 
		numberFormatter.setAllowsInvalid(false); 
		numberFormatter.setMinimum(0l);

		JLabel lblNFolder = new JLabel("N\u00BA Folder");
		lblNFolder.setBounds(25, 85, 81, 14);
		contentPane.add(lblNFolder);
		numFolder = new JFormattedTextField(numberFormatter);
		numFolder.setBounds(191, 82, 96, 20);
		contentPane.add(numFolder);
		numFolder.setColumns(10);
		
		
		numFolder.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (numFolder.getText().length() >= 5 ) // limit textfield to 5 characters
		            e.consume(); 
		    }  
		});

		JLabel lblDigital = new JLabel("Digital");
		lblDigital.setBounds(25, 121, 48, 14);
		contentPane.add(lblDigital);
		
		JCheckBox digitalBool = new JCheckBox("Sim");
		digitalBool.setBounds(191, 117, 97, 23);
		contentPane.add(digitalBool);

		JLabel lblArmrio = new JLabel("Arm\u00E1rio");
		lblArmrio.setBounds(25, 160, 48, 14);
		contentPane.add(lblArmrio);
		
		armarioPubli = new JTextField();
		armarioPubli.setBounds(191, 157, 96, 20);
		contentPane.add(armarioPubli);
		armarioPubli.setColumns(10);
						
		armarioPubli.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (armarioPubli.getText().length() >= 15 ) 
		            e.consume(); 
		    }  
		});

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(25, 201, 46, 14);
		contentPane.add(lblLocal);
		
		localPubli = new JTextField();
		localPubli.setBounds(191, 196, 185, 20);
		contentPane.add(localPubli);
		localPubli.setColumns(10);
		
		localPubli.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (localPubli.getText().length() >= 50) 
		            e.consume(); 
		    }  
		});

		
		class ItemChangeListener implements ItemListener{
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		      
		    }       
		}

		comboBoxTipo.addItemListener(new ItemChangeListener());

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(70, 227, 89, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				new Interface().setVisible(true);
			}
		});

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setTitulo = tituloPubli.getText().toString();
				String setTipoPublicacao = comboBoxTipo.getSelectedItem().toString();
				String setArmario = armarioPubli.getText().toString();
				String setLocal = localPubli.getText().toString();
				int setNumFolder = Integer.parseInt(numFolder.getText());
				boolean setDigital = false;
				if(digitalBool.isSelected()) {
					setDigital = true;
				} 
				try {
					InserirPublicacao.novaPublicacao(setTitulo, setTipoPublicacao, setNumFolder, setDigital, setArmario, setLocal);
					if (setTipoPublicacao == "LIVROCAP") {
						titulolivro = setTitulo;
						contentPane.setVisible(false);
						new Formulario2().setVisible(true); 
					}
					if (setTipoPublicacao == "LIVROART") {
						contentPane.setVisible(false);
						new Formulario3().setVisible(true); 
					}
					if (setTipoPublicacao == "LIVROANAIS") {
						contentPane.setVisible(false);
						new Formulario4().setVisible(true); 
					}
					if (setTipoPublicacao == "PERIODICO") {
						contentPane.setVisible(false);
						new Formulario5().setVisible(true); 
					}
					if (setTipoPublicacao == "MONOGRAFIA") {
						contentPane.setVisible(false);
						new Formulario().setVisible(true); 
					}
					if (setTipoPublicacao == "ARTDELIVRO") {
						contentPane.setVisible(false);
						new Formulario().setVisible(true); 
					}
					if (setTipoPublicacao == "ARTDEANAIS") {
						contentPane.setVisible(false);
						new Formulario().setVisible(true); 
					}
					if (setTipoPublicacao == "ARTDEPERIODICO") {
						contentPane.setVisible(false);
						new Formulario().setVisible(true); 
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao fazer inserção!");
				}

			}
		});
		btnContinuar.setBounds(191, 227, 128, 23);
		contentPane.add(btnContinuar);
		
	}
	
}
