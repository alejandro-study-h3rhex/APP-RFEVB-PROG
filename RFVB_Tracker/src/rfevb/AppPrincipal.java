package rfevb;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.ListModel;



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
	
	JPanel panelArbitro;
	JPanel panelAdmin;
	private JButton CerrarSesion;
	
	// -- ANON --
	JPanel panelAnonimo;
	private JPanel panelListasVerJornadas;
	private JPanel midPanel;
	private JScrollPane scrollPaneAnonimo;
	private JPanel scrollPanelAnonimo;


	// -- JORNDAS ANON --
	private JComboBox<String> comboBoxJornadas;
	private JPanel verJornadas;
	private JPanel northPanelJornadas;
	private JPanel panelVerJornadas;
	private JLabel lblVerEquipos;
	private JPanel listContainerVerJornadas;
	private JPanel headerPanelJornadas;
	private JLabel headerNJornadas;
	private JLabel headerEqLocal;
	private JLabel headerEqVisitante;
	private JPanel anonListPanelJorndas;
	private JList<String> listEqLocal;
	private JList<String> listEqVisitante;
	
	// -- CLASIFICACIÓN ANON --
	private JPanel verClasificacion;
	private JPanel northPanelClasificacion;
	private JLabel lblClasificacion;
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
	
	// -- ARBITRO --
	private JScrollPane scrollPaneArbitro;
	private JPanel scrollPanelArbitro;

	private JPanel gestionarJornadas;
	private JPanel gestionarClasifiacion;
	private JPanel northPanelGestionarJornadas;
	private JComboBox<String> comboBoxGestionarJornadas;
	private JButton btnCerrarSesionArbitros;
	private JPanel panelGestionarJornadas;
	private JLabel lblGestionarJornadas;
	private JPanel panelListasGestionarJornadas;
	private JPanel listContainerGestionarJornadas;
	private JPanel headerPanelGestionarJornadas;
	private JLabel headerNJornadas_1;
	private JLabel headerEqLocal_1;
	private JLabel headerEqVisitante_1;
	private JPanel arbitroListPanelJornadas;
	private JList<String> listEqLocalGestionar;
	private JList<String> listEqVisitanteGestionar;
	
	// -- DLMs --
	
	/*EQUIPOS*/
	private DefaultListModel<String> dlmEquipos;
	/*JORNADAS*/
	private DefaultListModel<String> dlmJornadasEqLocal;
	private DefaultListModel<String> dlmJornadasEqVisitante;
	private	DefaultComboBoxModel<String> dcbmNumeroJornada;
	private String[] equiposLocales = {
			// Jornada 1
			"CV ZARAGOZA",
			"CV RIVAS",
			"CV TORRELAVEGA",
			// Jornada 2
			"VALLADOLID CV",
			"CV ZARAGOZA",
			"CV SAN FERNANDO",
			// Jornada 3
			"CV ZARAGOZA",
			"CV RIVAS",
			"CV SAN FERNANDO",
			// Jornada 4
			"CV ZARAGOZA",
			"CV PALMA",
			"CV RIVAS",
			// Jornada 5
			"CV ZARAGOZA",
			"CV TORRELAVEGA",
			"CV PALMA",
			// Jornada 6
			"VALLADOLID CV",
			"CV RIVAS",
			"CV PALMA",
			// Jornada 7
			"CV ZARAGOZA",
			"CV PALMA",
			"VALLADOLID CV",
			// Jornada 8
			"CV PALMA",
			"CV TORRELAVEGA",
			"VALLADOLID CV",
			// Jornada 9
			"CV TORRELAVEGA",
			"VALLADOLID CV",
			"CV SAN FERNANDO",
			// Jornada 10
			"VALLADOLID CV",
			"CV SAN FERNANDO",
			"CV RIVAS"
		};
		
		private String[] equiposVisitantes = {
			// Jornada 1
			"CV SAN FERNANDO",
			"CV PALMA",
			"VALLADOLID CV",
			// Jornada 2
			"CV PALMA",
			"CV RIVAS",
			"CV TORRELAVEGA",
			// Jornada 3
			"CV PALMA",
			"CV TORRELAVEGA",
			"VALLADOLID CV",
			// Jornada 4
			"CV TORRELAVEGA",
			"VALLADOLID CV",
			"CV SAN FERNANDO",
			// Jornada 5
			"VALLADOLID CV",
			"CV SAN FERNANDO",
			"CV RIVAS",
			// Jornada 6
			"CV ZARAGOZA",
			"VALLADOLID CV",
			"CV RIVAS",
			// Jornada 7
			"CV SAN FERNANDO",
			"CV RIVAS",
			"CV TORRELAVEGA",
			// Jornada 8
			"CV ZARAGOZA",
			"CV RIVAS",
			"CV SAN FERNANDO",
			// Jornada 9
			"CV ZARAGOZA",
			"CV RIVAS",
			"CV PALMA",
			// Jornada 10
			"CV ZARAGOZA",
			"CV TORRELAVEGA",
			"CV PALMA"
		};
	/*CLASIFICACIÓN*/
	private DefaultListModel<Integer> dlmClasificacionPuntos;
	private DefaultListModel<Integer> dlmClasificacionPartidosJugados;
	private DefaultListModel<Integer> dlmClasificacionPartidosGanados;
	private DefaultListModel<Integer> dlmClasificacionPartidosPerdidos;
	private DefaultListModel<Integer> dlmClasificacionSetsGanados;
	private DefaultListModel<Integer> dlmClasificacionSetsPerdidos;
	private DefaultListModel<Integer> dlmClasificacionTantosFavor;
	private DefaultListModel<Integer> dlmClasificacionTantosContra;
	private JPanel panelListasGestionarResultadosJornadas;
	private JPanel panelResultadosHeader;
	private JPanel panelResultadosListas;
	private JLabel headerEquipo_1;
	private JLabel headerPTOS_1;
	private JLabel headerPJ_1;
	private JLabel headerPG_1;
	private JLabel headerPP_1;
	private JLabel headerSG_1;
	private JLabel headerSP_1;
	private JLabel headerTA_1;
	private JLabel headerTC_1;
	
	// -- DLMs --
	

	/**
	 * Create the frame.
	 */
	public AppPrincipal(String username) {
		
		/*INICIALIZAR DLMs*/
		
		/*EQUIPOS*/
		dlmEquipos = new DefaultListModel<String>();
		/*JORNADAS*/
		dlmJornadasEqLocal = new DefaultListModel<String>();
		dlmJornadasEqVisitante = new DefaultListModel<String>();
		dcbmNumeroJornada = new DefaultComboBoxModel<String>();
		
		/*CLASIFICACIÓN*/
		dlmClasificacionPuntos = new DefaultListModel<Integer>();
		dlmClasificacionPartidosJugados = new DefaultListModel<Integer>();
		dlmClasificacionPartidosGanados = new DefaultListModel<Integer>();
		dlmClasificacionPartidosPerdidos = new DefaultListModel<Integer>();
		dlmClasificacionSetsGanados = new DefaultListModel<Integer>();
		dlmClasificacionSetsPerdidos = new DefaultListModel<Integer>();
		dlmClasificacionTantosFavor = new DefaultListModel<Integer>();
		dlmClasificacionTantosContra = new DefaultListModel<Integer>();
		
		/*LLENAR DLMs y Arrays*/
		setEquipos(dlmEquipos);
		/*Por defecto se muestra la primera jornada*/
		setEquiposLocales(dlmJornadasEqLocal, 0, 2);
		setEquiposVisitantes(dlmJornadasEqVisitante, 0, 2);
		/*SET NUMERO JORNDAS*/
		setNumeroJorndas(dcbmNumeroJornada, 10);
		
		
		
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
		scrollPanelAnonimo = new JPanel();
		scrollPanelAnonimo.setLayout(new BoxLayout(scrollPanelAnonimo, BoxLayout.Y_AXIS));
		scrollPaneAnonimo = new JScrollPane(scrollPanelAnonimo);
		panelAnonimo.add(scrollPaneAnonimo, BorderLayout.CENTER);
		
		verJornadas = new JPanel();
		verJornadas.setBorder(new EmptyBorder(5, 5, 5, 5));
		verJornadas.setBackground(new Color(238, 235, 228));
		scrollPanelAnonimo.add(verJornadas); // <-- Esto está bien
		verJornadas.setLayout(new BorderLayout(0, 0));
		
		/*PANEL NORTE - VER JORNADAS*/
		northPanelJornadas = new JPanel();
		verJornadas.add(northPanelJornadas, BorderLayout.NORTH);
		
		/*SELECIONAR JORNDAS*/
		comboBoxJornadas = new JComboBox<String>(dcbmNumeroJornada);
		comboBoxJornadas.setSelectedIndex(0);
		comboBoxJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		// Asumiendo que 'comboBoxJornadas' ya está inicializado
		comboBoxJornadas.addItemListener(new ItemListener() {
		    
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        
		        // Comprobamos si el evento es de un ítem que acaba de ser SELECCIONADO
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            int indiceSeleccionado = comboBoxJornadas.getSelectedIndex();
		            setEquiposLocales(dlmJornadasEqLocal, indiceSeleccionado, indiceSeleccionado+2);
		            setEquiposVisitantes(dlmJornadasEqVisitante, indiceSeleccionado, indiceSeleccionado+2);
		        }
		    }
		});
		northPanelJornadas.add(comboBoxJornadas);
		
		CerrarSesion = new JButton("Cerrar Sesion");
		CerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 20));
		northPanelJornadas.add(CerrarSesion);
			
		panelVerJornadas = new JPanel();
		panelVerJornadas.setBackground(new Color(238, 235, 228));
		verJornadas.add(panelVerJornadas, BorderLayout.CENTER);
		panelVerJornadas.setLayout(new BorderLayout(0, 20));
		
		lblVerEquipos = new JLabel("JORNADAS");
		lblVerEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerEquipos.setForeground(new Color(0, 128, 192));
		lblVerEquipos.setFont(new Font("Leelawadee", Font.BOLD, 25));
		panelVerJornadas.add(lblVerEquipos, BorderLayout.NORTH);
		
		panelListasVerJornadas = new JPanel();
		panelListasVerJornadas.setBackground(new Color(238, 235, 228));
		panelVerJornadas.add(panelListasVerJornadas, BorderLayout.SOUTH);
		
		listContainerVerJornadas = new JPanel((LayoutManager) null);
		listContainerVerJornadas.setPreferredSize(new Dimension(500, 180));
		panelListasVerJornadas.add(listContainerVerJornadas);
		listContainerVerJornadas.setLayout(new BorderLayout());
		
		headerPanelJornadas = new JPanel();
		headerPanelJornadas.setBackground(new Color(51, 153, 204));
		listContainerVerJornadas.add(headerPanelJornadas, BorderLayout.NORTH);
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
		listContainerVerJornadas.add(anonListPanelJorndas, BorderLayout.CENTER);
		anonListPanelJorndas.setLayout(new GridLayout(0, 2, 0, 0));
		
		/*JORNADAS - EQ LOCALES*/
		listEqLocal = new JList<String>(dlmJornadasEqLocal);
		listEqLocal.setForeground(new Color(50, 50, 50));
		listEqLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqLocal.setFixedCellHeight(25);
		listEqLocal.setBackground(new Color(204, 229, 255));
		anonListPanelJorndas.add(listEqLocal);
		
		/*JORNADAS - EQ VISITANTES*/
		listEqVisitante = new JList<String>(dlmJornadasEqVisitante);
		listEqVisitante.setForeground(new Color(50, 50, 50));
		listEqVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqVisitante.setFixedCellHeight(25);
		listEqVisitante.setBackground(new Color(204, 229, 255));
		anonListPanelJorndas.add(listEqVisitante);
		
		/*SUB PANEL ANONIMOS - VER CLASIFICIÓN*/
		verClasificacion = new JPanel();
		scrollPanelAnonimo.add(verClasificacion);
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
		midPanel.setLayout(new BorderLayout());
		
		// CONTENEDOR D ELISTAS Y CAVEZERAS
		JPanel listContainer = new JPanel(new BorderLayout());

		midPanel.add(listContainer, BorderLayout.CENTER);

		// PANEL CABEZERA
		JPanel headerPanelClasificacion = new JPanel(new GridLayout(1, 0, 0, 0)); 
		headerPanelClasificacion.setBackground(azulSegundo);
		listContainer.add(headerPanelClasificacion, BorderLayout.NORTH);

		clasificacionListContainer = new JPanel();
		listContainer.add(clasificacionListContainer, BorderLayout.CENTER);
		clasificacionListContainer.setLayout(new GridLayout(0, 9, 0, 0));
	
		/*JLIST - EQUIPOS*/
		listEquipos = new JList<String>(dlmEquipos);
		listEquipos.setForeground(new Color(50, 50, 50));
		listEquipos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEquipos.setFixedCellHeight(25);
		listEquipos.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listEquipos);
		
		JLabel headerEquipo = new JLabel("EQUIPO");
		headerEquipo.setForeground(Color.WHITE);
		headerEquipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanelClasificacion.add(headerEquipo);
		
		/*JLIST - PUNTOS*/
		listPTOS = new JList<String>();
		listPTOS.setForeground(new Color(50, 50, 50));
		listPTOS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPTOS.setFixedCellHeight(25);
		listPTOS.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPTOS);
		
		JLabel headerPTOS = new JLabel("PTOS");
		headerPTOS.setHorizontalAlignment(SwingConstants.CENTER);
		headerPTOS.setForeground(Color.WHITE);
		headerPTOS.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPTOS);
		
		/*JLIST - Partidos Jugados*/
		listPJ = new JList<String>();
		listPJ.setForeground(new Color(50, 50, 50));
		listPJ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPJ.setFixedCellHeight(25);
		listPJ.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPJ);
		

		JLabel headerPJ = new JLabel("P.J");
		headerPJ.setHorizontalAlignment(SwingConstants.CENTER);
		headerPJ.setForeground(Color.WHITE);
		headerPJ.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPJ);

		
		/*JLIST - Partidos Ganados*/
		listPG = new JList<String>();
		listPG.setForeground(new Color(50, 50, 50));
		listPG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPG.setFixedCellHeight(25);
		listPG.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPG);
		
		JLabel headerPG = new JLabel("P.G");
		headerPG.setHorizontalAlignment(SwingConstants.CENTER);
		headerPG.setForeground(Color.WHITE);
		headerPG.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPG);
		
		/*JLIST - Partidos Perdidos*/
		listPP = new JList<String>();
		listPP.setForeground(new Color(50, 50, 50));
		listPP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPP.setFixedCellHeight(25);
		listPP.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listPP);
		
		JLabel headerPP = new JLabel("P.P");
		headerPP.setHorizontalAlignment(SwingConstants.CENTER);
		headerPP.setForeground(Color.WHITE);
		headerPP.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerPP);
		
		/*JLIST - Sets Ganados*/
		listSG = new JList<String>();
		listSG.setForeground(new Color(50, 50, 50));
		listSG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSG.setFixedCellHeight(25);
		listSG.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listSG);
		
		JLabel headerSG = new JLabel("S.G");
		headerSG.setHorizontalAlignment(SwingConstants.CENTER);
		headerSG.setForeground(Color.WHITE);
		headerSG.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerSG);
	
		/*JLIST - Sets Perdidos*/
		listSP = new JList<String>();
		listSP.setForeground(new Color(50, 50, 50));
		listSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSP.setFixedCellHeight(25);
		listSP.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listSP);
		
		JLabel headerSP = new JLabel("S.P");
		headerSP.setHorizontalAlignment(SwingConstants.CENTER);
		headerSP.setForeground(Color.WHITE);
		headerSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerSP);
		
		/*JLIST - Tantos a Favor*/
		listTA = new JList<String>();
		listTA.setForeground(new Color(50, 50, 50));
		listTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTA.setFixedCellHeight(25);
		listTA.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listTA);

		JLabel headerTA = new JLabel("T.A");
		headerTA.setHorizontalAlignment(SwingConstants.CENTER);
		headerTA.setForeground(Color.WHITE);
		headerTA.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerTA);

		
		/*JLIST - Tantos en Contra*/
		listTC = new JList<String>();
		listTC.setForeground(new Color(50, 50, 50));
		listTC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTC.setFixedCellHeight(25);
		listTC.setBackground(new Color(204, 229, 255));
		clasificacionListContainer.add(listTC);
		
		JLabel headerTC = new JLabel("T.C");
		headerTC.setHorizontalAlignment(SwingConstants.CENTER);
		headerTC.setForeground(Color.WHITE);
		headerTC.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanelClasificacion.add(headerTC);
		panelArbitro = new JPanel();
		contentPane.add(panelArbitro, "PanelArbitro_");
		panelArbitro.setLayout(new BorderLayout(0, 0));

		scrollPanelArbitro = new JPanel();
		scrollPanelArbitro.setLayout(new BoxLayout(scrollPanelArbitro, BoxLayout.Y_AXIS));

		scrollPaneArbitro = new JScrollPane(scrollPanelArbitro);
		panelArbitro.add(scrollPaneArbitro, BorderLayout.CENTER);
		gestionarJornadas = new JPanel();
		scrollPanelArbitro.add(gestionarJornadas);
		gestionarJornadas.setLayout(new BorderLayout(0, 0));

		northPanelGestionarJornadas = new JPanel();
		gestionarJornadas.add(northPanelGestionarJornadas, BorderLayout.NORTH);
		
		comboBoxGestionarJornadas = new JComboBox<String>(dcbmNumeroJornada);
		comboBoxGestionarJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxGestionarJornadas.addItemListener(new ItemListener() {
		    
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        
		        // Comprobamos si el evento es de un ítem que acaba de ser SELECCIONADO
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            int indiceSeleccionado = comboBoxJornadas.getSelectedIndex();
		            setEquiposLocales(dlmJornadasEqLocal, indiceSeleccionado, indiceSeleccionado+2);
		            setEquiposVisitantes(dlmJornadasEqVisitante, indiceSeleccionado, indiceSeleccionado+2);
		        }
		    }
		});
		northPanelGestionarJornadas.add(comboBoxGestionarJornadas);
		
		btnCerrarSesionArbitros = new JButton("Cerrar Sesion");
		btnCerrarSesionArbitros.setFont(new Font("Calibri", Font.PLAIN, 20));
		northPanelGestionarJornadas.add(btnCerrarSesionArbitros);
		
		panelGestionarJornadas = new JPanel();
		panelGestionarJornadas.setBackground(new Color(238, 235, 228));
		gestionarJornadas.add(panelGestionarJornadas, BorderLayout.CENTER);
		panelGestionarJornadas.setLayout(new BoxLayout(panelGestionarJornadas, BoxLayout.Y_AXIS));
		
		lblGestionarJornadas = new JLabel("GESTIONAR JORNADAS");
		lblGestionarJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarJornadas.setForeground(new Color(0, 128, 192));
		lblGestionarJornadas.setFont(new Font("Leelawadee", Font.BOLD, 25));
		panelGestionarJornadas.add(lblGestionarJornadas);
		
		panelListasGestionarJornadas = new JPanel();
		panelGestionarJornadas.add(panelListasGestionarJornadas);
		
		listContainerGestionarJornadas = new JPanel((LayoutManager) null);
		listContainerGestionarJornadas.setPreferredSize(new Dimension(500, 180));
		panelListasGestionarJornadas.add(listContainerGestionarJornadas);
		listContainerGestionarJornadas.setLayout(new BorderLayout());
		
		headerPanelGestionarJornadas = new JPanel();
		headerPanelGestionarJornadas.setBackground(new Color(77, 130, 188));
		listContainerGestionarJornadas.add(headerPanelGestionarJornadas, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanelGestionarJornadas = new GridBagLayout();
		gbl_headerPanelGestionarJornadas.columnWidths = new int[]{40, 30, 117, 152, 0};
		gbl_headerPanelGestionarJornadas.rowHeights = new int[]{19, 0};
		gbl_headerPanelGestionarJornadas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_headerPanelGestionarJornadas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerPanelGestionarJornadas.setLayout(gbl_headerPanelGestionarJornadas);
		
			
		headerNJornadas_1 = new JLabel("Nº  ");
		headerNJornadas_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerNJornadas_1.setForeground(Color.WHITE);
		headerNJornadas_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerNJornadas_1 = new GridBagConstraints();
		gbc_headerNJornadas_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerNJornadas_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerNJornadas_1.gridx = 0;
		gbc_headerNJornadas_1.gridy = 0;
		headerPanelGestionarJornadas.add(headerNJornadas_1, gbc_headerNJornadas_1);
		
		headerEqLocal_1 = new JLabel("EQUIPO LOCAL");
		headerEqLocal_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerEqLocal_1.setForeground(Color.WHITE);
		headerEqLocal_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEqLocal_1 = new GridBagConstraints();
		gbc_headerEqLocal_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerEqLocal_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerEqLocal_1.gridx = 1;
		gbc_headerEqLocal_1.gridy = 0;
		headerPanelGestionarJornadas.add(headerEqLocal_1, gbc_headerEqLocal_1);
		
		headerEqVisitante_1 = new JLabel("EQUIPO VISITANTE");
		headerEqVisitante_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerEqVisitante_1.setForeground(Color.WHITE);
		headerEqVisitante_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEqVisitante_1 = new GridBagConstraints();
		gbc_headerEqVisitante_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerEqVisitante_1.gridx = 3;
		gbc_headerEqVisitante_1.gridy = 0;
		headerPanelGestionarJornadas.add(headerEqVisitante_1, gbc_headerEqVisitante_1);
		
		arbitroListPanelJornadas = new JPanel();
		listContainerGestionarJornadas.add(arbitroListPanelJornadas, BorderLayout.CENTER);
		arbitroListPanelJornadas.setLayout(new GridLayout(0, 2, 0, 0));
		
		listEqLocalGestionar = new JList<String>(dlmJornadasEqLocal);
		listEqLocalGestionar.setForeground(new Color(50, 50, 50));
		listEqLocalGestionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqLocalGestionar.setFixedCellHeight(25);
		listEqLocalGestionar.setBackground(new Color(204, 229, 255));
		arbitroListPanelJornadas.add(listEqLocalGestionar);
		
		listEqVisitanteGestionar = new JList<String>(dlmJornadasEqVisitante);
		listEqVisitanteGestionar.setForeground(new Color(50, 50, 50));
		listEqVisitanteGestionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqVisitanteGestionar.setFixedCellHeight(25);
		listEqVisitanteGestionar.setBackground(new Color(204, 229, 255));
		arbitroListPanelJornadas.add(listEqVisitanteGestionar);
		
		panelListasGestionarResultadosJornadas = new JPanel();
		panelGestionarJornadas.add(panelListasGestionarResultadosJornadas);
		panelListasGestionarResultadosJornadas.setLayout(new BorderLayout(0, 0));
		
		/*CABEZERA GESTIONAR RESULTADOS JORNADAS*/
		panelResultadosHeader = new JPanel(new GridLayout(1, 0, 0, 0)); 
		panelResultadosHeader.setBackground(new Color(77, 130, 188));
		panelListasGestionarResultadosJornadas.add(panelResultadosHeader, BorderLayout.NORTH);
		GridBagLayout gbl_panelResultadosHeader = new GridBagLayout();
		gbl_panelResultadosHeader.columnWidths = new int[]{239, 62, 41, 22, 26, 24, 26, 24, 25, 25, 0};
		gbl_panelResultadosHeader.rowHeights = new int[]{19, 0};
		gbl_panelResultadosHeader.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelResultadosHeader.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelResultadosHeader.setLayout(gbl_panelResultadosHeader);
		
		headerEquipo_1 = new JLabel("EQUIPO");
		headerEquipo_1.setBackground(new Color(77, 130, 188));
		headerEquipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerEquipo_1.setForeground(Color.WHITE);
		headerEquipo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerEquipo_1 = new GridBagConstraints();
		gbc_headerEquipo_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerEquipo_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerEquipo_1.gridx = 1;
		gbc_headerEquipo_1.gridy = 0;
		panelResultadosHeader.add(headerEquipo_1, gbc_headerEquipo_1);
		
		headerPTOS_1 = new JLabel("PTOS");
		headerPTOS_1.setBackground(new Color(77, 130, 188));
		headerPTOS_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerPTOS_1.setForeground(Color.WHITE);
		headerPTOS_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerPTOS_1 = new GridBagConstraints();
		gbc_headerPTOS_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerPTOS_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerPTOS_1.gridx = 2;
		gbc_headerPTOS_1.gridy = 0;
		panelResultadosHeader.add(headerPTOS_1, gbc_headerPTOS_1);
		
		headerPJ_1 = new JLabel("P.J");
		headerPJ_1.setBackground(new Color(77, 130, 188));
		headerPJ_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerPJ_1.setForeground(Color.WHITE);
		headerPJ_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerPJ_1 = new GridBagConstraints();
		gbc_headerPJ_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerPJ_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerPJ_1.gridx = 3;
		gbc_headerPJ_1.gridy = 0;
		panelResultadosHeader.add(headerPJ_1, gbc_headerPJ_1);
		
		headerPG_1 = new JLabel("P.G");
		headerPG_1.setBackground(new Color(77, 130, 188));
		headerPG_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerPG_1.setForeground(Color.WHITE);
		headerPG_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerPG_1 = new GridBagConstraints();
		gbc_headerPG_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerPG_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerPG_1.gridx = 4;
		gbc_headerPG_1.gridy = 0;
		panelResultadosHeader.add(headerPG_1, gbc_headerPG_1);
		
		headerPP_1 = new JLabel("P.P");
		headerPP_1.setBackground(new Color(77, 130, 188));
		headerPP_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerPP_1.setForeground(Color.WHITE);
		headerPP_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerPP_1 = new GridBagConstraints();
		gbc_headerPP_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerPP_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerPP_1.gridx = 5;
		gbc_headerPP_1.gridy = 0;
		panelResultadosHeader.add(headerPP_1, gbc_headerPP_1);
		
		headerSG_1 = new JLabel("S.G");
		headerSG_1.setBackground(new Color(77, 130, 188));
		headerSG_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerSG_1.setForeground(Color.WHITE);
		headerSG_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerSG_1 = new GridBagConstraints();
		gbc_headerSG_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerSG_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerSG_1.gridx = 6;
		gbc_headerSG_1.gridy = 0;
		panelResultadosHeader.add(headerSG_1, gbc_headerSG_1);
		
		headerSP_1 = new JLabel("S.P");
		headerSP_1.setBackground(new Color(77, 130, 188));
		headerSP_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerSP_1.setForeground(Color.WHITE);
		headerSP_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerSP_1 = new GridBagConstraints();
		gbc_headerSP_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerSP_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerSP_1.gridx = 7;
		gbc_headerSP_1.gridy = 0;
		panelResultadosHeader.add(headerSP_1, gbc_headerSP_1);
		
		headerTA_1 = new JLabel("T.A");
		headerTA_1.setBackground(new Color(77, 130, 188));
		headerTA_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerTA_1.setForeground(Color.WHITE);
		headerTA_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerTA_1 = new GridBagConstraints();
		gbc_headerTA_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerTA_1.insets = new Insets(0, 0, 0, 5);
		gbc_headerTA_1.gridx = 8;
		gbc_headerTA_1.gridy = 0;
		panelResultadosHeader.add(headerTA_1, gbc_headerTA_1);
		
		headerTC_1 = new JLabel("T.C");
		headerTC_1.setBackground(new Color(77, 130, 188));
		headerTC_1.setHorizontalAlignment(SwingConstants.CENTER);
		headerTC_1.setForeground(Color.WHITE);
		headerTC_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerTC_1 = new GridBagConstraints();
		gbc_headerTC_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerTC_1.gridx = 9;
		gbc_headerTC_1.gridy = 0;
		panelResultadosHeader.add(headerTC_1, gbc_headerTC_1);
		
		panelResultadosListas = new JPanel();
		panelListasGestionarResultadosJornadas.add(panelResultadosListas, BorderLayout.CENTER);

		gestionarClasifiacion = new JPanel();
		scrollPanelArbitro.add(gestionarClasifiacion);
		
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
	
	private void setEquipos(DefaultListModel<String> dlmEquipos) {
		String[] equipos = {"CV Zaragoza", "CV San Fernando", "CV Valladolid", "CV Torrelavega", "CV Palma", "CV Rivas"};
		for(int i = 0; i < equipos.length; i++) {
			/*
			  Añades a la dlm en el indice (i) el valor de el array (i)
			  i = 3 -> dlmEquipos.add(3, "CV Valladolid")
			 */
			dlmEquipos.add(i, equipos[i]);
		}
	}
	
	/*Esta funcion vaciara la dlm y la rellenada con el rango estableciado */
	private void setEquiposLocales(DefaultListModel<String> dlmEquiposLocales,int minIndex,int maxIndex) {
		dlmEquiposLocales.clear(); // Vacia el dlm
		for(int i = minIndex; i <= maxIndex; i++) {
			dlmEquiposLocales.addElement(equiposLocales[i]);
		}
	}
	
	/*Esta funcion vaciara la dlm y la rellenada con el rango estableciado */
	private void setEquiposVisitantes(DefaultListModel<String> dlmEquiposVisitantes,int minIndex,int maxIndex) {
		dlmEquiposVisitantes.clear(); // Vacia el dlm
		for(int i = minIndex; i <= maxIndex; i++) {
			dlmEquiposVisitantes.addElement(equiposVisitantes[i]);
		}
	}
	
	/*Establece el numero de jornadas en la dlm -> Necesario para poder usar ComboBox*/
	private void setNumeroJorndas(DefaultComboBoxModel<String> dlmNumerosJorndas, int numeroJornadas) {
		for(int i = 1; i<= numeroJornadas; i++) {
			dlmNumerosJorndas.addElement("Jornada: " + i);
		}
	}

}
