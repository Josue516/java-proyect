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
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class DlgConsultaMatricula extends JDialog implements ActionListener {
	private static final long serialVersionUID=1L;
	private JLabel lblNewLabel;
	private JComboBox<Integer> cboCodigo;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaMatricula dialog = new DlgConsultaMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaMatricula() {
		setResizable(false);
		setTitle("CONSULTA MATRICULA");
		setBounds(100, 100, 499, 323);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Número de Matrícula :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 15, 143, 15);
		getContentPane().add(lblNewLabel);
		
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
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 483, 120);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(0, 119, 483, 165);
		getContentPane().add(panel_1);
		
		listarCboCodigo();
	}
	//declaracion global
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	private JPanel panel;
	private JPanel panel_1;
	
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
			imprimir("Seleccione un numero de matricula");
		}
	}
	
	void imprimir(){
		imprimir("");
	}
	//metodo Listar
	void listar() {
		Matricula m = am.buscar(leerCodigo());
		Alumno x = aa.buscar(m.getCodigoAlumno());
		Curso c = ac.buscar(m.getCodigoCurso());
		imprimir("CODIGO        : " + m.getNumeroMatricula());
		switch(x.getEstado()) {
		case 0: imprimir("ESTADO        : REGISTRADO");break;
		case 1: imprimir("ESTADO        : MATRICULADO");break;
		default:imprimir("ESTADO        : RETIRADO");
		}
		imprimir("-------------------------------------------------------");
		imprimir("COD. ALUMNO   : " + x.getCodAlumno());
		imprimir("NOMBRES       : " + x.getNombres());
		imprimir("APELLIDOS     : " + x.getApellidos());
		imprimir("DNI           : " + x.getDni());
		imprimir("EDAD          : " + x.getEdad());
		imprimir("CELULAR       : " + x.getCelular());
		imprimir("-------------------------------------------------------");
		imprimir("COD. CURSO    : " + c.getCodCurso());
		imprimir("ASIGNATURA    : " + c.getAsignatura());
		imprimir("CICLO         : " + nombreCiclo(c.getCiclo()));
		imprimir("CREDITOS      : " + c.getCreditos());
		imprimir("HORAS         : " + c.getHoras());
		txtResultado.setCaretPosition(0);
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboCodigo.addItem(am.obtener(i).getNumeroMatricula());
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
