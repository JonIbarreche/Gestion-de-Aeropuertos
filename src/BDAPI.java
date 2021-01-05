import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.sql.ResultSet;

import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Usuario;
import Jerarquias.Vuelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDAPI {

    protected String url = "jdbc:sqlite:sqlite/main.db";

    public BDAPI() {

        String queryCreateTableAeropuertos = "CREATE TABLE IF NOT EXISTS aeropuertos (\n"
                + "	id integer PRIMARY KEY,\n" + "	nombre text NOT NULL,\n" + "	iata text NOT NULL UNIQUE,\n"
                + "	ciudad text NOT NULL,\n" + "	pais text NOT NULL\n" + ");";

        String queryCreateTableUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (\n" + "	id integer PRIMARY KEY,\n"
                + "	username text NOT NULL UNIQUE,\n" + "	password text NOT NULL,\n" + "	dni text UNIQUE,\n"
                + "	nombre text,\n" + "	apellido text,\n" + "	email text,\n" + "	telefono text,\n"
                + "	tarjeta text,\n" + "	bookings text,\n" + "	nivel integer\n" + ");";

        String queryCreateTableBilletes = "CREATE TABLE IF NOT EXISTS billetes (\n" + "	id integer PRIMARY KEY,\n"
                + "	vuelos text NOT NULL,\n" + "	numero_pasajeros_adultos integer NOT NULL,\n"
                + "	numero_pasajeros_ninyios integer NOT NULL,\n" + "	numero_maletas integer NOT NULL,\n"
                + "	clase integer NOT NULL,\n" + "	precio real NOT NULL\n" + ");";

        String queryCreateTableVuelos = "CREATE TABLE IF NOT EXISTS vuelos (\n" + "	id integer PRIMARY KEY,\n"
                + "	aerolinea text NOT NULL,\n" + "	designator text NOT NULL,\n" + "	origen_iata text NOT NULL,\n"
                + "	destino_iata text NOT NULL,\n" + "	precio_base_adulto real NOT NULL,\n"
                + "	precio_base_ninyio real NOT NULL,\n" + "	precio_maleta real NOT NULL,\n"
                + "	fecha_origen text NOT NULL,\n" + "	fecha_destino text NOT NULL,\n"
                + "	asientos_clase_1 text NOT NULL,\n" + "	asientos_clase_2 text NOT NULL,\n"
                + "	asientos_clase_3 text NOT NULL\n" + ");";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(queryCreateTableAeropuertos);
                stmt.execute(queryCreateTableUsuarios);
                stmt.execute(queryCreateTableBilletes);
                stmt.execute(queryCreateTableVuelos);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Editar aeropuerto
    public Aeropuerto editarAeropuerto(Aeropuerto aeropuerto) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeAeropuerto = "SELECT id FROM aeropuertos";

                try {
                    ResultSet rs = stmt.executeQuery(existeAeropuerto);
                    boolean encontrado = false;
                    while (rs.next()) {
                        if (rs.getInt("id") == aeropuerto.getId()) {

                            String sqlUpdate = "UPDATE aeropuertos SET (nombre, ciudad, pais, iata) VALUES (?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, aeropuerto.getNombre());
                            pst.setString(2, aeropuerto.getCiudad());
                            pst.setString(3, aeropuerto.getPais());
                            pst.setString(4, aeropuerto.getIATA());

                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO aeropuertos (nombre, ciudad, pais, iata) VALUES (?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, aeropuerto.getNombre());
                        pst.setString(2, aeropuerto.getCiudad());
                        pst.setString(3, aeropuerto.getPais());
                        pst.setString(4, aeropuerto.getIATA());

                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aeropuerto;
    }

    // Editar usuario
    public Usuario editarUsuario(Usuario usuario) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeUsuario = "SELECT id FROM usuarios";
                try {
                    ResultSet rs = stmt.executeQuery(existeUsuario);
                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getInt("id") == usuario.getId()) {

                            String sqlUpdate = "UPDATE usuarios SET(username, password, dni, nombre, apellido, email, telefono, tarjeta, bookings, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, usuario.getUsername());
                            pst.setString(2, usuario.getPassword());
                            pst.setString(3, usuario.getDni());
                            pst.setString(4, usuario.getUsername());
                            pst.setString(5, usuario.getNombre());
                            pst.setString(6, usuario.getApellido());
                            pst.setString(7, usuario.getEmail());
                            pst.setString(8, usuario.getTelefono());
                            pst.setObject(9, usuario.getTarjeta());
                            pst.setArray(10, usuario.getBookings());
                            pst.setInt(11, usuario.getNivel());

                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO usuarios (username, password, dni, nombre, apellido, email, telefono, tarjeta, bookings, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, usuario.getUsername());
                        pst.setString(2, usuario.getPassword());
                        pst.setString(3, usuario.getDni());
                        pst.setString(4, usuario.getUsername());
                        pst.setString(5, usuario.getNombre());
                        pst.setString(6, usuario.getApellido());
                        pst.setString(7, usuario.getEmail());
                        pst.setString(8, usuario.getTelefono());
                        pst.setObject(9, usuario.getTarjeta());
                        pst.setArray(10, usuario.getBookings());
                        pst.setInt(12, usuario.getNivel());
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    // Editar billete
    public Billete editarBillete(Billete billete) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeBillete = "SELECT id FROM billetes";
                try {
                    ResultSet rs = stmt.executeQuery(existeBillete);
                    boolean encontrado = false;
                    while (rs.next()) {
                        if (rs.getInt("id") == billete.getId()) {

                            String sqlUpdate = "UPDATE billetes SET (vuelos, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, '?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setArray(1, billete.getVuelos());
                            pst.setInt(2, billete.getNumPasajerosAdultos());
                            pst.setInt(3, billete.getNumPasajerosNinyios());
                            pst.setInt(4, billete.getNumMaletas());
                            pst.setInt(5, billete.getClase());
                            pst.setFloat(6, billete.getPrecio());

                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO billetes (vuelos, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, '?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setArray(1, billete.getVuelos());
                        pst.setInt(2, billete.getNumPasajerosAdultos());
                        pst.setInt(3, billete.getNumPasajerosNinyios());
                        pst.setInt(4, billete.getNumMaletas());
                        pst.setInt(5, billete.getClase());
                        pst.setFloat(6, billete.getPrecio());
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return billete;
    }

    // Editar vuelo
    public Vuelo editarVuelo(Vuelo vuelo) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeVuelo = "SELECT id FROM vuelos";
                try {
                    ResultSet rs = stmt.executeQuery(existeVuelo);
                    boolean encontrado = false;
                    while (rs.next()) {
                        if (rs.getInt("id") == vuelo.getId()) {
                            String sqlUpdate = "UPDATE vuelos SET (aerolinea, designator, origen_iata, destino_iata, precio_base_adulto, precio_base_ninyio, precio_maleta, fecha_origen, fecha_destino, asientos_clase_1, asientos_clase_2, asientos_clase_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);
                            pst.setString(1, vuelo.getAerolinea());
                            pst.setString(2, vuelo.getDesignator());
                            pst.setObject(3, vuelo.getAeropuertOrigen());
                            pst.setObject(4, vuelo.getAeropuertoDestino());
                            pst.setFloat(5, vuelo.getPrecioBaseAdulto());
                            pst.setFloat(6, vuelo.getPrecioBaseNinyio());
                            pst.setFloat(7, vuelo.getPrecioMaleta());
                            pst.setCalendar(8, vuelo.getFechaOrigen());
                            pst.setDate(9, vuelo.getFechaDestino());
                            pst.setFloat(10, vuelo.getAsientosClase1());
                            pst.setFloat(11, vuelo.getAsientosClase2());
                            pst.setFloat(12, vuelo.getAsientosClase3());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        String sqlInsert = "INSERT INTO vuelos (aerolinea, designator, origen_iata, destino_iata, precio_base_adulto, precio_base_ninyio, precio_maleta, fecha_origen, fecha_destino, asientos_clase_1, asientos_clase_2, asientos_clase_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);
                        pst.setString(1, vuelo.getAerolinea());
                        pst.setString(2, vuelo.getDesignator());
                        pst.setObject(3, vuelo.getAeropuertOrigen());
                        pst.setObject(4, vuelo.getAeropuertoDestino());
                        pst.setFloat(5, vuelo.getPrecioBaseAdulto());
                        pst.setFloat(6, vuelo.getPrecioBaseNinyio());
                        pst.setFloat(7, vuelo.getPrecioMaleta());
                        pst.setCalendar(8, vuelo.getFechaOrigen());
                        pst.setString(9, vuelo.getFechaDestino());
                        pst.setFloat(10, vuelo.getAsientosClase1());
                        pst.setFloat(11, vuelo.getAsientosClase2());
                        pst.setFloat(12, vuelo.getAsientosClase3());
                        pst.executeUpdate();
                        pst.close();
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vuelo;
    }

    // Eliminar aeropuerto
    public void eliminarAeropuerto(Aeropuerto aeropuerto) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "DELETE FROM aeropuertos WHERE id = ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == aeropuerto.getId()) {
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setObject(1, aeropuerto);
                            pst.executeQuery();
                            pst.close();
                            break;
                        }
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Eliminar user
    public void eliminarUsuario(Usuario usuario) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "DELETE FROM usuarios WHERE id = ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == usuario.getId()) {
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setObject(1, usuario);
                            pst.executeQuery();
                            pst.close();
                            break;
                        }
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Eliminar billete
    public void eliminarBillete(Billete billete) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "DELETE FROM billetes WHERE id = ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == billete.getId()) {
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setObject(1, billete);
                            pst.executeQuery();
                            pst.close();
                            break;
                        }
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Eliminar vuelo
    public void eliminarVuelo(Vuelo vuelo) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "DELETE FROM vuelos WHERE id = ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == vuelo.getId()) {
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setObject(1, vuelo);
                            pst.executeQuery();
                            pst.close();
                            break;
                        }
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Buscar aeropuerto
    public ArrayList<HashMap<String, String>> leerAeropuerto() {
        String sql = "SELECT * FROM aeropuertos";
        ArrayList<HashMap<String, String>> listaDeHashMaps = new ArrayList<HashMap<String, String>>();
        try {

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (listaDeHashMaps != null) {
            return listaDeHashMaps;
        } else {
            return null;
        }
        // Buscar user
        // Buscar booking
        // Buscar vuelo

    }
}
