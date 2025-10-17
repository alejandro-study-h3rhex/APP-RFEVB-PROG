package rfevb;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ListModel;

public class GestionClasificacion extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel mainFrameGestionLigas;
	
	/*Botones*/
	private JButton btnVolverPanel; 
	
	/*JFields*/
	private JTextField txtCodLiga;
	private JTextField txtEquipo;
	private JTextField textPtos;
	private JTextField textPJ;
	private JTextField textPG;
	private JTextField textPP;
	private JTextField textSG;
	private JTextField textSP;
	private JTextField textTA;
	private JTextField textTC;

	
	/**
	 * Create the frame.
	 */
	public GestionClasificacion() {
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		// LOGO Y TITULO
		setTitle("RFEVB Tracker - Gestion Equipos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionClasificacion.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 480); 
		
		// COLORES
		Color azulPrimero = new Color(0, 128, 192); 
		Color azulSegundo = new Color(51, 153, 204); 
		Color azulTercero = new Color(204, 229, 255); 
		Color amarilloPrimero = new Color(253,253,150);
		//Color amarilloSegundo = new Color(248,248,195);
		Color fondoClaro = new Color(238, 235, 228); 
		
		mainFrameGestionLigas = new JPanel();
		mainFrameGestionLigas.setBackground(fondoClaro);
		mainFrameGestionLigas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainFrameGestionLigas);
		mainFrameGestionLigas.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		mainFrameGestionLigas.add(northPanel, BorderLayout.NORTH);
		
		
		JLabel lbl_Icono = new JLabel("");
		lbl_Icono.setIcon(new ImageIcon(GestionClasificacion.class.getResource("assets/favicon/icono-federacion.png")));
		lbl_Icono.setFont(new Font("Tahoma", Font.PLAIN, 6));
		northPanel.add(lbl_Icono);
		
		JLabel lbl_titulo_federacion = new JLabel("Real Federacion Española de Voleibol");
		lbl_titulo_federacion.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lbl_titulo_federacion.setForeground(new Color(0, 128, 192)); 
		northPanel.add(lbl_titulo_federacion);
		
		btnVolverPanel = new JButton("Volver");
		btnVolverPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolverPanel.setBackground(amarilloPrimero);
		btnVolverPanel.setForeground(azulSegundo);
		btnVolverPanel.addActionListener(this);
		northPanel.add(btnVolverPanel);		
		
		mainFrameGestionLigas.add(northPanel, BorderLayout.NORTH);

	
		// PANEL CENTRAL: GESTIONAR EQUIPOS
		
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(fondoClaro);
		mainFrameGestionLigas.add(panelGestion, BorderLayout.CENTER);
		panelGestion.setLayout(new BorderLayout(0, 20)); 
		
		// PANEL DE INSERTAR/BORRAR/LIMPIAR 
		
		JPanel inputAndButtonsPanel = new JPanel();
		inputAndButtonsPanel.setBackground(new Color(192, 192, 192));
		panelGestion.add(inputAndButtonsPanel, BorderLayout.NORTH);
		
		GridBagLayout gbl_inputAndButtonsPanel = new GridBagLayout();
		gbl_inputAndButtonsPanel.columnWidths = new int[] {70, 150, 70, 150}; 
		gbl_inputAndButtonsPanel.rowHeights = new int[] {30, 40};
		gbl_inputAndButtonsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		gbl_inputAndButtonsPanel.rowWeights = new double[]{0.0, 0.0};
		inputAndButtonsPanel.setLayout(gbl_inputAndButtonsPanel);
		
		// ETIQUETAS Y CAMPOS DE TEXTO
		JLabel lbl_CodLiga = new JLabel("COD LIGA:");
		lbl_CodLiga.setBackground(new Color(0, 0, 160));
		lbl_CodLiga.setForeground(azulSegundo);
		lbl_CodLiga.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_CodLiga = new GridBagConstraints();
		gbc_lbl_CodLiga.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_CodLiga.anchor = GridBagConstraints.EAST;
		gbc_lbl_CodLiga.gridx = 0;
		gbc_lbl_CodLiga.gridy = 0;
		inputAndButtonsPanel.add(lbl_CodLiga, gbc_lbl_CodLiga);
		
		txtCodLiga = new JTextField();
		txtCodLiga.setColumns(10);
		GridBagConstraints gbc_txtCodLiga = new GridBagConstraints();
		gbc_txtCodLiga.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodLiga.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodLiga.gridx = 1;
		gbc_txtCodLiga.gridy = 0;
		inputAndButtonsPanel.add(txtCodLiga, gbc_txtCodLiga);
		
		JLabel lbl_Equipo = new JLabel("EQUIPO:");
		lbl_Equipo.setBackground(new Color(217, 217, 217));
		lbl_Equipo.setForeground(azulSegundo);
		lbl_Equipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_Equipo = new GridBagConstraints();
		gbc_lbl_Equipo.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_Equipo.anchor = GridBagConstraints.EAST;
		gbc_lbl_Equipo.gridx = 2;
		gbc_lbl_Equipo.gridy = 0;
		inputAndButtonsPanel.add(lbl_Equipo, gbc_lbl_Equipo);
		
		txtEquipo = new JTextField();
		txtEquipo.setColumns(10);
		GridBagConstraints gbc_txtEquipo = new GridBagConstraints();
		gbc_txtEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_txtEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEquipo.gridx = 3;
		gbc_txtEquipo.gridy = 0;
		inputAndButtonsPanel.add(txtEquipo, gbc_txtEquipo);
		
		JLabel lblPtos = new JLabel("PTOS:");
		lblPtos.setForeground(new Color(51, 153, 204));
		lblPtos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPtos.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblPtos = new GridBagConstraints();
		gbc_lblPtos.anchor = GridBagConstraints.EAST;
		gbc_lblPtos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPtos.gridx = 4;
		gbc_lblPtos.gridy = 0;
		inputAndButtonsPanel.add(lblPtos, gbc_lblPtos);
		
		textPtos = new JTextField();
		textPtos.setColumns(10);
		GridBagConstraints gbc_textPtos = new GridBagConstraints();
		gbc_textPtos.insets = new Insets(0, 0, 5, 5);
		gbc_textPtos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPtos.gridx = 5;
		gbc_textPtos.gridy = 0;
		inputAndButtonsPanel.add(textPtos, gbc_textPtos);
		
		JLabel lblPJ = new JLabel("P.J:");
		lblPJ.setForeground(new Color(51, 153, 204));
		lblPJ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPJ.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblPJ = new GridBagConstraints();
		gbc_lblPJ.anchor = GridBagConstraints.EAST;
		gbc_lblPJ.insets = new Insets(0, 0, 5, 5);
		gbc_lblPJ.gridx = 7;
		gbc_lblPJ.gridy = 0;
		inputAndButtonsPanel.add(lblPJ, gbc_lblPJ);
		
		textPJ = new JTextField();
		textPJ.setColumns(10);
		GridBagConstraints gbc_textPJ = new GridBagConstraints();
		gbc_textPJ.insets = new Insets(0, 0, 5, 5);
		gbc_textPJ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPJ.gridx = 8;
		gbc_textPJ.gridy = 0;
		inputAndButtonsPanel.add(textPJ, gbc_textPJ);
		
		JLabel lblPG = new JLabel("P.G:");
		lblPG.setForeground(new Color(51, 153, 204));
		lblPG.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPG.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblPG = new GridBagConstraints();
		gbc_lblPG.anchor = GridBagConstraints.EAST;
		gbc_lblPG.insets = new Insets(0, 0, 5, 5);
		gbc_lblPG.gridx = 10;
		gbc_lblPG.gridy = 0;
		inputAndButtonsPanel.add(lblPG, gbc_lblPG);
		
		textPG = new JTextField();
		textPG.setColumns(10);
		GridBagConstraints gbc_textPG = new GridBagConstraints();
		gbc_textPG.insets = new Insets(0, 0, 5, 5);
		gbc_textPG.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPG.gridx = 11;
		gbc_textPG.gridy = 0;
		inputAndButtonsPanel.add(textPG, gbc_textPG);
		
		JLabel lblPP = new JLabel("P.P:");
		lblPP.setForeground(new Color(51, 153, 204));
		lblPP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPP.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblPP = new GridBagConstraints();
		gbc_lblPP.anchor = GridBagConstraints.EAST;
		gbc_lblPP.insets = new Insets(0, 0, 5, 5);
		gbc_lblPP.gridx = 13;
		gbc_lblPP.gridy = 0;
		inputAndButtonsPanel.add(lblPP, gbc_lblPP);
		
		textPP = new JTextField();
		textPP.setColumns(10);
		GridBagConstraints gbc_textPP = new GridBagConstraints();
		gbc_textPP.insets = new Insets(0, 0, 5, 5);
		gbc_textPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPP.gridx = 14;
		gbc_textPP.gridy = 0;
		inputAndButtonsPanel.add(textPP, gbc_textPP);
		
		JLabel lblSG = new JLabel("S.G:");
		lblSG.setForeground(new Color(51, 153, 204));
		lblSG.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSG.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblSG = new GridBagConstraints();
		gbc_lblSG.anchor = GridBagConstraints.EAST;
		gbc_lblSG.insets = new Insets(0, 0, 5, 5);
		gbc_lblSG.gridx = 16;
		gbc_lblSG.gridy = 0;
		inputAndButtonsPanel.add(lblSG, gbc_lblSG);
		
		textSG = new JTextField();
		textSG.setColumns(10);
		GridBagConstraints gbc_textSG = new GridBagConstraints();
		gbc_textSG.insets = new Insets(0, 0, 5, 5);
		gbc_textSG.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSG.gridx = 17;
		gbc_textSG.gridy = 0;
		inputAndButtonsPanel.add(textSG, gbc_textSG);
		
		JLabel lblSP = new JLabel("S.P:");
		lblSP.setForeground(new Color(51, 153, 204));
		lblSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSP.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblSP = new GridBagConstraints();
		gbc_lblSP.anchor = GridBagConstraints.EAST;
		gbc_lblSP.insets = new Insets(0, 0, 5, 5);
		gbc_lblSP.gridx = 19;
		gbc_lblSP.gridy = 0;
		inputAndButtonsPanel.add(lblSP, gbc_lblSP);
		
		textSP = new JTextField();
		textSP.setColumns(10);
		GridBagConstraints gbc_textSP = new GridBagConstraints();
		gbc_textSP.insets = new Insets(0, 0, 5, 5);
		gbc_textSP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSP.gridx = 20;
		gbc_textSP.gridy = 0;
		inputAndButtonsPanel.add(textSP, gbc_textSP);
		
		JLabel lblTA = new JLabel("T.A:");
		lblTA.setForeground(new Color(51, 153, 204));
		lblTA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTA.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lblTA = new GridBagConstraints();
		gbc_lblTA.anchor = GridBagConstraints.EAST;
		gbc_lblTA.insets = new Insets(0, 0, 5, 5);
		gbc_lblTA.gridx = 22;
		gbc_lblTA.gridy = 0;
		inputAndButtonsPanel.add(lblTA, gbc_lblTA);
		
		textTA = new JTextField();
		textTA.setColumns(10);
		GridBagConstraints gbc_textTA = new GridBagConstraints();
		gbc_textTA.insets = new Insets(0, 0, 5, 5);
		gbc_textTA.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTA.gridx = 23;
		gbc_textTA.gridy = 0;
		inputAndButtonsPanel.add(textTA, gbc_textTA);
		
		JLabel lbl_TC = new JLabel("T.C:");
		lbl_TC.setForeground(new Color(51, 153, 204));
		lbl_TC.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_TC.setBackground(new Color(217, 217, 217));
		GridBagConstraints gbc_lbl_TC = new GridBagConstraints();
		gbc_lbl_TC.anchor = GridBagConstraints.EAST;
		gbc_lbl_TC.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_TC.gridx = 25;
		gbc_lbl_TC.gridy = 0;
		inputAndButtonsPanel.add(lbl_TC, gbc_lbl_TC);
		
		textTC = new JTextField();
		textTC.setColumns(10);
		GridBagConstraints gbc_textTC = new GridBagConstraints();
		gbc_textTC.insets = new Insets(0, 0, 5, 0);
		gbc_textTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTC.gridx = 26;
		gbc_textTC.gridy = 0;
		inputAndButtonsPanel.add(textTC, gbc_textTC);
		
		// BOTONES
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsertar.setBackground(amarilloPrimero);
		btnInsertar.setForeground(azulSegundo);
		GridBagConstraints gbc_btnInsertar = new GridBagConstraints();
		gbc_btnInsertar.fill = GridBagConstraints.BOTH;
		gbc_btnInsertar.insets = new Insets(5, 5, 0, 5);
		gbc_btnInsertar.gridx = 1;
		gbc_btnInsertar.gridy = 1;
		inputAndButtonsPanel.add(btnInsertar, gbc_btnInsertar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(azulSegundo);
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBorrar.setBackground(amarilloPrimero);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.insets = new Insets(5, 5, 0, 5);
		gbc_btnBorrar.gridx = 2;
		gbc_btnBorrar.gridy = 1;
		inputAndButtonsPanel.add(btnBorrar, gbc_btnBorrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(azulSegundo);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar.setBackground(amarilloPrimero);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.insets = new Insets(5, 5, 0, 5);
		gbc_btnLimpiar.gridx = 3;
		gbc_btnLimpiar.gridy = 1;
		inputAndButtonsPanel.add(btnLimpiar, gbc_btnLimpiar);
		
		// TÍTULO "GESTIONAR EQUIPOS"
		
		JLabel lblGestionarEquipos = new JLabel("CLASIFICACIÓN MASC-25-26");
		lblGestionarEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarEquipos.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lblGestionarEquipos.setForeground(azulPrimero);
		panelGestion.add(lblGestionarEquipos, BorderLayout.CENTER);
		
		// PANEL DE LAS LISTAS
		
		// DATOS
		String[] codigos = {"CV-ZG", "CV-SF", "VD-CV", "CV-TG", "CV-PM", "CV-RI"};
		String[] equipos = {"CV Zaragoza", "CV San Fernando", "Valladolid CV", "CV Torrelavega", "CV Palma", "CV Rivas"};
		
		// MODELO DE LAS JLIST
		DefaultListModel<String> modelCodLiga_Masc = new DefaultListModel<>();
		for (String cod : codigos) {
			modelCodLiga_Masc.addElement(cod);
		}
		
		DefaultListModel<String> modelEquipos_Masc= new DefaultListModel<>();
		for (String eq : equipos) {
			modelEquipos_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelPTOS_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelPTOS_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelPJ_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelPJ_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelPG_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelPG_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelPP_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelPP_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelSG_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelSG_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelSP_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelSP_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelTA_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelTA_Masc.addElement(eq);
		}
		
		DefaultListModel<String> modelTC_Masc = new DefaultListModel<>();
		for (String eq : equipos) {
			modelTC_Masc.addElement(eq);
		}

		// JLIST DE CODIGOS
		JList<String> listCodLiga = new JList<>(modelCodLiga_Masc);
		listCodLiga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listCodLiga.setBackground(azulTercero);
		listCodLiga.setForeground(new Color(50, 50, 50));
		listCodLiga.setFixedCellHeight(25); 
		
		// Panel de las dos JList 
		JPanel listsPanel = new JPanel(new GridLayout(1, 2, 0, 0)); 
		listsPanel.add(listCodLiga);
		
		// JLIST DE EQUIPOS
		JList<String> listEquipos = new JList<>(modelEquipos_Masc);
		listEquipos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEquipos.setBackground(azulTercero);
		listEquipos.setForeground(new Color(50, 50, 50));
		listEquipos.setFixedCellHeight(25); 
		listsPanel.add(listEquipos);
		
		JList<String> listPTOS = new JList<String>(modelPTOS_Masc);
		listPTOS.setForeground(new Color(50, 50, 50));
		listPTOS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPTOS.setFixedCellHeight(25);
		listPTOS.setBackground(new Color(204, 229, 255));
		listsPanel.add(listPTOS);
		
		JList<String> listPJ = new JList<String>(modelPJ_Masc);
		listPJ.setForeground(new Color(50, 50, 50));
		listPJ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPJ.setFixedCellHeight(25);
		listPJ.setBackground(new Color(204, 229, 255));
		listsPanel.add(listPJ);
		
		JList<String> listPG = new JList<String>(modelPG_Masc);
		listPG.setForeground(new Color(50, 50, 50));
		listPG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPG.setFixedCellHeight(25);
		listPG.setBackground(new Color(204, 229, 255));
		listsPanel.add(listPG);
		
		JList<String> listPP = new JList<String>(modelPP_Masc);
		listPP.setForeground(new Color(50, 50, 50));
		listPP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPP.setFixedCellHeight(25);
		listPP.setBackground(new Color(204, 229, 255));
		listsPanel.add(listPP);
		
		JList<String> listSG = new JList<String>(modelSG_Masc);
		listSG.setForeground(new Color(50, 50, 50));
		listSG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSG.setFixedCellHeight(25);
		listSG.setBackground(new Color(204, 229, 255));
		listsPanel.add(listSG);
		
		JList<String> listSP = new JList<String>(modelSP_Masc);
		listSP.setForeground(new Color(50, 50, 50));
		listSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listSP.setFixedCellHeight(25);
		listSP.setBackground(new Color(204, 229, 255));
		listsPanel.add(listSP);
		
		JList<String> listTA = new JList<String>(modelTA_Masc);
		listTA.setForeground(new Color(50, 50, 50));
		listTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTA.setFixedCellHeight(25);
		listTA.setBackground(new Color(204, 229, 255));
		listsPanel.add(listTA);
		
		JList<String> listTC = new JList<String>(modelTC_Masc);
		listTC.setForeground(new Color(50, 50, 50));
		listTC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listTC.setFixedCellHeight(25);
		listTC.setBackground(new Color(204, 229, 255));
		listsPanel.add(listTC);
		
		// PANEL CABEZERA
		JPanel headerPanel = new JPanel(new GridLayout(1, 2, 0, 0)); 
		headerPanel.setBackground(azulSegundo);
		
		// CABEZERA COD EQ
		JLabel headerCodLiga = new JLabel("COD LIGA");
		headerCodLiga.setForeground(Color.WHITE);
		headerCodLiga.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerCodLiga.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(headerCodLiga);
		
		// CABEZERA EQUIPO
		JLabel headerEquipo = new JLabel("EQUIPO");
		headerEquipo.setForeground(Color.WHITE);
		headerEquipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(headerEquipo);
		
		// CONTENEDOR D ELISTAS Y CAVEZERAS
		JPanel listContainer = new JPanel(new BorderLayout());
		int numRows = codigos.length;
		int rowHeight = 25;
		int headerHeight = 30;
		
		listContainer.setPreferredSize(new Dimension(1500, numRows * rowHeight + headerHeight)); 
		
		listContainer.add(headerPanel, BorderLayout.NORTH); 
		
		JLabel headerPTOS = new JLabel("PTOS");
		headerPTOS.setHorizontalAlignment(SwingConstants.CENTER);
		headerPTOS.setForeground(Color.WHITE);
		headerPTOS.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerPTOS);
		
		JLabel headerPJ = new JLabel("P.J");
		headerPJ.setHorizontalAlignment(SwingConstants.CENTER);
		headerPJ.setForeground(Color.WHITE);
		headerPJ.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerPJ);
		
		JLabel headerPG = new JLabel("P.G");
		headerPG.setHorizontalAlignment(SwingConstants.CENTER);
		headerPG.setForeground(Color.WHITE);
		headerPG.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerPG);
		
		JLabel headerPP = new JLabel("P.P");
		headerPP.setHorizontalAlignment(SwingConstants.CENTER);
		headerPP.setForeground(Color.WHITE);
		headerPP.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerPP);
		
		JLabel headerSG = new JLabel("S.G");
		headerSG.setHorizontalAlignment(SwingConstants.CENTER);
		headerSG.setForeground(Color.WHITE);
		headerSG.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerSG);
		
		JLabel headerSP = new JLabel("S.P");
		headerSP.setHorizontalAlignment(SwingConstants.CENTER);
		headerSP.setForeground(Color.WHITE);
		headerSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerSP);
		
		JLabel headerTA = new JLabel("T.A");
		headerTA.setHorizontalAlignment(SwingConstants.CENTER);
		headerTA.setForeground(Color.WHITE);
		headerTA.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerTA);
		
		JLabel headerTC = new JLabel("T.C");
		headerTC.setHorizontalAlignment(SwingConstants.CENTER);
		headerTC.setForeground(Color.WHITE);
		headerTC.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerPanel.add(headerTC);
		listContainer.add(listsPanel, BorderLayout.CENTER); 
		
		// CENTRAR EL CONTENEDOR EN EL PANEL SUR
		JPanel panelSur = new JPanel();
		panelSur.setBackground(fondoClaro);
		panelSur.add(listContainer);
		
		panelGestion.add(panelSur, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == btnVolverPanel) {
			PanelAdmin panelAdmin = new PanelAdmin();
			panelAdmin.setVisible(true);
			this.dispose();
		}
		
	}
}