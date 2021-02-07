import static org.junit.Assert.*;

import org.junit.Test;

import Jerarquias.Admin;
import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Cliente;
import Jerarquias.Vuelo;

public class Test {

	@Test
	public void testCliente() {
		String username = "ssc1999";
                String password = "1234";
                String dni = "72858016L";
                String nombre = "sergio";
                String apellido = "Salgado";
                String email = "ssc1099.csmm@gmail.com";
                String telefono = "67867894";
                Cliente cliente1 = new Cliente("ssc1999", "1234", "72858016L", "sergio", "Salgado", "ssc1099.csmm@gmail.com",
                        "67867894");
                
                Cliente cliente2 = new Cliente(username, password, dni, nombre, apellido, email, telefono);

                boolean iguales = (cliente1).equals(cliente2);
                assertTrue(iguales);
	}
	
	@Test
	public void testAdmin() {
		String username = "admin";
                String password = "1234";
                int nivel = 1;
                Admin admin1 = new Admin("admin", "1234", 1);
                Admin admin2 = new Admin(username, password,nivel);

                boolean iguales = (admin1).equals(admin2);
                assertTrue(iguales);
	}

        @Test
        public void testAeropuerto() {
                String nombre = "Barajas";
                String IATA = "CSD";
                String ciudad = "Madrid";
                String pais = "España";
                Aeropuerto aeropuerto1 = new Aeropuerto("Barajas", "CSD", "Madrid", "España");
                Aeropuerto aeropuerto2 = new Aeropuerto(nombre, IATA, ciudad, pais);

                boolean iguales = (aeropuerto1).equals(aeropuerto2);
                assertTrue(iguales);
        }
        
        @Test
        public void testBillete() {
                Cliente cliente = new Cliente("ssc1999", "1234", "72858016L", "sergio", "Salgado",
                                "ssc1099.csmm@gmail.com", "67867894");
                Vuelo vuelo = new Vuelo("RyanAir", "HSDIF", new Aeropuerto("Barajas", "CSD", "Madrid", "España"),
                                new Aeropuerto("Barajas", "CSD", "Madrid", "España"), 0, 0, 0, "02/10/2020", "2:00", 10,
                                5, 1);
                int numPasajerosAdultos = 0;
                int numPasajerosNinyios = 0;
                int numMaletas = 0;
                int clase = 1;
                float precio = 0;

                Billete billete1 = new Billete(
                                new Cliente("ssc1999", "1234", "72858016L", "sergio", "Salgado",
                                                "ssc1099.csmm@gmail.com", "67867894"),
                                new Vuelo("RyanAir", "HSDIF", new Aeropuerto("Barajas", "CSD", "Madrid", "España"),
                                                new Aeropuerto("Barajas", "CSD", "Madrid", "España"), 0, 0, 0,
                                                "02/10/2020", "2:00", 10, 5, 1),
                                0, 0, 0, 1, 0);
                Billete billete2 = new Billete(cliente, vuelo, numPasajerosAdultos, numPasajerosNinyios, numMaletas,
                                clase, precio);

                boolean iguales = (billete1).equals(billete2);
                assertTrue(iguales);
        }
        
        
        @Test
        public void testVuelo() {
                String aerolinea = "RyanAir";
                String designator = "HSDIF";
                Aeropuerto aeropuertOrigen = new Aeropuerto("Barajas", "CSD", "Madrid", "España");
                Aeropuerto aeropuertoDestino = new Aeropuerto("Barajas", "CSD", "Madrid", "España");
                float precioBaseAdulto = 0;
                float precioBaseNinyio = 0;
                float precioMaleta = 0;
                String fecha = "02/10/2020";
                String hora = "2:00";
                int asientosClase1 = 0;
                int asientosClase2 = 0;
                int asientosClase3 = 0;

                Vuelo vuelo1 = new Vuelo("RyanAir", "HSDIF", new Aeropuerto("Barajas", "CSD", "Madrid", "España"),
                                                new Aeropuerto("Barajas", "CSD", "Madrid", "España"), 0, 0, 0,
                                                "02/10/2020", "2:00", 0, 0, 0);
                Vuelo vuelo2 = new Vuelo(aerolinea, designator, aeropuertOrigen, aeropuertoDestino, precioBaseAdulto, precioBaseNinyio, precioMaleta, fecha, hora, asientosClase1, asientosClase2, asientosClase3);

                boolean iguales = (vuelo1).equals(vuelo2);
                assertTrue(iguales);
        }
}
