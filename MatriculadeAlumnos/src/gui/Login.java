package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	//Variables usadas para el login
	private HashMap<String, String> usuarios;

	private JButton btnSesion;
	private JButton btnCerrarSesion;
	private JCheckBox chkVer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("LOGIN");
		setBounds(100, 100, 515, 420);
		setLocationRelativeTo(null);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Login.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(this);
		
		chkVer = new JCheckBox("Ver");
		chkVer.addActionListener(this);
		chkVer.setFont(new Font("Tahoma", Font.BOLD, 12));
		chkVer.setBackground(new Color(104, 117, 234));
		chkVer.setBounds(380, 263, 50, 23);
		getContentPane().add(chkVer);
		btnCerrarSesion.setBounds(273, 310, 115, 34);
		getContentPane().add(btnCerrarSesion);
		
		btnSesion = new JButton("Iniciar Sesión");
		btnSesion.addActionListener(this);
		btnSesion.setBounds(130, 310, 115, 34);
		getContentPane().add(btnSesion);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(240, 264, 130, 20);
		getContentPane().add(txtContraseña);
		txtContraseña.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(240, 228, 130, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ingrese su Contraseña  :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setBounds(70, 262, 160, 22);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ingrese su Usuario        :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(70, 226, 160, 22);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("INICIO DE SESION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(178, 181, 140, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/LogoLogin.png")));
		lblNewLabel_1.setBounds(153, 0, 191, 189);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 499, 381);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/FondoLogin.jpeg")));
		getContentPane().add(lblNewLabel);
		
		//USUARIOS VALIDOS
		usuarios = new HashMap<>();
	    usuarios.put("josue", "1234");
	    usuarios.put("juan", "qwerty");
	    usuarios.put("gerald", "abc123");
	    usuarios.put("patrick", "4321");
	    usuarios.put("abraham", "almuerzo");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chkVer) {
			actionPerformedChkVer(e);
		}
		if (e.getSource() == btnCerrarSesion) {
			actionPerformedBtnCerrarSesion(e);
		}
		if (e.getSource() == btnSesion) {
			actionPerformedBtnSesion(e);
		}
	}
	//CHECKBOX
	protected void actionPerformedChkVer(ActionEvent e) {
		if (chkVer.isSelected()) {
			txtContraseña.setEchoChar((char) 0);//SE MUESTRA LA CONTRASE�A
		}else {
			txtContraseña.setEchoChar('*');//SE OCULA LA CONTRASE�A
		}
	}
	protected void actionPerformedBtnSesion(ActionEvent e) {
		String usuario = txtUsuario.getText();
		String contraseña = new String(txtContraseña.getPassword());
		if (usuarios.containsKey(usuario)) {
			String contraseñaCorrecta = usuarios.get(usuario);
			if(contraseñaCorrecta.equals(contraseña)) {
				JOptionPane.showMessageDialog(this, "Inicio de Sesión exitoso! \n"
						+"Bienvenido de nuevo, "+usuario+"!");
				//PARA ABRIR EL JFRAME PRINCIPAL
				JFramePrincipal jframeprincipal = new JFramePrincipal();
				jframeprincipal.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Contraseña Incorrecta.");
			}
		}else{
			JOptionPane.showMessageDialog(this, "Usuario no Registrado.");
		}
	}
	protected void actionPerformedBtnCerrarSesion(ActionEvent e) {
		System.exit(0);
	}
}
