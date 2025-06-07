package gui;

import arreglos.*;
import clases.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsultaCurso extends JDialog implements ActionListener {
	private static final long serialVersionUID=1L;
	private JLabel lblNewLabel;
	private JComboBox<Integer> cboCodigo; //Especifique que tipo de dato es (En este caso un integer)
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaCurso dialog = new DlgConsultaCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaCurso() {
		setTitle("CONSULTA CURSOS");
		setBounds(100, 100, 509, 300);
		getContentPane().setLayout(null);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);

		
		lblNewLabel = new JLabel("C\u00F3digo de curso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 18, 115, 15);
		getContentPane().add(lblNewLabel);
		
		cboCodigo = new JComboBox<Integer>();
		cboCodigo.setBounds(124, 16, 115, 21);
		getContentPane().add(cboCodigo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(388, 13, 97, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 475, 204);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		listarCboCodigo();
	}
	
	//declaraciones globales
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		try {
			txtResultado.setText("");
			listar();
			cboCodigo.requestFocus();
		} catch (Exception error) {
			mensaje("Seleccione un codigo de curso");
		}
	}
	
	//M�todos tipo void (sin par�metros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Curso c = ac.buscar(leerCurso());
		imprimir("CODIGO               : " + c.getCodCurso());
		imprimir("ASIGNATURA           : " + c.getAsignatura());
		imprimir("CICLO                : " + nombreCiclo(c.getCiclo()));
		imprimir("CANTIDAD DE CREDITOS : " + c.getCreditos());
		imprimir("CANTIDAD DE HORAS    : " + c.getHoras());
		imprimir("----------------------------------------------------------");
		int x = 0;
		for (int i = 0; i < am.tamaño(); i++) {
			if (am.obtener(i).getCodigoCurso() == c.getCodCurso())
				x++;
		}
		if (x == 0) imprimir("NO HAY ALUMNOS MATRICULADOS");
		else if (x == 1) imprimir("HAY " + x + " ALUMNO MATRICULADO");
		else imprimir("HAY " + x + " ALUMNOS MATRICULADOS");
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigo.addItem(ac.obtener(i).getCodCurso());
		}
		cboCodigo.setSelectedIndex(-1);
	}
	String nombreCiclo(int i) {
		switch (i) {
			case 0: return "PRIMERO";
			case 1: return "SEGUNDO";
			case 2: return "TERCERO";
			case 3: return "CUARTO";
			case 4: return "QUINTO";
			case 5: return "SEXTO";
			default:return null;
		}
	}
//  M�todos tipo void (con par�metros)
	void imprimir(String s){
		txtResultado.append(s + "\n"); 
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//otros metodos
	public int leerCurso() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
}
