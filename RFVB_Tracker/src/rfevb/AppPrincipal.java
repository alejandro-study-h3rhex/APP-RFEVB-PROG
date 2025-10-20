package rfevb;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class AppPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JPanel panelAnonimo;
	JPanel panelArbitro;
	JPanel panelAdmin;
	
	/*ANONIMOS*/
	
	// -- BOTONES DE NAVEGACION --
	private JButton btnVerJorndas;
	private JButton btnVerClasificación;
	private JButton anonCerrarSesion;
	
	// -- JORNDAS --
	private JPanel verJornadas;
	private JPanel northPanelJornadas;
	private JPanel panelJornadas;
	private JLabel lblGestionarEquipos;
	private JPanel panelSur;
	private JPanel listContainer;
	private JPanel headerPanel;
	private JLabel headerNJornadas;
	private JLabel headerEqLocal;
	private JLabel headerEqVisitante;
	private JPanel anonListPanelJorndas;
	private JList<String> listEqLocal;
	private JList<String> listEqVisitante;
	
	// -- CLASIFICACIÓN --
	private JPanel verClasificacion;
	private JPanel northPanelClasificacion;
	private JLabel lblClasificacion;
	private JButton anonCerrarSesion_1;
	private JPanel midPanel;
	private JScrollPane scrollPane;
	

	/**
	 * Create the frame.
	 */
	public AppPrincipal(String username) {
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		//LOGO Y TITULO
		setTitle("RFEVB Tracker");
		// OBTIENE EL RECURSO DE LA DIRECCION RELATIVA
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayoutPrincipal = new CardLayout(0,0);
		contentPane.setLayout(cardLayoutPrincipal);
		
		/*PANEL ANONIMO*/
		panelAnonimo = new JPanel();
		contentPane.add(panelAnonimo, "PanelAnonimo_");
		panelAnonimo.setLayout(new CardLayout(0, 0));
		verJornadas = new JPanel();
		verJornadas.setBorder(new EmptyBorder(5, 5, 5, 5));
		verJornadas.setBackground(new Color(238, 235, 228));
		panelAnonimo.add(verJornadas, "name_10114257992300");
		verJornadas.setLayout(new BorderLayout(0, 0));
		
		/*PANEL NORTE - VER JORNADAS*/
		northPanelJornadas = new JPanel();
		verJornadas.add(northPanelJornadas, BorderLayout.NORTH);
		
		btnVerJorndas = new JButton("Ver Jorndas");
		btnVerJorndas.setFont(new Font("Calibri", Font.PLAIN, 20));
		northPanelJornadas.add(btnVerJorndas);
		
		btnVerClasificación = new JButton("Ver Clasificación");
		btnVerClasificación.setFont(new Font("Calibri", Font.PLAIN, 20));
		northPanelJornadas.add(btnVerClasificación);
		
		anonCerrarSesion = new JButton("Cerrar Sesion");
		anonCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 20));
		northPanelJornadas.add(anonCerrarSesion);
		
		panelJornadas = new JPanel();
		panelJornadas.setBackground(new Color(238, 235, 228));
		verJornadas.add(panelJornadas, BorderLayout.CENTER);
		panelJornadas.setLayout(new BorderLayout(0, 20));
		
		lblGestionarEquipos = new JLabel("JORNADAS");
		lblGestionarEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarEquipos.setForeground(new Color(0, 128, 192));
		lblGestionarEquipos.setFont(new Font("Leelawadee", Font.BOLD, 25));
		panelJornadas.add(lblGestionarEquipos, BorderLayout.NORTH);
		
		panelSur = new JPanel();
		panelSur.setBackground(new Color(238, 235, 228));
		panelJornadas.add(panelSur, BorderLayout.SOUTH);
		
		listContainer = new JPanel((LayoutManager) null);
		listContainer.setPreferredSize(new Dimension(500, 180));
		panelSur.add(listContainer);
		listContainer.setLayout(new BorderLayout());
		
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(51, 153, 204));
		listContainer.add(headerPanel, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[] {0, 0, 0, 0, 0, 20, 0, 30, 30};
		gbl_headerPanel.rowHeights = new int[]{19, 0};
		gbl_headerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_headerPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerPanel.setLayout(gbl_headerPanel);
		
		headerNJornadas = new JLabel("Nº  ");
		headerNJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		headerNJornadas.setForeground(Color.WHITE);
		headerNJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerNJornadas = new GridBagConstraints();
		gbc_headerNJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_headerNJornadas.gridx = 0;
		gbc_headerNJornadas.gridy = 0;
		headerPanel.add(headerNJornadas, gbc_headerNJornadas);
		
		headerEqLocal = new JLabel("EQUIPO LOCAL");
		headerEqLocal.setHorizontalAlignment(SwingConstants.CENTER);
		headerEqLocal.setForeground(Color.WHITE);
		headerEqLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEqLocal = new GridBagConstraints();
		gbc_headerEqLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerEqLocal.insets = new Insets(0, 0, 0, 5);
		gbc_headerEqLocal.gridx = 2;
		gbc_headerEqLocal.gridy = 0;
		headerPanel.add(headerEqLocal, gbc_headerEqLocal);
		
		headerEqVisitante = new JLabel("EQUIPO VISITANTE");
		headerEqVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		headerEqVisitante.setForeground(Color.WHITE);
		headerEqVisitante.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEqVisitante = new GridBagConstraints();
		gbc_headerEqVisitante.insets = new Insets(0, 0, 0, 5);
		gbc_headerEqVisitante.fill = GridBagConstraints.BOTH;
		gbc_headerEqVisitante.gridx = 7;
		gbc_headerEqVisitante.gridy = 0;
		headerPanel.add(headerEqVisitante, gbc_headerEqVisitante);
		
		anonListPanelJorndas = new JPanel();
		listContainer.add(anonListPanelJorndas, BorderLayout.CENTER);
		anonListPanelJorndas.setLayout(new GridLayout(0, 2, 0, 0));
		
		listEqLocal = new JList<String>();
		listEqLocal.setForeground(new Color(50, 50, 50));
		listEqLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqLocal.setFixedCellHeight(25);
		listEqLocal.setBackground(new Color(204, 229, 255));
		anonListPanelJorndas.add(listEqLocal);
		
		listEqVisitante = new JList<String>();
		listEqVisitante.setForeground(new Color(50, 50, 50));
		listEqVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqVisitante.setFixedCellHeight(25);
		listEqVisitante.setBackground(new Color(204, 229, 255));
		anonListPanelJorndas.add(listEqVisitante);
		
		/*SUB PANEL ANONIMOS - VER CLASIFICIÓN*/
		verClasificacion = new JPanel();
		panelAnonimo.add(verClasificacion, "name_10114269669100");
		verClasificacion.setLayout(new BorderLayout(0, 0));
		
		northPanelClasificacion = new JPanel();
		verClasificacion.add(northPanelClasificacion, BorderLayout.NORTH);
		
		lblClasificacion = new JLabel("CLASIFICACIÓN");
		lblClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacion.setForeground(new Color(0, 128, 192));
		lblClasificacion.setFont(new Font("Leelawadee", Font.BOLD, 25));
		northPanelClasificacion.add(lblClasificacion);
		
		anonCerrarSesion_1 = new JButton("Cerrar Sesion");
		anonCerrarSesion_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		northPanelClasificacion.add(anonCerrarSesion_1);
	
		midPanel = new JPanel();
		verClasificacion.add(midPanel, BorderLayout.CENTER);
		
		
		/*PANEL ARBITRO*/
		panelArbitro = new JPanel();
		contentPane.add(panelArbitro, "PanelArbitro_");
		/*PANEL ADMIN*/
		panelAdmin = new JPanel();
		contentPane.add(panelAdmin, "PanelAdmin_");
		
		
		if(username.equals(Login.admin_user)) {
			cardLayoutPrincipal.show(contentPane, "PanelAdmin_");
		} else if (username.equals(Login.arbitro_user)){
			cardLayoutPrincipal.show(contentPane, "PanelArbitro_");
		} else {
			cardLayoutPrincipal.show(contentPane, "PanelAnonimo_");
		}
	}

}
