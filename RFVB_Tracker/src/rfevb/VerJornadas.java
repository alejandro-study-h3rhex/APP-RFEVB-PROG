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
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridLayout;

public class VerJornadas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel mainFrameGestionLigas;
	
	/*Botones*/
	private JButton btnVolverPanel; 
	private JButton btnAnterior; 
	private JButton btnSiguiente;
	
	/*JList*/
	private JList<String> listEqLocal;
	private JList<String> listEqVisitante;
	
	/*JLabel*/
	private JLabel headerNJornadas;
	
	/**
	 * Create the frame.
	 */
	public VerJornadas() {
		// COLORES
		Color azulPrimero = new Color(0, 128, 192); 
		Color azulSegundo = new Color(51, 153, 204); 
		Color azulTercero = new Color(204, 229, 255); 
		Color amarilloPrimero = new Color(253,253,150);
		//Color amarilloSegundo = new Color(248,248,195);
		Color fondoClaro = new Color(238, 235, 228); 
		
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		// LOGO Y TITULO
		setTitle("RFEVB Tracker - Jornadas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerJornadas.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 520); 
		
		mainFrameGestionLigas = new JPanel();
		mainFrameGestionLigas.setBackground(fondoClaro);
		mainFrameGestionLigas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainFrameGestionLigas);
		mainFrameGestionLigas.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		mainFrameGestionLigas.add(northPanel, BorderLayout.NORTH);
		
		
		JLabel lbl_Icono = new JLabel("");
		lbl_Icono.setIcon(new ImageIcon(VerJornadas.class.getResource("assets/favicon/icono-federacion.png")));
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

	
		// PANEL CENTRAL: GESTIONAR JORNADAS
		
		JPanel panelJornadas = new JPanel();
		panelJornadas.setBackground(fondoClaro);
		mainFrameGestionLigas.add(panelJornadas, BorderLayout.CENTER);
		panelJornadas.setLayout(new BorderLayout(0, 20));
		
		// TÍTULO "GESTIONAR JORNADAS"
		
		JLabel lblGestionarEquipos = new JLabel("JORNADAS");
		lblGestionarEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarEquipos.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lblGestionarEquipos.setForeground(azulPrimero);
		panelJornadas.add(lblGestionarEquipos, BorderLayout.CENTER);
		
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
		
		/*NUMERO JORNADAS*/
		headerNJornadas = new JLabel("Nº  ");
		headerNJornadas.setHorizontalAlignment(SwingConstants.CENTER);
		headerNJornadas.setForeground(Color.WHITE);
		headerNJornadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_headerNJornadas = new GridBagConstraints();
		gbc_headerNJornadas.insets = new Insets(0, 0, 0, 5);
		gbc_headerNJornadas.gridx = 0;
		gbc_headerNJornadas.gridy = 0;
		headerPanel.add(headerNJornadas, gbc_headerNJornadas);
		
		// CABEZERA EQUIPO LOCAL
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
		
		// CABEZERA EQUIPO VISITANTE
		JLabel headerEqVisitante = new JLabel("EQUIPO VISITANTE");
		headerEqVisitante.setForeground(Color.WHITE);
		headerEqVisitante.setFont(new Font("Tahoma", Font.BOLD, 15));
		headerEqVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_headerEqVisitante = new GridBagConstraints();
		gbc_headerEqVisitante.fill = GridBagConstraints.BOTH;
		gbc_headerEqVisitante.gridx = 4;
		gbc_headerEqVisitante.gridy = 0;
		headerPanel.add(headerEqVisitante, gbc_headerEqVisitante);
		
		// CENTRAR EL CONTENEDOR EN EL PANEL SUR
		JPanel panelSur = new JPanel();
		panelSur.setBackground(fondoClaro);
		panelSur.add(listContainer);
		
		// PANEL DE LAS LISTAS
		
		// DATOS
		
		// MODELO DE LAS JLIST
		

		// JLIST DE CODIGOS
		listEqLocal = new JList<String>();
		listEqLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqLocal.setBackground(azulTercero);
		listEqLocal.setForeground(new Color(50, 50, 50));
		listEqLocal.setFixedCellHeight(25); 
		
		// JLIST DE EQUIPOS
		listEqVisitante = new JList<String>();
		listEqVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEqVisitante.setBackground(azulTercero);
		listEqVisitante.setForeground(new Color(50, 50, 50));
		listEqVisitante.setFixedCellHeight(25); 
		
		// Panel de las dos JList 
		JPanel listsPanel = new JPanel(new GridLayout(1, 2, 0, 0)); 
		listsPanel.add(listEqLocal);
		listsPanel.add(listEqVisitante);
		listContainer.add(listsPanel, BorderLayout.CENTER); 
		
		panelJornadas.add(panelSur, BorderLayout.SOUTH);
		
		JPanel btnPanel = new JPanel();
		mainFrameGestionLigas.add(btnPanel, BorderLayout.SOUTH);
		
		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnAnterior.setBackground(amarilloPrimero);
		btnAnterior.setForeground(azulPrimero);
		btnPanel.add(btnAnterior);
		
		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSiguiente.setBackground(amarilloPrimero);
		btnSiguiente.setForeground(azulPrimero);
		btnPanel.add(btnSiguiente);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == btnVolverPanel) {
			PanelAnonimos panelAnonimo = new PanelAnonimos();
			panelAnonimo.setVisible(true);
			this.dispose();
		} else if (o == btnAnterior) {
			
		} else if (o == btnSiguiente) {
			
		}
		
	}
}