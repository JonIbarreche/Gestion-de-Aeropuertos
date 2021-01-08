package BDAPI;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                + "	tarjeta text,\n" + "	billetes text,\n" + "	nivel integer\n" + ");";

        String queryCreateTableBilletes = "CREATE TABLE IF NOT EXISTS billetes (\n" + "	id integer PRIMARY KEY,\n"
                + "	vuelos text NOT NULL,\n" + "	numero_pasajeros_adultos integer NOT NULL,\n"
                + "	numero_pasajeros_ninyios integer NOT NULL,\n" + "	numero_maletas integer NOT NULL,\n"
                + "	clase integer NOT NULL,\n" + "	precio real NOT NULL\n" + ");";

        String queryCreateTableVuelos = "CREATE TABLE IF NOT EXISTS vuelos (\n" + "	id integer PRIMARY KEY,\n"
                + "	aerolinea text NOT NULL,\n" + "	designator text NOT NULL,\n" + "	origen_iata text NOT NULL,\n" + "	destino_iata text NOT NULL,\n" + "	precio_base_adulto real NOT NULL,\n"
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
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO aeropuertos (nombre, iata, ciudad, pais) VALUES (?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, aeropuerto.getNombre());
                        pst.setString(2, aeropuerto.getIATA());
                        pst.setString(3, aeropuerto.getCiudad());
                        pst.setString(4, aeropuerto.getPais());
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

                            String sqlUpdate = "UPDATE usuarios SET(username, password, dni, nombre, apellido, email, telefono, tarjeta, billetes, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, usuario.getUsername());
                            pst.setString(2, usuario.getPassword());
                            pst.setString(3, usuario.getDni());
                            pst.setString(4, usuario.getNombre());
                            pst.setString(5, usuario.getApellido());
                            pst.setString(6, usuario.getEmail());
                            pst.setString(7, usuario.getTelefono());
                            pst.setObject(8, usuario.getTarjeta());
                            pst.setObject(9, usuario.getBilletes());
                            pst.setInt(10, usuario.getNivel());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO usuarios (username, password, dni, nombre, apellido, email, telefono, tarjeta, billetes, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, usuario.getUsername());
                        pst.setString(2, usuario.getPassword());
                        pst.setString(3, usuario.getDni());
                        pst.setString(4, usuario.getNombre());
                        pst.setString(5, usuario.getApellido());
                        pst.setString(6, usuario.getEmail());
                        pst.setString(7, usuario.getTelefono());
                        pst.setObject(8, usuario.getTarjeta());
                        pst.setObject(9, usuario.getBilletes());
                        pst.setInt(10, usuario.getNivel());
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

                            String sqlUpdate = "UPDATE billetes SET (vuelos, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setObject(1, billete.getVuelos());
                            pst.setInt(2, billete.getNumPasajerosAdultos());
                            pst.setInt(3, billete.getNumPasajerosNinyios());
                            pst.setInt(4, billete.getNumMaletas());
                            pst.setInt(5, billete.getClase());
                            pst.setFloat(6, billete.getPrecio());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO billetes (vuelos, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setObject(1, billete.getVuelos());
                        pst.setInt(2, billete.getNumPasajerosAdultos());
                        pst.setInt(3, billete.getNumPasajerosNinyios());
                        pst.setInt(4, billete.getNumMaletas());
                        pst.setInt(5, billete.getClase());
                        pst.setFloat(6, billete.getPrecio());
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
                            pst.setObject(8, vuelo.getFechaOrigen());
                            pst.setObject(9, vuelo.getFechaDestino());
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
                        pst.setObject(8, vuelo.getFechaOrigen());
                        pst.setObject(9, vuelo.getFechaDestino());
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
    public ArrayList<HashMap<String, String>> getAllAeropuertos() {
        String sql = "SELECT * FROM aeropuertos";
        ArrayList<HashMap<String, String>> listaAeropuertos = new ArrayList<HashMap<String, String>>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
        
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HashMap<String, String> mapaAeropuerto = new HashMap<String, String>();
                mapaAeropuerto.put("id", Integer.toString(rs.getInt("id")));
                mapaAeropuerto.put("nombre", rs.getString("nombre"));
                mapaAeropuerto.put("iata", rs.getString("iata"));
                mapaAeropuerto.put("ciudad", rs.getString("ciudad"));
                mapaAeropuerto.put("pais", rs.getString("pais"));
                listaAeropuertos.add(mapaAeropuerto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaAeropuertos;
    }

    // Buscar user

    public ArrayList<HashMap<String, String>> getAllUsuarios() {
        String sql = "SELECT * FROM usuarios";
        ArrayList<HashMap<String, String>> listaUsuarios = new ArrayList<HashMap<String, String>>();

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
    
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HashMap<String, String> mapaUsuario = new HashMap<String, String>();
                mapaUsuario.put("id", Integer.toString(rs.getInt("id")));
                mapaUsuario.put("username", rs.getString("username"));
                mapaUsuario.put("password", rs.getString("password"));
                mapaUsuario.put("dni", rs.getString("dni"));
                mapaUsuario.put("nombre", rs.getString("nombre"));
                mapaUsuario.put("apellido", rs.getString("apellido"));
                mapaUsuario.put("email", rs.getString("email"));
                mapaUsuario.put("telefono", rs.getString("telefono"));
                mapaUsuario.put("tarjeta", rs.getString("tarjeta"));
                mapaUsuario.put("billetes", rs.getString("billetes"));
                mapaUsuario.put("nivel", Integer.toString(rs.getInt("nivel")));
                listaUsuarios.add(mapaUsuario);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    
    // Buscar booking
    public ArrayList<HashMap<String, String>> getAllBilletes() {
        String sql = "SELECT * FROM billetes";
        ArrayList<HashMap<String, String>> listaBilletes = new ArrayList<HashMap<String, String>>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
                  
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HashMap<String, String> mapaBillete = new HashMap<String, String>();
                mapaBillete.put("id", Integer.toString(rs.getInt("id")));
                mapaBillete.put("vuelos", rs.getString("vuelos"));
                mapaBillete.put("numero_pasajeros_adultos", rs.getString("numero_pasajeros_adultos"));
                mapaBillete.put("numero_pasajeros_ninyios", rs.getString("numero_pasajeros_adultos"));
                mapaBillete.put("numero_maletas", Integer.toString(rs.getInt("numero_maletas")));
                mapaBillete.put("clase", Integer.toString(rs.getInt("clase")));
                mapaBillete.put("precio", Float.toString(rs.getFloat("precio")));
                listaBilletes.add(mapaBillete);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaBilletes;
    }
    
    // Buscar vuelo
    public ArrayList<HashMap<String, String>> getAllVuelos() {
        String sql = "SELECT * FROM vuelos";
        ArrayList<HashMap<String, String>> listaVuelos = new ArrayList<HashMap<String, String>>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
           
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HashMap<String, String> mapaVuelo = new HashMap<String, String>();
                mapaVuelo.put("id", Integer.toString(rs.getInt("id")));
                mapaVuelo.put("aerolinea", rs.getString("aerolinea"));
                mapaVuelo.put("designator", rs.getString("designator"));
                mapaVuelo.put("origen_iata", rs.getString("origen_iata"));
                mapaVuelo.put("destino_iata", rs.getString("destino_iata"));
                mapaVuelo.put("precio_base_adulto", rs.getString("precio_base_adulto"));
                mapaVuelo.put("precio_base_ninyio", rs.getString("precio_base_ninyio"));
                mapaVuelo.put("precio_maleta", rs.getString("precio_maleta"));
                mapaVuelo.put("fecha_origen", rs.getString("fecha_origen"));
                mapaVuelo.put("fecha_destino", rs.getString("fecha_destino"));
                mapaVuelo.put("asientos_clase_1", Integer.toString(rs.getInt("asientos_clase_1")));
                mapaVuelo.put("asientos_clase_2", Integer.toString(rs.getInt("asientos_clase_2")));
                mapaVuelo.put("asientos_clase_3", Integer.toString(rs.getInt("asientos_clase_3")));
                listaVuelos.add(mapaVuelo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaVuelos;
    }

}
