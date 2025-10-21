package rfevb;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;



public class AppPrincipal extends JFrame implements ActionListener, ListSelectionListener{
	private String username;
	
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
	
	
	// -- ANON --
	JPanel panelAnonimo;
	private JPanel panelListasVerJornadas;
	private JPanel midPanel;
	private JScrollPane scrollPaneAnonimo;
	private JPanel scrollPanelAnonimo;
	private JButton btnCerrarSesion_ANON;


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
	private JButton btnCerrarSesion_ARBITRO;
	private JPanel panelGestionarJornadas;
	private JLabel lblGestionarJornadas;
	private JPanel panelListasGestionarJornadas;
	private JPanel listContainerGestionarJornadas;
	private JPanel headerPanelGestionarJornadas;
	private JLabel headerNJornadas_1;
	private JLabel headerEqLocal_1;
	private JLabel headerEqVisitante_1;
	private JPanel arbitroListPanelJornadas;
	/*EQUIPOS JORNADAS*/
	private JList<String> listEqLocalGestionar;
	private JList<String> listEqVisitanteGestionar;
	/*RESULTADOS*/
	private JList<String> listEquipos_resultadosJornadas;
	private JList<Integer> listPTOS_resultadosJornadas;
	private JList<Integer> listPJ_resultadosJornadas;
	private JList<Integer> listPG_resultadosJornadas;
	private JList<Integer> listPP_resultadosJornadas;
	private JList<Integer> listSG_resultadosJornadas;
	private JList<Integer> listSP_resultadosJornadas;
	private JList<Integer> listTA_resultadosJornadas;
	private JList<Integer> listTC_resultadosJornadas;
	private JTextField txtPtos_resultadosJornadas;
	private JTextField txtPJ_resultadosJornadas;
	private JTextField txtPG_resultadosJornadas;
	private JTextField txtPP_resultadosJornadas;
	private JTextField txtSG_resultadosJornadas;
	private JTextField txtSP_resultadosJornadas;
	private JTextField txtTA_resultadosJornadas;
	private JTextField txtTC_resultadosJornadas;
	private JButton btnInsertar_resultadosJornadas;
	private JButton btnBorrar_resultadosJornadas;
	private JButton btnLimpiar_resultadosJornadas;
	
	// -- DLMs --
	
	/*EQUIPOS*/
	private DefaultListModel<String> dlmEquipos;
	// -- MATRICES EQUIPOS --
	private int[][] matriz_zaragoza = new int[10][10];
	private int[][] matriz_valladolid = new int[10][10];
	private int[][] matriz_torrelavega = new int[10][10];
	private int[][] matriz_rivas = new int[10][10];
	private int[][] matriz_palma = new int[10][10];
	private int[][] matriz_sanfernando = new int[10][10];
	
	// -- INDICE DE CADA COLUMNA --> MAS FACIL EL ACCESO
	private final int COL_PJ = 0;       // Partidos Jugados
	private final int COL_PG = 1;       // Partidos Ganados
	private final int COL_PP = 2;       // Partidos Perdidos
	private final int COL_PUNTOS = 3;   // Puntos totales
	private final int COL_SG = 4;       // Sets Ganados
	private final int COL_SP = 5;       // Sets Perdidos
	private final int COL_TA = 6;       // Tantos a Favor
	private final int COL_TC = 7;       // Tantos en Contra
	
	// --- EL PUENTE/DICCIONARIO ---
    private Map<String, int[][]> mapaMatricesEquipos;
	
	/*JORNADAS*/
	private DefaultListModel<String> dlmJornadasEqLocal;
	private DefaultListModel<String> dlmJornadasEqVisitante;
	private	DefaultComboBoxModel<String> dcbmNumeroJornada;
	private String[] equiposLocales = {
			// Jornada 1
			"CV ZARAGOZA",
			"VALLADOLID CV",
			"CV TORRELAVEGA",
			// Jornada 2
			"CV ZARAGOZA",
			"CV SAN FERNANDO",
			"VALLADOLID CV",
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
			"CV SAN FERNANDO",
			"CV RIVAS",
			"CV PALMA",
			// Jornada 7
			"CV RIVAS",
			"CV PALMA",
			"CV TORRELAVEGA",
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
			    "CV RIVAS",       
			    "CV PALMA",       
			    // Jornada 2
			    "CV RIVAS",
			    "CV PALMA",        
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
			    "CV TORRELAVEGA", 
			    // Jornada 7
			    "CV ZARAGOZA",   
			    "CV SAN FERNANDO", 
			    "VALLADOLID CV",  
			    // Jornada 8
			    "CV ZARAGOZA",
			    "CV RIVAS",
			    "CV SAN FERNANDO",
			    // Jornada 9
			    "CV ZARAGOZA",
			    "CV PALMA",       
			    "CV RIVAS",      
			    // Jornada 10
			    "CV ZARAGOZA",
			    "CV TORRELAVEGA",
			    "CV PALMA"
		};
	/*GESTIONAR - RESULTADOS - JORNADAS*/
	//-- para los 8 datos de resultados de esos 6 equipos --
	private DefaultListModel<String> dlmJornadasEquipos_resultado;
	private DefaultListModel<Integer> dlmJornadasPuntos_resultado;
	private DefaultListModel<Integer> dlmJornadasPartidosJugados_resultado;
	private DefaultListModel<Integer> dlmJornadasPartidosGanados_resultado;
	private DefaultListModel<Integer> dlmJornadasPartidosPerdidos_resultado;
	private DefaultListModel<Integer> dlmJornadasSetsGanados_resultado;
	private DefaultListModel<Integer> dlmJornadasSetsPerdidos_resultado;
	private DefaultListModel<Integer> dlmJornadasTantosFavor_resultado;
	private DefaultListModel<Integer> dlmJornadasTantosContra_resultado;
		
		
	/*CLASIFICACIÓN*/
	private DefaultListModel<Integer> dlmClasificacionPuntos;
	private DefaultListModel<Integer> dlmClasificacionPartidosJugados;
	private DefaultListModel<Integer> dlmClasificacionPartidosGanados;
	private DefaultListModel<Integer> dlmClasificacionPartidosPerdidos;
	private DefaultListModel<Integer> dlmClasificacionSetsGanados;
	private DefaultListModel<Integer> dlmClasificacionSetsPerdidos;
	private DefaultListModel<Integer> dlmClasificacionTantosFavor;
	private DefaultListModel<Integer> dlmClasificacionTantosContra;
	private JPanel panelInputDatosJornadas;
	private JLabel lbl_Equipos_resultadosJornadas;
	private JTextField txtEquipos_resultadosJornadas;
	
	// -- DLMs --
	

	/**
	 * Create the frame.
	 */
	public AppPrincipal(String username_param) {
		// *GRACIAS A ESTE DICCIONARIO PODEMOS FACILMENTE USAR EL NOMBRE DE EL EQUIPO PARA ENCONTRAR SU MATRIZ* //
	    mapaMatricesEquipos = new HashMap<>();
	    
	    // Conectamos el String "CV ZARAGOZA" con la variable matriz_zaragoza
	    mapaMatricesEquipos.put("CV ZARAGOZA", matriz_zaragoza);
	    mapaMatricesEquipos.put("VALLADOLID CV", matriz_valladolid);
	    mapaMatricesEquipos.put("CV TORRELAVEGA", matriz_torrelavega);
	    mapaMatricesEquipos.put("CV RIVAS", matriz_rivas);
	    mapaMatricesEquipos.put("CV PALMA", matriz_palma);
	    mapaMatricesEquipos.put("CV SAN FERNANDO", matriz_sanfernando);
		
		// pasa el parametro recibido a una variable local
		username = username_param;
		
		/*INICIALIZAR DLMs*/
		
		/*EQUIPOS*/
		dlmEquipos = new DefaultListModel<String>();
		/*JORNADAS*/
		dlmJornadasEqLocal = new DefaultListModel<String>();
		dlmJornadasEqVisitante = new DefaultListModel<String>();
		dlmJornadasEquipos_resultado = new DefaultListModel<String>();
		dcbmNumeroJornada = new DefaultComboBoxModel<String>();
		// -- JORNADAS - RESULTADOS
		dlmJornadasPuntos_resultado = new DefaultListModel<Integer>();
		dlmJornadasPartidosJugados_resultado = new DefaultListModel<Integer>();
		dlmJornadasPartidosGanados_resultado = new DefaultListModel<Integer>();
		dlmJornadasPartidosPerdidos_resultado = new DefaultListModel<Integer>();
	    dlmJornadasSetsGanados_resultado = new DefaultListModel<Integer>();
	    dlmJornadasSetsPerdidos_resultado = new DefaultListModel<Integer>();
	    dlmJornadasTantosFavor_resultado = new DefaultListModel<Integer>();
	    dlmJornadasTantosContra_resultado = new DefaultListModel<Integer>();
		
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
		verJornadas.setBackground(fondoClaro);
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
		        	/*CAMBIA EN ANONIMO*/
		        	cambiarJornada(comboBoxJornadas, headerNJornadas);
		        }
		    }
		});
		northPanelJornadas.add(comboBoxJornadas);
		
		btnCerrarSesion_ANON = new JButton("Cerrar Sesion");
		btnCerrarSesion_ANON.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnCerrarSesion_ANON.addActionListener(this);
		northPanelJornadas.add(btnCerrarSesion_ANON);
			
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
		gbl_headerPanelJornadas.columnWidths = new int[] {51, 0, 30, 30, 30, 30, 30, 30};
		gbl_headerPanelJornadas.rowHeights = new int[]{19, 0};
		gbl_headerPanelJornadas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_headerPanelJornadas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerPanelJornadas.setLayout(gbl_headerPanelJornadas);
		
		headerNJornadas = new JLabel("Nº  ");
		headerNJornadas.setHorizontalAlignment(SwingConstants.LEFT);
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
		
		/*PANEL ARBITRO*/
		
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
		        	cambiarJornada(comboBoxGestionarJornadas, headerNJornadas_1);
		        	unirEquiposLocalesVisitantes();
		        }
		    }
		});
		northPanelGestionarJornadas.add(comboBoxGestionarJornadas);
		
		btnCerrarSesion_ARBITRO = new JButton("Cerrar Sesion");
		btnCerrarSesion_ARBITRO.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnCerrarSesion_ARBITRO.addActionListener(this);
		northPanelGestionarJornadas.add(btnCerrarSesion_ARBITRO);
		
		panelGestionarJornadas = new JPanel();
		panelGestionarJornadas.setBackground(new Color(238, 235, 228));
		gestionarJornadas.add(panelGestionarJornadas, BorderLayout.CENTER);
		panelGestionarJornadas.setLayout(new BoxLayout(panelGestionarJornadas, BoxLayout.Y_AXIS));
		
		lblGestionarJornadas = new JLabel("GESTIONAR JORNADAS");
		lblGestionarJornadas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGestionarJornadas.setAlignmentY(0.0f);
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
		listEqLocalGestionar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEqLocalGestionar.setForeground(new Color(50, 50, 50));
		listEqLocalGestionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqLocalGestionar.setFixedCellHeight(25);
		listEqLocalGestionar.setBackground(new Color(204, 229, 255));
		arbitroListPanelJornadas.add(listEqLocalGestionar);
		
		listEqVisitanteGestionar = new JList<String>(dlmJornadasEqVisitante);
		listEqVisitanteGestionar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEqVisitanteGestionar.setForeground(new Color(50, 50, 50));
		listEqVisitanteGestionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqVisitanteGestionar.setFixedCellHeight(25);
		listEqVisitanteGestionar.setBackground(new Color(204, 229, 255));
		arbitroListPanelJornadas.add(listEqVisitanteGestionar);
		
		JPanel panelListasGestionarResultadosJornadas = new JPanel();
		panelListasGestionarResultadosJornadas.setAlignmentY(0.2f);
		panelListasGestionarResultadosJornadas.setAlignmentX(0.2f);
		panelGestionarJornadas.add(panelListasGestionarResultadosJornadas);
		
		/*PANEL INTRODUCIR DATOS JORNADAS*/
		panelInputDatosJornadas = new JPanel();
		panelListasGestionarResultadosJornadas.add(panelInputDatosJornadas);
		GridBagLayout gbl_panelInputDatosJornadas = new GridBagLayout();
		gbl_panelInputDatosJornadas.columnWidths = new int[] {40, 0, 20};
		gbl_panelInputDatosJornadas.rowHeights = new int[] {30, 20};
		gbl_panelInputDatosJornadas.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panelInputDatosJornadas.rowWeights = new double[]{0.0, 0.0};
		panelInputDatosJornadas.setLayout(gbl_panelInputDatosJornadas);
		
		lbl_Equipos_resultadosJornadas = new JLabel("EQUIPOS:");
		lbl_Equipos_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_Equipos_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Equipos_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_Equipos_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_Equipos_resultadosJornadas.anchor = GridBagConstraints.EAST;
		gbc_lbl_Equipos_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Equipos_resultadosJornadas.gridx = 0;
		gbc_lbl_Equipos_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_Equipos_resultadosJornadas, gbc_lbl_Equipos_resultadosJornadas);
		
		txtEquipos_resultadosJornadas = new JTextField();
		txtEquipos_resultadosJornadas.setEditable(false);
		txtEquipos_resultadosJornadas.setEnabled(false);
		txtEquipos_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtEquipos_resultadosJornadas = new GridBagConstraints();
		gbc_txtEquipos_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtEquipos_resultadosJornadas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEquipos_resultadosJornadas.gridx = 1;
		gbc_txtEquipos_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtEquipos_resultadosJornadas, gbc_txtEquipos_resultadosJornadas);
		
		JLabel lbl_Ptos_resultadosJornadas = new JLabel("PTOS:");
		lbl_Ptos_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_Ptos_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Ptos_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_Ptos_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_Ptos_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_Ptos_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Ptos_resultadosJornadas.gridx = 3;
		gbc_lbl_Ptos_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_Ptos_resultadosJornadas, gbc_lbl_Ptos_resultadosJornadas);
		
		txtPtos_resultadosJornadas = new JTextField();
		txtPtos_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtPtos_resultadosJornadas = new GridBagConstraints();
		gbc_txtPtos_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtPtos_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtPtos_resultadosJornadas.gridx = 4;
		gbc_txtPtos_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtPtos_resultadosJornadas, gbc_txtPtos_resultadosJornadas);
		
		JLabel lbl_PJ_resultadosJornadas = new JLabel("P.J:");
		lbl_PJ_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_PJ_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_PJ_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_PJ_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_PJ_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_PJ_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_PJ_resultadosJornadas.gridx = 5;
		gbc_lbl_PJ_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_PJ_resultadosJornadas, gbc_lbl_PJ_resultadosJornadas);
		
		txtPJ_resultadosJornadas = new JTextField();
		txtPJ_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtPJ_resultadosJornadas = new GridBagConstraints();
		gbc_txtPJ_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtPJ_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtPJ_resultadosJornadas.gridx = 6;
		gbc_txtPJ_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtPJ_resultadosJornadas, gbc_txtPJ_resultadosJornadas);
		
		JLabel lbl_PG_resultadosJornadas = new JLabel("P.G:");
		lbl_PG_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_PG_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_PG_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_PG_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_PG_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_PG_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_PG_resultadosJornadas.gridx = 8;
		gbc_lbl_PG_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_PG_resultadosJornadas, gbc_lbl_PG_resultadosJornadas);
		
		txtPG_resultadosJornadas = new JTextField();
		txtPG_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtPG_resultadosJornadas = new GridBagConstraints();
		gbc_txtPG_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtPG_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtPG_resultadosJornadas.gridx = 9;
		gbc_txtPG_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtPG_resultadosJornadas, gbc_txtPG_resultadosJornadas);
		
		JLabel lbl_PP_resultadosJornadas = new JLabel("P.P:");
		lbl_PP_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_PP_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_PP_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_PP_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_PP_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_PP_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_PP_resultadosJornadas.gridx = 10;
		gbc_lbl_PP_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_PP_resultadosJornadas, gbc_lbl_PP_resultadosJornadas);
		
		txtPP_resultadosJornadas = new JTextField();
		txtPP_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtPP_resultadosJornadas = new GridBagConstraints();
		gbc_txtPP_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtPP_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtPP_resultadosJornadas.gridx = 11;
		gbc_txtPP_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtPP_resultadosJornadas, gbc_txtPP_resultadosJornadas);
		
		JLabel lbl_SG_resultadosJornadas = new JLabel("S.G:");
		lbl_SG_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_SG_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_SG_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_SG_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_SG_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_SG_resultadosJornadas.gridx = 12;
		gbc_lbl_SG_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_SG_resultadosJornadas, gbc_lbl_SG_resultadosJornadas);
		
		txtSG_resultadosJornadas = new JTextField();
		txtSG_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtSG_resultadosJornadas = new GridBagConstraints();
		gbc_txtSG_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtSG_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtSG_resultadosJornadas.gridx = 13;
		gbc_txtSG_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtSG_resultadosJornadas, gbc_txtSG_resultadosJornadas);
		
		JLabel lbl_SP_resultadosJornadas = new JLabel("S.P:");
		lbl_SP_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_SP_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_SP_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_SP_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_SP_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_SP_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_SP_resultadosJornadas.gridx = 15;
		gbc_lbl_SP_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_SP_resultadosJornadas, gbc_lbl_SP_resultadosJornadas);
		
		txtSP_resultadosJornadas = new JTextField();
		txtSP_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtSP_resultadosJornadas = new GridBagConstraints();
		gbc_txtSP_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtSP_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtSP_resultadosJornadas.gridx = 16;
		gbc_txtSP_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtSP_resultadosJornadas, gbc_txtSP_resultadosJornadas);
		
		JLabel lbl_TA_resultadosJornadas = new JLabel("T.A:");
		lbl_TA_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_TA_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TA_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_TA_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_TA_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_TA_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_TA_resultadosJornadas.gridx = 17;
		gbc_lbl_TA_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_TA_resultadosJornadas, gbc_lbl_TA_resultadosJornadas);
		
		txtTA_resultadosJornadas = new JTextField();
		txtTA_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtTA_resultadosJornadas = new GridBagConstraints();
		gbc_txtTA_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtTA_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtTA_resultadosJornadas.gridx = 18;
		gbc_txtTA_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtTA_resultadosJornadas, gbc_txtTA_resultadosJornadas);
		
		JLabel lbl_TC_resultadosJornadas = new JLabel("T.C:");
		lbl_TC_resultadosJornadas.setForeground(new Color(51, 153, 204));
		lbl_TC_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TC_resultadosJornadas.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_TC_resultadosJornadas = new GridBagConstraints();
		gbc_lbl_TC_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_lbl_TC_resultadosJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_TC_resultadosJornadas.gridx = 19;
		gbc_lbl_TC_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(lbl_TC_resultadosJornadas, gbc_lbl_TC_resultadosJornadas);
		
		txtTC_resultadosJornadas = new JTextField();
		txtTC_resultadosJornadas.setColumns(10);
		GridBagConstraints gbc_txtTC_resultadosJornadas = new GridBagConstraints();
		gbc_txtTC_resultadosJornadas.anchor = GridBagConstraints.WEST;
		gbc_txtTC_resultadosJornadas.insets = new Insets(0, 0, 5, 0);
		gbc_txtTC_resultadosJornadas.gridx = 20;
		gbc_txtTC_resultadosJornadas.gridy = 0;
		panelInputDatosJornadas.add(txtTC_resultadosJornadas, gbc_txtTC_resultadosJornadas);
		
		btnInsertar_resultadosJornadas = new JButton("Insertar");
		btnInsertar_resultadosJornadas.setForeground(azulSegundo);
		btnInsertar_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsertar_resultadosJornadas.setBackground(amarilloPrimero);
		
		GridBagConstraints gbc_btnInsertar_resultadosJornadas = new GridBagConstraints();
		gbc_btnInsertar_resultadosJornadas.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnInsertar_resultadosJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_btnInsertar_resultadosJornadas.gridx = 9;
		gbc_btnInsertar_resultadosJornadas.gridy = 1;
		panelInputDatosJornadas.add(btnInsertar_resultadosJornadas, gbc_btnInsertar_resultadosJornadas);
		
		btnBorrar_resultadosJornadas = new JButton("Borrar");
		btnBorrar_resultadosJornadas.setForeground(new Color(51, 153, 204));
		btnBorrar_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBorrar_resultadosJornadas.setBackground(new Color(253, 253, 150));
		GridBagConstraints gbc_btnBorrar_resultadosJornadas = new GridBagConstraints();
		gbc_btnBorrar_resultadosJornadas.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar_resultadosJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorrar_resultadosJornadas.gridx = 11;
		gbc_btnBorrar_resultadosJornadas.gridy = 1;
		panelInputDatosJornadas.add(btnBorrar_resultadosJornadas, gbc_btnBorrar_resultadosJornadas);
		
		btnLimpiar_resultadosJornadas = new JButton("Limpiar");
		btnLimpiar_resultadosJornadas.setForeground(new Color(51, 153, 204));
		btnLimpiar_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar_resultadosJornadas.setBackground(new Color(253, 253, 150));
		GridBagConstraints gbc_btnLimpiar_resultadosJornadas = new GridBagConstraints();
		gbc_btnLimpiar_resultadosJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar_resultadosJornadas.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLimpiar_resultadosJornadas.gridx = 12;
		gbc_btnLimpiar_resultadosJornadas.gridy = 1;
		panelInputDatosJornadas.add(btnLimpiar_resultadosJornadas, gbc_btnLimpiar_resultadosJornadas);
		
		
		/*CABEZERA GESTIONAR RESULTADOS JORNADAS*/
		panelListasGestionarResultadosJornadas.setLayout(new BoxLayout(panelListasGestionarResultadosJornadas, BoxLayout.Y_AXIS));
		JPanel panelGestionarResultadosJornadasHeader = new JPanel();
		panelGestionarResultadosJornadasHeader.setBackground(azulPrimero);
		panelListasGestionarResultadosJornadas.add(panelGestionarResultadosJornadasHeader);
		panelGestionarResultadosJornadasHeader.setLayout(new GridLayout(1, 1, 0, 0));
		
		/*JLIST Y LABELS GESTIONAR RESULTADOS JORNADAS*/
		JPanel panelResultadosListas = new JPanel();
		panelListasGestionarResultadosJornadas.add(panelResultadosListas);
		panelResultadosListas.setLayout(new GridLayout(0, 9, 0, 0));
		
		/*EQUIPOS*/
		JLabel lblheaderEquipo_restultados = new JLabel("EQUIPO");
		lblheaderEquipo_restultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblheaderEquipo_restultados.setForeground(Color.WHITE);
		lblheaderEquipo_restultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblheaderEquipo_restultados);

		listEquipos_resultadosJornadas = new JList<String>(dlmJornadasEquipos_resultado);
		listEquipos_resultadosJornadas.addListSelectionListener(this);
		listEquipos_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEquipos_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listEquipos_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEquipos_resultadosJornadas.setFixedCellHeight(25);
		listEquipos_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listEquipos_resultadosJornadas);
		
		/*PUNTOS*/
		JLabel lblheaderPTOS_resultados = new JLabel("PTOS");
		lblheaderPTOS_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblheaderPTOS_resultados.setForeground(Color.WHITE);
		lblheaderPTOS_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblheaderPTOS_resultados);
		
		listPTOS_resultadosJornadas = new JList<Integer>(dlmJornadasPuntos_resultado);
		listPTOS_resultadosJornadas.addListSelectionListener(this);
		listPTOS_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPTOS_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listPTOS_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPTOS_resultadosJornadas.setFixedCellHeight(25);
		listPTOS_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listPTOS_resultadosJornadas);
		
		/*PARTIDOS JUGADOS*/
		JLabel lblheaderPJ_resultados = new JLabel("P.J");
		lblheaderPJ_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblheaderPJ_resultados.setForeground(Color.WHITE);
		lblheaderPJ_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblheaderPJ_resultados);
		
		listPJ_resultadosJornadas = new JList<Integer>(dlmJornadasPartidosJugados_resultado);
		listPJ_resultadosJornadas.addListSelectionListener(this);
		listPJ_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPJ_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listPJ_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPJ_resultadosJornadas.setFixedCellHeight(25);
		listPJ_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listPJ_resultadosJornadas);
		
		
		/*PARTIDOS GANADOS*/
		JLabel lblheaderPG_resultados = new JLabel("P.G");
		lblheaderPG_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblheaderPG_resultados.setForeground(Color.WHITE);
		lblheaderPG_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblheaderPG_resultados);
		
		listPG_resultadosJornadas = new JList<Integer>(dlmJornadasPartidosGanados_resultado);
		listPG_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPG_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listPG_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPG_resultadosJornadas.setFixedCellHeight(25);
		listPG_resultadosJornadas.setBackground(new Color(204, 229, 255));
		listPG_resultadosJornadas.addListSelectionListener(this);
		panelResultadosListas.add(listPG_resultadosJornadas);
		
		
		/*PARTIDOS PERDIDOS*/
		JLabel lblHeaderPP_resultados = new JLabel("P.P");
		lblHeaderPP_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderPP_resultados.setForeground(Color.WHITE);
		lblHeaderPP_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblHeaderPP_resultados);
		
		listPP_resultadosJornadas = new JList<Integer>(dlmJornadasPartidosPerdidos_resultado);
		listPP_resultadosJornadas.addListSelectionListener(this);
		listPP_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPP_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listPP_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPP_resultadosJornadas.setFixedCellHeight(25);
		listPP_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listPP_resultadosJornadas);
		
		/*SETS GANADOS*/
		JLabel lblHeaderSG = new JLabel("S.G");
		lblHeaderSG.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderSG.setForeground(Color.WHITE);
		lblHeaderSG.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblHeaderSG);
		
		listSG_resultadosJornadas = new JList<Integer>(dlmJornadasSetsGanados_resultado);
		listSG_resultadosJornadas.addListSelectionListener(this);
		listSG_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSG_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listSG_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSG_resultadosJornadas.setFixedCellHeight(25);
		listSG_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listSG_resultadosJornadas);
		
		/*SETS PERDIDOS*/
		JLabel lblHeaderSP_resultados = new JLabel("S.P");
		lblHeaderSP_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderSP_resultados.setForeground(Color.WHITE);
		lblHeaderSP_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblHeaderSP_resultados);
		
		listSP_resultadosJornadas = new JList<Integer>(dlmJornadasSetsPerdidos_resultado);
		listSP_resultadosJornadas.addListSelectionListener(this);
		listSP_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSP_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listSP_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSP_resultadosJornadas.setFixedCellHeight(25);
		listSP_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listSP_resultadosJornadas);
		
		/*TANTOS A FAVOR*/
		JLabel lblHeaderTA_resultados = new JLabel("T.A");
		lblHeaderTA_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderTA_resultados.setForeground(Color.WHITE);
		lblHeaderTA_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblHeaderTA_resultados);
		
		listTA_resultadosJornadas = new JList<Integer>(dlmJornadasTantosFavor_resultado);
		listTA_resultadosJornadas.addListSelectionListener(this);
		listTA_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTA_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listTA_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTA_resultadosJornadas.setFixedCellHeight(25);
		listTA_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listTA_resultadosJornadas);
		
		/*TANTOS EN CONTRA*/
		JLabel lblHeaderTC_resultados = new JLabel("T.C");
		lblHeaderTC_resultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderTC_resultados.setForeground(Color.WHITE);
		lblHeaderTC_resultados.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGestionarResultadosJornadasHeader.add(lblHeaderTC_resultados);
		
		listTC_resultadosJornadas = new JList<Integer>(dlmJornadasTantosContra_resultado);
		listTC_resultadosJornadas.addListSelectionListener(this);
		listTC_resultadosJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTC_resultadosJornadas.setForeground(new Color(50, 50, 50));
		listTC_resultadosJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTC_resultadosJornadas.setFixedCellHeight(25);
		listTC_resultadosJornadas.setBackground(new Color(204, 229, 255));
		panelResultadosListas.add(listTC_resultadosJornadas);
		
		gestionarClasifiacion = new JPanel();
		scrollPanelArbitro.add(gestionarClasifiacion);
		
		/*PANEL ADMIN*/
		panelAdmin = new JPanel();
		contentPane.add(panelAdmin, "PanelAdmin_");
		
		/*GESTION USUARIOS*/
		if(username.equals(Login.admin_user)) {
			cardLayoutPrincipal.show(contentPane, "PanelAdmin_");
		} else if (username_param.equals(Login.arbitro_user)){
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setTitle(this.getTitle() + " - GESTIÓN ARBITRO");
			cardLayoutPrincipal.show(contentPane, "PanelArbitro_");
			cambiarJornada(comboBoxGestionarJornadas, headerNJornadas_1);
        	unirEquiposLocalesVisitantes();
        	definirDatosResultadosJornadasPorDefecto();
		} else {
			cardLayoutPrincipal.show(contentPane, "PanelAnonimo_");
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        	cambiarJornada(comboBoxJornadas, headerNJornadas);
		}
	}
	
	// -- METODOS (FUNCIONES) PRIVADAS --
	
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
		for(int i = minIndex; i < maxIndex; i++) {
			dlmEquiposLocales.addElement(equiposLocales[i]);
		}
	}
	
	/*Esta funcion vaciara la dlm y la rellenada con el rango estableciado */
	private void setEquiposVisitantes(DefaultListModel<String> dlmEquiposVisitantes,int minIndex,int maxIndex) {
		dlmEquiposVisitantes.clear(); // Vacia el dlm
		for(int i = minIndex; i < maxIndex; i++) {

			dlmEquiposVisitantes.addElement(equiposVisitantes[i]);
		}
	}
	
	/*Establece el numero de jornadas en la dlm -> Necesario para poder usar ComboBox*/
	private void setNumeroJorndas(DefaultComboBoxModel<String> dlmNumerosJorndas, int numeroJornadas) {
		for(int i = 1; i<= numeroJornadas; i++) {
			dlmNumerosJorndas.addElement("Jornada: " + i);
		}
	}
	
	/*Este metodo cambia la apariencia de las jornadas al cambiar entre ellas*/
	/*
	 * JORNADA 1 -> ComoboBox Index (0) | DLM (0,1,2)
	 * JORNADA 2 -> ComoboBox Index (1) | DLM (3,4,5)
	 * JORNADA 3 -> ComoboBox Index (2) | DLM (6,7,8)
	 * -- FORMULA --
	 * minIndex * 3 | maxIndex + 3
	 * minIndex(0) -> 0 * 3 
	 * minIndex(1) -> 1 * 3
	 * minIndex(2) -> 2 * 3
	 **/
	
	/**
	 * Este método cambia la apariencia de las jornadas al cambiar entre ellas.
	 * Rellena los 6 equipos y busca en las matrices sus resultados para
	 * rellenar las 8 listas de datos (Puntos, PJ, PG, etc.), asegurando
	 * que todas las listas estén sincronizadas con 6 elementos.
	 */
	private void cambiarJornada(JComboBox<String> comboBox, JLabel nJornada) {
	    
	    // 1. OBTIENE LA JORNADA SELECCIONADA (0 para Jornada 1, 1 para Jornada 2, etc.)
	    int jornadaIndex = comboBox.getSelectedIndex();
	    
	    // 2. CALCULA EL RANGO PARA TUS ARRAYS DE EQUIPOS
	    int minIndex = jornadaIndex * 3;
	    int maxIndex = minIndex + 3;
	    
	    // 3. RELLENA LAS LISTAS TEMPORALES DE LOCAL/VISITANTE
	    // (Estos métodos usan las variables de clase dlmJornadasEqLocal y dlmJornadasEqVisitante)
	    setEquiposLocales(dlmJornadasEqLocal, minIndex, maxIndex);
	    setEquiposVisitantes(dlmJornadasEqVisitante, minIndex, maxIndex);
	    
	    // 4. UNE LOS 6 EQUIPOS EN LA LISTA PRINCIPAL
	    // (Esto limpia dlmJornadasEquipos_resultado y añade los 6 equipos)
	    unirEquiposLocalesVisitantes();
	    
	    // 5. LIMPIA TODAS LAS LISTAS DE DATOS (PUNTOS, PJ, PG...)
	    dlmJornadasPuntos_resultado.clear();
	    dlmJornadasPartidosJugados_resultado.clear();
	    dlmJornadasPartidosGanados_resultado.clear();
	    dlmJornadasPartidosPerdidos_resultado.clear();
	    dlmJornadasSetsGanados_resultado.clear();
	    dlmJornadasSetsPerdidos_resultado.clear();
	    dlmJornadasTantosFavor_resultado.clear();
	    dlmJornadasTantosContra_resultado.clear();
	    
	    // 6. RELLENA LAS LISTAS DE DATOS USANDO LAS MATRICES
	    // Este bucle se ejecuta 6 veces (una por cada equipo en la lista)
	    for (int i = 0; i < dlmJornadasEquipos_resultado.getSize(); i++) {
	        
	        // A. Obtiene el nombre del equipo (en el índice 0, 1, 2, 3, 4, 5)
	        String nombreEquipo = dlmJornadasEquipos_resultado.getElementAt(i);
	        
	        // B. Obtiene la matriz de ese equipo usando el 'Map'
	        int[][] matrizDelEquipo = getMatrizPorNombre(nombreEquipo);
	        
	        // C. Obtiene la FILA de datos para esa JORNADA
	        // (matrizDelEquipo[jornadaIndex] te da la fila: int[10])
	        int[] datosFila = matrizDelEquipo[jornadaIndex];
	        
	        // D. Añade los datos de esa fila a las listas DLM
	        // (Usando las constantes COL_... que definimos)
	        dlmJornadasPuntos_resultado.addElement(datosFila[COL_PUNTOS]);
	        dlmJornadasPartidosJugados_resultado.addElement(datosFila[COL_PJ]);
	        dlmJornadasPartidosGanados_resultado.addElement(datosFila[COL_PG]);
	        dlmJornadasPartidosPerdidos_resultado.addElement(datosFila[COL_PP]);
	        dlmJornadasSetsGanados_resultado.addElement(datosFila[COL_SG]);
	        dlmJornadasSetsPerdidos_resultado.addElement(datosFila[COL_SP]);
	        dlmJornadasTantosFavor_resultado.addElement(datosFila[COL_TA]);
	        dlmJornadasTantosContra_resultado.addElement(datosFila[COL_TC]);
	    }
	    
	    // 7. ACTUALIZA LA ETIQUETA
	    nJornada.setText("Nº " + Integer.toString(jornadaIndex + 1));
	}
	
	/*Este metodo se encarga de hacer una lista modelo para la gestion en jornadas es decir muestra los equipos que juegan esa jornada en una unica lista*/
	private void unirEquiposLocalesVisitantes() {
		// Primero vaciamos la lista
		dlmJornadasEquipos_resultado.clear();
		/*Añadir ala dlm listEquipos_resultadosJornadas los equipos locales*/
		for(int i = 0; i< dlmJornadasEqLocal.getSize();i++) {
			dlmJornadasEquipos_resultado.addElement(dlmJornadasEqLocal.getElementAt(i));
		}
		for(int i = 0; i< dlmJornadasEqVisitante.getSize();i++) {
			//araSystem.out.println("equipo " +  dlmJornadasEqVisitante.getElementAt(i));
			dlmJornadasEquipos_resultado.addElement(dlmJornadasEqVisitante.getElementAt(i));
		}
	}

	/*POR DEFECTO TODOS LOS RESULTADOS DE LA TEMPORADA EN CADA JORNADA*/
	private void definirDatosResultadosJornadasPorDefecto() {
	    
	    // Variables de ayuda para que el código sea más limpio
	    int j; // Índice de la jornada (fila de la matriz)
	    int[][] matLocal; // Matriz del equipo local
	    int[][] matVisit; // Matriz del equipo visitante

	    // --- JORNADA 1 (j=0) ---
	    j = 0;
	    
	    // Zaragoza (3) vs SanFernando (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV ZARAGOZA");
	    matVisit = getMatrizPorNombre("CV SAN FERNANDO");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 55;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 55; matVisit[j][COL_TC] = 75;
	    
	    // Valladolid (3) vs Rivas (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("VALLADOLID CV");
	    matVisit = getMatrizPorNombre("CV RIVAS");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 55;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 55; matVisit[j][COL_TC] = 75;

	    // Torrelavega (3) vs Palma (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV TORRELAVEGA");
	    matVisit = getMatrizPorNombre("CV PALMA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 52;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 52; matVisit[j][COL_TC] = 75;
	    
	    // --- JORNADA 2 (j=1) ---
	    j = 1;
	    
	    // Zaragoza (3) vs Rivas (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV ZARAGOZA");
	    matVisit = getMatrizPorNombre("CV RIVAS");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 48;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 48; matVisit[j][COL_TC] = 75;

	    // SanFernando (3) vs Palma (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV SAN FERNANDO");
	    matVisit = getMatrizPorNombre("CV PALMA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 54;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 54; matVisit[j][COL_TC] = 75;
	    
	    // Valladolid (3) vs Torrelavega (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("VALLADOLID CV");
	    matVisit = getMatrizPorNombre("CV TORRELAVEGA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 61;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 61; matVisit[j][COL_TC] = 75;
	    
	    // --- JORNADA 3 (j=2) ---
	    j = 2;
	    
	    // Zaragoza (3) vs Palma (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV ZARAGOZA");
	    matVisit = getMatrizPorNombre("CV PALMA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 53;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 53; matVisit[j][COL_TC] = 75;
	    
	    // Rivas (0) vs Torrelavega (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV RIVAS");
	    matVisit = getMatrizPorNombre("CV TORRELAVEGA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 55; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 55;

	    // SanFernando (3) vs Valladolid (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV SAN FERNANDO");
	    matVisit = getMatrizPorNombre("VALLADOLID CV");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 63;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 63; matVisit[j][COL_TC] = 75;

	    // --- JORNADA 4 (j=3) ---
	    j = 3;
	    
	    // Zaragoza (3) vs Torrelavega (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV ZARAGOZA");
	    matVisit = getMatrizPorNombre("CV TORRELAVEGA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 57;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 57; matVisit[j][COL_TC] = 75;

	    // Palma (0) vs Valladolid (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV PALMA");
	    matVisit = getMatrizPorNombre("VALLADOLID CV");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 54; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 54;
	    
	    // Rivas (0) vs SanFernando (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV RIVAS");
	    matVisit = getMatrizPorNombre("CV SAN FERNANDO");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 52; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 52;

	    // --- JORNADA 5 (j=4) ---
	    j = 4;
	    
	    // Zaragoza (3) vs Valladolid (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV ZARAGOZA");
	    matVisit = getMatrizPorNombre("VALLADOLID CV");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 61;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 61; matVisit[j][COL_TC] = 75;
	    
	    // Torrelavega (0) vs SanFernando (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV TORRELAVEGA");
	    matVisit = getMatrizPorNombre("CV SAN FERNANDO");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 57; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 57;
	    
	    // Palma (3) vs Rivas (0) -> Puntos: 3-0
	    matLocal = getMatrizPorNombre("CV PALMA");
	    matVisit = getMatrizPorNombre("CV RIVAS");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 3; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 0; matLocal[j][COL_TA] = 75; matLocal[j][COL_TC] = 55;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 0; matVisit[j][COL_SG] = 0; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 55; matVisit[j][COL_TC] = 75;
	    
	    // --- JORNADA 6 (j=5) ---
	    j = 5;
	    
	    // SanFernando (0) vs Zaragoza (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV SAN FERNANDO");
	    matVisit = getMatrizPorNombre("CV ZARAGOZA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 60; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 60;
	    
	    // Rivas (0) vs Valladolid (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV RIVAS");
	    matVisit = getMatrizPorNombre("VALLADOLID CV");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 54; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 54;

	    // Palma (0) vs Torrelavega (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV PALMA");
	    matVisit = getMatrizPorNombre("CV TORRELAVEGA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 52; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 52;
	    
	    // --- JORNADA 7 (j=6) ---
	    j = 6;
	    
	    // Rivas (0) vs Zaragoza (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV RIVAS");
	    matVisit = getMatrizPorNombre("CV ZARAGOZA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 51; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 51;

	    // Palma (0) vs SanFernando (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV PALMA");
	    matVisit = getMatrizPorNombre("CV SAN FERNANDO");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 52; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 52;
	    
	    // Torrelavega (0) vs Valladolid (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV TORRELAVEGA");
	    matVisit = getMatrizPorNombre("VALLADOLID CV");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 57; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 57;

	    // --- JORNADA 8 (j=7) ---
	    j = 7;
	    
	    // Palma (2) vs Zaragoza (3) -> Puntos: 1-2
	    matLocal = getMatrizPorNombre("CV PALMA");
	    matVisit = getMatrizPorNombre("CV ZARAGOZA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 1; matLocal[j][COL_SG] = 2; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 107; matLocal[j][COL_TC] = 110;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 2; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 2; matVisit[j][COL_TA] = 110; matVisit[j][COL_TC] = 107;

	    // Torrelavega (0) vs Rivas (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV TORRELAVEGA");
	    matVisit = getMatrizPorNombre("CV RIVAS");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 0; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 55; matLocal[j][COL_TC] = 75;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 0; matVisit[j][COL_TA] = 75; matVisit[j][COL_TC] = 55;
	    
	    // Valladolid (2) vs SanFernando (3) -> Puntos: 1-2
	    matLocal = getMatrizPorNombre("VALLADOLID CV");
	    matVisit = getMatrizPorNombre("CV SAN FERNANDO");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 1; matLocal[j][COL_SG] = 2; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 106; matLocal[j][COL_TC] = 110;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 2; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 2; matVisit[j][COL_TA] = 110; matVisit[j][COL_TC] = 106;
	    
	    // --- JORNADA 9 (j=8) ---
	    j = 8;
	    
	    // Torrelavega (1) vs Zaragoza (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("CV TORRELAVEGA");
	    matVisit = getMatrizPorNombre("CV ZARAGOZA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 1; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 88; matLocal[j][COL_TC] = 98;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 1; matVisit[j][COL_TA] = 98; matVisit[j][COL_TC] = 88;

	    // Valladolid (3) vs Palma (2) -> Puntos: 2-1
	    matLocal = getMatrizPorNombre("VALLADOLID CV");
	    matVisit = getMatrizPorNombre("CV PALMA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 2; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 2; matLocal[j][COL_TA] = 107; matLocal[j][COL_TC] = 106;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 1; matVisit[j][COL_SG] = 2; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 106; matVisit[j][COL_TC] = 107;
	    
	    // SanFernando (3) vs Rivas (2) -> Puntos: 2-1
	    matLocal = getMatrizPorNombre("CV SAN FERNANDO");
	    matVisit = getMatrizPorNombre("CV RIVAS");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PG] = 1; matLocal[j][COL_PUNTOS] = 2; matLocal[j][COL_SG] = 3; matLocal[j][COL_SP] = 2; matLocal[j][COL_TA] = 107; matLocal[j][COL_TC] = 106;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PP] = 1; matVisit[j][COL_PUNTOS] = 1; matVisit[j][COL_SG] = 2; matVisit[j][COL_SP] = 3; matVisit[j][COL_TA] = 106; matVisit[j][COL_TC] = 107;
	    
	    // --- JORNADA 10 (j=9) ---
	    j = 9;
	    
	    // Valladolid (1) vs Zaragoza (3) -> Puntos: 0-3
	    matLocal = getMatrizPorNombre("VALLADOLID CV");
	    matVisit = getMatrizPorNombre("CV ZARAGOZA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 0; matLocal[j][COL_SG] = 1; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 86; matLocal[j][COL_TC] = 98;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 3; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 1; matVisit[j][COL_TA] = 98; matVisit[j][COL_TC] = 86;
	    
	    // SanFernando (2) vs Torrelavega (3) -> Puntos: 1-2
	    matLocal = getMatrizPorNombre("CV SAN FERNANDO");
	    matVisit = getMatrizPorNombre("CV TORRELAVEGA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 1; matLocal[j][COL_SG] = 2; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 105; matLocal[j][COL_TC] = 108;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 2; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 2; matVisit[j][COL_TA] = 108; matVisit[j][COL_TC] = 105;
	    
	    // Rivas (2) vs Palma (3) -> Puntos: 1-2
	    matLocal = getMatrizPorNombre("CV RIVAS");
	    matVisit = getMatrizPorNombre("CV PALMA");
	    matLocal[j][COL_PJ] = 1; matLocal[j][COL_PP] = 1; matLocal[j][COL_PUNTOS] = 1; matLocal[j][COL_SG] = 2; matLocal[j][COL_SP] = 3; matLocal[j][COL_TA] = 108; matLocal[j][COL_TC] = 108;
	    matVisit[j][COL_PJ] = 1; matVisit[j][COL_PG] = 1; matVisit[j][COL_PUNTOS] = 2; matVisit[j][COL_SG] = 3; matVisit[j][COL_SP] = 2; matVisit[j][COL_TA] = 108; matVisit[j][COL_TC] = 108;
	}
	
	
	/*OBTENER MATRIZ USANDO EL NOMBRE DE EL EQUIPO*/
	private int[][] getMatrizPorNombre(String nombreEquipo) {
	    // .get(nombreEquipo) busca la clave en el Map y devuelve el valor asociado
	    return mapaMatricesEquipos.get(nombreEquipo);
	}
	
	// -- EVENTOS --
	
	
	//*ACTION LISTENER*//
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource(); // Obtiene la fuente de el evento ( quien lo invoca)
		
		// BOTON CERRAR SESION
		if(o == btnCerrarSesion_ANON || o == btnCerrarSesion_ARBITRO) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();	
		}
		
		// SOLO EL ARBITRO PUEDE EJECTUTAR ESTOS EVENTOS
		if(o == btnInsertar_resultadosJornadas && username.equals(Login.arbitro_user)) {
		}
		
		if(o == btnBorrar_resultadosJornadas && username.equals(Login.arbitro_user)) {
			
		}
		
		if(o == btnLimpiar_resultadosJornadas && username.equals(Login.arbitro_user)) {
		
		}
		
	}
	
	

	/*CUANDO SE SLEECCIONA UNA LISTA*/
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		Object o = lse.getSource();
		int index;
		index = ((JList<?>)o).getSelectedIndex();
		if(index >= 0) {
			/*SELECCIONAR EL RESTO DE LISTAS DE LAS JORNADAS*/
			listEquipos_resultadosJornadas.setSelectedIndex(index);
			listPTOS_resultadosJornadas.setSelectedIndex(index);
			listPJ_resultadosJornadas.setSelectedIndex(index);
			listPG_resultadosJornadas.setSelectedIndex(index);
			listPP_resultadosJornadas.setSelectedIndex(index);
			listSG_resultadosJornadas.setSelectedIndex(index);
			listSP_resultadosJornadas.setSelectedIndex(index);
			listTA_resultadosJornadas.setSelectedIndex(index);
			listTC_resultadosJornadas.setSelectedIndex(index);
			
			/*CAMBIAR TXT FIELDS*/
			
			txtEquipos_resultadosJornadas.setText(dlmJornadasEquipos_resultado.get(index));
			txtPtos_resultadosJornadas.setText(Integer.toString(dlmJornadasPuntos_resultado.get(index)));
		    txtPJ_resultadosJornadas.setText(Integer.toString(dlmJornadasPartidosJugados_resultado.get(index)));
		    txtPG_resultadosJornadas.setText(Integer.toString(dlmJornadasPartidosGanados_resultado.get(index)));
		    txtPP_resultadosJornadas.setText(Integer.toString(dlmJornadasPartidosPerdidos_resultado.get(index)));
		    txtSG_resultadosJornadas.setText(Integer.toString(dlmJornadasSetsGanados_resultado.get(index)));
		    txtSP_resultadosJornadas.setText(Integer.toString(dlmJornadasSetsPerdidos_resultado.get(index)));
		    txtTA_resultadosJornadas.setText(Integer.toString(dlmJornadasTantosFavor_resultado.get(index)));
		    txtTC_resultadosJornadas.setText(Integer.toString(dlmJornadasTantosContra_resultado.get(index)));
		}	
	}
}
