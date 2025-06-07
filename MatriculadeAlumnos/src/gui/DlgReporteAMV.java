package gui;

import arreglos.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class DlgReporteAMV extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteAMV dialog = new DlgReporteAMV();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteAMV() {
		setTitle("ALUMNOS CON MATR\u00CDCULA VIGENTE");
		setBounds(100, 100, 624, 592);
		getContentPane().setLayout(null);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(254, 10, 103, 28);
		getContentPane().add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 48, 590, 497);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
	}
	
	//DECLARACION GLOBAL
	ArregloAlumnos aa = new ArregloAlumnos();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtResultado.setText("");
		for (int i = 0; i < aa.tamaño(); i++) {
			if (aa.obtener(i).getEstado() == 1) {
				imprimir(" CODIGO    : " + aa.obtener(i).getCodAlumno());
				imprimir(" NOMBRES   : " + aa.obtener(i).getNombres());
				imprimir(" APELLIDOS : " + aa.obtener(i).getApellidos());
				imprimir(" DNI       : " + aa.obtener(i).getDni());
				imprimir(" EDAD      : " + aa.obtener(i).getEdad());
				imprimir(" CELULAR   : " + aa.obtener(i).getCelular());
				imprimir(" ESTADO    : " + nombreEstado(aa.obtener(i).getEstado()));
				imprimir("-------------------------------------------------------------------------");
			}
		}
	}
	
	String nombreEstado(int i) {
		switch (i) {
		case 0: return "REGISTRADO";
		case 1: return "MATRICULADO";
		case 2: return "RETIRADO";
		default: return null;
		}
	}
	
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
}
