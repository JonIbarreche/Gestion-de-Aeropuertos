
// import javax.swing.SwingUtilities;
import java.awt.EventQueue;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Cliente;
import Jerarquias.Usuario;
import Jerarquias.Vuelo;
import Ventanas.VentanaAdmin;
import Ventanas.VentanaBusqueda;
import Ventanas.VentanaInicioUsuario;
import Ventanas.VentanaLogin;
import Ventanas.VentanaPago;
import Ventanas.VentanaInicio;

import BDAPI.*;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAPI bd = new BDAPI();
					VentanaLogin frameLogin = new VentanaLogin();
					frameLogin.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
