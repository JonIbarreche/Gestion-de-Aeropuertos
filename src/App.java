
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

import Controladores.*;
import BDAPI.*;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAPI bd = new BDAPI();
					// Controlador controlador = new Controlador(bd);
					// Aeropuerto aeropuerto1 = new Aeropuerto("cccc", "ccccc", "Valladolid", "IDA");
					// aeropuerto1 = bd.editarAeropuerto(aeropuerto1);
					// Cliente cliente = new Cliente("user1", "sahjf", "74890074M", "fred", "elpez", "fred@gmail", "748374837");
					// bd.editarCliente(cliente);
					// Vuelo vuelo1 = new Vuelo("ffffff", "bbbbbb", aeropuerto1, aeropuerto1, 5.55f, 5.55f, 5.55f,"02/10/2020", "17:30", 10, 20, 5);
					// bd.editarVuelo(vuelo1);
					
					//  Billete billete1 = new Billete(1, 0, 1, 1, 0);
					//  billete1.addVuelo(vuelo1);
					//  bd.editarBillete(billete1);
					// bd.eliminarAeropuerto(aeropuerto1);
					VentanaLogin frameLogin = new VentanaLogin();
					frameLogin.setVisible(true);
					// VentanaInicio frameInicio2 = new VentanaInicio();
					// frameInicio2.setVisible(true);
					// VentanaAdmin frameAdmin = new VentanaAdmin();
					// frameAdmin.setVisible(true);
					// VentanaInicio frameInicio = new VentanaInicio();
					// frameInicio.setVisible(true);
					// Aeropuerto o1 = new Aeropuerto("Barajas", "JHDF", "Madrid", "España");
					// Aeropuerto o2 = new Aeropuerto("Prat", "JSDHF", "Barcelona", "España");
					// bd.editarAeropuerto(o1);
					// bd.editarAeropuerto(o2);
					// VentanaBusqueda frameBusqueda = new VentanaBusqueda();
					// frameBusqueda.setVisible(true);
					// VentanaPago framePago = new VentanaPago();
					// framePago.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
