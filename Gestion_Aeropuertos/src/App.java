import javax.swing.SwingUtilities;

import Ventanas.VentanaAdmin;
import Ventanas.VentanaInicio;
import Ventanas.VentanaLogin;

import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				VentanaLogin frameLogin = new VentanaLogin();
				frameLogin.setVisible(false);
				VentanaInicio frameInicio = new VentanaInicio();
				frameInicio.setVisible(false);
				VentanaAdmin frameAdmin = new VentanaAdmin();
				frameAdmin.setVisible(true);
					//locations Locations = new ocations();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
