package Biblioteca;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Listagens extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listagens frame = new Listagens();
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
	public Listagens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		class TextAreaOutputStream extends OutputStream {
		    private JTextArea textControl;

		    /**
		     * Creates a new instance of TextAreaOutputStream which writes
		     * to the specified instance of javax.swing.JTextArea control.
		     *
		     * @param control   A reference to the javax.swing.JTextArea
		     *                  control to which the output must be redirected
		     *                  to.
		     */
		    public TextAreaOutputStream(JTextArea control) {
		        textControl = control;
		    }


		    /**
		     * Writes the specified byte as a character to the
		     * javax.swing.JTextArea.
		     *
		     * @param   b   The byte to be written as character to the
		     *              JTextArea.
		     */
		    public void write(int b) throws IOException {
		        // append the data as characters to the JTextArea control
		        textControl.append(String.valueOf((char)b));
		        
		    }  
		}


		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione pesquisa", "Listar todas as publica\u00E7\u00F5es por tema", "Listar todas as publica\u00E7\u00F5es por autores", "Listar todas as publica\u00E7\u00F5es em ordem alfab\u00E9tica", "Listar todos os artigos que constituem anais de confer\u00EAncia", "Listar todos os artigos que constituem peri\u00F3dicos"}));
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		JTextArea txtListas = new JTextArea();
		txtListas.setText("");
		contentPane.add(txtListas, BorderLayout.CENTER);
		
		PrintStream out = new PrintStream(new TextAreaOutputStream(txtListas));

		// redirect standard output stream to the TextAreaOutputStream
		System.setOut(out);

		// redirect standard error stream to the TextAreaOutputStream
		System.setErr(out);

		class ItemChangeListener implements ItemListener{
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		    	   String selecao = comboBox.getSelectedItem().toString();

		    	   if(selecao == "Listar todas as publica\u00E7\u00F5es por tema") {
		    		   Object item = event.getItem();
		    		   Pesquisas.listarPublicacoesTema();
		    	   } 
		    	   else if(selecao == "Listar todas as publica\u00E7\u00F5es por autores") {
		    		   Object item = event.getItem();
		    		   Pesquisas.listarAutores();
		    	   } 
		    	   else if(selecao == "Listar todas as publica\u00E7\u00F5es em ordem alfab\u00E9tica") {
		    		   Object item = event.getItem();
		    		   Pesquisas.listarPublicacoesTitulo();
		    	   }
		    	   else if (selecao == "Listar todos os artigos que constituem anais de confer\\u00EAncia"){
		    		   Object item = event.getItem();
		    		   Pesquisas.listarArtigosAnais();
		    		}
		    	   else if (selecao == "Listar todos os artigos que constituem peri\\\\u00F3dicos") {		   
		    	   		Object item = event.getItem();
		    	     	Pesquisas.listarArtigosPeriodicos();
		    	   }
		       }
		    }       
		}

		comboBox.addItemListener(new ItemChangeListener());

		
	}

}
