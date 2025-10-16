package rfevb;

import java.awt.EventQueue;
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

public class PanelAdmin extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/*BOTONES*/
	JButton btnCerrarsesion;
	JButton btnGestionLigas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin frame = new PanelAdmin();
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
	public PanelAdmin() {
		setResizable(false);
		setTitle("RFEVB Tracker - Panel Admininstrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelAdmin.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JLabel lbl_Icono = new JLabel("");
		lbl_Icono.setIcon(new ImageIcon(PanelAdmin.class.getResource("assets/favicon/icono-federacion.png")));
		lbl_Icono.setFont(new Font("Tahoma", Font.PLAIN, 6));
		northPanel.add(lbl_Icono);
		
		JLabel lbl_titulo_federacion = new JLabel("Real Federacion Española de Voleibol");
		lbl_titulo_federacion.setFont(new Font("Leelawadee", lbl_titulo_federacion.getFont().getStyle() | Font.BOLD, 25));
		lbl_titulo_federacion.setForeground(new Color(0, 128, 192));
		northPanel.add(lbl_titulo_federacion);
		
		btnCerrarsesion = new JButton("Cerrar Sesion");
		btnCerrarsesion.setBackground(new Color(255, 255, 128));
		btnCerrarsesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrarsesion.addActionListener(this);
		northPanel.add(btnCerrarsesion);
		
		JPanel optionPanel = new JPanel();
		contentPane.add(optionPanel, BorderLayout.CENTER);
		
		// --- GESTION EQUIPOS ---
		JButton btnGestionEquipos = new JButton("Gestionar Equipos");
		btnGestionEquipos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGestionEquipos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGestionEquipos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Lógica de acción para Gestion Equipos
		    }
		});
		// Cargar la imagen
		ImageIcon iconoGestionEquipos = new ImageIcon(PanelAdmin.class.getResource("assets/Gestion-Equipos.png"));
		Image imagenGestionEquipos = iconoGestionEquipos.getImage();

		// Escalar la imagen (120x120 como en tu ejemplo)
		Image imagenEscaladaGestionEquipos = imagenGestionEquipos.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon iconoEscaladoGestionEquipos = new ImageIcon(imagenEscaladaGestionEquipos);

		// Asignar el icono escalado al botón correcto
		btnGestionEquipos.setIcon(iconoEscaladoGestionEquipos);

		// ***** APLICAR TRANSPARENCIA *****
		btnGestionEquipos.setContentAreaFilled(false); // Quita el color de fondo
		btnGestionEquipos.setBorderPainted(false);    // Quita el borde
		// **********************************

		btnGestionEquipos.setHorizontalAlignment(SwingConstants.TRAILING);
		optionPanel.add(btnGestionEquipos);


		// --- GESTION LIGAS ---
		// *** IMPORTANTE: Carga la imagen ANTES de crear el botón ***

		// Cargar y escalar la imagen para GESTION LIGAS
		ImageIcon iconoGestionLigas = new ImageIcon(PanelAdmin.class.getResource("assets/Gestion-Liga.png"));
		Image imagenGestionLigas = iconoGestionLigas.getImage();
		Image imagenEscaladaGestionLigas = imagenGestionLigas.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon iconoEscaladoGestionLigas = new ImageIcon(imagenEscaladaGestionLigas);

		// Crear y configurar el botón LIGAS (Asegúrate de inicializarlo aquí)
		JButton btnGestionLigas = new JButton(); // Nuevo botón
		btnGestionLigas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGestionLigas.setText("Gestionar Ligas");
		btnGestionLigas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Lógica de acción para Gestion Ligas
		    }
		});

		// Asignar el icono escalado al botón
		btnGestionLigas.setIcon(iconoEscaladoGestionLigas);

		// ***** APLICAR TRANSPARENCIA *****
		btnGestionLigas.setContentAreaFilled(false); // Quita el color de fondo
		btnGestionLigas.setBorderPainted(false);    // Quita el borde
		// **********************************

		btnGestionLigas.setHorizontalAlignment(SwingConstants.CENTER);
		optionPanel.add(btnGestionLigas);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == btnCerrarsesion) {
    		/*Cierra el panel admin y abre la ventana de login*/
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
		
	}

}
