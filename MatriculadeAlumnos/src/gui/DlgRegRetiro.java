package gui;

import arreglos.*;
import clases.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgRegRetiro extends JDialog implements ItemListener, ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JComboBox<Integer> cboNumRetiro;
	private JComboBox<Integer> cboNumMatricula;
	private JTextField txtAlumno;
	private JTextField txtCurso;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox<Integer> cboCodigoCurso;
	private JTable tblRetiro;
	private DefaultTableModel modelo;
	private JTextField txtActivoMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegRetiro dialog = new DlgRegRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegRetiro() {
		setTitle("REGISTRO DE RETIROS");
		setBounds(100, 100, 850, 514);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(492, 22, 193, 168);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Número de Retiro:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 22, 136, 15);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Número de matr\u00EDcula:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 57, 136, 15);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Alumno:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 92, 63, 15);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Código del curso:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 127, 136, 15);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Curso:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 162, 63, 15);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Activo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 193, 63, 15);
		getContentPane().add(lblNewLabel_6);
		
		cboNumRetiro = new JComboBox<Integer>();
		cboNumRetiro.addItemListener(this);
		cboNumRetiro.setSelectedIndex(-1);
		cboNumRetiro.setEnabled(false);
		cboNumRetiro.setBounds(156, 22, 152, 21);
		getContentPane().add(cboNumRetiro);
		
		cboNumMatricula = new JComboBox<Integer>();
		cboNumMatricula.addItemListener(this);
		cboNumMatricula.setSelectedIndex(-1);
		cboNumMatricula.setEnabled(false);
		cboNumMatricula.setBounds(156, 55, 152, 21);
		getContentPane().add(cboNumMatricula);
		
		txtAlumno = new JTextField();
		txtAlumno.setText("");
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(83, 91, 225, 19);
		getContentPane().add(txtAlumno);
		
		cboCodigoCurso = new JComboBox<Integer>();
		cboCodigoCurso.addItemListener(this);
		cboCodigoCurso.setSelectedIndex(-1);
		cboCodigoCurso.setEnabled(false);
		cboCodigoCurso.setBounds(156, 125, 152, 21);
		getContentPane().add(cboCodigoCurso);
		
		txtCurso = new JTextField();
		txtCurso.setText("");
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(83, 161, 225, 19);
		getContentPane().add(txtCurso);
		
		txtActivoMatricula = new JTextField();
		txtActivoMatricula.setText("");
		txtActivoMatricula.setEditable(false);
		txtActivoMatricula.setColumns(10);
		txtActivoMatricula.setBounds(83, 192, 69, 19);
		getContentPane().add(txtActivoMatricula);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(10, 227, 142, 27);
		getContentPane().add(btnAceptar);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(166, 227, 142, 27);
		getContentPane().add(btnCancelar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setEnabled(true);
		btnAdicionar.setBounds(722, 22, 104, 33);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setEnabled(true);
		btnModificar.setBounds(722, 82, 104, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setEnabled(true);
		btnEliminar.setBounds(722, 144, 104, 33);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 264, 816, 203);
		getContentPane().add(scrollPane);
		
		tblRetiro = new JTable();
		tblRetiro.addMouseListener(this);
		tblRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiro);
		modelo = new DefaultTableModel();
		modelo.addColumn("N°. RETIRO");
		modelo.addColumn("N°. MAT.");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("FECHA");
		modelo.addColumn("HORA");
		tblRetiro.setModel(modelo);
		
		ajustarColumnas();
		listar();
		deshabilitarTodo();
	}
	
	//DECLARACI�N GLOBAL
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	ArregloRetiros ar = new ArregloRetiros();
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigoCurso) {
			itemStateChangedCboCodigoCurso(e);
		}
		if (e.getSource() == cboNumMatricula) {
			itemStateChangedCboNumMatricula(e);
		}
		if (e.getSource() == cboNumRetiro) {
			itemStateChangedCboNumRetiro(e);
		}
	}
	protected void itemStateChangedCboNumRetiro(ItemEvent e) {
		try {
			int numRetiro = leerNumeroRetiro();
			Retiro buscadoR = ar.buscar(numRetiro);
			Matricula buscadoM = am.buscar(buscadoR.getNumMatricula());
			cboNumMatricula.setSelectedItem(buscadoR.getNumMatricula());
			cboCodigoCurso.setSelectedItem(buscadoM.getCodigoCurso());
			tblRetiro.setRowSelectionInterval(cboNumRetiro.getSelectedIndex(), cboNumRetiro.getSelectedIndex());
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			Matricula buscado = am.buscar(numMatricula);
			txtAlumno.setText(aa.buscar(buscado.getCodigoAlumno()).getNombres()
					+ " " + aa.buscar(buscado.getCodigoAlumno()).getApellidos());
			cboCodigoCurso.setSelectedItem(buscado.getCodigoCurso());
			txtActivoMatricula.setText(activo(aa.buscar(buscado.getCodigoAlumno()).getEstado()));
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboCodigoCurso(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso buscado = ac.buscar(codCurso);
			txtCurso.setText(buscado.getAsignatura());
		} catch (Exception error) {
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int numRetiro = leerNumeroRetiro();
			try {
				int numMatricula = leerNumeroMatricula();
				int codCurso = leerCodigoCurso();
				if (!btnAdicionar.isEnabled()) {
					if (aa.buscar(am.buscar(numMatricula).getCodigoAlumno()).getEstado() == 1) {
						Retiro nuevo = new Retiro(numRetiro, numMatricula, Calendario.fechaActual(), Calendario.horaActual());
						aa.buscar(am.buscar(numMatricula).getCodigoAlumno()).setEstado(2);
						aa.ActualizarArchivo();
						ar.adicionar(nuevo);
						listar();
						mensaje("Nuevo retiro añadido exitosamente");
						deshabilitarTodo();
					} else {
						error("No es posible completar la acción, el alumno ya se encuentra retirado", cboNumMatricula);
					}
				} else if (!btnModificar.isEnabled()) {
						Retiro buscado = ar.buscar(numRetiro);
						am.buscar(buscado.getNumMatricula()).setCodigoCurso(codCurso);
						am.ActualizarArchivo();
						listar();
						mensaje("Retiro modificado exitosamente");
						deshabilitarTodo();
				}
			} catch (Exception error) {
				error("Inserte un n+umero de matrícula", cboNumMatricula);
			}
		} catch (Exception error) {
			error("Seleccione un número de retiro", cboNumRetiro);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		limpiar();
		habilitar(false, true, false, false, false, false, true, true, false, true, false);
		cboNumRetiro.addItem(ar.codigoCorrelativo());
		cboNumRetiro.setSelectedIndex(ar.tamaño());
		cboNumMatricula.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, false, false, true, false, false, true, true, true, false, false);
		cboNumRetiro.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int numRetiro = leerNumeroRetiro();
			Retiro buscado = ar.buscar(numRetiro);
			if (confirmar() == 0) {
				ar.eliminar(buscado);
				aa.buscar(am.buscar(buscado.getNumMatricula()).getCodigoAlumno()).setEstado(1);
				aa.ActualizarArchivo();
				listar();
				mensaje("Retiro eliminado exitosamente");
				deshabilitarTodo();
			}
		} catch (Exception error) {
			error("Seleccione un número de retiro", cboNumRetiro);
		}
	}
	void habilitar(boolean numRetiro, boolean numMatricula, boolean alumno, boolean codigoCurso, boolean curso,
			boolean activoMatricula, boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboNumRetiro.setEnabled(numRetiro);
		cboNumMatricula.setEnabled(numMatricula);
		txtAlumno.setEditable(alumno);
		cboCodigoCurso.setEnabled(codigoCurso);
		txtCurso.setEditable(curso);
		txtActivoMatricula.setEditable(activoMatricula);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	void deshabilitarTodo() {
		listarCboNumRetiro();
		listarCboNumMatricula();
		listarCboCodCurso();
		habilitar(false, false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	void limpiar() {
		cboNumRetiro.setSelectedIndex(-1);
		cboNumMatricula.setSelectedIndex(-1);
		txtAlumno.setText("");
		cboCodigoCurso.setSelectedIndex(-1);
		txtCurso.setText("");
		txtActivoMatricula.setText("");
	}
	void listarCboNumRetiro() {
		cboNumRetiro.removeAllItems();
		for (int i = 0; i < ar.tamaño(); i++) {
			cboNumRetiro.addItem(ar.obtener(i).getNumRetiro());
		}
	}
	void listarCboNumMatricula() {
		cboNumMatricula.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(am.obtener(i).getNumeroMatricula());
		}
	}
	void listarCboCodCurso() {
		cboCodigoCurso.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigoCurso.addItem(ac.obtener(i).getCodCurso());
		}
	}
	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblRetiro.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*3);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*5);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*6);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*11);
		modeloColuma.getColumn(5).setPreferredWidth(scrollPane.getWidth()*3);
		modeloColuma.getColumn(6).setPreferredWidth(scrollPane.getWidth()*3);
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ar.tamaño(); i++) {
			Object[] fila = {
					ar.obtener(i).getNumRetiro(),
					ar.obtener(i).getNumMatricula(),
					aa.buscar(am.buscar(ar.obtener(i).getNumMatricula()).getCodigoAlumno()).getNombres(),
					aa.buscar(am.buscar(ar.obtener(i).getNumMatricula()).getCodigoAlumno()).getApellidos(),
					ac.buscar(am.buscar(ar.obtener(i).getNumMatricula()).getCodigoCurso()).getAsignatura(),
					ar.obtener(i).getFecha(),
					ar.obtener(i).getHora(),
			};
			modelo.addRow(fila);
		}
	}
	int leerNumeroRetiro() {
		return Integer.parseInt(cboNumRetiro.getSelectedItem().toString());
	}
	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}
	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}
	int leerCodigoCurso() {
		return Integer.parseInt(cboCodigoCurso.getSelectedItem().toString());
	}
	String leerCurso() {
		return txtCurso.getText().trim().toUpperCase();
	}
	String activo(int i) {
		return i == 1 ? "Sí" : "No";
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JComboBox<?> cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estas seguro de eliminar este retiro?\n"
				+ "Alumno: " + leerAlumno() + "\n" + "Curso: " + leerCurso(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRetiro) {
			mouseClickedTblRetiro(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblRetiro(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Retiro buscado = ar.obtener(tblRetiro.getSelectedRow());
				cboNumRetiro.setSelectedIndex(tblRetiro.getSelectedRow());
				cboNumMatricula.setSelectedItem(buscado.getNumMatricula());
			} catch (Exception error) {
				
			}	
		}
	}
}
