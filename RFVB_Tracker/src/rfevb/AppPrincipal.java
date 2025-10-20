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
import javax.swing.BoxLayout;



public class AppPrincipal extends JFrame {
	
	// COLORES
	Color azulPrimero = new Color(0, 128, 192); 
	Color azulSegundo = new Color(51, 153, 204); 
	Color azulTercero = new Color(204, 229, 255); 
	Color amarilloPrimero = new Color(253,253,150);
	//Color amarilloSegundo = new Color(248,248,195);
	Color fondoClaro = new Color(238, 235, 228); 
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JPanel panelAnonimo;
	JPanel panelArbitro;
	JPanel panelAdmin;
	private JButton anonCerrarSesion;
	
	// -- JORNDAS --
	private JPanel verJornadas;
	private JPanel northPanelJornadas;
	private JPanel panelJornadas;
	private JLabel lblGestionarEquipos;
	private JPanel panelSur;
	private JPanel listContainer;
	private JPanel headerPanelJornadas;
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
	private JPanel midPanel;
	private JPanel scrollPanel;
	private JScrollPane scrollPane;
	private JPanel clasificacionListContainer;
	private JList<String> listEquipos;
	private JList<String> listPTOS;
	private JList<String> listPJ;
	private JList<String> listPG;
	private JList<String> listPP;
	private JList<String> listSG;
	private JList<String> listSP;
	private JList<String> listTA;
	private JList<String> listTC;
	

	/**
	 * Create the frame.
	 */
	public AppPrincipal(String username) {
		//LOGO Y TITULO
		setTitle("RFEVB Tracker");
		// OBTIENE EL RECURSO DE LA DIRECCION RELATIVA
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayoutPrincipal = new CardLayout(0,0);
		contentPane.setLayout(cardLayoutPrincipal);
		
		/*PANEL ANONIMO*/
		panelAnonimo = new JPanel();
		contentPane.add(panelAnonimo, "PanelAnonimo_");
		
		panelAnonimo.setLayout(new BorderLayout(0, 0));
		scrollPanel = new JPanel();
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(scrollPanel);
		panelAnonimo.add(scrollPane, BorderLayout.CENTER);
		
		/*SUB PANEL ANONIMOS - VER JORNDAS*/
		// <-- CORRECCIÓN 4: Estas líneas ya no son necesarias aquí, se movieron arriba.
		// panelAnonimo.setLayout(new BorderLayout(0, 0));
		// scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		verJornadas = new JPanel();
		verJornadas.setBorder(new EmptyBorder(5, 5, 5, 5));
		verJornadas.setBackground(new Color(238, 235, 228));
		scrollPanel.add(verJornadas); // <-- Esto está bien
		verJornadas.setLayout(new BorderLayout(0, 0));
		
		/*PANEL NORTE - VER JORNADAS*/
		northPanelJornadas = new JPanel();
		verJornadas.add(northPanelJornadas, BorderLayout.NORTH);
		
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
		
		headerPanelJornadas = new JPanel();
		headerPanelJornadas.setBackground(new Color(51, 153, 204));
		listContainer.add(headerPanelJornadas, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanelJornadas = new GridBagLayout();
		gbl_headerPanelJornadas.columnWidths = new int[] {0, 0, 0, 0, 0, 20, 0, 30, 30};
		gbl_headerPanelJornadas.rowHeights = new int[]{19, 0};
		gbl_headerPanelJornadas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_headerPanelJornadas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerPanelJornadas.setLayout(gbl_headerPanelJornadas);
		
		headerNJornadas = new JLabel("Nº  ");
		headerNJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		headerNJornadas.setForeground(Color.WHITE);
		headerNJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerNJornadas = new GridBagConstraints();
		gbc_headerNJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_headerNJornadas.gridx = 0;
		gbc_headerNJornadas.gridy = 0;
		headerPanelJornadas.add(headerNJornadas, gbc_headerNJornadas);
		
		headerEqLocal = new JLabel("EQUIPO LOCAL");
		headerEqLocal.setHorizontalAlignment(SwingConstants.CENTER);
		headerEqLocal.setForeground(Color.WHITE);
		headerEqLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEqLocal = new GridBagConstraints();
		gbc_headerEqLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerEqLocal.insets = new Insets(0, 0, 0, 5);
		gbc_headerEqLocal.gridx = 2;
		gbc_headerEqLocal.gridy = 0;
		headerPanelJornadas.add(headerEqLocal, gbc_headerEqLocal);
		
		headerEqVisitante = new JLabel("EQUIPO VISITANTE");
		headerEqVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		headerEqVisitante.setForeground(Color.WHITE);
		headerEqVisitante.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEqVisitante = new GridBagConstraints();
		gbc_headerEqVisitante.insets = new Insets(0, 0, 0, 5);
		gbc_headerEqVisitante.fill = GridBagConstraints.BOTH;
		gbc_headerEqVisitante.gridx = 7;
		gbc_headerEqVisitante.gridy = 0;
		headerPanelJornadas.add(headerEqVisitante, gbc_headerEqVisitante);
		
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
		scrollPanel.add(verClasificacion);
		verClasificacion.setLayout(new BorderLayout(0, 0));
		
		/*CLASIFICACION - NORTE*/
		northPanelClasificacion = new JPanel();
		verClasificacion.add(northPanelClasificacion, BorderLayout.NORTH);
		
		lblClasificacion = new JLabel("CLASIFICACIÓN");
		lblClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacion.setForeground(new Color(0, 128, 192));
		lblClasificacion.setFont(new Font("Leelawadee", Font.BOLD, 25));
		northPanelClasificacion.add(lblClasificacion);
		
		/*CLASIFICACION - CENTRO*/
		midPanel = new JPanel();
		verClasificacion.add(midPanel, BorderLayout.CENTER);

		// CAMBIO: Damos un layout a midPanel para que listContainer se expanda
		midPanel.setLayout(new BorderLayout());

		// CONTENEDOR D ELISTAS Y CAVEZERAS
		JPanel listContainer = new JPanel(new BorderLayout());

		// ¡¡¡ ELIMINA ESTA LÍNEA !!! ¡Arruina el JScrollPane!
		// listContainer.setPreferredSize(new Dimension(1500, numRows * rowHeight + headerHeight)); 

		// CAMBIO: Añade listContainer a midPanel para que sea visible
		midPanel.add(listContainer, BorderLayout.CENTER);

		// PANEL CABEZERA
		// CAMBIO: (1, 2) es incorrecto. Usa (1, 0) para todas las columnas.
		JPanel headerPanelClasificacion = new JPanel(new GridLayout(1, 0, 0, 0)); 
		headerPanelClasificacion.setBackground(azulSegundo); // Asumo que 'azulSegundo' está definida
		listContainer.add(headerPanelClasificacion, BorderLayout.NORTH);

		// CABEZERA EQUIPO
		JLabel headerEquipo = new JLabel("EQUIPO");
		headerEquipo.setForeground(Color.WHITE);
		headerEquipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanelClasificacion.add(headerEquipo);

		JLabel headerPTOS = new JLabel("PTOS");
		headerPTOS.setHorizontalAlignment(SwingConstants.CENTER);
		headerPTOS.setForeground(Color.WHITE);
		headerPTOS.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPTOS);

		JLabel headerPJ = new JLabel("P.J");
		headerPJ.setHorizontalAlignment(SwingConstants.CENTER);
		headerPJ.setForeground(Color.WHITE);
		headerPJ.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPJ);

		JLabel headerPG = new JLabel("P.G");
		headerPG.setHorizontalAlignment(SwingConstants.CENTER);
		headerPG.setForeground(Color.WHITE);
		headerPG.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPG);

		JLabel headerPP = new JLabel("P.P");
		headerPP.setHorizontalAlignment(SwingConstants.CENTER);
		headerPP.setForeground(Color.WHITE);
		headerPP.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPP);

		JLabel headerSG = new JLabel("S.G");
		headerSG.setHorizontalAlignment(SwingConstants.CENTER);
		headerSG.setForeground(Color.WHITE);
		headerSG.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerSG);

		JLabel headerSP = new JLabel("S.P");
		headerSP.setHorizontalAlignment(SwingConstants.CENTER);
		headerSP.setForeground(Color.WHITE);
		headerSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerSP);

		JLabel headerTA = new JLabel("T.A");
		headerTA.setHorizontalAlignment(SwingConstants.CENTER);
		headerTA.setForeground(Color.WHITE);
		headerTA.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerTA);

		JLabel headerTC = new JLabel("T.C");
		headerTC.setHorizontalAlignment(SwingConstants.CENTER);
		headerTC.setForeground(Color.WHITE);
		headerTC.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerTC);		
		
		clasificacionListContainer = new JPanel();
		listContainer.add(clasificacionListContainer, BorderLayout.CENTER);
		clasificacionListContainer.setLayout(new GridLayout(0, 9, 0, 0));
		
		listEquipos.setForeground(new Color(50, 50, 50));
		listEquipos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEquipos.setFixedCellHeight(25);
		listEquipos.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listEquipos);
		
		listPTOS = new JList<String>();
		listPTOS.setForeground(new Color(50, 50, 50));
		listPTOS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPTOS.setFixedCellHeight(25);
		listPTOS.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPTOS);
		
		listPJ = new JList<String>();
		listPJ.setForeground(new Color(50, 50, 50));
		listPJ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPJ.setFixedCellHeight(25);
		listPJ.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPJ);
		
		listPG = new JList<String>();
		listPG.setForeground(new Color(50, 50, 50));
		listPG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPG.setFixedCellHeight(25);
		listPG.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPG);
		
		listPP = new JList<String>();
		listPP.setForeground(new Color(50, 50, 50));
		listPP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPP.setFixedCellHeight(25);
		listPP.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPP);
		
		listSG = new JList<String>();
		listSG.setForeground(new Color(50, 50, 50));
		listSG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSG.setFixedCellHeight(25);
		listSG.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listSG);
		
		listSP = new JList<String>();
		listSP.setForeground(new Color(50, 50, 50));
		listSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSP.setFixedCellHeight(25);
		listSP.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listSP);
		
		listTA = new JList<String>();
		listTA.setForeground(new Color(50, 50, 50));
		listTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTA.setFixedCellHeight(25);
		listTA.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listTA);
		
		listTC = new JList<String>();
		listTC.setForeground(new Color(50, 50, 50));
		listTC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTC.setFixedCellHeight(25);
		listTC.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listTC);
		
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
