package rfevb;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Toolkit;

public class AppPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JPanel panelAnonimo;
	JPanel panelArbitro;
	JPanel panelAdmin;
	

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayoutPrincipal = new CardLayout(0,0);
		contentPane.setLayout(cardLayoutPrincipal);
		
		/*PANEL ANONIMO*/
		panelAnonimo = new JPanel();
		contentPane.add(panelAnonimo, "PanelAnonimo_");
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
