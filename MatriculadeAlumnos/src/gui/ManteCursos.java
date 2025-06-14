package gui;

import arreglos.*;
import clases.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ManteCursos extends JDialog implements ActionListener, ItemListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox<Integer> cboCodigo;
	private JTextField txtAsignatura;
	private JComboBox<String> cboCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblCurso;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManteCursos dialog = new ManteCursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManteCursos() {
		setTitle("MANTENIMIENTO DE CURSOS");
		setBounds(100, 100, 700, 450);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(342, 22, 193, 168);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 22, 77, 15);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Asignatura:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 57, 77, 15);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ciclo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 92, 77, 15);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("N° Creditos:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 127, 77, 15);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Cant. de Horas:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(156, 127, 100, 15);
		getContentPane().add(lblNewLabel_5);
		
		cboCodigo = new JComboBox<Integer>();
		cboCodigo.addItemListener(this);
		cboCodigo.setBounds(97, 20, 115, 21);
		getContentPane().add(cboCodigo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(97, 56, 211, 19);
		getContentPane().add(txtAsignatura);
		
		cboCiclo = new JComboBox<String>();
		cboCiclo.setModel(new DefaultComboBoxModel<String>(new String[] {"PRIMERO", "SEGUNDO", "TERCERO", "CUARTO", "QUINTO", "SEXTO"}));
		cboCiclo.setBounds(97, 90, 115, 21);
		getContentPane().add(cboCiclo);
		
		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(97, 126, 49, 19);
		getContentPane().add(txtCreditos);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(259, 126, 49, 19);
		getContentPane().add(txtHoras);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(10, 163, 142, 27);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(166, 163, 142, 27);
		getContentPane().add(btnCancelar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setBounds(572, 22, 104, 33);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(572, 82, 104, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(572, 140, 104, 33);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 666, 203);
		getContentPane().add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("CICLO");
		modelo.addColumn("CRÉDITOS");
		modelo.addColumn("HORAS");
		tblCurso.setModel(modelo);
		
		ajustarColumnas();
		listar();
		deshabilitarTodo();
		
	}
	
	//DECLARACI�N GLOBAL
	ArregloCursos ac = new ArregloCursos();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigo) {
			itemStateChangedCboCodigo(e);
		}
	}
	protected void itemStateChangedCboCodigo(ItemEvent e) {
		try {
			int codCurso = leerCodigo();
			Curso buscado = ac.buscar(codCurso);
			txtAsignatura.setText(buscado.getAsignatura());
			cboCiclo.setSelectedIndex(buscado.getCiclo());
			txtCreditos.setText("" + buscado.getCreditos());
			txtHoras.setText("" + buscado.getHoras());
			tblCurso.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
		} catch (Exception error) {
			
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codCurso = leerCodigo();
			String asignatura = leerAsignatura();
			if (asignatura.length() != 0) {
				int ciclo = leerCiclo();
				if (ciclo != -1) {
					try {
						int creditos = leerCreditos();
						try {
							int horas = leerHoras();
							if (!btnAdicionar.isEnabled()) {
								Curso nuevo = new Curso(codCurso, asignatura, ciclo, creditos, horas);
								ac.adicionar(nuevo);
								listar();
								mensaje("Nuevo curso añadido exitosamente");
								deshabilitarTodo();
							} else if (!btnModificar.isEnabled()) {
								Curso buscado = ac.buscar(codCurso);
								buscado.setAsignatura(asignatura);
								buscado.setCiclo(ciclo);
								buscado.setCreditos(creditos);
								buscado.setHoras(horas);
								ac.ActualizarArchivo();
								listar();
								mensaje("Curso modificado exitosamente");
								deshabilitarTodo();
							}
						} catch (Exception error) {
							error("Ingrese un número de horas válido", txtHoras);
						}
					} catch (Exception error) {
						error("Ingrese una cantidad de créditos válida", txtCreditos);
					}
				} else {
					error("Seleccione el ciclo al que pertenece el curso", cboCiclo);
				}
			} else {
				error("Ingrese el nombre de la asignatura", txtAsignatura);
			}
		} catch (Exception error) {
			error("Seleccione un código de curso", cboCodigo);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		limpiar();
		habilitar(false, true, true, true, true, true, true, false, true, false);
		cboCodigo.addItem(ac.codigoCorrelativo());
		cboCodigo.setSelectedIndex(ac.tamaño());
		txtAsignatura.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, true, true, true, true, true, true, true, false, false);
		cboCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int codCurso = leerCodigo();
			if (confirmar() == 0) {
				Curso buscado = ac.buscar(codCurso);
				ac.eliminar(buscado);
				listar();
				mensaje("Curso eliminado exitosamente");
				deshabilitarTodo();
			}
		} catch (Exception error) {
			error("Seleccione un codigo de curso", cboCodigo);
		}
	}
	void habilitar(boolean codigo,boolean asignatura, boolean ciclo, boolean creditos, boolean horas, 
			boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboCodigo.setEnabled(codigo);
		txtAsignatura.setEditable(asignatura);
		cboCiclo.setEnabled(ciclo);
		txtCreditos.setEditable(creditos);
		txtHoras.setEditable(horas);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	void limpiar() {
		cboCodigo.setSelectedIndex(-1);
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(-1);
		txtCreditos.setText("");
		txtHoras.setText("");
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigo.addItem(ac.obtener(i).getCodCurso());
		}
	}
	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblCurso.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*6);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*1);
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tamaño(); i++) {
			Object[] fila = {
					ac.obtener(i).getCodCurso(),
					ac.obtener(i).getAsignatura(),
					nombreCiclo(ac.obtener(i).getCiclo()),
					ac.obtener(i).getCreditos(),
					ac.obtener(i).getHoras()
			};
			modelo.addRow(fila);
		}
	}
	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
	String leerAsignatura() {
		return txtAsignatura.getText().trim().toUpperCase();
	}
	int leerCiclo() {
		return cboCiclo.getSelectedIndex();
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
	int leerCreditos() {
		return Integer.parseInt(txtCreditos.getText().trim());
	}
	int leerHoras() {
		return Integer.parseInt(txtHoras.getText().trim());
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JComboBox<?> cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	void error(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		txt.selectAll();
		txt.requestFocus();
	}
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estas seguro de eliminar este curso?\n"
				+ ac.buscar(leerCodigo()).getAsignatura(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCurso) {
			mouseClickedTblCurso(e);
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
	protected void mouseClickedTblCurso(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Curso buscado = ac.obtener(tblCurso.getSelectedRow());
				cboCodigo.setSelectedIndex(tblCurso.getSelectedRow());
				txtAsignatura.setText(buscado.getAsignatura());
				cboCiclo.setSelectedItem(buscado.getCiclo());
				txtCreditos.setText("" + buscado.getCreditos());
				txtHoras.setText("" + buscado.getHoras());
			} catch (Exception error) {
				
			}
		}
	}
}
