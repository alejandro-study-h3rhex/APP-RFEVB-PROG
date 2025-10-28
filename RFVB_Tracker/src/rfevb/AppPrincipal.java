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
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JTextField;



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
	
	JPanel panelPrincipal;
	
	private JScrollPane scrollPane;
	private JPanel scrollPanel;

	private JPanel Jornadas;
	private JPanel northPanelJornadas;
	private JComboBox<String> comboBoxJornadas;
	private JButton btnCerrarSesion;
	private JPanel panelJornadas;
	private JPanel panelListasJornadas;
	private JPanel Clasificacion;
	private JPanel panelGestionarClasificacionHeader;
	private JLabel lblheaderEquipo_restultados_1;
	private JLabel lblheaderPTOS_resultadosClasificacion;
	private JLabel lblheaderPJ_resultadosClasificacion;
	private JLabel lblheaderPG_resultadosClasificacion;
	private JLabel lblHeaderPP_resultadosClasificacion;
	private JLabel lblHeaderSG_1;
	private JLabel lblHeaderSP_resultadosClasificacion;
	private JLabel lblHeaderTA_resultadosClasificacion;
	private JLabel lblHeaderTC_resultadosClasificacion;
	private JPanel panelGestionClasificacionListas;
	private JList<String> listEquipos__resultadosClasificacion;
	private JList<Integer> listPJ__resultadosClasificacion;
	private JList<Integer> listPG__resultadosClasificacion;
	private JList<Integer> listPP__resultadosClasificacion;
	private JList<Integer> listSG__resultadosClasificacion;
	private JList<Integer> listSP__resultadosClasificacion;
	private JList<Integer> listTA__resultadosClasificacion;
	private JList<Integer> listTC__resultadosClasificacion;
	private JList<Integer> listPuntos__resultadosClasificacion;
	private JPanel panelTitulo;
	private JLabel lblGestionarJornadas;
	private JButton btnSiguienteJornada;
	private JButton btnAnteriorJornada;
	private JPanel panelNumeroJornadas;
	private JPanel panelEqLocales;
	private JPanel panelEqVisitantes;
	private JLabel headerNJornadas;
	private JLabel lblTitleEqLocales;
	private JLabel lblTitleEqVisitante;
	private JPanel panelListContainerVisitantes;
	private JPanel panelListContainerLocales;
	private JList<String> listNombreEquiposLocal;
	private JList<Integer> listSetsLocales;
	private JList<Integer> listS1TL;
	private JList<Integer> listS2TL;
	private JList<Integer> listS3TL;
	private JList<Integer> listS4TL;
	private JList<Integer> listS5TL;
	private JList<String> listNombreEquiposVisitantes;
	private JList<Integer> listSetsVisitantes;
	private JList<Integer> listS1TV;
	private JList<Integer> listS2TV;
	private JList<Integer> listS3TV;
	private JList<Integer> listS4TV;
	private JList<Integer> listS5TV;
	private JPanel panelTxtJornadasContainer;
	private JPanel panelBtnContainer;
	private JButton btnGuardarCambios_resultadosJornadas;
	private JButton btnBorrar_resultadosJornadas;
	private JButton btnLimpiar_resultadosJornadas;
	private JPanel txtLocales;
	private JPanel txtVisitantes;
	private JLabel lblEquipoLocal_ResultadoPartido;
	private JLabel lblEquipoVisitante_ResultadoPartido;
	private JPanel localesInput;
	private JLabel lblSetsTotales;
	private JTextField txtSestL;
	private JLabel lblS1Ta;
	private JTextField txtS1TaL;
	private JLabel lblS2Ta;
	private JTextField txtS2TaL;
	private JLabel lblS3Ta;
	private JTextField txtS3TaL;
	private JLabel lblS4Ta;
	private JTextField txtS4TaL;
	private JLabel lblS5Ta;
	private JTextField txtS5TaL;
	private JPanel visitantesInput;
	private JLabel lblSetsTotalesV;
	private JTextField txtSetsV;
	private JLabel lblS1TaV;
	private JTextField txtS1TavV;
	private JLabel lblS2TaV;
	private JTextField txtS2TaV;
	private JLabel lblS3TaV;
	private JTextField txtS3TaV;
	private JLabel lblS4TaV;
	private JTextField txtS4TaV;
	private JLabel lblS5TaV;
	private JTextField txtS5TaV;

	
	// -- DLMs --
	
	/*EQUIPOS*/
	private DefaultListModel<String> dlmEquipos;
	// -- MATRICES EQUIPOS --
	private int[][] matriz_zaragoza = new int[11][13];
	private int[][] matriz_valladolid = new int[11][13];
	private int[][] matriz_torrelavega = new int[11][13];
	private int[][] matriz_rivas = new int[11][13];
	private int[][] matriz_palma = new int[11][13];
	private int[][] matriz_sanfernando = new int[11][13];
	
	// -- INDICE DE CADA COLUMNA --> MAS FACIL EL ACCESO
	private final int COL_PUNTOS = 0;   // Puntos totales
	private final int COL_SG = 1;       // Sets Ganados
	private final int COL_SP = 2;       // Sets Perdidos
	private final int COL_TA = 3;       // Tantos a Favor
	private final int COL_TC = 4;       // Tantos en Contra
	private final int COL_S1_TA = 5; 	// Tantos a Favor en SET1
	private final int COL_S2_TA = 6; 	// Tantos a Favor en SET2
	private final int COL_S3_TA = 7; 	// Tantos a Favor en SET3
	private final int COL_S4_TA = 8; 	// Tantos a Favor en SET4
	private final int COL_S5_TA = 9; 	// Tantos a Favor en SET5
	private final int COL_PG = 10;		// Partidos ganados
	private final int COL_PP = 11;		// Partidos pertidos
	private final int COL_PJ = 12;		// Patidos jugados
	
	
	// -- FILA FINAL --
	private final int ROW_TOTAL = 10; // Fila con total de los parametros
	
	
	// --- EL PUENTE/DICCIONARIO ---
    private Map<String, int[][]> mapaMatricesEquipos;
    
    // --- LISTA EQUIPOS -------
    String[] equipos = {
		    "CV ZARAGOZA", 
		    "CV SAN FERNANDO", 
		    "VALLADOLID CV", 
		    "CV TORRELAVEGA", 
		    "CV PALMA", 
		    "CV RIVAS"
	};
	
	/*JORNADAS*/
	private DefaultListModel<String> dlmJornadasEqLocal;
	private DefaultListModel<String> dlmJornadasEqVisitante;
	private	DefaultComboBoxModel<String> dcmJornadas;
	private String[][] matrizJornadas = new String[30][2]; // COL 0 = LOCAL COL 1 = VISITANTE
	private int COL_EQUIPOS_LOCALES = 0;
	private int COL_EQUIPOS_VISITANTES = 1;
	
	/*GESTIONAR - RESULTADOS - JORNADAS (ESTAS DLMS SON TEMPORALES SOLO ALMACENAN UNA JORNADA ALA VEZ)*/
	//-- para los 5 datos de resultados de cada partido --
	// --LOCALES--
	private DefaultListModel<Integer>dlmJornadaSetsL;
	private DefaultListModel<Integer>dlmJornadaS1TAL;
	private DefaultListModel<Integer>dlmJornadaS2TAL;
	private DefaultListModel<Integer>dlmJornadaS3TAL;
	private DefaultListModel<Integer>dlmJornadaS4TAL;
	private DefaultListModel<Integer>dlmJornadaS5TAL;
	// --VISITANTES--
	private DefaultListModel<Integer>dlmJornadaSetsV;
	private DefaultListModel<Integer>dlmJornadaS1TAV;
	private DefaultListModel<Integer>dlmJornadaS2TAV;
	private DefaultListModel<Integer>dlmJornadaS3TAV;
	private DefaultListModel<Integer>dlmJornadaS4TAV;
	private DefaultListModel<Integer>dlmJornadaS5TAV;
		
		
	/*CLASIFICACIÓN*/
	private DefaultListModel<Integer> dlmClasificacionPuntos;
	private DefaultListModel<Integer> dlmClasificacionPartidosJugados;
	private DefaultListModel<Integer> dlmClasificacionPartidosGanados;
	private DefaultListModel<Integer> dlmClasificacionPartidosPerdidos;
	private DefaultListModel<Integer> dlmClasificacionSetsGanados;
	private DefaultListModel<Integer> dlmClasificacionSetsPerdidos;
	private DefaultListModel<Integer> dlmClasificacionTantosFavor;
	private DefaultListModel<Integer> dlmClasificacionTantosContra;
	private JPanel panelTituloClasificacion;
	private JLabel lblClasificacion;
	
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
		
		/*INTRODUCIR JORNADAS*/
		String[] equiposLocales = {
			    // Jornada 1
			    "CV ZARAGOZA", "VALLADOLID CV", "CV TORRELAVEGA", 
			    // Jornada 2
			    "CV ZARAGOZA", "CV SAN FERNANDO", "VALLADOLID CV", 
			    // Jornada 3
			    "CV ZARAGOZA", "CV RIVAS", "CV SAN FERNANDO", 
			    // Jornada 4
			    "CV ZARAGOZA", "CV PALMA", "CV RIVAS", 
			    // Jornada 5
			    "CV ZARAGOZA", "CV TORRELAVEGA", "CV PALMA", 
			    // Jornada 6
			    "CV SAN FERNANDO", "CV RIVAS", "CV PALMA", 
			    // Jornada 7
			    "CV RIVAS", "CV PALMA", "CV TORRELAVEGA", 
			    // Jornada 8
			    "CV PALMA", "CV TORRELAVEGA", "VALLADOLID CV", 
			    // Jornada 9
			    "CV TORRELAVEGA", "VALLADOLID CV", "CV SAN FERNANDO",
			    // Jornada 10
			    "VALLADOLID CV", "CV SAN FERNANDO", "CV RIVAS" 
			};
		
		String[] equiposVisitantes = {
			    // Jornada 1
			    "CV SAN FERNANDO", "CV RIVAS", "CV PALMA", 
			    // Jornada 2
			    "CV RIVAS", "CV PALMA", "CV TORRELAVEGA", 
			    // Jornada 3
			    "CV PALMA", "CV TORRELAVEGA", "VALLADOLID CV", 
			    // Jornada 4
			    "CV TORRELAVEGA", "VALLADOLID CV", "CV SAN FERNANDO", 
			    // Jornada 5
			    "VALLADOLID CV", "CV SAN FERNANDO", "CV RIVAS", 
			    // Jornada 6
			    "CV ZARAGOZA", "VALLADOLID CV", "CV TORRELAVEGA", 
			    // Jornada 7
			    "CV ZARAGOZA", "CV SAN FERNANDO", "VALLADOLID CV", 
			    // Jornada 8
			    "CV ZARAGOZA", "CV RIVAS", "CV SAN FERNANDO", 
			    // Jornada 9
			    "CV ZARAGOZA", "CV PALMA", "CV RIVAS",
			    // Jornada 10
			    "CV ZARAGOZA", "CV TORRELAVEGA", "CV PALMA"
			};
		
		for (int i = 0; i < matrizJornadas.length; i++) {
	        // Columna 0: Equipo Local
	        matrizJornadas[i][COL_EQUIPOS_LOCALES] = equiposLocales[i];
	        
	        // Columna 1: Equipo Visitante
	        matrizJornadas[i][COL_EQUIPOS_VISITANTES] = equiposVisitantes[i];
	    }
	    //System.out.println("Matriz Jornadas rellenada con " + matrizJornadas.length + " partidos.");
		
		/*INICIALIZAR DLMs*/
		dcmJornadas = new DefaultComboBoxModel<String>();
		
		/*EQUIPOS*/
		dlmEquipos = new DefaultListModel<String>();
		/*JORNADAS*/
		
	    // Inicialización de dlm LOCALES 
		dlmJornadasEqLocal = new DefaultListModel<String>();
		dlmJornadasEqVisitante = new DefaultListModel<String>();
		dlmJornadaSetsL = new DefaultListModel<Integer>();
	    dlmJornadaS1TAL = new DefaultListModel<Integer>();
	    dlmJornadaS2TAL = new DefaultListModel<Integer>();
	    dlmJornadaS3TAL = new DefaultListModel<Integer>();
	    dlmJornadaS4TAL = new DefaultListModel<Integer>();
	    dlmJornadaS5TAL = new DefaultListModel<Integer>();

	    // Inicialización de dlm VISITANTES 
	    dlmJornadaSetsV = new DefaultListModel<Integer>();
	    dlmJornadaS1TAV = new DefaultListModel<Integer>();
	    dlmJornadaS2TAV = new DefaultListModel<Integer>();
	    dlmJornadaS3TAV = new DefaultListModel<Integer>();
	    dlmJornadaS4TAV = new DefaultListModel<Integer>();
	    dlmJornadaS5TAV = new DefaultListModel<Integer>();
		
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
		setNumeroJorndas(dcmJornadas, 10);

		
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
		
		/*PANEL ARBITRO*/
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, "PanelArbitro_");
		panelPrincipal.setLayout(new BorderLayout(0, 0));

		scrollPanel = new JPanel();
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));

		scrollPane = new JScrollPane(scrollPanel);
		panelPrincipal.add(scrollPane, BorderLayout.CENTER);
		Jornadas = new JPanel();
		scrollPanel.add(Jornadas);
		Jornadas.setLayout(new BorderLayout(0, 0));

		northPanelJornadas = new JPanel();
		Jornadas.add(northPanelJornadas, BorderLayout.NORTH);
		
		comboBoxJornadas = new JComboBox<String>(dcmJornadas);
		comboBoxJornadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		
		btnAnteriorJornada = new JButton("<< Anterior");
		btnAnteriorJornada.addActionListener(this);
		northPanelJornadas.add(btnAnteriorJornada);
		northPanelJornadas.add(comboBoxJornadas);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnCerrarSesion.addActionListener(this);
		
		btnSiguienteJornada = new JButton("Siguiente >>");
		northPanelJornadas.add(btnSiguienteJornada);
		northPanelJornadas.add(btnCerrarSesion);
		btnSiguienteJornada.addActionListener(this);
		
		panelJornadas = new JPanel();
		panelJornadas.setBackground(new Color(238, 235, 228));
		Jornadas.add(panelJornadas, BorderLayout.CENTER);
		panelJornadas.setLayout(new BoxLayout(panelJornadas, BoxLayout.Y_AXIS));
		
		panelTitulo = new JPanel();
		panelJornadas.add(panelTitulo);
		
		lblGestionarJornadas = 	new JLabel("JORNADAS");
		lblGestionarJornadas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGestionarJornadas.setForeground(azulPrimero);
		lblGestionarJornadas.setFont(new Font("Leelawadee", Font.BOLD, 25));
		panelTitulo.add(lblGestionarJornadas);
		
		panelListasJornadas = new JPanel();
		panelListasJornadas.setPreferredSize(new Dimension(750, 200));
		panelListasJornadas.setMaximumSize(new Dimension(1500, 300));
	
		panelJornadas.add(panelListasJornadas);
		GridBagLayout gbl_panelListasJornadas = new GridBagLayout();
		gbl_panelListasJornadas.columnWidths = new int[] {50, 150, 150};
		gbl_panelListasJornadas.rowHeights = new int[]{0, 0};
		gbl_panelListasJornadas.columnWeights = new double[]{0.0, 1.0, 1.0};
		gbl_panelListasJornadas.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelListasJornadas.setLayout(gbl_panelListasJornadas);
		
		panelNumeroJornadas = new JPanel();
		panelNumeroJornadas.setMaximumSize(new Dimension(75, 0));
		panelNumeroJornadas.setMinimumSize(new Dimension(75, 0));
		panelNumeroJornadas.setBackground(azulSegundo);
		GridBagConstraints gbc_panelNumeroJornadas = new GridBagConstraints();
		gbc_panelNumeroJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_panelNumeroJornadas.fill = GridBagConstraints.VERTICAL;
		gbc_panelNumeroJornadas.gridx = 0;
		gbc_panelNumeroJornadas.gridy = 0;
		panelListasJornadas.add(panelNumeroJornadas, gbc_panelNumeroJornadas);
		
		headerNJornadas = new JLabel("Nº ");
		headerNJornadas.setForeground(amarilloPrimero);
	
		headerNJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		headerNJornadas.setFont(new Font("Lucida Console", Font.BOLD, 20));
		panelNumeroJornadas.add(headerNJornadas);
		
		panelEqLocales = new JPanel();
		panelEqLocales.setBackground(azulSegundo);
		GridBagConstraints gbc_panelEqLocales = new GridBagConstraints();
		gbc_panelEqLocales.insets = new Insets(0, 0, 0, 5);
		gbc_panelEqLocales.fill = GridBagConstraints.BOTH;
		gbc_panelEqLocales.gridx = 1;
		gbc_panelEqLocales.gridy = 0;
		panelListasJornadas.add(panelEqLocales, gbc_panelEqLocales);
		panelEqLocales.setLayout(new BoxLayout(panelEqLocales, BoxLayout.Y_AXIS));
		
		lblTitleEqLocales = new JLabel("EQUIPOS LOCALES");
		lblTitleEqLocales.setForeground(new Color(255, 255, 255));
		lblTitleEqLocales.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitleEqLocales.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitleEqLocales.setHorizontalAlignment(SwingConstants.CENTER);
		panelEqLocales.add(lblTitleEqLocales);
		
		panelListContainerLocales = new JPanel();
		panelListContainerLocales.setBackground(azulTercero);
		panelEqLocales.add(panelListContainerLocales);
		GridBagLayout gbl_panelListContainerLocales = new GridBagLayout();
		gbl_panelListContainerLocales.columnWidths = new int[] {140, 30, 30, 30, 30, 30, 30, 0};
		gbl_panelListContainerLocales.rowHeights = new int[]{373, 0};
		gbl_panelListContainerLocales.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelListContainerLocales.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelListContainerLocales.setLayout(gbl_panelListContainerLocales);
		
		listNombreEquiposLocal = new JList<String>(dlmJornadasEqLocal);
		listNombreEquiposLocal.addListSelectionListener(this);
		listNombreEquiposLocal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNombreEquiposLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listNombreEquiposLocal.setBackground(azulTercero);
		GridBagConstraints gbc_listNombreEquiposLocal = new GridBagConstraints();
		gbc_listNombreEquiposLocal.fill = GridBagConstraints.BOTH;
		gbc_listNombreEquiposLocal.insets = new Insets(0, 0, 0, 5);
		gbc_listNombreEquiposLocal.gridx = 0;
		gbc_listNombreEquiposLocal.gridy = 0;
		panelListContainerLocales.add(listNombreEquiposLocal, gbc_listNombreEquiposLocal);
		
		listSetsLocales = new JList<Integer>(dlmJornadaSetsL);
		listSetsLocales.addListSelectionListener(this);
		listSetsLocales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSetsLocales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSetsLocales.setBackground(azulTercero);
		GridBagConstraints gbc_listSetsLocales = new GridBagConstraints();
		gbc_listSetsLocales.fill = GridBagConstraints.BOTH;
		gbc_listSetsLocales.insets = new Insets(0, 0, 0, 5);
		gbc_listSetsLocales.gridx = 1;
		gbc_listSetsLocales.gridy = 0;
		panelListContainerLocales.add(listSetsLocales, gbc_listSetsLocales);
		
		listS1TL = new JList<Integer>(dlmJornadaS1TAL);
		listS1TL.addListSelectionListener(this);
		listS1TL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS1TL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS1TL.setBackground(azulTercero);
		GridBagConstraints gbc_listS1TL = new GridBagConstraints();
		gbc_listS1TL.fill = GridBagConstraints.BOTH;
		gbc_listS1TL.insets = new Insets(0, 0, 0, 5);
		gbc_listS1TL.gridx = 2;
		gbc_listS1TL.gridy = 0;
		panelListContainerLocales.add(listS1TL, gbc_listS1TL);
		
		listS2TL = new JList<Integer>(dlmJornadaS2TAL);
		listS2TL.addListSelectionListener(this);
		listS2TL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS2TL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS2TL.setBackground(azulTercero);
		GridBagConstraints gbc_listS2TL = new GridBagConstraints();
		gbc_listS2TL.fill = GridBagConstraints.BOTH;
		gbc_listS2TL.insets = new Insets(0, 0, 0, 5);
		gbc_listS2TL.gridx = 3;
		gbc_listS2TL.gridy = 0;
		panelListContainerLocales.add(listS2TL, gbc_listS2TL);
		
		listS3TL = new JList<Integer>(dlmJornadaS3TAL);
		listS3TL.addListSelectionListener(this);
		listS3TL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS3TL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS3TL.setBackground(azulTercero);
		GridBagConstraints gbc_listS3TL = new GridBagConstraints();
		gbc_listS3TL.fill = GridBagConstraints.BOTH;
		gbc_listS3TL.insets = new Insets(0, 0, 0, 5);
		gbc_listS3TL.gridx = 4;
		gbc_listS3TL.gridy = 0;
		panelListContainerLocales.add(listS3TL, gbc_listS3TL);
		
		listS4TL = new JList<Integer>(dlmJornadaS4TAL);
		listS4TL.addListSelectionListener(this);
		listS4TL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS4TL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS4TL.setBackground(azulTercero);
		GridBagConstraints gbc_listS4TL = new GridBagConstraints();
		gbc_listS4TL.fill = GridBagConstraints.BOTH;
		gbc_listS4TL.insets = new Insets(0, 0, 0, 5);
		gbc_listS4TL.gridx = 5;
		gbc_listS4TL.gridy = 0;
		panelListContainerLocales.add(listS4TL, gbc_listS4TL);
		
		listS5TL = new JList<Integer>(dlmJornadaS5TAL);
		listS5TL.addListSelectionListener(this);
		listS5TL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS5TL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS5TL.setBackground(azulTercero);
		GridBagConstraints gbc_listS5TL = new GridBagConstraints();
		gbc_listS5TL.fill = GridBagConstraints.BOTH;
		gbc_listS5TL.gridx = 6;
		gbc_listS5TL.gridy = 0;
		panelListContainerLocales.add(listS5TL, gbc_listS5TL);
		
	
		
		panelEqVisitantes = new JPanel();
		panelEqVisitantes.setBackground(azulSegundo);
		GridBagConstraints gbc_panelEqVisitantes = new GridBagConstraints();
		gbc_panelEqVisitantes.fill = GridBagConstraints.BOTH;
		gbc_panelEqVisitantes.gridx = 2;
		gbc_panelEqVisitantes.gridy = 0;
		panelListasJornadas.add(panelEqVisitantes, gbc_panelEqVisitantes);
		panelEqVisitantes.setLayout(new BoxLayout(panelEqVisitantes, BoxLayout.Y_AXIS));
		
		lblTitleEqVisitante = new JLabel("EQUIPOS VISITANTES");
		lblTitleEqVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleEqVisitante.setForeground(Color.WHITE);
		lblTitleEqVisitante.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitleEqVisitante.setAlignmentX(0.5f);
		panelEqVisitantes.add(lblTitleEqVisitante);
		
		panelListContainerVisitantes = new JPanel();
		panelListContainerVisitantes.setBackground(azulTercero);
		panelEqVisitantes.add(panelListContainerVisitantes);
		GridBagLayout gbl_panelListContainerVisitantes = new GridBagLayout();
		gbl_panelListContainerVisitantes.columnWidths = new int[] {140, 30, 30, 30, 30, 30, 30, 0};
		gbl_panelListContainerVisitantes.rowHeights = new int[]{373, 0};
		gbl_panelListContainerVisitantes.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelListContainerVisitantes.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelListContainerVisitantes.setLayout(gbl_panelListContainerVisitantes);
		
		listNombreEquiposVisitantes = new JList<String>(dlmJornadasEqVisitante);
		listNombreEquiposVisitantes.addListSelectionListener(this);
		listNombreEquiposVisitantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNombreEquiposVisitantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listNombreEquiposVisitantes.setBackground(azulTercero);
		GridBagConstraints gbc_listNombreEquiposVisitantes = new GridBagConstraints();
		gbc_listNombreEquiposVisitantes.fill = GridBagConstraints.BOTH;
		gbc_listNombreEquiposVisitantes.insets = new Insets(0, 0, 0, 5);
		gbc_listNombreEquiposVisitantes.gridx = 0;
		gbc_listNombreEquiposVisitantes.gridy = 0;
		panelListContainerVisitantes.add(listNombreEquiposVisitantes, gbc_listNombreEquiposVisitantes);
		
		listSetsVisitantes = new JList<Integer>(dlmJornadaSetsV);
		listSetsVisitantes.addListSelectionListener(this);
		listSetsVisitantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSetsVisitantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSetsVisitantes.setBackground(azulTercero);
		GridBagConstraints gbc_listSetsVisitantes = new GridBagConstraints();
		gbc_listSetsVisitantes.fill = GridBagConstraints.BOTH;
		gbc_listSetsVisitantes.insets = new Insets(0, 0, 0, 5);
		gbc_listSetsVisitantes.gridx = 1;
		gbc_listSetsVisitantes.gridy = 0;
		panelListContainerVisitantes.add(listSetsVisitantes, gbc_listSetsVisitantes);
		
		listS1TV = new JList<Integer>(dlmJornadaS1TAV);
		listS1TV.addListSelectionListener(this);
		listS1TV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS1TV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS1TV.setBackground(azulTercero);
		GridBagConstraints gbc_listS1TV = new GridBagConstraints();
		gbc_listS1TV.fill = GridBagConstraints.BOTH;
		gbc_listS1TV.insets = new Insets(0, 0, 0, 5);
		gbc_listS1TV.gridx = 2;
		gbc_listS1TV.gridy = 0;
		panelListContainerVisitantes.add(listS1TV, gbc_listS1TV);
		
		listS2TV = new JList<Integer>(dlmJornadaS2TAV);
		listS2TV.addListSelectionListener(this);
		listS2TV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS2TV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS2TV.setBackground(azulTercero);
		GridBagConstraints gbc_listS2TV = new GridBagConstraints();
		gbc_listS2TV.fill = GridBagConstraints.BOTH;
		gbc_listS2TV.insets = new Insets(0, 0, 0, 5);
		gbc_listS2TV.gridx = 3;
		gbc_listS2TV.gridy = 0;
		panelListContainerVisitantes.add(listS2TV, gbc_listS2TV);
		
		listS3TV = new JList<Integer>(dlmJornadaS3TAV);
		listS3TV.addListSelectionListener(this);
		listS3TV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS3TV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS3TV.setBackground(azulTercero);
		GridBagConstraints gbc_listS3TV = new GridBagConstraints();
		gbc_listS3TV.fill = GridBagConstraints.BOTH;
		gbc_listS3TV.insets = new Insets(0, 0, 0, 5);
		gbc_listS3TV.gridx = 4;
		gbc_listS3TV.gridy = 0;
		panelListContainerVisitantes.add(listS3TV, gbc_listS3TV);
		
		listS4TV = new JList<Integer>(dlmJornadaS4TAV);
		listS4TV.addListSelectionListener(this);
		listS4TV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS4TV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS4TV.setBackground(azulTercero);
		GridBagConstraints gbc_listS4TV = new GridBagConstraints();
		gbc_listS4TV.fill = GridBagConstraints.BOTH;
		gbc_listS4TV.insets = new Insets(0, 0, 0, 5);
		gbc_listS4TV.gridx = 5;
		gbc_listS4TV.gridy = 0;
		panelListContainerVisitantes.add(listS4TV, gbc_listS4TV);
		
		listS5TV = new JList<Integer>(dlmJornadaS5TAV);
		listS5TV.addListSelectionListener(this);
		listS5TV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listS5TV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listS5TV.setBackground(azulTercero);
		GridBagConstraints gbc_listS5TV = new GridBagConstraints();
		gbc_listS5TV.fill = GridBagConstraints.BOTH;
		gbc_listS5TV.gridx = 6;
		gbc_listS5TV.gridy = 0;
		panelListContainerVisitantes.add(listS5TV, gbc_listS5TV);
		
		JPanel panelBotonesJornadas = new JPanel();
		panelBotonesJornadas.setPreferredSize(new Dimension(1100, 220));
		panelBotonesJornadas.setMaximumSize(new Dimension(1000, 220));
		
		panelJornadas.add(panelBotonesJornadas);
		panelBotonesJornadas.setLayout(new BoxLayout(panelBotonesJornadas, BoxLayout.Y_AXIS));
		
		panelTxtJornadasContainer = new JPanel();
		panelBotonesJornadas.add(panelTxtJornadasContainer);
		panelTxtJornadasContainer.setLayout(new BoxLayout(panelTxtJornadasContainer, BoxLayout.Y_AXIS));
		
		txtLocales = new JPanel();
		panelTxtJornadasContainer.add(txtLocales);
		txtLocales.setLayout(new BorderLayout(0, 0));
		
		lblEquipoLocal_ResultadoPartido= new JLabel("EQUIPO LOCAL");
		lblEquipoLocal_ResultadoPartido.setPreferredSize(new Dimension(200, 50));
		lblEquipoLocal_ResultadoPartido.setVerticalAlignment(SwingConstants.TOP);
		lblEquipoLocal_ResultadoPartido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipoLocal_ResultadoPartido.setHorizontalAlignment(SwingConstants.LEFT);
		txtLocales.add(lblEquipoLocal_ResultadoPartido, BorderLayout.WEST);
		
		localesInput = new JPanel();
		txtLocales.add(localesInput, BorderLayout.CENTER);
		
		lblSetsTotales = new JLabel("SETS:");
		lblSetsTotales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetsTotales.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		localesInput.add(lblSetsTotales);
		
		txtSestL = new JTextField();
		txtSestL.setEnabled(false);
		txtSestL.setEditable(false);
		txtSestL.setHorizontalAlignment(SwingConstants.CENTER);
		txtSestL.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		txtSestL.setColumns(3);
		localesInput.add(txtSestL);
		
		lblS1Ta = new JLabel("S1 - TA:");
		
		lblS1Ta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblS1Ta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		localesInput.add(lblS1Ta);
		
		
		txtS1TaL = new JTextField();
		txtS1TaL.setHorizontalAlignment(SwingConstants.CENTER);
		txtS1TaL.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS1TaL.setColumns(3);
		localesInput.add(txtS1TaL);
		
		lblS2Ta = new JLabel("S2 - TA:");
		lblS2Ta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblS2Ta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		localesInput.add(lblS2Ta);
		
		txtS2TaL = new JTextField();
		txtS2TaL.setHorizontalAlignment(SwingConstants.CENTER);
		txtS2TaL.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS2TaL.setColumns(3);
		localesInput.add(txtS2TaL);
		
		lblS3Ta = new JLabel("S3 - TA:");
		lblS3Ta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblS3Ta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		localesInput.add(lblS3Ta);
		
		txtS3TaL = new JTextField();
		txtS3TaL.setHorizontalAlignment(SwingConstants.CENTER);
		txtS3TaL.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS3TaL.setColumns(3);
		localesInput.add(txtS3TaL);
		
		lblS4Ta = new JLabel("S4 - TA:");
		lblS4Ta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblS4Ta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		localesInput.add(lblS4Ta);
		
		txtS4TaL = new JTextField();
		txtS4TaL.setHorizontalAlignment(SwingConstants.CENTER);
		txtS4TaL.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS4TaL.setColumns(3);
		localesInput.add(txtS4TaL);
		
		lblS5Ta = new JLabel("S5 - TA:");
		lblS5Ta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblS5Ta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		localesInput.add(lblS5Ta);
		
		txtS5TaL = new JTextField();
		txtS5TaL.setHorizontalAlignment(SwingConstants.CENTER);
		txtS5TaL.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS5TaL.setColumns(3);
		localesInput.add(txtS5TaL);
		
		
		txtVisitantes = new JPanel();
		panelTxtJornadasContainer.add(txtVisitantes);
		txtVisitantes.setLayout(new BorderLayout(0, 0));
		
		lblEquipoVisitante_ResultadoPartido = new JLabel("EQUIPO VISITANTE");
		lblEquipoVisitante_ResultadoPartido.setPreferredSize(new Dimension(200, 50));
		lblEquipoVisitante_ResultadoPartido.setVerticalAlignment(SwingConstants.TOP);
		lblEquipoVisitante_ResultadoPartido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipoVisitante_ResultadoPartido.setHorizontalAlignment(SwingConstants.LEFT);
		txtVisitantes.add(lblEquipoVisitante_ResultadoPartido, BorderLayout.WEST);
		
		visitantesInput = new JPanel();
		txtVisitantes.add(visitantesInput);
		
		lblSetsTotalesV = new JLabel("SETS:");
		lblSetsTotalesV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetsTotalesV.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		visitantesInput.add(lblSetsTotalesV);
		
		txtSetsV = new JTextField();
		txtSetsV.setEnabled(false);
		txtSetsV.setEditable(false);
		txtSetsV.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetsV.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		txtSetsV.setColumns(3);
		visitantesInput.add(txtSetsV);
		
		lblS1TaV = new JLabel("S1 - TA:");
		lblS1TaV.setHorizontalAlignment(SwingConstants.CENTER);
		lblS1TaV.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		visitantesInput.add(lblS1TaV);
		
		txtS1TavV = new JTextField();
		txtS1TavV.setHorizontalAlignment(SwingConstants.CENTER);
		txtS1TavV.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS1TavV.setColumns(3);
		visitantesInput.add(txtS1TavV);
		
		lblS2TaV = new JLabel("S2 - TA:");
		lblS2TaV.setHorizontalAlignment(SwingConstants.CENTER);
		lblS2TaV.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		visitantesInput.add(lblS2TaV);
		
		txtS2TaV = new JTextField();
		txtS2TaV.setHorizontalAlignment(SwingConstants.CENTER);
		txtS2TaV.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS2TaV.setColumns(3);
		visitantesInput.add(txtS2TaV);
		
		lblS3TaV = new JLabel("S3 - TA:");
		lblS3TaV.setHorizontalAlignment(SwingConstants.CENTER);
		lblS3TaV.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		visitantesInput.add(lblS3TaV);
		
		txtS3TaV = new JTextField();
		txtS3TaV.setHorizontalAlignment(SwingConstants.CENTER);
		txtS3TaV.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS3TaV.setColumns(3);
		visitantesInput.add(txtS3TaV);
		
		lblS4TaV = new JLabel("S4 - TA:");
		lblS4TaV.setHorizontalAlignment(SwingConstants.CENTER);
		lblS4TaV.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		visitantesInput.add(lblS4TaV);
		
		txtS4TaV = new JTextField();
		txtS4TaV.setHorizontalAlignment(SwingConstants.CENTER);
		txtS4TaV.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS4TaV.setColumns(3);
		visitantesInput.add(txtS4TaV);
		
		lblS5TaV = new JLabel("S5 - TA:");
		lblS5TaV.setHorizontalAlignment(SwingConstants.CENTER);
		lblS5TaV.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		visitantesInput.add(lblS5TaV);
		
		txtS5TaV = new JTextField();
		txtS5TaV.setHorizontalAlignment(SwingConstants.CENTER);
		txtS5TaV.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		txtS5TaV.setColumns(3);
		visitantesInput.add(txtS5TaV);
		
		panelBtnContainer = new JPanel();
		panelBotonesJornadas.add(panelBtnContainer);
		panelBtnContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnGuardarCambios_resultadosJornadas = new JButton("Guardar Cambios");
		btnGuardarCambios_resultadosJornadas.addActionListener(this);
		btnGuardarCambios_resultadosJornadas.setForeground(new Color(51, 153, 204));
		btnGuardarCambios_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardarCambios_resultadosJornadas.setBackground(new Color(253, 253, 150));
		panelBtnContainer.add(btnGuardarCambios_resultadosJornadas);
		
		btnBorrar_resultadosJornadas = new JButton("Borrar Partido");
		btnBorrar_resultadosJornadas.addActionListener(this);
		btnBorrar_resultadosJornadas.setForeground(new Color(51, 153, 204));
		btnBorrar_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBorrar_resultadosJornadas.setBackground(new Color(253, 253, 150));
		panelBtnContainer.add(btnBorrar_resultadosJornadas);
		
		btnLimpiar_resultadosJornadas = new JButton("Limpiar Jornada");
		btnLimpiar_resultadosJornadas.addActionListener(this);
		btnLimpiar_resultadosJornadas.setForeground(new Color(51, 153, 204));
		btnLimpiar_resultadosJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar_resultadosJornadas.setBackground(new Color(253, 253, 150));
		panelBtnContainer.add(btnLimpiar_resultadosJornadas);
		

		
		Clasificacion = new JPanel();
		scrollPanel.add(Clasificacion);
		Clasificacion.setLayout(new BoxLayout(Clasificacion, BoxLayout.Y_AXIS));
		
		panelTituloClasificacion = new JPanel();
		Clasificacion.add(panelTituloClasificacion);
		
		lblClasificacion = new JLabel("CLASIFICACIÓN");
		lblClasificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClasificacion.setForeground(new Color(0, 128, 192));
		lblClasificacion.setFont(new Font("Leelawadee", Font.BOLD, 25));
		panelTituloClasificacion.add(lblClasificacion);
		
		panelGestionarClasificacionHeader = new JPanel();
		panelGestionarClasificacionHeader.setBackground(new Color(0, 128, 192));
		Clasificacion.add(panelGestionarClasificacionHeader);
		panelGestionarClasificacionHeader.setLayout(new GridLayout(1, 1, 0, 0));
		
		panelGestionClasificacionListas = new JPanel();
		Clasificacion.add(panelGestionClasificacionListas);
		panelGestionClasificacionListas.setLayout(new GridLayout(0, 9, 0, 0));
		
		
		/*CLASIFIACION EQUIPOS*/
		listEquipos__resultadosClasificacion = new JList<String>(dlmEquipos);
		listEquipos__resultadosClasificacion.setEnabled(false);
		listEquipos__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEquipos__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listEquipos__resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 17));
		listEquipos__resultadosClasificacion.setFixedCellHeight(25);
		listEquipos__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listEquipos__resultadosClasificacion);

		lblheaderEquipo_restultados_1 = new JLabel("EQUIPO");
		lblheaderEquipo_restultados_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblheaderEquipo_restultados_1.setForeground(Color.WHITE);
		lblheaderEquipo_restultados_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblheaderEquipo_restultados_1);
		
		/*CLASIFIACION PUNTOS*/
		listPuntos__resultadosClasificacion = new JList<Integer>(dlmClasificacionPuntos);
		listPuntos__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPuntos__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listPuntos__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listPuntos__resultadosClasificacion.setFixedCellHeight(25);
		listPuntos__resultadosClasificacion.setEnabled(false);
		listPuntos__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listPuntos__resultadosClasificacion);
		
		lblheaderPTOS_resultadosClasificacion = new JLabel("PTOS");
		lblheaderPTOS_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblheaderPTOS_resultadosClasificacion.setForeground(Color.WHITE);
		lblheaderPTOS_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblheaderPTOS_resultadosClasificacion);
		
		/*CLASIFIACION PARTIDOS JUGADOS*/
		listPJ__resultadosClasificacion = new JList<Integer>(dlmClasificacionPartidosJugados);
		listPJ__resultadosClasificacion.setEnabled(false);
		listPJ__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPJ__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listPJ__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listPJ__resultadosClasificacion.setFixedCellHeight(25);
		listPJ__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listPJ__resultadosClasificacion);
		
		lblheaderPJ_resultadosClasificacion = new JLabel("P.J");
		lblheaderPJ_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblheaderPJ_resultadosClasificacion.setForeground(Color.WHITE);
		lblheaderPJ_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblheaderPJ_resultadosClasificacion);
		
		/*CLASIFIACION PARTIDOS GANADOS*/
		listPG__resultadosClasificacion = new JList<Integer>(dlmClasificacionPartidosGanados);
		listPG__resultadosClasificacion.setEnabled(false);
		listPG__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPG__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listPG__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listPG__resultadosClasificacion.setFixedCellHeight(25);
		listPG__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listPG__resultadosClasificacion);
		
		lblheaderPG_resultadosClasificacion = new JLabel("P.G");
		lblheaderPG_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblheaderPG_resultadosClasificacion.setForeground(Color.WHITE);
		lblheaderPG_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblheaderPG_resultadosClasificacion);
		
		/*CLASIFIACION PARTIDOS PERDIDOS*/
		listPP__resultadosClasificacion = new JList<Integer>(dlmClasificacionPartidosPerdidos);
		listPP__resultadosClasificacion.setEnabled(false);
		listPP__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPP__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listPP__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listPP__resultadosClasificacion.setFixedCellHeight(25);
		listPP__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listPP__resultadosClasificacion);
		
		lblHeaderPP_resultadosClasificacion = new JLabel("P.P");
		lblHeaderPP_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeaderPP_resultadosClasificacion.setForeground(Color.WHITE);
		lblHeaderPP_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblHeaderPP_resultadosClasificacion);
		
		/*CLASIFIACION SETS GANADOS*/
		listSG__resultadosClasificacion = new JList<Integer>(dlmClasificacionSetsGanados);
		listSG__resultadosClasificacion.setEnabled(false);
		listSG__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSG__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listSG__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listSG__resultadosClasificacion.setFixedCellHeight(25);
		listSG__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listSG__resultadosClasificacion);
		
		lblHeaderSG_1 = new JLabel("S.G");
		lblHeaderSG_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeaderSG_1.setForeground(Color.WHITE);
		lblHeaderSG_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblHeaderSG_1);
		
		/*CLASIFIACION SETS PERDIDOS*/
		listSP__resultadosClasificacion = new JList<Integer>(dlmClasificacionSetsPerdidos);
		listSP__resultadosClasificacion.setEnabled(false);
		listSP__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSP__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listSP__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listSP__resultadosClasificacion.setFixedCellHeight(25);
		listSP__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listSP__resultadosClasificacion);
		
		lblHeaderSP_resultadosClasificacion = new JLabel("S.P");
		lblHeaderSP_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeaderSP_resultadosClasificacion.setForeground(Color.WHITE);
		lblHeaderSP_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblHeaderSP_resultadosClasificacion);
		
		/*CLASIFIACION TANTOS A FAVOR*/
		listTA__resultadosClasificacion = new JList<Integer>(dlmClasificacionTantosFavor);
		listTA__resultadosClasificacion.setEnabled(false);
		listTA__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTA__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listTA__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listTA__resultadosClasificacion.setFixedCellHeight(25);
		listTA__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listTA__resultadosClasificacion);
		
		lblHeaderTA_resultadosClasificacion = new JLabel("T.A");
		lblHeaderTA_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeaderTA_resultadosClasificacion.setForeground(Color.WHITE);
		lblHeaderTA_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblHeaderTA_resultadosClasificacion);
		
		/*CLASIFIACION TANTOS EN CONTRA*/
		listTC__resultadosClasificacion = new JList<Integer>(dlmClasificacionTantosContra);
		listTC__resultadosClasificacion.setEnabled(false);
		listTC__resultadosClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTC__resultadosClasificacion.setForeground(new Color(50, 50, 50));
		listTC__resultadosClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listTC__resultadosClasificacion.setFixedCellHeight(25);
		listTC__resultadosClasificacion.setBackground(azulTercero);
		panelGestionClasificacionListas.add(listTC__resultadosClasificacion);
		
		lblHeaderTC_resultadosClasificacion = new JLabel("T.C");
		lblHeaderTC_resultadosClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeaderTC_resultadosClasificacion.setForeground(Color.WHITE);
		lblHeaderTC_resultadosClasificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelGestionarClasificacionHeader.add(lblHeaderTC_resultadosClasificacion);
		
		
		
		
		
// ----------------------------------- GESTION USUARIOS ------------------------------------ //  
	    
	    /*GESTION USUARIOS*/
		
		if (username_param.equals(Login.arbitro_user)){
			this.setTitle(this.getTitle() + " - GESTIÓN ARBITRO");
		} else {
			panelBtnContainer.setVisible(false);
			btnGuardarCambios_resultadosJornadas.setEnabled(false);
			btnBorrar_resultadosJornadas.setEnabled(false);
			btnLimpiar_resultadosJornadas.setEnabled(false);
			txtS1TaL.setEnabled(false);
			txtS2TaL.setEnabled(false);
			txtS3TaL.setEnabled(false);
			txtS4TaL.setEnabled(false);
			txtS5TaL.setEnabled(false);
			txtSetsV.setEnabled(false);
			txtS1TavV.setEnabled(false);
			txtS2TaV.setEnabled(false);
			txtS3TaV.setEnabled(false);
			txtS4TaV.setEnabled(false);
			txtS5TaV.setEnabled(false);
			
		}
		
		//ESTABLECEMOS LOS DATOS DE LAS JORNADAS
		definirDatosResultadosJornadasPorDefecto();
		//ACTUALIZAR LAS JORNADAS
		cambiarJornada(comboBoxJornadas, headerNJornadas);
		//ACTUALIZAR CLASIFICACIÓN
		actualizarPosicionClasifiacion();
		listNombreEquiposLocal.setSelectedIndex(0);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	// -- METODOS (FUNCIONES) PRIVADAS --
	
	private void setEquipos(DefaultListModel<String> dlmEquipos) {
		for(int i = 0; i < equipos.length; i++) {
			/*
			  Añades a la dlm en el indice (i) el valor de el array (i)
			  i = 3 -> dlmEquipos.add(3, "VALLADOLID CV ")
			 */
			dlmEquipos.add(i, equipos[i]);
		}
	}
	
	/*Esta funcion vaciara la dlm y la rellenada con el rango estableciado */
	private void setEquiposLocales(DefaultListModel<String> dlmEquiposLocales, int minIndex, int maxIndex) {
	    // 1. Vacia el dlm para empezar desde cero
	    dlmEquiposLocales.clear(); 
	    
	    // 2. Recorre el rango de filas (partidos) especificado
	    for (int i = minIndex; i < maxIndex; i++) {
	        // 3. Añade el elemento de la matriz:
	        //    'i' es el índice de la fila (el partido).
	        //   'COL_EQUIPOS_LOCALES' es el índice de la columna (0).
	
	            String equipoLocal = matrizJornadas[i][COL_EQUIPOS_LOCALES];
	            dlmEquiposLocales.addElement(equipoLocal);
	        }
	    }
	
	
	/*Esta funcion vaciara la dlm y la rellenada con el rango estableciado */
	private void setEquiposVisitantes(DefaultListModel<String> dlmEquiposLocales, int minIndex, int maxIndex) {
	    // 1. Vacia el dlm para empezar desde cero
	    dlmEquiposLocales.clear(); 
	    
	    // 2. Recorre el rango de filas (partidos) especificado
	    for (int i = minIndex; i < maxIndex; i++) {
	        // 3. Añade el elemento de la matriz:
	        //    'i' es el índice de la fila (el partido).
	        //   'COL_EQUIPOS_LOCALES' es el índice de la columna (0).
	
	            String equipoLocal = matrizJornadas[i][COL_EQUIPOS_VISITANTES];
	            dlmEquiposLocales.addElement(equipoLocal);
	        }
	    }
	
	/*Establece el numero de jornadas en la dlm -> Necesario para poder usar ComboBox*/
	private void setNumeroJorndas(DefaultComboBoxModel<String> dcmJornadas, int numeroJornadas) {
		for(int i = 1; i<= numeroJornadas; i++) {
			dcmJornadas.addElement("Jornada: " + i);
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
	    
	    // 1. OBTIENE LA JORNADA SELECCIONADA (0 for Jornada 1, 1 for Jornada 2, etc.)
	    int jornadaIndex = comboBox.getSelectedIndex();
	    
	    // 2. CALCULA EL RANGO DE ÍNDICES DE PARTIDO para la jornada seleccionada
	    // (Cada jornada tiene 3 partidos en la matriz de pairings)
	    int minIndex = jornadaIndex * 3; 
	    int maxIndex = minIndex + 3;
	    
	    // 3. RELLENA LAS LISTAS DE NOMBRES DE EQUIPOS LOCAL/VISITANTE para la jornada
	    setEquiposLocales(dlmJornadasEqLocal, minIndex, maxIndex);
	    setEquiposVisitantes(dlmJornadasEqVisitante, minIndex, maxIndex);
	    
	    // 4. LIMPIA LOS MODELOS DE LISTA DE RESULTADOS ANTES DE RELLENARLOS
	    dlmJornadaSetsL.clear();
	    dlmJornadaS1TAL.clear();
	    dlmJornadaS2TAL.clear();
	    dlmJornadaS3TAL.clear();
	    dlmJornadaS4TAL.clear();
	    dlmJornadaS5TAL.clear();
	    
	    dlmJornadaSetsV.clear(); // No olvides limpiar los de visitantes también
	    dlmJornadaS1TAV.clear();
	    dlmJornadaS2TAV.clear();
	    dlmJornadaS3TAV.clear();
	    dlmJornadaS4TAV.clear();
	    dlmJornadaS5TAV.clear();
	  
	    // 5. ITERA POR LOS 3 PARTIDOS DE LA JORNADA Y RELLENA LOS MODELOS DE RESULTADOS
	    for (int i = minIndex; i < maxIndex; i++) {
	        // Obtiene los nombres de los equipos de la matriz de pairings
	        String local = matrizJornadas[i][COL_EQUIPOS_LOCALES];
	        String visitante = matrizJornadas[i][COL_EQUIPOS_VISITANTES];

	        // Obtiene las matrices de estadísticas correspondientes a los equipos
	        int[][] matrizLocal = obtenterMatrizPorNombreEquipo(local);
	        int[][] matrizVisitante = obtenterMatrizPorNombreEquipo(visitante);

	        // Verifica si las matrices se encontraron
	        if (matrizLocal == null || matrizVisitante == null) {
	            // Puedes añadir valores por defecto (ej. 0) o saltar este partido
	            dlmJornadaSetsL.addElement(0);
	            dlmJornadaS1TAL.addElement(0);
	            dlmJornadaS2TAL.addElement(0);
	            dlmJornadaS3TAL.addElement(0);
	            dlmJornadaS4TAL.addElement(0);
	            dlmJornadaS5TAL.addElement(0);
	            
	            dlmJornadaSetsV.addElement(0);
	            dlmJornadaS1TAV.addElement(0);
	            dlmJornadaS2TAV.addElement(0);
	            dlmJornadaS3TAV.addElement(0);
	            dlmJornadaS4TAV.addElement(0);
	            dlmJornadaS5TAV.addElement(0);
	            continue; // Pasa al siguiente partido
	        }

	        // Añade los resultados del equipo LOCAL a sus modelos de lista
	        dlmJornadaSetsL.addElement(matrizLocal[jornadaIndex][COL_SG]); // Sets Ganados por el local
	        dlmJornadaS1TAL.addElement(matrizLocal[jornadaIndex][COL_S1_TA]);
	        dlmJornadaS2TAL.addElement(matrizLocal[jornadaIndex][COL_S2_TA]);
	        dlmJornadaS3TAL.addElement(matrizLocal[jornadaIndex][COL_S3_TA]);
	        dlmJornadaS4TAL.addElement(matrizLocal[jornadaIndex][COL_S4_TA]);
	        dlmJornadaS5TAL.addElement(matrizLocal[jornadaIndex][COL_S5_TA]);
	        
	        // Añade los resultados del equipo VISITANTE a sus modelos de lista
	        dlmJornadaSetsV.addElement(matrizVisitante[jornadaIndex][COL_SG]); // Sets Ganados por el visitante
	        dlmJornadaS1TAV.addElement(matrizVisitante[jornadaIndex][COL_S1_TA]);
	        dlmJornadaS2TAV.addElement(matrizVisitante[jornadaIndex][COL_S2_TA]);
	        dlmJornadaS3TAV.addElement(matrizVisitante[jornadaIndex][COL_S3_TA]);
	        dlmJornadaS4TAV.addElement(matrizVisitante[jornadaIndex][COL_S4_TA]);
	        dlmJornadaS5TAV.addElement(matrizVisitante[jornadaIndex][COL_S5_TA]);
	    }
	  
	    // 6. ACTUALIZA LA ETIQUETA DEL NÚMERO DE JORNADA
	    nJornada.setText("Nº " + (jornadaIndex + 1));
	
	    listNombreEquiposLocal.setSelectedIndex(0);
	}
	
	private void definirDatosResultadosJornadasPorDefecto() {
	    
	    // Método auxiliar (sin cambios, ya que los 15 parámetros son correctos)
	    // private void asignarResultadosJornada(int[][] matriz, int J, int puntos, int sg, int sp, int ta, int tc, int s1Ta, int s2Ta, int s3Ta, int s4Ta, int s5Ta, int pg, int pp, int pj)

	    // -------------------------------------------------------------------------
	    // JORNADA 1 (Índice 0)
	    // -------------------------------------------------------------------------
	    int J = 0;
	    
	    // CV ZARAGOZA (3-1) -> Gana (2 Pts) vs. CV SAN FERNANDO (1-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 1, 98, 85, 25, 23, 25, 25, 0, 1, 0, 1); 
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 1, 3, 85, 98, 21, 25, 19, 20, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // VALLADOLID CV (3-2) -> Gana (2 Pts) vs. CV RIVAS (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_valladolid, J, 2, 3, 2, 106, 103, 25, 20, 25, 21, 15, 1, 0, 1);
	    asignarResultadosJornada(matriz_rivas, J, 1, 2, 3, 103, 106, 18, 25, 22, 25, 13, 0, 1, 1); // Se mantiene 1 Pto por perder 2-3

	    // CV TORRELAVEGA (0-3) -> Gana (1 Pto) vs. CV PALMA (3-0) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_torrelavega, J, 1, 0, 3, 63, 75, 19, 21, 23, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_palma, J, 2, 3, 0, 75, 63, 25, 25, 25, 0, 0, 1, 0, 1);

	    // -------------------------------------------------------------------------
	    // JORNADA 2 (Índice 1)
	    // -------------------------------------------------------------------------
	    J = 1;
	    
	    // CV ZARAGOZA (3-0) -> Gana (2 Pts) vs. CV RIVAS (0-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 0, 75, 55, 25, 25, 25, 0, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_rivas, J, 1, 0, 3, 55, 75, 16, 17, 22, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV SAN FERNANDO (3-2) -> Gana (2 Pts) vs. CV PALMA (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_sanfernando, J, 2, 3, 2, 110, 109, 25, 19, 25, 24, 17, 1, 0, 1);
	    asignarResultadosJornada(matriz_palma, J, 1, 2, 3, 109, 110, 23, 25, 20, 26, 15, 0, 1, 1); // Se mantiene 1 Pto

	    // VALLADOLID CV (1-3) -> Gana (1 Pto) vs. CV TORRELAVEGA (3-1) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_valladolid, J, 1, 1, 3, 85, 97, 25, 20, 18, 22, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_torrelavega, J, 2, 3, 1, 97, 85, 22, 25, 25, 25, 0, 1, 0, 1);

	    // -------------------------------------------------------------------------
	    // JORNADA 3 (Índice 2)
	    // -------------------------------------------------------------------------
	    J = 2;

	    // CV ZARAGOZA (3-1) -> Gana (2 Pts) vs. CV PALMA (1-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 1, 96, 87, 25, 25, 21, 25, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_palma, J, 1, 1, 3, 87, 96, 19, 23, 25, 20, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV RIVAS (2-3) -> Gana (1 Pto) vs. CV TORRELAVEGA (3-2) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_rivas, J, 1, 2, 3, 105, 108, 25, 23, 25, 20, 12, 0, 1, 1); // Se mantiene 1 Pto
	    asignarResultadosJornada(matriz_torrelavega, J, 2, 3, 2, 108, 105, 21, 25, 22, 25, 15, 1, 0, 1);

	    // CV SAN FERNANDO (0-3) -> Gana (1 Pto) vs. VALLADOLID CV (3-0) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 0, 3, 61, 75, 21, 17, 23, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_valladolid, J, 2, 3, 0, 75, 61, 25, 25, 25, 0, 0, 1, 0, 1);

	    // -------------------------------------------------------------------------
	    // JORNADA 4 (Índice 3)
	    // -------------------------------------------------------------------------
	    J = 3;
	    
	    // CV ZARAGOZA (3-2) -> Gana (2 Pts) vs. CV TORRELAVEGA (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 2, 111, 104, 25, 23, 26, 22, 15, 1, 0, 1);
	    asignarResultadosJornada(matriz_torrelavega, J, 1, 2, 3, 104, 111, 20, 25, 24, 25, 10, 0, 1, 1); // Se mantiene 1 Pto

	    // CV PALMA (3-0) -> Gana (2 Pts) vs. VALLADOLID CV (0-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_palma, J, 2, 3, 0, 75, 59, 25, 25, 25, 0, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_valladolid, J, 1, 0, 3, 59, 75, 20, 18, 21, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV RIVAS (1-3) -> Gana (1 Pto) vs. CV SAN FERNANDO (3-1) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_rivas, J, 1, 1, 3, 85, 98, 25, 21, 19, 20, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_sanfernando, J, 2, 3, 1, 98, 85, 23, 25, 25, 25, 0, 1, 0, 1);

	    // -------------------------------------------------------------------------
	    // JORNADA 5 (Índice 4)
	    // -------------------------------------------------------------------------
	    J = 4;
	    
	    // CV ZARAGOZA (3-0) -> Gana (2 Pts) vs. VALLADOLID CV (0-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 0, 75, 58, 25, 25, 25, 0, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_valladolid, J, 1, 0, 3, 58, 75, 17, 18, 23, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV TORRELAVEGA (3-1) -> Gana (2 Pts) vs. CV SAN FERNANDO (1-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_torrelavega, J, 2, 3, 1, 95, 90, 25, 25, 20, 25, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 1, 3, 90, 95, 22, 20, 25, 23, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV PALMA (3-1) -> Gana (2 Pts) vs. CV RIVAS (1-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_palma, J, 2, 3, 1, 96, 89, 25, 21, 25, 25, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_rivas, J, 1, 1, 3, 89, 96, 23, 25, 19, 22, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // -------------------------------------------------------------------------
	    // JORNADA 6 (Índice 5)
	    // -------------------------------------------------------------------------
	    J = 5;

	    // CV SAN FERNANDO (1-3) -> Gana (1 Pto) vs. CV ZARAGOZA (3-1) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 1, 3, 85, 97, 25, 19, 20, 21, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 1, 97, 85, 22, 25, 25, 25, 0, 1, 0, 1);

	    // CV RIVAS (3-0) -> Gana (2 Pts) vs. VALLADOLID CV (0-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_rivas, J, 2, 3, 0, 75, 63, 25, 25, 25, 0, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_valladolid, J, 1, 0, 3, 63, 75, 19, 23, 21, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV PALMA (3-2) -> Gana (2 Pts) vs. CV TORRELAVEGA (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_palma, J, 2, 3, 2, 110, 105, 25, 22, 25, 23, 15, 1, 0, 1);
	    asignarResultadosJornada(matriz_torrelavega, J, 1, 2, 3, 105, 110, 23, 25, 21, 25, 11, 0, 1, 1); // Se mantiene 1 Pto

	    // -------------------------------------------------------------------------
	    // JORNADA 7 (Índice 6)
	    // -------------------------------------------------------------------------
	    J = 6;

	    // CV RIVAS (0-3) -> Gana (1 Pto) vs. CV ZARAGOZA (3-0) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_rivas, J, 1, 0, 3, 61, 75, 18, 20, 23, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 0, 75, 61, 25, 25, 25, 0, 0, 1, 0, 1);

	    // CV PALMA (3-0) -> Gana (2 Pts) vs. CV SAN FERNANDO (0-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_palma, J, 2, 3, 0, 75, 60, 25, 25, 25, 0, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 0, 3, 60, 75, 21, 17, 22, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV TORRELAVEGA (3-0) -> Gana (2 Pts) vs. VALLADOLID CV (0-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_torrelavega, J, 2, 3, 0, 75, 60, 25, 25, 25, 0, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_valladolid, J, 1, 0, 3, 60, 75, 18, 19, 23, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // -------------------------------------------------------------------------
	    // JORNADA 8 (Índice 7)
	    // -------------------------------------------------------------------------
	    J = 7;

	    // CV PALMA (1-3) -> Gana (1 Pto) vs. CV ZARAGOZA (3-1) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_palma, J, 1, 1, 3, 85, 97, 25, 20, 19, 21, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 1, 98, 85, 23, 25, 25, 25, 0, 1, 0, 1);

	    // CV TORRELAVEGA (3-1) -> Gana (2 Pts) vs. CV RIVAS (1-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_torrelavega, J, 2, 3, 1, 98, 85, 25, 25, 23, 25, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_rivas, J, 1, 1, 3, 85, 98, 22, 18, 25, 20, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // VALLADOLID CV (3-2) -> Gana (2 Pts) vs. CV SAN FERNANDO (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_valladolid, J, 2, 3, 2, 110, 107, 25, 23, 25, 22, 15, 1, 0, 1);
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 2, 3, 107, 110, 21, 25, 23, 25, 13, 0, 1, 1); // Se mantiene 1 Pto

	    // -------------------------------------------------------------------------
	    // JORNADA 9 (Índice 8)
	    // -------------------------------------------------------------------------
	    J = 8;
	    
	    // CV TORRELAVEGA (0-3) -> Gana (1 Pto) vs. CV ZARAGOZA (3-0) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_torrelavega, J, 1, 0, 3, 62, 75, 21, 22, 19, 0, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 0, 75, 62, 25, 25, 25, 0, 0, 1, 0, 1);

	    // VALLADOLID CV (3-1) -> Gana (2 Pts) vs. CV PALMA (1-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_valladolid, J, 2, 3, 1, 95, 88, 25, 25, 20, 25, 0, 1, 0, 1);
	    asignarResultadosJornada(matriz_palma, J, 1, 1, 3, 88, 95, 19, 23, 25, 21, 0, 0, 1, 1); // Corregido: 1 Pto por perder

	    // CV SAN FERNANDO (3-2) -> Gana (2 Pts) vs. CV RIVAS (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_sanfernando, J, 2, 3, 2, 110, 107, 24, 25, 25, 21, 15, 1, 0, 1);
	    asignarResultadosJornada(matriz_rivas, J, 1, 2, 3, 107, 110, 26, 21, 23, 25, 12, 0, 1, 1); // Se mantiene 1 Pto

	    // -------------------------------------------------------------------------
	    // JORNADA 10 (Índice 9)
	    // -------------------------------------------------------------------------
	    J = 9;

	    // VALLADOLID CV (1-3) -> Gana (1 Pto) vs. CV ZARAGOZA (3-1) -> Gana (2 Pts)
	    asignarResultadosJornada(matriz_valladolid, J, 1, 1, 3, 85, 98, 25, 20, 18, 22, 0, 0, 1, 1); // Corregido: 1 Pto por perder
	    asignarResultadosJornada(matriz_zaragoza, J, 2, 3, 1, 98, 85, 23, 25, 25, 25, 0, 1, 0, 1);

	    // CV SAN FERNANDO (0-3) -> Gana (1 Pto) vs. CV TORRELAVEGA (3-0) -> Gana (2 Pts)
	    // Corregido: Puntos=1, PG=0, PP=1, PJ=1 y los 15 argumentos.
	    asignarResultadosJornada(matriz_sanfernando, J, 1, 0, 3, 62, 75, 19, 22, 21, 0, 0, 0, 1, 1); 
	    asignarResultadosJornada(matriz_torrelavega, J, 2, 3, 0, 75, 62, 25, 25, 25, 0, 0, 1, 0, 1);

	    // CV RIVAS (3-2) -> Gana (2 Pts) vs. CV PALMA (2-3) -> Gana (1 Pto)
	    asignarResultadosJornada(matriz_rivas, J, 2, 3, 2, 108, 102, 25, 23, 25, 21, 15, 1, 0, 1);
	    asignarResultadosJornada(matriz_palma, J, 1, 2, 3, 102, 109, 20, 25, 22, 25, 10, 0, 1, 1); // Se mantiene 1 Pto
	    
	    // ESTABLECER TOTALES
	    recalcularTotalParaEquipo(matriz_zaragoza);
	    recalcularTotalParaEquipo(matriz_sanfernando); 
	    recalcularTotalParaEquipo(matriz_palma);
	    recalcularTotalParaEquipo(matriz_torrelavega);
	    recalcularTotalParaEquipo(matriz_rivas);
	    recalcularTotalParaEquipo(matriz_valladolid); 
	    
	  //AÑADIR INDICES A DLM CLASIFIACION -> PARA PODER ACTUALIZAR DATOS
	    for(int d = 0; d < equipos.length; d++) {
	    	dlmClasificacionPuntos.add(d, 0); 
    		dlmClasificacionPartidosJugados.add(d, 0); 
    		dlmClasificacionPartidosGanados.add(d, 0); 
    		dlmClasificacionPartidosPerdidos.add(d, 0); 
    		dlmClasificacionSetsGanados.add(d, 0); 
    		dlmClasificacionSetsPerdidos.add(d, 0); 
    		dlmClasificacionTantosFavor.add(d, 0); 
    		dlmClasificacionTantosContra.add(d, 0);
    	}
	}
	private void asignarResultadosJornada(int[][] matriz, int J, int puntos, int sg, int sp, int ta, int tc, int s1Ta, int s2Ta, int s3Ta, int s4Ta, int s5Ta, int pg, int pp, int pj) {
		matriz[J][COL_PUNTOS] = puntos;
		matriz[J][COL_SG] = sg;
		matriz[J][COL_SP] = sp;
		matriz[J][COL_TA] = ta;
		matriz[J][COL_TC] = tc;
		matriz[J][COL_S1_TA] = s1Ta;
		matriz[J][COL_S2_TA] = s2Ta;
		matriz[J][COL_S3_TA] = s3Ta;
		matriz[J][COL_S4_TA] = s4Ta;
		matriz[J][COL_S5_TA] = s5Ta;
		matriz[J][COL_PG] = pg;
		matriz[J][COL_PP] = pp;
		matriz[J][COL_PJ] = pj;
}
	
	/*OBTENER MATRIZ USANDO EL NOMBRE DE EL EQUIPO*/
	private int[][] obtenterMatrizPorNombreEquipo(String nombreEquipo) {
	    // .get(nombreEquipo) busca la clave en el Map y devuelve el valor asociado
	    return mapaMatricesEquipos.get(nombreEquipo.toUpperCase());
	}
	
 	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------//		        
	
	
	
    
    /*CALCULA EL TOTAL DE CADA PARAMETRO DE LA CLASIFICACION DE CADA EQUIPO --> Necesario para actualizar la clasificacion*/
    private void recalcularTotalParaEquipo(int[][] matrizDelEquipo) {
       // Se asume que las constantes de columna (COL_PUNTOS, COL_SG, etc.)
       // están definidas y son accesibles, y que la matrizDelEquipo tiene 10 filas (Jornadas).
        
       int puntosTotales = 0;
       int setsGanadosTotales = 0;
       int setsPerdidosTotales = 0;
       int tantosFavorTotales = 0;
       int tantosContraTotales = 0;
       int s1TaTotales = 0;
       int s2TaTotales = 0;
       int s3TaTotales = 0;
       int s4TaTotales = 0;
       int s5TaTotales = 0;
       int partidosJugadosTotales = 0;
       int partidosPerdidosTotales = 0;
       int partidosGanadosTotales = 0;
       
       // Se itera sobre cada jornada (fila) en la matriz del equipo.
       // Suponiendo que la matrizDelEquipo.length es el número total de jornadas (10).
       for (int J = 0; J < ROW_TOTAL; J++) {
           // Calcular puntos
           puntosTotales += matrizDelEquipo[J][COL_PUNTOS];
           
           // Calcular sets
           setsGanadosTotales += matrizDelEquipo[J][COL_SG];
           setsPerdidosTotales += matrizDelEquipo[J][COL_SP];
           
           // Calcular tantos (puntos)
           tantosFavorTotales += matrizDelEquipo[J][COL_TA];
           tantosContraTotales += matrizDelEquipo[J][COL_TC];

           // Calcular tantos por set (sólo para la información detallada)
           s1TaTotales += matrizDelEquipo[J][COL_S1_TA];
           s2TaTotales += matrizDelEquipo[J][COL_S2_TA];
           s3TaTotales += matrizDelEquipo[J][COL_S3_TA];
           s4TaTotales += matrizDelEquipo[J][COL_S4_TA];
           s5TaTotales += matrizDelEquipo[J][COL_S5_TA];
           
           // Calcular partidos
           partidosJugadosTotales += matrizDelEquipo[J][COL_PJ];
           partidosGanadosTotales += matrizDelEquipo[J][COL_PG];
           partidosPerdidosTotales += matrizDelEquipo[J][COL_PP];
       }
       
       matrizDelEquipo[ROW_TOTAL][COL_PUNTOS] = puntosTotales;
       matrizDelEquipo[ROW_TOTAL][COL_SG] = setsGanadosTotales;
       matrizDelEquipo[ROW_TOTAL][COL_SP] = setsPerdidosTotales;
       matrizDelEquipo[ROW_TOTAL][COL_TA] = tantosFavorTotales;
       matrizDelEquipo[ROW_TOTAL][COL_TC] = tantosContraTotales;
       matrizDelEquipo[ROW_TOTAL][COL_S1_TA] = s1TaTotales;
       matrizDelEquipo[ROW_TOTAL][COL_S2_TA] = s2TaTotales;
       matrizDelEquipo[ROW_TOTAL][COL_S3_TA] = s3TaTotales;
       matrizDelEquipo[ROW_TOTAL][COL_S4_TA] = s4TaTotales;
       matrizDelEquipo[ROW_TOTAL][COL_S5_TA] = s5TaTotales;
       matrizDelEquipo[ROW_TOTAL][COL_PJ] = partidosJugadosTotales;
       matrizDelEquipo[ROW_TOTAL][COL_PG] = partidosGanadosTotales;
       matrizDelEquipo[ROW_TOTAL][COL_PP] = partidosPerdidosTotales;
       
    }
    
    /*ORDENAR CLASIFICACION -> INSERCCIÓN DE DATOS*/
    
    // Este metodo se encarga de insertar los datos de forma ordenada en las dlms
    private void actualizarPosicionClasifiacion() {    	
    	String[] ordenEquipos = new String[equipos.length];

    	//Llenar de vacios el array ordenEquipos para poder actualizar la posición
    	for(int i = 0; i < ordenEquipos.length; i++) {
    		ordenEquipos[i] = "";
    	}
    	//Actualiza los datos del array ordenEquipos con los nombres de los equipos en orden
    	for(int p = 0; p < equipos.length; p++) {
    		int posicion_final = obtenerIndiceEqClasificacion(equipos[p], equipos);
    		//System.out.printf("EQUIPO %s posicion %s\n", equipos[p], posicion_final);
    		ordenEquipos[posicion_final] = equipos[p];
    	}
    	
    	
    		
    	// Actualizar posicion dlms
    	for(int d = 0; d < ordenEquipos.length; d++) {
    		//Obtiene la matriz de el equipo
    		int[][] matrizEquipo = obtenterMatrizPorNombreEquipo(ordenEquipos[d]);
    		//Establece los resultados de la temporada en variables
    		int ptos = matrizEquipo[ROW_TOTAL][COL_PUNTOS];
    		//CALCULAR PARTIDOS
    		int pj = matrizEquipo[ROW_TOTAL][COL_PJ];
	        int pg = matrizEquipo[ROW_TOTAL][COL_PG];
	        int pp = matrizEquipo[ROW_TOTAL][COL_PP];
	        int sg = matrizEquipo[ROW_TOTAL][COL_SG];
	        int sp = matrizEquipo[ROW_TOTAL][COL_SP];
	        int ta = matrizEquipo[ROW_TOTAL][COL_TA];
	        int tc = matrizEquipo[ROW_TOTAL][COL_TC];

    		dlmEquipos.set(d, ordenEquipos[d]); 
    		dlmClasificacionPuntos.set(d, ptos); 
    		dlmClasificacionPartidosJugados.set(d, pj);
    		dlmClasificacionPartidosGanados.set(d, pg);
    		dlmClasificacionPartidosPerdidos.set(d, pp);
    		dlmClasificacionSetsGanados.set(d, sg);
    		dlmClasificacionSetsPerdidos.set(d, sp);
    		dlmClasificacionTantosFavor.set(d, ta);
    		dlmClasificacionTantosContra.set(d, tc);
    	}
    }
    
    // Este metodo se encarga de calcular en que posicion ira el equipo que se le es pasado como parametro
    private int obtenerIndiceEqClasificacion(String NOMBRE_EQUIPO, String[] ARRAY_EQUIPOS) {
        // 1. Obtene los resultados del equipo principal
        // (Asumo que tu método se llama 'obtenterMatrizPorNombreEquipo' como escribiste)
    	int[][] matrizEquipo = obtenterMatrizPorNombreEquipo(NOMBRE_EQUIPO);
    	
    	if (matrizEquipo == null) {
            System.out.println("ERROR CRÍTICO: No se pudo encontrar la matriz para '" + NOMBRE_EQUIPO + "'.");
            System.out.println("Revisa que ese nombre exista EXACTAMENTE en 'mapaMatricesEquipos'.");
            return -1; // Devolvemos -1 (o 0) para indicar un error y salir
        }
        // Almacenamos el total de stats que ha obtenido el equipo
        int ptos = matrizEquipo[ROW_TOTAL][COL_PUNTOS];
        int pg = matrizEquipo[ROW_TOTAL][COL_PG];
        int sg = matrizEquipo[ROW_TOTAL][COL_SG];
        int sp = matrizEquipo[ROW_TOTAL][COL_SP];
        int ta = matrizEquipo[ROW_TOTAL][COL_TA];
        int tc = matrizEquipo[ROW_TOTAL][COL_TC];

        // 2. ESTE SERA EL VALOR QUE VAMOS A RETORNAR
        //    Es un contador de cuántos equipos son MEJORES que el nuestro.
        int posicion = 0;
    	  
        // 3. Iterar por TODOS los equipos
        //    (Asumo que dlmEquipos contiene los 6 nombres de equipo)
        for(int i = 0; i < ARRAY_EQUIPOS.length; i++) {
            String nombreOtroEquipo = ARRAY_EQUIPOS[i];
            
            // 4. COMPROBAR QUE NO ESTAMOS MIRANDO EL MISMO EQUIPO
            if(NOMBRE_EQUIPO.equals(nombreOtroEquipo)){
                continue; // Saltamos esta iteración, no nos comparamos con nosotros mismos
            }
    		  
            // 5. Obtener stats del OTRO equipo
            int[][] matrizOtroEquipo = obtenterMatrizPorNombreEquipo(nombreOtroEquipo);
            if(matrizOtroEquipo == null) {
            	 System.out.printf("ERROR CRÍTICO: No se pudo encontrar el equipo %s con la que comparamos el equipo %s\n", NOMBRE_EQUIPO, nombreOtroEquipo);
                 System.out.println("Revisa que ese nombre exista EXACTAMENTE en 'mapaMatricesEquipos'.");
            }
            
            int ptosOtro = matrizOtroEquipo[ROW_TOTAL][COL_PUNTOS];
            int pgOtro = matrizOtroEquipo[ROW_TOTAL][COL_PG];
            int sgOtro = matrizOtroEquipo[ROW_TOTAL][COL_SG];
            int spOtro = matrizOtroEquipo[ROW_TOTAL][COL_SP];
            int taOtro = matrizOtroEquipo[ROW_TOTAL][COL_TA];
            int tcOtro = matrizOtroEquipo[ROW_TOTAL][COL_TC];

            // 6. LÓGICA DE COMPARACIÓN JERÁRQUICA
            //    ¿Es el 'otro' equipo MEJOR que el nuestro?
    		
            
            // Criterio 1: Puntos
            if (ptosOtro > ptos) {
                posicion++; // El otro es mejor, sumamos 1
                continue; // y pasamos al siguiente equipo
            } else if (ptosOtro < ptos) {
                continue; // El otro es peor, pasamos al siguiente equipo
            }
            
            // Si llegamos aquí, los PUNTOS son iguales. Pasamos al Criterio 2:
            
            // Criterio 2: Partidos Ganados
            if (pgOtro > pg) {
                posicion++;
                continue;
            } else if (pgOtro < pg) {
                continue;
            }
            
            // Si llegamos aquí, PUNTOS y PG son iguales. Criterio 3:
            
            // Criterio 3: Sets Ganados
            if (sgOtro > sg) {
                posicion++;
                continue;
            } else if (sgOtro < sg) {
                continue;
            }
            
            // Criterio 4: Sets Perdidos (OJO: Menos es mejor)
            if (spOtro < sp) {
                posicion++;
                continue;
            } else if (spOtro > sp) {
                continue;
            }
            
            // Criterio 5: Tantos a Favor
            if (taOtro > ta) {
                posicion++;
                continue;
            } else if (taOtro < ta) {
                continue;
            }

            // Criterio 6: Tantos en Contra (OJO: Menos es mejor)
            if (tcOtro < tc) {
                posicion++;
                continue;
            } else if (tcOtro > tc) {
                continue;
            }
            
            // Criterio 7: Desempate final (si todo es idéntico)
            // Por "orden de aparición" (alfabético).
            if (nombreOtroEquipo.compareTo(NOMBRE_EQUIPO) < 0) {
                posicion++;
            }
        }
    	   
        return posicion; // Devuelve el número de equipos que quedaron por encima
    }
    

	
    private void insertarResultadosJornada() {
        int partidoSeleccionado = listNombreEquiposLocal.getSelectedIndex();
        int jornadaIndex = comboBoxJornadas.getSelectedIndex();
        
        int setsGanadosLocal = 0;
        int setsGanadosVisitante = 0;
       
        
        // 1. PRIMERO: Validar que no haya campos vacíos
        if (txtS1TaL.getText().trim().isEmpty() || 
            txtS2TaL.getText().trim().isEmpty() || 
            txtS3TaL.getText().trim().isEmpty() || 
            txtS4TaL.getText().trim().isEmpty() || 
            txtS5TaL.getText().trim().isEmpty() ||
            txtS1TavV.getText().trim().isEmpty() || 
            txtS2TaV.getText().trim().isEmpty() || 
            txtS3TaV.getText().trim().isEmpty() || 
            txtS4TaV.getText().trim().isEmpty() || 
            txtS5TaV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Error: Todos los campos deben estar completos.\nSi un set no se jugó, introduce 0.",
                "Validación - Campos Vacíos", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        // 2. SEGUNDO: Parsear los valores (ahora sabemos que no están vacíos)
        int s1TaL = Integer.parseInt(txtS1TaL.getText().trim());
        int s2TaL = Integer.parseInt(txtS2TaL.getText().trim());
        int s3TaL = Integer.parseInt(txtS3TaL.getText().trim());
        int s4TaL = Integer.parseInt(txtS4TaL.getText().trim());
        int s5TaL = Integer.parseInt(txtS5TaL.getText().trim());
        
        int s1TaV = Integer.parseInt(txtS1TavV.getText().trim());
        int s2TaV = Integer.parseInt(txtS2TaV.getText().trim());
        int s3TaV = Integer.parseInt(txtS3TaV.getText().trim());
        int s4TaV = Integer.parseInt(txtS4TaV.getText().trim());
        int s5TaV = Integer.parseInt(txtS5TaV.getText().trim());
        
        // 3. TERCERO: Validar que no haya valores negativos
        if (s1TaL < 0 || s2TaL < 0 || s3TaL < 0 || s4TaL < 0 || s5TaL < 0 ||
            s1TaV < 0 || s2TaV < 0 || s3TaV < 0 || s4TaV < 0 || s5TaV < 0) {
            JOptionPane.showMessageDialog(this, 
                "Error: Los tantos no pueden ser negativos.",
                "Validación - Valores Negativos", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }  
        
        // 4. Al menos los 3 primeros sets deben estar jugados (al menos un equipo con tantos > 0)
        if ((s1TaL == 0 && s1TaV == 0) || 
            (s2TaL == 0 && s2TaV == 0) || 
            (s3TaL == 0 && s3TaV == 0)) {
            JOptionPane.showMessageDialog(this, 
                "Error: Los sets 1, 2 y 3 son obligatorios. Al menos un equipo debe tener tantos en cada uno.",
                "Validación - Sets Obligatorios", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 5. Comprobar empates (solo en sets que se jugaron)
        if ((s1TaL == s1TaV && s1TaL > 0) || 
            (s2TaL == s2TaV && s2TaL > 0) || 
            (s3TaL == s3TaV && s3TaL > 0) ||
            (s4TaL == s4TaV && s4TaL > 0) ||
            (s5TaL == s5TaV && s5TaL > 0)) {
            JOptionPane.showMessageDialog(this, 
                "Error: No puede haber empates en los sets.\nCada set debe tener un ganador claro.",
                "Validación - Empate No Permitido", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
     // 6. CALCULAR SETS GANADOS (solo contar sets que se jugaron)
        // Set 1
        if (s1TaL > 0 || s1TaV > 0) {  // Solo si el set se jugó
            if (s1TaL > s1TaV) setsGanadosLocal++; 
            else if (s1TaV > s1TaL) setsGanadosVisitante++;
        }

        // Set 2
        if (s2TaL > 0 || s2TaV > 0) {
            if (s2TaL > s2TaV) setsGanadosLocal++; 
            else if (s2TaV > s2TaL) setsGanadosVisitante++;
        }

        // Set 3
        if (s3TaL > 0 || s3TaV > 0) {
            if (s3TaL > s3TaV) setsGanadosLocal++; 
            else if (s3TaV > s3TaL) setsGanadosVisitante++;
        }

        // Set 4
        if (s4TaL > 0 || s4TaV > 0) {
            if (s4TaL > s4TaV) setsGanadosLocal++; 
            else if (s4TaV > s4TaL) setsGanadosVisitante++;
        }

        // Set 5
        if (s5TaL > 0 || s5TaV > 0) {
            if (s5TaL > s5TaV) setsGanadosLocal++; 
            else if (s5TaV > s5TaL) setsGanadosVisitante++;
        }
        
        // 7. Validar que haya un ganador (3 sets)
        if (setsGanadosLocal != 3 && setsGanadosVisitante != 3) {
            JOptionPane.showMessageDialog(this, 
                "Error: El partido no está completo. Un equipo debe ganar 3 sets.",
                "Validación - Partido Incompleto", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 8. Validar que no se jueguen sets de más (SI YA HAY GANADOR)
        int totalSetsJugados = setsGanadosLocal + setsGanadosVisitante;
        
        // Si terminó 3-0, los sets 4 y 5 deben estar en 0
        if (totalSetsJugados == 3 && (s4TaL > 0 || s4TaV > 0 || s5TaL > 0 || s5TaV > 0)) {
            JOptionPane.showMessageDialog(this, 
                "Error: Si el partido terminó 3-0, los sets 4 y 5 deben estar en 0.",
                "Validación - Sets Extra", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Si terminó 3-1, el set 5 debe estar en 0
        if (totalSetsJugados == 4 && (s5TaL > 0 || s5TaV > 0)) {
            JOptionPane.showMessageDialog(this, 
                "Error: Si el partido terminó 3-1, el set 5 debe estar en 0.",
                "Validación - Sets Extra", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
     // 10. ACTUALIZAR DLMs
        txtSestL.setText(Integer.toString(setsGanadosLocal));
        dlmJornadaSetsL.set(partidoSeleccionado, setsGanadosLocal);
        dlmJornadaS1TAL.set(partidoSeleccionado, s1TaL);
        dlmJornadaS2TAL.set(partidoSeleccionado, s2TaL);
        dlmJornadaS3TAL.set(partidoSeleccionado, s3TaL);
        dlmJornadaS4TAL.set(partidoSeleccionado, s4TaL);
        dlmJornadaS5TAL.set(partidoSeleccionado, s5TaL);

        txtSetsV.setText(Integer.toString(setsGanadosVisitante));
        dlmJornadaSetsV.set(partidoSeleccionado, setsGanadosVisitante);
        dlmJornadaS1TAV.set(partidoSeleccionado, s1TaV);
        dlmJornadaS2TAV.set(partidoSeleccionado, s2TaV);
        dlmJornadaS3TAV.set(partidoSeleccionado, s3TaV);
        dlmJornadaS4TAV.set(partidoSeleccionado, s4TaV);
        dlmJornadaS5TAV.set(partidoSeleccionado, s5TaV);

        // 11. ACTUALIZAR MATRICES DIRECTAMENTE
        String nombreEquipoLocal = lblEquipoLocal_ResultadoPartido.getText();
        String nombreEquipoVisitante = lblEquipoVisitante_ResultadoPartido.getText();

        int[][] matriz_eq_local = obtenterMatrizPorNombreEquipo(nombreEquipoLocal);
        int[][] matriz_eq_visitante = obtenterMatrizPorNombreEquipo(nombreEquipoVisitante);

 
        // Determinar ganador
        boolean isLocalWinner = setsGanadosLocal > setsGanadosVisitante;
        boolean isVisitanteWinner = setsGanadosVisitante > setsGanadosLocal;

        // Calcular puntos: 2 por victoria, 1 por derrota
        int puntosLocal = isLocalWinner ? 2 : 1;
        int puntosVisitante = isVisitanteWinner ? 2 : 1;

        // MATRIZ EQUIPO LOCAL
        matriz_eq_local[jornadaIndex][COL_PUNTOS] = puntosLocal;
        matriz_eq_local[jornadaIndex][COL_SG] = setsGanadosLocal;
        matriz_eq_local[jornadaIndex][COL_SP] = setsGanadosVisitante;
        matriz_eq_local[jornadaIndex][COL_TA] = s1TaL + s2TaL + s3TaL + s4TaL + s5TaL;
        matriz_eq_local[jornadaIndex][COL_TC] = s1TaV + s2TaV + s3TaV + s4TaV + s5TaV;
        matriz_eq_local[jornadaIndex][COL_S1_TA] = s1TaL;
        matriz_eq_local[jornadaIndex][COL_S2_TA] = s2TaL;
        matriz_eq_local[jornadaIndex][COL_S3_TA] = s3TaL;
        matriz_eq_local[jornadaIndex][COL_S4_TA] = s4TaL;
        matriz_eq_local[jornadaIndex][COL_S5_TA] = s5TaL;
        matriz_eq_local[jornadaIndex][COL_PG] = isLocalWinner ? 1 : 0;
        matriz_eq_local[jornadaIndex][COL_PP] = isLocalWinner ? 0 : 1;
        matriz_eq_local[jornadaIndex][COL_PJ] = 1;

        // MATRIZ EQUIPO VISITANTE
        matriz_eq_visitante[jornadaIndex][COL_PUNTOS] = puntosVisitante;
        matriz_eq_visitante[jornadaIndex][COL_SG] = setsGanadosVisitante;
        matriz_eq_visitante[jornadaIndex][COL_SP] = setsGanadosLocal;
        matriz_eq_visitante[jornadaIndex][COL_TA] = s1TaV + s2TaV + s3TaV + s4TaV + s5TaV;
        matriz_eq_visitante[jornadaIndex][COL_TC] = s1TaL + s2TaL + s3TaL + s4TaL + s5TaL;
        matriz_eq_visitante[jornadaIndex][COL_S1_TA] = s1TaV;
        matriz_eq_visitante[jornadaIndex][COL_S2_TA] = s2TaV;
        matriz_eq_visitante[jornadaIndex][COL_S3_TA] = s3TaV;
        matriz_eq_visitante[jornadaIndex][COL_S4_TA] = s4TaV;
        matriz_eq_visitante[jornadaIndex][COL_S5_TA] = s5TaV;
        matriz_eq_visitante[jornadaIndex][COL_PG] = isVisitanteWinner ? 1 : 0;
        matriz_eq_visitante[jornadaIndex][COL_PP] = isVisitanteWinner ? 0 : 1;
        matriz_eq_visitante[jornadaIndex][COL_PJ] = 1;

        // 12. Recalcular totales
        recalcularTotalParaEquipo(matriz_eq_local);
        recalcularTotalParaEquipo(matriz_eq_visitante);

        // 13. ACTUALIZAR CLASIFICACIÓN
        actualizarPosicionClasifiacion();


        // 14. MENSAJE DE ÉXITO
        JOptionPane.showMessageDialog(this, 
            "Resultados guardados correctamente.",
            "Guardado Exitoso", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void borrarPatido() {
        int partidoSeleccionado = listNombreEquiposLocal.getSelectedIndex();
        
        // 1. PRIMERO: Actualizar las DLM a 0
        dlmJornadaSetsL.set(partidoSeleccionado, 0);
        dlmJornadaS1TAL.set(partidoSeleccionado, 0);
        dlmJornadaS2TAL.set(partidoSeleccionado, 0);
        dlmJornadaS3TAL.set(partidoSeleccionado, 0);
        dlmJornadaS4TAL.set(partidoSeleccionado, 0);
        dlmJornadaS5TAL.set(partidoSeleccionado, 0);
        
        dlmJornadaSetsV.set(partidoSeleccionado, 0);
        dlmJornadaS1TAV.set(partidoSeleccionado, 0);
        dlmJornadaS2TAV.set(partidoSeleccionado, 0);
        dlmJornadaS3TAV.set(partidoSeleccionado, 0);
        dlmJornadaS4TAV.set(partidoSeleccionado, 0);
        dlmJornadaS5TAV.set(partidoSeleccionado, 0);
        
        // 2. SEGUNDO: Obtener los equipos del partido seleccionado
        String nombreEquipoLocal = dlmJornadasEqLocal.get(partidoSeleccionado);
        String nombreEquipoVisitante = dlmJornadasEqVisitante.get(partidoSeleccionado);
        
        int[][] matrizEquipoLocal = obtenterMatrizPorNombreEquipo(nombreEquipoLocal);
        int[][] matrizEquipoVisitante = obtenterMatrizPorNombreEquipo(nombreEquipoVisitante);
        
        int jornadaIndex = comboBoxJornadas.getSelectedIndex();
        
        // 3. TERCERO: Poner a 0 en las matrices
        asignarResultadosJornada(matrizEquipoLocal, jornadaIndex, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        asignarResultadosJornada(matrizEquipoVisitante, jornadaIndex, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
       
        
        // 4. CUARTO: Recalcular totales
        recalcularTotalParaEquipo(matrizEquipoLocal);
        recalcularTotalParaEquipo(matrizEquipoVisitante);
        
        // 5. QUINTO: Actualizar clasificación
        actualizarPosicionClasifiacion();
        
        // 6. SEXTO: Actualizar la vista de los JTextField
        txtSestL.setText("0");
        txtS1TaL.setText("0");
        txtS2TaL.setText("0");
        txtS3TaL.setText("0");
        txtS4TaL.setText("0");
        txtS5TaL.setText("0");
        txtSetsV.setText("0");
        txtS1TavV.setText("0");
        txtS2TaV.setText("0");
        txtS3TaV.setText("0");
        txtS4TaV.setText("0");
        txtS5TaV.setText("0");
    }
    
    private void limpiarJornada() {
        int jornadaIndex = comboBoxJornadas.getSelectedIndex();
        
        // 1. PRIMERO: Limpiar todas las DLM de la jornada
        for(int i = 0; i < (equipos.length/2); i++) {
            dlmJornadaSetsL.set(i, 0);
            dlmJornadaS1TAL.set(i, 0);
            dlmJornadaS2TAL.set(i, 0);
            dlmJornadaS3TAL.set(i, 0);
            dlmJornadaS4TAL.set(i, 0);
            dlmJornadaS5TAL.set(i, 0);
            
            dlmJornadaSetsV.set(i, 0);
            dlmJornadaS1TAV.set(i, 0);
            dlmJornadaS2TAV.set(i, 0);
            dlmJornadaS3TAV.set(i, 0);
            dlmJornadaS4TAV.set(i, 0);
            dlmJornadaS5TAV.set(i, 0);
        }
        
        // 2. SEGUNDO: Limpiar las matrices de todos los partidos de la jornada
        for (int i = 0; i < dlmJornadasEqLocal.getSize(); i++) {
            String nombreEquipoLocal = dlmJornadasEqLocal.get(i);
            String nombreEquipoVisitante = dlmJornadasEqVisitante.get(i);
            
            int[][] matrizEquipoLocal = obtenterMatrizPorNombreEquipo(nombreEquipoLocal);
            int[][] matrizEquipoVisitante = obtenterMatrizPorNombreEquipo(nombreEquipoVisitante);
            
            // Poner a 0 en las matrices
            asignarResultadosJornada(matrizEquipoLocal, jornadaIndex, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            asignarResultadosJornada(matrizEquipoVisitante, jornadaIndex, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            
            // Recalcular totales
            recalcularTotalParaEquipo(matrizEquipoLocal);
            recalcularTotalParaEquipo(matrizEquipoVisitante);
        }
        
        // 3. TERCERO: Actualizar clasificación
        actualizarPosicionClasifiacion();
        
        // 4. CUARTO: Actualizar vista si hay un partido seleccionado
        int partidoSeleccionado = listNombreEquiposLocal.getSelectedIndex();
        if(partidoSeleccionado >= 0) {
            txtSestL.setText("0");
            txtS1TaL.setText("0");
            txtS2TaL.setText("0");
            txtS3TaL.setText("0");
            txtS4TaL.setText("0");
            txtS5TaL.setText("0");
            txtSetsV.setText("0");
            txtS1TavV.setText("0");
            txtS2TaV.setText("0");
            txtS3TaV.setText("0");
            txtS4TaV.setText("0");
            txtS5TaV.setText("0");
        }
    }
   
        
// ---------------------- EVENT LISTENERS ------------------------------------ //    
    
    //*ACTION LISTENER*//
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource(); // Obtiene la fuente de el evento ( quien lo invoca)
		
		// CERRAR SESION
		if(o == btnCerrarSesion) {
			this.dispose();
			Login login = new Login();
			login.setVisible(true);
		}
			
		// SIGUIENTE JORNADA
		if(o == btnSiguienteJornada) {
			int index = comboBoxJornadas.getSelectedIndex()+1;
			if(index < dcmJornadas.getSize()) {
				comboBoxJornadas.setSelectedIndex(index);
			}	
		}
		
		// JORNADA ANTERIOR
		if(o == btnAnteriorJornada) {
			int index = comboBoxJornadas.getSelectedIndex()-1;
			if(index >= 0) {
				comboBoxJornadas.setSelectedIndex(index);
			}
		}
			
		// SOLO EL ARBITRO PUEDE EJECTUTAR ESTOS EVENTOS
		if(o == btnGuardarCambios_resultadosJornadas && username.equals(Login.arbitro_user)) {
			insertarResultadosJornada();
		}
		
		if(o == btnBorrar_resultadosJornadas && username.equals(Login.arbitro_user)) {
			int respuesta = JOptionPane.showConfirmDialog(
				    this,
				    "¿Está seguro de que desea eliminar todos los datos del partido?\n\nEsta acción no se puede deshacer.",
				    "Advertencia - Borrar Partido",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.WARNING_MESSAGE
				);

				if (respuesta == JOptionPane.YES_OPTION) {
					borrarPatido();
				    JOptionPane.showMessageDialog(this, "Datos del partido eliminados correctamente.");
				}
		}
		
		if(o == btnLimpiar_resultadosJornadas && username.equals(Login.arbitro_user)) {
			// PARA EVITAR QUE EL USUARIO BORRE SIN QUERER LOS DATOS
			int respuesta = JOptionPane.showConfirmDialog(
				    this,
				    "¿Está seguro de que desea eliminar todos los datos de la jornada?\n\nEsta acción no se puede deshacer.",
				    "Advertencia - Limpiar Jornada",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.WARNING_MESSAGE
				);

				if (respuesta == JOptionPane.YES_OPTION) {
				    limpiarJornada();
				    JOptionPane.showMessageDialog(this, "Datos de la jornada eliminados correctamente.");
				}
		}
		
	}
	
	/*CUANDO SE SLEECCIONA UNA LISTA*/
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		Object o = lse.getSource();
		int index;
		index = ((JList<?>)o).getSelectedIndex();
		
		// SINCRONIZAR SELECCIÓN
		if(index >= 0) {
			listNombreEquiposLocal.setSelectedIndex(index);
			listSetsLocales.setSelectedIndex(index); 
			listS1TL.setSelectedIndex(index);
			listS2TL.setSelectedIndex(index);
			listS3TL.setSelectedIndex(index);
			listS4TL.setSelectedIndex(index);
			listS5TL.setSelectedIndex(index);
			listNombreEquiposVisitantes.setSelectedIndex(index);
			listSetsVisitantes.setSelectedIndex(index);
			listS1TV.setSelectedIndex(index);
			listS2TV.setSelectedIndex(index);
			listS3TV.setSelectedIndex(index);
			listS4TV.setSelectedIndex(index);
			listS5TV.setSelectedIndex(index);
		}	
		// SINCRONIZAR NOMBRE EQUIPOS, Y JTEXTFIELDS
		if(index >= 0 &&
	        index < dlmJornadasEqLocal.getSize() &&
	        index < dlmJornadasEqVisitante.getSize() &&
	        index < dlmJornadaSetsL.getSize() &&
	        index < dlmJornadaS1TAL.getSize() &&
	        index < dlmJornadaS2TAL.getSize() &&
	        index < dlmJornadaS3TAL.getSize() &&
	        index < dlmJornadaS4TAL.getSize() &&
	        index < dlmJornadaS5TAL.getSize() &&
	        index < dlmJornadaSetsV.getSize() &&
	        index < dlmJornadaS1TAV.getSize() &&
	        index < dlmJornadaS2TAV.getSize() &&
	        index < dlmJornadaS3TAV.getSize() &&
	        index < dlmJornadaS4TAV.getSize() &&
	        index < dlmJornadaS5TAV.getSize()) {
			// UNA VEZ COMPROBADO QUE PODEMOS ACCEDER ALAS DLM ACTUALIZAMOS LOS JTEXT FIELDS Y LOS NOMBRES DE LOS EQUIPOS
			//--LOCALES--
			lblEquipoLocal_ResultadoPartido.setText(dlmJornadasEqLocal.get(index));
			txtSestL.setText(Integer.toString(dlmJornadaSetsL.get(index)));
			txtS1TaL.setText(Integer.toString(dlmJornadaS1TAL.get(index)));
			txtS2TaL.setText(Integer.toString(dlmJornadaS2TAL.get(index)));
			txtS3TaL.setText(Integer.toString(dlmJornadaS3TAL.get(index)));
			txtS4TaL.setText(Integer.toString(dlmJornadaS4TAL.get(index)));
			txtS5TaL.setText(Integer.toString(dlmJornadaS5TAL.get(index)));
			//--VISITANTES--
			lblEquipoVisitante_ResultadoPartido.setText(dlmJornadasEqVisitante.get(index));
			txtSetsV.setText(Integer.toString(dlmJornadaSetsV.get(index)));
			txtS1TavV.setText(Integer.toString(dlmJornadaS1TAV.get(index)));
			txtS2TaV.setText(Integer.toString(dlmJornadaS2TAV.get(index)));
			txtS3TaV.setText(Integer.toString(dlmJornadaS3TAV.get(index)));
			txtS4TaV.setText(Integer.toString(dlmJornadaS4TAV.get(index)));
			txtS5TaV.setText(Integer.toString(dlmJornadaS5TAV.get(index)));
			
		} else {
			//--LOCALES--
			lblEquipoLocal_ResultadoPartido.setText("EQUIPO LOCAL");
			txtSestL.setText("");
			txtS1TaL.setText("");
			txtS2TaL.setText("");
			txtS3TaL.setText("");
			txtS4TaL.setText("");
			txtS5TaL.setText("");
			//--VISITANTES--
			lblEquipoVisitante_ResultadoPartido.setText("EQUIPO VISITANTE");
			txtSetsV.setText("");
			txtS1TavV.setText("");
			txtS2TaV.setText("");
			txtS3TaV.setText("");
			txtS4TaV.setText("");
			txtS5TaV.setText("");
			
		}
	}
}