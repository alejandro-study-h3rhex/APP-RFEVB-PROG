package rfevb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class GestionLigas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainFrameGestionLigas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionLigas frame = new GestionLigas();
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
	public GestionLigas() {
		// NO PERMITE HACER MAS GRANDE O MAS PEQUEÑA LA PANTALLA
		setResizable(false);
		//LOGO Y TITULO
		setTitle("RFEVB Tracker - Gestion Ligas");
		// OBTIENE EL RECURSO DE LA DIRECCION RELATIVA
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionLigas.class.getResource("assets/favicon/web-app-manifest-512x512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 460);
		mainFrameGestionLigas = new JPanel();
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
		lbl_titulo_federacion.setFont(new Font("Leelawadee", lbl_titulo_federacion.getFont().getStyle() | Font.BOLD, 25));
		lbl_titulo_federacion.setForeground(new Color(0, 128, 192));
		northPanel.add(lbl_titulo_federacion);
		
		JButton btnCerrarsesion = new JButton("Cerrar Sesion");
		btnCerrarsesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrarsesion.setBackground(new Color(255, 255, 128));
		northPanel.add(btnCerrarsesion);
		
		JPanel panelGestion = new JPanel();
		mainFrameGestionLigas.add(panelGestion, BorderLayout.CENTER);
		panelGestion.setLayout(new BorderLayout(0, 0));
		
		JPanel addPanel = new JPanel();
		panelGestion.add(addPanel, BorderLayout.NORTH);
		
		JPanel listPanel = new JPanel();
		panelGestion.add(listPanel, BorderLayout.CENTER);
		listPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel listPanelNames = new JPanel();
		FlowLayout flowLayout = (FlowLayout) listPanelNames.getLayout();
		listPanel.add(listPanelNames, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("CODIGO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		listPanelNames.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LIGAS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		listPanelNames.add(lblNewLabel_1);
		
		JPanel listPanelJList = new JPanel();
		listPanel.add(listPanelJList, BorderLayout.CENTER);
		
		JList list = new JList();
		listPanelJList.add(list);

	}

}
