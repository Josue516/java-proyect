package gui;

import arreglos.*;
import clases.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;

public class DlgConsultaAlumno extends JDialog implements ActionListener {
	private static final long serialVersionUID=1L;
	private JButton btnConsultar;
	private JTextArea txtResultado;
	private JComboBox<Integer> cboCodigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaAlumno dialog = new DlgConsultaAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaAlumno() {
		setResizable(false);
		setTitle("CONSULTA ALUMNOS");
		setBounds(100, 100, 500, 323);
		getContentPane().setLayout(null);
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Codigo de alumno:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 19, 122, 14);
		getContentPane().add(lblNewLabel);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(387, 16, 89, 23);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 466, 227);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		cboCodigo = new JComboBox<Integer>();
		cboCodigo.setBounds(142, 16, 94, 23);
		getContentPane().add(cboCodigo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 484, 122);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(0, 122, 484, 162);
		getContentPane().add(panel_1);
		
		listarCboCodigo();
	}
	
	//declaracion global
	ArregloAlumnos aa = new ArregloAlumnos();
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
		}
		catch (Exception error) {
			mensaje("Seleccione un codigo de alumno");
		}
	}
	//imprimir	
	void imprimir(){
		imprimir("");
	}
	
	
	//metodo Listar
	void listar() {
		Alumno x = aa.buscar(leerCodigo());
		imprimir("CODIGO               : " + x.getCodAlumno());
		imprimir("NOMBRES              : " + x.getNombres());
		imprimir("APELLIDOS            : " + x.getApellidos());
		imprimir("DNI                  : " + x.getDni());
		imprimir("EDAD                 : " + x.getEdad());
		imprimir("CELULAR              : " + x.getCelular());
		imprimir("ESTADO               : " + nombreEstado(x.getEstado()));
		imprimir("-------------------------------------------------------");
		if (x.getEstado() != 0) {
			Matricula m = am.buscarCod(leerCodigo());
			Curso c = ac.buscar(m.getCodigoCurso());
			imprimir("ASIGNATURA           : " + c.getAsignatura());
			imprimir("CICLO                : " + nombreCiclo(c.getCiclo()));
			imprimir("CANTIDAD DE CREDITOS : " + c.getCreditos());
			imprimir("HORAS                : " + c.getHoras());
		}
		txtResultado.setCaretPosition(0);
	}
	
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < aa.tamaño(); i++) {
			cboCodigo.addItem(aa.obtener(i).getCodAlumno());
		}
		cboCodigo.setSelectedIndex(-1);
	}
	String nombreEstado(int i) {
		switch (i) {
			case 0: return "REGISTRADO";
			case 1: return "MATRICULADO";
			case 2: return "RETIRADO";
			default:return null;
		}
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
	void imprimir(String s){
		txtResultado.append(s + "\n"); 
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//otros metodos
	public int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
}
