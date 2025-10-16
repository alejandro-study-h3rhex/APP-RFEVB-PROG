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

public class GestionJornadas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel mainFrameGestionLigas;
	
	/*Botones*/
	private JButton btnVolverPanel; 
	
	/*JFields*/
	private JTextField txtCodEq;
	private JTextField txtEquipo;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public GestionJornadas() {
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		// LOGO Y TITULO
		setTitle("RFEVB Tracker - Gestion Jornadas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionJornadas.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 520); 
		
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
		lbl_Icono.setIcon(new ImageIcon(GestionJornadas.class.getResource("assets/favicon/icono-federacion.png")));
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
		gbl_inputAndButtonsPanel.columnWidths = new int[] {0, 0, 70, 150, 70, 150}; 
		gbl_inputAndButtonsPanel.rowHeights = new int[] {30, 40};
		gbl_inputAndButtonsPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_inputAndButtonsPanel.rowWeights = new double[]{0.0, 0.0};
		inputAndButtonsPanel.setLayout(gbl_inputAndButtonsPanel);
		
		JLabel lbl_EqNJornadas = new JLabel("Nº:");
		lbl_EqNJornadas.setForeground(new Color(51, 153, 204));
		lbl_EqNJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_EqNJornadas.setBackground(new Color(0, 0, 160));
		GridBagConstraints gbc_lbl_EqNJornadas = new GridBagConstraints();
		gbc_lbl_EqNJornadas.anchor = GridBagConstraints.EAST;
		gbc_lbl_EqNJornadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_EqNJornadas.gridx = 0;
		gbc_lbl_EqNJornadas.gridy = 0;
		inputAndButtonsPanel.add(lbl_EqNJornadas, gbc_lbl_EqNJornadas);
		
		textField = new JTextField();
		textField.setColumns(5);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		inputAndButtonsPanel.add(textField, gbc_textField);
		
		// ETIQUETAS Y CAMPOS DE TEXTO
		JLabel lbl_EqLocal = new JLabel("EQUIPO LOCAL:");
		lbl_EqLocal.setBackground(new Color(0, 0, 160));
		lbl_EqLocal.setForeground(azulSegundo);
		lbl_EqLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_EqLocal = new GridBagConstraints();
		gbc_lbl_EqLocal.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_EqLocal.anchor = GridBagConstraints.EAST;
		gbc_lbl_EqLocal.gridx = 2;
		gbc_lbl_EqLocal.gridy = 0;
		inputAndButtonsPanel.add(lbl_EqLocal, gbc_lbl_EqLocal);
		
		txtCodEq = new JTextField();
		txtCodEq.setColumns(10);
		GridBagConstraints gbc_txtCodEq = new GridBagConstraints();
		gbc_txtCodEq.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodEq.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodEq.gridx = 3;
		gbc_txtCodEq.gridy = 0;
		inputAndButtonsPanel.add(txtCodEq, gbc_txtCodEq);
		
		JLabel lbl_EqVisitante = new JLabel("EQUIPO VISITANTE:");
		lbl_EqVisitante.setBackground(new Color(217, 217, 217));
		lbl_EqVisitante.setForeground(azulSegundo);
		lbl_EqVisitante.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_EqVisitante = new GridBagConstraints();
		gbc_lbl_EqVisitante.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_EqVisitante.anchor = GridBagConstraints.EAST;
		gbc_lbl_EqVisitante.gridx = 4;
		gbc_lbl_EqVisitante.gridy = 0;
		inputAndButtonsPanel.add(lbl_EqVisitante, gbc_lbl_EqVisitante);
		
		txtEquipo = new JTextField();
		txtEquipo.setColumns(10);
		GridBagConstraints gbc_txtEquipo = new GridBagConstraints();
		gbc_txtEquipo.insets = new Insets(0, 0, 5, 0);
		gbc_txtEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEquipo.gridx = 5;
		gbc_txtEquipo.gridy = 0;
		inputAndButtonsPanel.add(txtEquipo, gbc_txtEquipo);
		
		// BOTONES
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsertar.setBackground(amarilloPrimero);
		btnInsertar.setForeground(azulSegundo);
		GridBagConstraints gbc_btnInsertar = new GridBagConstraints();
		gbc_btnInsertar.fill = GridBagConstraints.BOTH;
		gbc_btnInsertar.insets = new Insets(5, 5, 0, 5);
		gbc_btnInsertar.gridx = 2;
		gbc_btnInsertar.gridy = 1;
		inputAndButtonsPanel.add(btnInsertar, gbc_btnInsertar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(azulSegundo);
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBorrar.setBackground(amarilloPrimero);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.insets = new Insets(5, 5, 0, 5);
		gbc_btnBorrar.gridx = 3;
		gbc_btnBorrar.gridy = 1;
		inputAndButtonsPanel.add(btnBorrar, gbc_btnBorrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(azulSegundo);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar.setBackground(amarilloPrimero);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.insets = new Insets(5, 5, 0, 5);
		gbc_btnLimpiar.gridx = 4;
		gbc_btnLimpiar.gridy = 1;
		inputAndButtonsPanel.add(btnLimpiar, gbc_btnLimpiar);
		
		// TÍTULO "GESTIONAR EQUIPOS"
		
		JLabel lblGestionarEquipos = new JLabel("GESTIONAR JORNADAS");
		lblGestionarEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarEquipos.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lblGestionarEquipos.setForeground(azulPrimero);
		panelGestion.add(lblGestionarEquipos, BorderLayout.CENTER);
		
		// PANEL DE LAS LISTAS
		
		// DATOS
		
		// MODELO DE LAS JLIST
		

		// JLIST DE CODIGOS
		JList<String> listEqLocal = new JList<String>();
		listEqLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqLocal.setBackground(azulTercero);
		listEqLocal.setForeground(new Color(50, 50, 50));
		listEqLocal.setFixedCellHeight(25); 
		
		// JLIST DE EQUIPOS
		JList<String> listEqVisitante = new JList<String>();
		listEqVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqVisitante.setBackground(azulTercero);
		listEqVisitante.setForeground(new Color(50, 50, 50));
		listEqVisitante.setFixedCellHeight(25); 
		
		// Panel de las dos JList 
		JPanel listsPanel = new JPanel(new GridLayout(1, 2, 0, 0)); 
		listsPanel.add(listEqLocal);
		listsPanel.add(listEqVisitante);
		
		// PANEL CABEZERA
		JPanel headerPanel = new JPanel(); 
		headerPanel.setBackground(azulSegundo);
		GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[] {0, 166};
		gbl_headerPanel.rowHeights = new int[]{19, 0};
		gbl_headerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_headerPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerPanel.setLayout(gbl_headerPanel);
		
		// CONTENEDOR D ELISTAS Y CAVEZERAS
		JPanel listContainer = new JPanel(new BorderLayout());
		int numRows = 6;
		int rowHeight = 25;
		int headerHeight = 30;
		
		listContainer.setPreferredSize(new Dimension(500, numRows * rowHeight + headerHeight)); 
		
		listContainer.add(headerPanel, BorderLayout.NORTH); 
		
		JLabel headerNJornadas = new JLabel("Nº  ");
		headerNJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		headerNJornadas.setForeground(Color.WHITE);
		headerNJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerNJornadas = new GridBagConstraints();
		gbc_headerNJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_headerNJornadas.gridx = 0;
		gbc_headerNJornadas.gridy = 0;
		headerPanel.add(headerNJornadas, gbc_headerNJornadas);
		
		// CABEZERA COD EQ
		JLabel headerEqLocal = new JLabel("EQUIPO LOCAL");
		headerEqLocal.setForeground(Color.WHITE);
		headerEqLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEqLocal.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_headerEqLocal = new GridBagConstraints();
		gbc_headerEqLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerEqLocal.insets = new Insets(0, 0, 0, 5);
		gbc_headerEqLocal.gridx = 1;
		gbc_headerEqLocal.gridy = 0;
		headerPanel.add(headerEqLocal, gbc_headerEqLocal);
		
		// CABEZERA EQUIPO
		JLabel headerEqVisitante = new JLabel("EQUIPO VISITANTE");
		headerEqVisitante.setForeground(Color.WHITE);
		headerEqVisitante.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEqVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_headerEqVisitante = new GridBagConstraints();
		gbc_headerEqVisitante.fill = GridBagConstraints.BOTH;
		gbc_headerEqVisitante.gridx = 4;
		gbc_headerEqVisitante.gridy = 0;
		headerPanel.add(headerEqVisitante, gbc_headerEqVisitante);
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