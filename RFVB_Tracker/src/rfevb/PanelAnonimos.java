package rfevb;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class PanelAnonimos extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel mainFramePanelAnonimos;
	
	/*BOTONES*/
	JButton btnCerrarsesion;
	JButton btnVerClasificacion;
	JButton btnVerJornadas;

	
	/**
	 * Create the frame.
	 */
	public PanelAnonimos() {
		
		// COLORES
		Color azulPrimero = new Color(0, 128, 192); 
		//Color azulSegundo = new Color(51, 153, 204); 
		//Color azulTercero = new Color(204, 229, 255); 
		Color amarilloPrimero = new Color(253,253,150);
		//Color amarilloSegundo = new Color(248,248,195);
		//Color fondoClaro = new Color(238, 235, 228); 
		
		
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		//LOGO Y TITULO
		setTitle("RFEVB Tracker");
		// OBTIENE EL RECURSO DE LA DIRECCION RELATIVA
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelAnonimos.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 401);
		mainFramePanelAnonimos = new JPanel();
		mainFramePanelAnonimos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainFramePanelAnonimos);
		mainFramePanelAnonimos.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		mainFramePanelAnonimos.add(northPanel, BorderLayout.NORTH);
		
		JLabel lbl_Icono = new JLabel("");
		lbl_Icono.setIcon(new ImageIcon(PanelAnonimos.class.getResource("assets/favicon/icono-federacion.png")));
		lbl_Icono.setFont(new Font("Tahoma", Font.PLAIN, 6));
		northPanel.add(lbl_Icono);
		
		JLabel lbl_titulo_federacion = new JLabel("Real Federacion Española de Voleibol");
		lbl_titulo_federacion.setFont(new Font("Leelawadee", lbl_titulo_federacion.getFont().getStyle() | Font.BOLD, 25));
		lbl_titulo_federacion.setForeground(azulPrimero);
		northPanel.add(lbl_titulo_federacion);
		
		btnCerrarsesion = new JButton("Cerrar Sesion");
		btnCerrarsesion.setBackground(amarilloPrimero);
		btnCerrarsesion.setForeground(azulPrimero);
		btnCerrarsesion.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnCerrarsesion.addActionListener(this);
		northPanel.add(btnCerrarsesion);
		
		JPanel optionPanel = new JPanel();
		mainFramePanelAnonimos.add(optionPanel, BorderLayout.CENTER);
		
		// --- VER CLASIFICACION ---
		JButton btnVerClasificacion = new JButton("Clasificación");
		btnVerClasificacion.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnVerClasificacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerClasificacion.addActionListener(this);
		// Cargar la imagen
		ImageIcon iconoVerClasifiacion = new ImageIcon(PanelAnonimos.class.getResource("assets/Clasificacion.png"));
		Image imagenVerClasificacion = iconoVerClasifiacion.getImage();
		// Escalar la imagen (120x120 como en tu ejemplo)
		Image imagenEscaladaVerClasificacion = imagenVerClasificacion.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon iconoEscaladoGestionEquipos = new ImageIcon(imagenEscaladaVerClasificacion);
		// Asignar el icono escalado al botón correcto
		btnVerClasificacion.setIcon(iconoEscaladoGestionEquipos);
		btnVerClasificacion.setContentAreaFilled(false); // Quita el color de fondo
		btnVerClasificacion.setBorderPainted(false);    // Quita el borde
		btnVerClasificacion.setHorizontalAlignment(SwingConstants.TRAILING);
		optionPanel.add(btnVerClasificacion);


		// --- VER JORNADAS ---
		
		// Cargar y escalar la imagen para ver jornadas
		ImageIcon iconoVerJornadas = new ImageIcon(PanelAnonimos.class.getResource("assets/Jornadas.png"));
		Image imagenVerJornadas = iconoVerJornadas.getImage();
		Image imagenEscaladaVerJornadas = imagenVerJornadas.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon iconoEscaladoVerJornadas = new ImageIcon(imagenEscaladaVerJornadas);

		// Crear y configurar el botón LIGAS (Asegúrate de inicializarlo aquí)
		btnVerJornadas = new JButton();
		btnVerJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerJornadas.setText("Jornadas");
		btnVerJornadas.addActionListener(this);

		// Asignar el icono escalado al botón
		btnVerJornadas.setIcon(iconoEscaladoVerJornadas);

		// ***** APLICAR TRANSPARENCIA *****
		btnVerJornadas.setContentAreaFilled(false); // Quita el color de fondo
		btnVerJornadas.setBorderPainted(false);    // Quita el borde
		// **********************************

		btnVerJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		optionPanel.add(btnVerJornadas);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == btnCerrarsesion) {
    		/*Cierra el panel admin y abre la ventana de login*/
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		} else if (o == btnVerJornadas) {
			VerJornadas verJornadas = new VerJornadas();
			verJornadas.setVisible(true);
			this.dispose();
		}
		
	}

}
