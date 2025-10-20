package rfevb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel mainFrameLogin;
	/*LOGIN DATA*/
	private JTextField txtUsernameValue;
	private JPasswordField txtPasswordValue;
	/*BOTONES*/
	private JButton btnAceptar; 
	
	/*USUARIOS Y CONTRASEÑAS*/
	
	/*
	 	CREDENCIALES REALES
	  	
	  	private String admin_user = "admin_rfvb";
		private String admin_password = "RFVB@4dm1n*25";
		
		private String arbitro_user = "arbitro_rfvb";
		private String arbitro_password ="Jorn4da#Delg";
		
	*/
	// Estas son claves que usamos para simplificar tareas en las etapas de desarrollo
	public static String admin_user = "admin";
	private  String admin_password = "admin";
	public static String arbitro_user = "arbitro";
	private String arbitro_password ="arbitro";
	public static String anonimo_user = "anonimo";
	private String anonimo_password = "anonimo";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		//LOGO Y TITULO
		setTitle("RFEVB Tracker");
		// OBTIENE EL RECURSO DE LA DIRECCION RELATIVA
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 310);
		mainFrameLogin = new JPanel();
		mainFrameLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainFrameLogin);
		mainFrameLogin.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		mainFrameLogin.add(northPanel, BorderLayout.NORTH);
		
		JLabel lbl_Icono = new JLabel("");
		lbl_Icono.setFont(new Font("Tahoma", Font.PLAIN, 6));
		lbl_Icono.setIcon(new ImageIcon(Login.class.getResource("assets/favicon/icono-federacion.png")));
		northPanel.add(lbl_Icono);
		
		JLabel lbl_titulo_federacion = new JLabel("Real Federacion Española de Voleibol");
		lbl_titulo_federacion.setForeground(new Color(0, 128, 192));
		lbl_titulo_federacion.setFont(new Font("Leelawadee", lbl_titulo_federacion.getFont().getStyle() | Font.BOLD, 25));
		northPanel.add(lbl_titulo_federacion);
		
		JPanel loginPanel = new JPanel();
		mainFrameLogin.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel passwordPanel = new JPanel();
		loginPanel.add(passwordPanel);
		
		JLabel lblUsername = new JLabel("Contraseña: ");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Leelawadee", Font.PLAIN, 20));
		lblUsername.setEnabled(false);
		passwordPanel.add(lblUsername);
		
		/*JFIELD CONTRASEÑA*/
		txtPasswordValue = new JPasswordField();
		txtPasswordValue.addActionListener(this);
		txtPasswordValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordValue.setFont(new Font("Leelawadee", Font.PLAIN, 15));
		txtPasswordValue.setColumns(20);
		passwordPanel.add(txtPasswordValue);
		/*Cuando el usuario fonga el foco en el JField se seleccionara todo el texto y cuando lo pierda se deselecionara*/
		txtPasswordValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPasswordValue.select(0, txtPasswordValue.getPassword().length);
			}
			public void focusLost(FocusEvent e) {
				txtPasswordValue.select(0, 0);
			}
		});
		
		JPanel usernamePanel = new JPanel();
		loginPanel.add(usernamePanel, BorderLayout.NORTH);
		
		JLabel lblPassword = new JLabel("Usuario: ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Leelawadee", Font.PLAIN, 20));
		usernamePanel.add(lblPassword);
		
		/*JFIELD NOMBRE DE USUARIO*/
		txtUsernameValue = new JTextField();
		/*Cuando el usuario fonga el foco en el JField se seleccionara todo el texto y cuando lo pierda se deselecionara*/
		txtUsernameValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsernameValue.select(0, txtUsernameValue.getText().length());
			}
			public void focusLost(FocusEvent e) {
				txtUsernameValue.select(0, 0);
			}
		});
		/*Cuando el usuario pulsa enter el foco se movera el JField Password*/
		txtUsernameValue.addActionListener(this);
		txtUsernameValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsernameValue.setFont(new Font("Leelawadee", Font.PLAIN, 15));
		txtUsernameValue.setColumns(20);
		usernamePanel.add(txtUsernameValue);
		
		/*BOTON ACEPTAR*/
		btnAceptar = new JButton("Iniciar Sesión");
		btnAceptar.setBackground(new Color(255, 255, 128));
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Leelawadee", Font.PLAIN, 15));
		loginPanel.add(btnAceptar, BorderLayout.SOUTH);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		  if (o == btnAceptar || o == txtPasswordValue) {
		        // COMPROBAR DATOS
			  	/*Primero recogemos los datos de los JField y JPassword
			  	  y los guardamos en String para poder comprobarlas despues
			  	 */
		        String username = new String(txtUsernameValue.getText());
		        String password = new String(txtPasswordValue.getPassword());
		        
		       if(username.equals(admin_user) && password.equals(admin_password)) {
		    	  AppPrincipal appPrincipal = new AppPrincipal(username);
		    	  this.dispose();
		    	  appPrincipal.setVisible(true);
		       } else if(username.equals(arbitro_user) && password.equals(arbitro_password)) {
		    	   AppPrincipal appPrincipal = new AppPrincipal(username);
		    	   appPrincipal.setVisible(true);
		    	   this.dispose();

		       } else if(username.equals(anonimo_user) && password.equals(anonimo_password)) {
		    	   AppPrincipal appPrincipal = new AppPrincipal(username);
		    	   appPrincipal.setVisible(true);
		    	   this.dispose();

		       } else {
					JOptionPane.showMessageDialog(this, (String)"Error. Usuario o constraseña incorrectos","Error al inciar sesion",JOptionPane.ERROR_MESSAGE,null);
		       }
		        
		  } else if(o == txtUsernameValue) {
			  txtPasswordValue.requestFocus();
		  }
		  else {
		        System.out.println("Error. No se ha reconocido el evento");
		  }
	}

}
