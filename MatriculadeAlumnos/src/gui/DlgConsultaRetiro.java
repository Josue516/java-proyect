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
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsultaRetiro extends JDialog implements ActionListener {
	private static final long serialVersionUID=1L;
	private JLabel lblNmeroDeRetiro;
	private JComboBox<Integer> cboCodigo;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaRetiro dialog = new DlgConsultaRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaRetiro() {
		setTitle("CONSULTA RETIRO");
		setBounds(100, 100, 500, 323);
		getContentPane().setLayout(null);
		
		lblNmeroDeRetiro = new JLabel("N\u00FAmero de retiro:");
		lblNmeroDeRetiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmeroDeRetiro.setBounds(10, 15, 143, 15);
		getContentPane().add(lblNmeroDeRetiro);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);

		
		cboCodigo = new JComboBox<Integer>();
		cboCodigo.setSelectedIndex(-1);
		cboCodigo.setBounds(154, 13, 115, 21);
		getContentPane().add(cboCodigo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(378, 10, 97, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 465, 230);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		listarCboCodigo();
	}
	
	//declaracion global
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	ArregloRetiros ar = new ArregloRetiros();
	
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
			mensaje("Seleccione un n�mero de retiro");
		}
	}
		
	void imprimir(){
		imprimir("");
	}
	//metodo Listar
	void listar() {
		Retiro r = ar.buscar(leerCodigo());
		Matricula m = am.buscar(r.getNumMatricula());
		Alumno x = aa.buscar(m.getCodigoAlumno());
		Curso c = ac.buscar(m.getCodigoCurso());
		imprimir("CODIGO         : " + r.getNumRetiro());
		imprimir("NUM. MATR�CULA : " + m.getNumeroMatricula());
		imprimir("");
		imprimir("COD. ALUMNO    : " + x.getCodAlumno());
		imprimir("NOMBRES        : " + x.getNombres());
		imprimir("APELLIDOS      : " + x.getApellidos());
		imprimir("DNI            : " + x.getDni());
		imprimir("EDAD           : " + x.getEdad());
		imprimir("CELULAR        : " + x.getCelular());
		imprimir("");
		imprimir("COD. CURSO     : " + c.getAsignatura());
		imprimir("CICLO          : " + nombreCiclo(c.getCiclo()));
		imprimir("CREDITOS       : " + c.getCreditos());
		imprimir("HORAS          : " + c.getHoras());
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ar.tamaño(); i++) {
			cboCodigo.addItem(ar.obtener(i).getNumRetiro());
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
	void imprimir(String s){
		txtResultado.append(s + "\n"); 
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	public int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
}
