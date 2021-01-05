
// import javax.swing.SwingUtilities;
import java.awt.EventQueue;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Usuario;
import Jerarquias.Vuelo;
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
					BDAPI bd = new BDAPI();
					Aeropuerto aeropuerto1 = new Aeropuerto("Barajas", "DSD", "Madrid", "IDA");
					bd.editarAeropuerto(aeropuerto1);
					Usuario usuario1 = new Usuario("pasajero3", "DFD", "7489474M", "sadfasdf", "fred", "fred@gmail", "748374837", null, null, 1);
					bd.editarUser(usuario1);
					Billete billete1 = new Billete(null, 1, 0, 1, 1, 0);
					bd.editarBillete(billete1);
					Vuelo vuelo1 = new Vuelo("RyanAir", "CNXVN", null, null, 0, 0, 0, new GregorianCalendar(3920, 10, 25, 11, 55), new GregorianCalendar(3920, 10, 25, 11, 55), 0, 0, 0);
					bd.editarVuelo(vuelo1);
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
