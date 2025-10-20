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

public class GestionLigas extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel mainFrameGestionLigas;
	
	/*Botones*/
	private JButton btnVolverPanel; 
	
	/*JFields*/
	private JTextField txtCodLiga;
	private JTextField txtLiga;
	
	/**
	 * Create the frame.
	 */
	public GestionLigas() {
	
	
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		// LOGO Y TITULO
		setTitle("RFEVB Tracker - Gestion Ligas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionLigas.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 480); 
		setVisible(true);
		
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
		lbl_Icono.setIcon(new ImageIcon(GestionLigas.class.getResource("assets/favicon/icono-federacion.png")));
		lbl_Icono.setFont(new Font("Tahoma", Font.PLAIN, 6));
		northPanel.add(lbl_Icono);
		
		JLabel lbl_titulo_federacion = new JLabel("Real Federacion Española de Voleibol");
		lbl_titulo_federacion.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lbl_titulo_federacion.setForeground(azulPrimero); 
		northPanel.add(lbl_titulo_federacion);
		
		btnVolverPanel = new JButton("Volver");
		btnVolverPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolverPanel.setBackground(amarilloPrimero);
		btnVolverPanel.setForeground(azulSegundo);
		btnVolverPanel.addActionListener(this);
		northPanel.add(btnVolverPanel);	
		
		
		mainFrameGestionLigas.add(northPanel, BorderLayout.NORTH);

	
		// PANEL CENTRAL: GESTIONAR LIGAS
		
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
		gbl_inputAndButtonsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_inputAndButtonsPanel.rowWeights = new double[]{0.0, 0.0};
		inputAndButtonsPanel.setLayout(gbl_inputAndButtonsPanel);
		
		// ETIQUETAS Y CAMPOS DE TEXTO
		JLabel lbl_CodEq = new JLabel("COD LIGA:");
		lbl_CodEq.setBackground(new Color(0, 0, 160));
		lbl_CodEq.setForeground(azulSegundo);
		lbl_CodEq.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_CodEq = new GridBagConstraints();
		gbc_lbl_CodEq.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_CodEq.anchor = GridBagConstraints.EAST;
		gbc_lbl_CodEq.gridx = 0;
		gbc_lbl_CodEq.gridy = 0;
		inputAndButtonsPanel.add(lbl_CodEq, gbc_lbl_CodEq);
		
		txtCodLiga = new JTextField();
		txtCodLiga.setColumns(10);
		GridBagConstraints gbc_txtCodEq = new GridBagConstraints();
		gbc_txtCodEq.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodEq.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodEq.gridx = 1;
		gbc_txtCodEq.gridy = 0;
		inputAndButtonsPanel.add(txtCodLiga, gbc_txtCodEq);
		
		JLabel lbl_Equipo = new JLabel("LIGA:");
		lbl_Equipo.setBackground(new Color(217, 217, 217));
		lbl_Equipo.setForeground(azulSegundo);
		lbl_Equipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_Equipo = new GridBagConstraints();
		gbc_lbl_Equipo.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_Equipo.anchor = GridBagConstraints.EAST;
		gbc_lbl_Equipo.gridx = 2;
		gbc_lbl_Equipo.gridy = 0;
		inputAndButtonsPanel.add(lbl_Equipo, gbc_lbl_Equipo);
		
		txtLiga = new JTextField();
		txtLiga.setColumns(10);
		GridBagConstraints gbc_txtEquipo = new GridBagConstraints();
		gbc_txtEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_txtEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEquipo.gridx = 3;
		gbc_txtEquipo.gridy = 0;
		inputAndButtonsPanel.add(txtLiga, gbc_txtEquipo);
		
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
		
		// TÍTULO "GESTIONAR LIGAS"
		
		JLabel lblGestionarEquipos = new JLabel("GESTIONAR LIGAS");
		lblGestionarEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarEquipos.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lblGestionarEquipos.setForeground(azulPrimero);
		panelGestion.add(lblGestionarEquipos, BorderLayout.CENTER);
		
		// PANEL DE LAS LISTAS
		
		// DATOS
		String[] codigos = {"MASC-CV" ,"FEM-CV"};
		String[] ligas = {"Super Liga Masculina", "Super Liga Femenina"};
		
		// MODELO DE LAS JLIST
		DefaultListModel<String> modelCodigos = new DefaultListModel<>();
		for (String cod : codigos) {
			modelCodigos.addElement(cod);
		}
		
		DefaultListModel<String> modelEquipos = new DefaultListModel<>();
		for (String lg : ligas) {
			modelEquipos.addElement(lg);
		}

		// JLIST DE CODIGOS
		JList<String> listCodigos = new JList<>(modelCodigos);
		listCodigos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listCodigos.setBackground(azulTercero);
		listCodigos.setForeground(new Color(50, 50, 50));
		listCodigos.setFixedCellHeight(25); 
		
		// JLIST DE LIGAS
		JList<String> listLigas = new JList<>(modelEquipos);
		listLigas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listLigas.setBackground(azulTercero);
		listLigas.setForeground(new Color(50, 50, 50));
		listLigas.setFixedCellHeight(25); 
		
		// Panel de las dos JList 
		JPanel listsPanel = new JPanel(new GridLayout(1, 2, 0, 0)); 
		listsPanel.add(listCodigos);
		listsPanel.add(listLigas);
		
		// PANEL CABEZERA
		JPanel headerPanel = new JPanel(new GridLayout(1, 2, 0, 0)); 
		headerPanel.setBackground(azulSegundo);
		
		// CABEZERA COD EQ
		JLabel headerCodEq = new JLabel("COD LIGA");
		headerCodEq.setForeground(Color.WHITE);
		headerCodEq.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerCodEq.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(headerCodEq);
		
		// CABEZERA EQUIPO
		JLabel headerEquipo = new JLabel("LIGA");
		headerEquipo.setForeground(Color.WHITE);
		headerEquipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(headerEquipo);
		
		// CONTENEDOR D ELISTAS Y CAVEZERAS
		JPanel listContainer = new JPanel(new BorderLayout());
		int numRows = codigos.length;
		int rowHeight = 25;
		int headerHeight = 30;
		
		listContainer.setPreferredSize(new Dimension(500, numRows * rowHeight + headerHeight)); 
		
		listContainer.add(headerPanel, BorderLayout.NORTH); 
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