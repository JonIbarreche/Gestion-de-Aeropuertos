// import javax.swing.SwingUtilities;
import java.awt.EventQueue;

import Ventanas.VentanaAdmin;
import Ventanas.VentanaBusqueda;
import Ventanas.VentanaInicioUsuario;
import Ventanas.VentanaLogin;
import Ventanas.VentanaPago;
import Ventanas.VentanaInicio;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAPI bd = new BDAPI("main.db");
					System.out.println(bd);
					VentanaLogin frameLogin = new VentanaLogin();
					frameLogin.setVisible(true);
					VentanaInicio frameInicio = new VentanaInicio();
					frameInicio.setVisible(true);
					VentanaAdmin frameAdmin = new VentanaAdmin();
					frameAdmin.setVisible(true);
					VentanaInicioUsuario frameInicioUsuario = new VentanaInicioUsuario();
					frameInicioUsuario.setVisible(true);
					VentanaBusqueda frameBusqueda = new VentanaBusqueda();
					frameBusqueda.setVisible(true);
					VentanaPago framePago = new VentanaPago();
					framePago.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
