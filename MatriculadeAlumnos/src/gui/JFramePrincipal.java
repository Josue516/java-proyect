package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class JFramePrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//EL FONDO
	FondoPanel fondo = new FondoPanel(); //LLAMA A LA IMAGEN DEFINIDA EN FONDO PANEL

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmMantAlumno;
	private JMenuItem mntmMantCurso;
	private JMenuItem mntmRegRetiro;
	private JMenuItem mntmRegMatricula;
	private JMenuItem mntmConsAlumno;
	private JMenuItem mntmConsCurso;
	private JMenuItem mntmConsMatricula;
	private JMenuItem mntmConsRetiro;
	private JMenuItem mntmAlumMatPendiente;
	private JMenuItem mntmAlumMatVigente;
	private JMenuItem mntmAlumMatCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePrincipal frame = new JFramePrincipal();
					frame.setLocationRelativeTo(null);
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
	public JFramePrincipal() {
		setTitle("REGISTRO Y MATRICULA DE ALUMNOS");
		//PARA LLAMAR AL FONDO
		this.setContentPane(fondo);//LE DICE A LA VENTANA QUE SU PANEL PRINCIPAL DEBE SER FondoPanel
		fondo.setLayout(null);//DESACTIVA EL LAYOUT AUTOMATICO PARA QUE NO SE DESORDENE
		//ACA ACABA EL FONDO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);//PARA CENTRAR EN LA MITAD DE LA PANTALLA
		setExtendedState(JFrame.MAXIMIZED_BOTH);//PARA QUE APAREZCA EN PANTALLA COMPLETA
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));

		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmMantAlumno = new JMenuItem("Alumno");
		mntmMantAlumno.addActionListener(this);
		mnMantenimiento.add(mntmMantAlumno);
		
		mntmMantCurso = new JMenuItem("Curso");
		mntmMantCurso.addActionListener(this);
		mnMantenimiento.add(mntmMantCurso);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmRegMatricula = new JMenuItem("Matricula");
		mntmRegMatricula.addActionListener(this);
		mnRegistro.add(mntmRegMatricula);
		
		mntmRegRetiro = new JMenuItem("Retiro");
		mntmRegRetiro.addActionListener(this);
		mnRegistro.add(mntmRegRetiro);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmConsAlumno = new JMenuItem("Alumno");
		mntmConsAlumno.addActionListener(this);
		mnConsulta.add(mntmConsAlumno);
		
		mntmConsCurso = new JMenuItem("Curso");
		mntmConsCurso.addActionListener(this);
		mnConsulta.add(mntmConsCurso);
		
		mntmConsMatricula = new JMenuItem("Matricula");
		mntmConsMatricula.addActionListener(this);
		mnConsulta.add(mntmConsMatricula);
		
		mntmConsRetiro = 
				new JMenuItem("Retiro");
		mntmConsRetiro.addActionListener(this);
		mnConsulta.add(mntmConsRetiro);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmAlumMatPendiente = new JMenuItem("Alumnos con matricula pendiente");
		mntmAlumMatPendiente.addActionListener(this);
		mnReporte.add(mntmAlumMatPendiente);
		
		mntmAlumMatVigente = new JMenuItem("Alumnos con matricula vigente");
		mntmAlumMatVigente.addActionListener(this);
		mnReporte.add(mntmAlumMatVigente);
		
		mntmAlumMatCurso = new JMenuItem("Alumnos matriculados por curso");
		mntmAlumMatCurso.addActionListener(this);
		mnReporte.add(mntmAlumMatCurso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAlumMatCurso) {
			actionPerformedMntmAlumMatCurso(e);
		}
		if (e.getSource() == mntmAlumMatVigente) {
			actionPerformedMntmAlumMatVigente(e);
		}
		if (e.getSource() == mntmAlumMatPendiente) {
			actionPerformedMntmAlumMatPendiente(e);
		}
		if (e.getSource() == mntmConsRetiro) {
			actionPerformedMntmConsRetiro(e);
		}
		if (e.getSource() == mntmConsMatricula) {
			actionPerformedMntmConsMatricula(e);
		}
		if (e.getSource() == mntmConsCurso) {
			actionPerformedMntmConsCurso(e);
		}
		if (e.getSource() == mntmConsAlumno) {
			actionPerformedMntmConsAlumno(e);
		}
		if (e.getSource() == mntmRegRetiro) {
			actionPerformedMntmRegRetiro(e);
		}
		if (e.getSource() == mntmRegMatricula) {
			actionPerformedMntmRegMatricula(e);
		}
		if (e.getSource() == mntmMantCurso) {
			actionPerformedMntmMantCurso(e);
		}
		if (e.getSource() == mntmMantAlumno) {
			actionPerformedMntmMantAlumno(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int valor = JOptionPane.showOptionDialog(null, "¿Estas seguro de cerrar el programa?","Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		if (valor == 0) System.exit(0);
	}
	protected void actionPerformedMntmMantAlumno(ActionEvent e) {
		ManteAlumno mantAlumno = new ManteAlumno();
		mantAlumno.setModal(true);
		mantAlumno.setLocationRelativeTo(this);
		mantAlumno.setVisible(true);
	}
	protected void actionPerformedMntmMantCurso(ActionEvent e) {
		ManteCursos mantCurso = new ManteCursos();
		mantCurso.setModal(true);
		mantCurso.setLocationRelativeTo(this);
		mantCurso.setVisible(true);
	}
	
	protected void actionPerformedMntmRegMatricula(ActionEvent e) {
		RegistroMatricula regMatricula = new RegistroMatricula();
		regMatricula.setModal(true);
		regMatricula.setLocationRelativeTo(this);
		regMatricula.setVisible(true);
	}
	
	protected void actionPerformedMntmRegRetiro(ActionEvent e) {
		RegistroRetiro regRetiro = new RegistroRetiro();
		regRetiro.setModal(true);
		regRetiro.setLocationRelativeTo(this);
		regRetiro.setVisible(true);
	}
	
	protected void actionPerformedMntmConsAlumno(ActionEvent e) {
		ConsultaAlumno consultaAlumno = new ConsultaAlumno();
		consultaAlumno.setModal(true);
		consultaAlumno.setLocationRelativeTo(this);
		consultaAlumno.setVisible(true);
	}
	
	protected void actionPerformedMntmConsCurso(ActionEvent e) {
		ConsultaCurso consultaCurso = new ConsultaCurso();
		consultaCurso.setModal(true);
		consultaCurso.setLocationRelativeTo(this);
		consultaCurso.setVisible(true);
	}
	
	protected void actionPerformedMntmConsMatricula(ActionEvent e) {
		ConsultaMatricula consultaMatricula = new ConsultaMatricula();
		consultaMatricula.setModal(true);
		consultaMatricula.setLocationRelativeTo(this);
		consultaMatricula.setVisible(true);
	}
	
	protected void actionPerformedMntmConsRetiro(ActionEvent e) {
		ConsultaRetiro consultaRetiro = new ConsultaRetiro();
		consultaRetiro.setModal(true);
		consultaRetiro.setLocationRelativeTo(this);
		consultaRetiro.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumMatPendiente(ActionEvent e) {
		ReporteMatriPendiente reporteAMP = new ReporteMatriPendiente();
		reporteAMP.setModal(true);
		reporteAMP.setLocationRelativeTo(this);
		reporteAMP.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumMatVigente(ActionEvent e) {
		ReporteMatriVigen reporteAMV = new ReporteMatriVigen();
		reporteAMV.setModal(true);
		reporteAMV.setLocationRelativeTo(this);
		reporteAMV.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumMatCurso(ActionEvent e) {
		ReporteMatriCurso reporteAMC = new ReporteMatriCurso();
		reporteAMC.setModal(true);
		reporteAMC.setLocationRelativeTo(this);
		reporteAMC.setVisible(true);
	}
	//FONDO
	public class FondoPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private Image imagen;
		
		
		public FondoPanel() {
			ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/Fondo.png"));
			imagen = icono.getImage();
		}
		@Override
	    protected void paintComponent(Graphics g) {
	        if (imagen != null) {
	            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
	        }

	        setOpaque(false);
	        super.paintComponent(g);
	    }
	}
}
