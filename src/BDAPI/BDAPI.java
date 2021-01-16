package BDAPI;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;

import Jerarquias.Admin;
import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Cliente;
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
        
        String queryCreateTableClientes = "CREATE TABLE IF NOT EXISTS clientes (\n" + "	id integer PRIMARY KEY,\n"
                + "	username text NOT NULL UNIQUE,\n" + "	password text NOT NULL,\n" + "	dni text UNIQUE,\n"
                + "	nombre text,\n" + "	apellido text,\n" + "	email text,\n" + "	telefono text\n"
                + ");";

        String queryCreateTableAdmins = "CREATE TABLE IF NOT EXISTS admins (\n" + "	id integer PRIMARY KEY,\n"
        + "	username text NOT NULL UNIQUE,\n" + "	password text NOT NULL,\n" + "	nivel integer\n" + ");";

        String queryCreateTableVuelos = "CREATE TABLE IF NOT EXISTS vuelos (\n" + "	id integer PRIMARY KEY,\n"
                + "	aerolinea text NOT NULL,\n" + "	designator text NOT NULL,\n" + "aeropuerto_origen integer,\n"
                + " aeropuerto_destino integer,\n" + "	precio_base_adulto real NOT NULL,\n"
                + "	precio_base_ninyio real NOT NULL,\n" + "	precio_maleta real NOT NULL,\n"
                + "	fecha text NOT NULL,\n" + "	asientos_clase_1 integer NOT NULL,\n" + "	asientos_clase_2 integer NOT NULL,\n"
                + "	asientos_clase_3 integer NOT NULL,\n"
                + " FOREIGN KEY(aeropuerto_origen) REFERENCES aeropuertos(id),\n"
                + " FOREIGN KEY(aeropuerto_destino) REFERENCES aeropuertos(id)\n" + ");";

        String queryCreateTableBilletes = "CREATE TABLE IF NOT EXISTS billetes (\n" + "	id integer PRIMARY KEY,\n" + "	cliente integer NOT NULL,\n"
                + "	vuelo integer NOT NULL,\n" + "	numero_pasajeros_adultos integer NOT NULL,\n"
                + "	numero_pasajeros_ninyios integer NOT NULL,\n" + "	numero_maletas integer NOT NULL,\n"
                + "	clase integer NOT NULL,\n" + "	precio real NOT NULL,\n"
                + " FOREIGN KEY(vuelo) REFERENCES vuelos(id)\n" + " FOREIGN KEY(usuario) REFERENCES usuarios(id)\n"
                + ");";
                        
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(queryCreateTableAeropuertos);
                stmt.execute(queryCreateTableClientes);
                stmt.execute(queryCreateTableAdmins);
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

                            String sqlUpdate = "UPDATE aeropuertos SET (nombre, iata, ciudad, pais) VALUES (?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, aeropuerto.getNombre());
                            pst.setString(2, aeropuerto.getIATA());
                            pst.setString(3, aeropuerto.getCiudad());
                            pst.setString(4, aeropuerto.getPais());
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
    public Cliente editarCliente(Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeCliente = "SELECT id FROM clientes";
                try {
                    ResultSet rs = stmt.executeQuery(existeCliente);
                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getInt("id") == cliente.getId()) {

                            String sqlUpdate = "UPDATE clientes SET(username, password, dni, nombre, apellido, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, cliente.getUsername());
                            pst.setString(2, cliente.getPassword());
                            pst.setString(3, cliente.getDni());
                            pst.setString(4, cliente.getNombre());
                            pst.setString(5, cliente.getApellido());
                            pst.setString(6, cliente.getEmail());
                            pst.setString(7, cliente.getTelefono());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO clientes SET(username, password, dni, nombre, apellido, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, cliente.getUsername());
                        pst.setString(2, cliente.getPassword());
                        pst.setString(3, cliente.getDni());
                        pst.setString(4, cliente.getNombre());
                        pst.setString(5, cliente.getApellido());
                        pst.setString(6, cliente.getEmail());
                        pst.setString(7, cliente.getTelefono());
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
        return cliente;
    }

    // Editar admin
    public Admin editarCliente(Admin admin) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeAdmin = "SELECT id FROM admin";
                try {
                    ResultSet rs = stmt.executeQuery(existeAdmin);
                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getInt("id") == admin.getId()) {
                            String sqlUpdate = "UPDATE admin SET(username, password, nivel) VALUES (?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, admin.getUsername());
                            pst.setString(2, admin.getPassword());
                            pst.setInt(3, admin.getNivel());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO admin SET(username, password, nivel) VALUES (?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, admin.getUsername());
                        pst.setString(2, admin.getPassword());
                        pst.setInt(3, admin.getNivel());
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
        return admin;
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
                            String sqlUpdate = "UPDATE vuelos SET (aerolinea, designator, aeropuerto_origen, aeropuerto_destino, precio_base_adulto, precio_base_ninyio, precio_maleta, fecha, asientos_clase_1, asientos_clase_2, asientos_clase_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);
                            
                            pst.setString(1, vuelo.getAerolinea());
                            pst.setString(2, vuelo.getDesignator());
                            pst.setInt(3, vuelo.getAeropuertOrigen().getId());
                            pst.setInt(4, vuelo.getAeropuertoDestino().getId());
                            pst.setFloat(5, vuelo.getPrecioBaseAdulto());
                            pst.setFloat(6, vuelo.getPrecioBaseNinyio());
                            pst.setFloat(7, vuelo.getPrecioMaleta());
                            pst.setString(8, vuelo.getFecha());
                            pst.setInt(9, vuelo.getAsientosClase1());
                            pst.setInt(10, vuelo.getAsientosClase2());
                            pst.setInt(11, vuelo.getAsientosClase3());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        String sqlInsert = "INSERT INTO vuelos (aerolinea, designator, aeropuerto_origen, aeropuerto_destino, precio_base_adulto, precio_base_ninyio, precio_maleta, fecha_origen, fecha_destino, asientos_clase_1, asientos_clase_2, asientos_clase_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);
                        pst.setString(1, vuelo.getAerolinea());
                            pst.setString(2, vuelo.getDesignator());
                            pst.setInt(3, vuelo.getAeropuertOrigen().getId());
                            pst.setInt(4, vuelo.getAeropuertoDestino().getId());
                            pst.setFloat(5, vuelo.getPrecioBaseAdulto());
                            pst.setFloat(6, vuelo.getPrecioBaseNinyio());
                            pst.setFloat(7, vuelo.getPrecioMaleta());
                            pst.setString(8, vuelo.getFecha());
                            pst.setInt(9, vuelo.getAsientosClase1());
                            pst.setInt(10, vuelo.getAsientosClase2());
                            pst.setInt(11, vuelo.getAsientosClase3());
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

    // Editar billete
    public Billete editarBillete(Billete billete, Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeBillete = "SELECT id FROM billetes";
                try {
                    ResultSet rs = stmt.executeQuery(existeBillete);
                    boolean encontrado = false;
                    while (rs.next()) {
                        if (rs.getInt("id") == billete.getId()) {

                            String sqlUpdate = "UPDATE billetes SET (cliente, vuelo, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);
                            
                            pst.setInt(1, cliente.getId());
                            pst.setInt(2, billete.getVuelo().getId());
                            pst.setInt(3, billete.getNumPasajerosAdultos());
                            pst.setInt(4, billete.getNumPasajerosNinyios());
                            pst.setInt(5, billete.getNumMaletas());
                            pst.setInt(6, billete.getClase());
                            pst.setFloat(7, billete.getPrecio());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO billetes (cliente, vuelo, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setInt(1, cliente.getId());
                        pst.setObject(2, billete.getVuelo());
                        pst.setInt(3, billete.getNumPasajerosAdultos());
                        pst.setInt(4, billete.getNumPasajerosNinyios());
                        pst.setInt(5, billete.getNumMaletas());
                        pst.setInt(6, billete.getClase());
                        pst.setFloat(7, billete.getPrecio());
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

    // Eliminar aeropuerto
    public void eliminarAeropuerto(Aeropuerto aeropuerto) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "SELECT id from aeropuertos";
                String delete = "DELETE from aeropuertos WHERE id == ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == aeropuerto.getId()) {
                            PreparedStatement pst = conn.prepareStatement(delete);
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

    

    // Eliminar cliente
    public void eliminarCliente(Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "SELECT id from clientes";
                String delete = "DELETE from clientes WHERE id == ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == cliente.getId()) {
                            PreparedStatement pst = conn.prepareStatement(delete);
                            pst.setInt(1, cliente.getId());
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

    // Eliminar admin
    public void eliminarAdmin(Admin admin) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "SELECT id from admins";
                String delete = "DELETE from admins WHERE id == ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == admin.getId()) {
                            PreparedStatement pst = conn.prepareStatement(delete);
                            pst.setInt(1, admin.getId());
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
                String sql = "SELECT id from vuelos";
                String delete = "DELETE from vuelos WHERE id == ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == vuelo.getId()) {
                            PreparedStatement pst = conn.prepareStatement(delete);
                            pst.setInt(1, vuelo.getId());
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
                String sql = "SELECT id from billetes";
                String delete = "DELETE from billetes WHERE id == ?";
                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getInt("id") == billete.getId()) {
                            PreparedStatement pst = conn.prepareStatement(delete);
                            pst.setInt(1, billete.getId());
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

    // Listar aeropuertos
    public List<Aeropuerto> getListaAeropuertos() {
        String sql = "SELECT * FROM aeropuertos";
        List<Aeropuerto> listaAeropuertos = new ArrayList<Aeropuerto>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
           
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaAeropuertos.add(new Aeropuerto(rs.getInt("id"), rs.getString("nombre"), rs.getString("iata"),
                        rs.getString("ciudad"), rs.getString("pais")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaAeropuertos;
    }

    // Listar clientes
    public List<Cliente> getListaClientes() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
           
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaClientes.add(new Cliente(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaClientes;
    }

    // Listar admins
    public List<Admin> getListaAdmins() {
        String sql = "SELECT * FROM admins";
        List<Admin> listaAdmins = new ArrayList<Admin>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
        
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaAdmins.add(new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("nivel")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaAdmins;
    }
    
    // Listar aeropuertos

    // String sqlAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE id == ?";
    // String sqlAeropuertoDestino = "SELECT * FROM aeropuertos WHERE id == ?";
    // ResultSet rsAerpuertoOrigen = stmt.executeQuery(sqlAeropuertoOrigen);
    // ResultSet rsAerpuertoDestino = stmt.executeQuery(sqlAeropuertoDestino);
    // PreparedStatement pstAeropuertoOrigen = conn.prepareStatement(sqlAeropuertoOrigen);
    // PreparedStatement pstAeropuertoDestino = conn.prepareStatement(sqlAeropuertoDestino);

    // pstAeropuertoOrigen.setInt(1, rs.getInt("aeropuertoOrigen"));
    // pstAeropuertoDestino.setInt(1, rs.getInt("aeropuertoOrigen"));

    public List<Vuelo> getListaVuelos() {
        String sql = "SELECT * FROM vuelos";
        List<Vuelo> listaVuelos = new ArrayList<Vuelo>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                String sqlAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE id == ?";
                String sqlAeropuertoDestino = "SELECT * FROM aeropuertos WHERE id == ?";
                
                ResultSet rsAerpuertoOrigen = stmt.executeQuery(sqlAeropuertoOrigen);
                ResultSet rsAerpuertoDestino = stmt.executeQuery(sqlAeropuertoDestino);
                
                PreparedStatement pstAeropuertoOrigen = conn.prepareStatement(sqlAeropuertoOrigen);
                PreparedStatement pstAeropuertoDestino = conn.prepareStatement(sqlAeropuertoDestino);
               
                pstAeropuertoOrigen.setInt(1, rs.getInt("aeropuertoOrigen"));
                pstAeropuertoDestino.setInt(1, rs.getInt("aeropuertoDestino"));

                rsAerpuertoOrigen = pstAeropuertoOrigen.executeQuery();
                rsAerpuertoDestino = pstAeropuertoDestino.executeQuery();

                listaVuelos.add(new Vuelo(rs.getInt("id"), rs.getString("aerolinea"), rs.getString("designator"), new Aeropuerto(rsAerpuertoOrigen.getInt("id"), rsAerpuertoOrigen.getString("nombre"), rsAerpuertoOrigen.getString("IATA"), rsAerpuertoOrigen.getString("ciudad"), rsAerpuertoOrigen.getString("pais")), new Aeropuerto(rsAerpuertoDestino.getInt("id"), rsAerpuertoDestino.getString("nombre"), rsAerpuertoDestino.getString("IATA"), rsAerpuertoDestino.getString("ciudad"), rsAerpuertoDestino.getString("pais")), rs.getFloat("precio_base_adulto"), rs.getFloat("precio_base_ninyio"), rs.getFloat("precio_maleta"), rs.getString("fecha"), rs.getInt("asientos_clase_1"), rs.getInt("asientos_clase_2"), rs.getInt("asientos_clase_3")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaVuelos;
    }

    public List<Billete> getListaBilletes() {
        String sql = "SELECT * FROM billetes";
        List<Billete> listaBilletes = new ArrayList<Billete>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                String sqlCliente = "SELECT * FROM clientes WHERE id == ?";
                String sqlVuelo = "SELECT * FROM vuelos WHERE id == ?";
                String sqlAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE id == ?";
                String sqlAeropuertoDestino = "SELECT * FROM aeropuertos WHERE id == ?";
                
                ResultSet rsCliente = stmt.executeQuery(sqlCliente);
                ResultSet rsVuelo = stmt.executeQuery(sqlVuelo);
                ResultSet rsAerpuertoOrigen = stmt.executeQuery(sqlAeropuertoOrigen);
                ResultSet rsAerpuertoDestino = stmt.executeQuery(sqlAeropuertoDestino);
                
                PreparedStatement pstCliente = conn.prepareStatement(sqlCliente);
                PreparedStatement pstVuelo = conn.prepareStatement(sqlVuelo);
                PreparedStatement pstAeropuertoOrigen = conn.prepareStatement(sqlAeropuertoOrigen);
                PreparedStatement pstAeropuertoDestino = conn.prepareStatement(sqlAeropuertoDestino);
                
                pstCliente.setInt(1, rs.getInt("cliente"));
                pstVuelo.setInt(1, rs.getInt("vuelo"));
                pstAeropuertoOrigen.setInt(1, rs.getInt("aeropuertoOrigen"));
                pstAeropuertoDestino.setInt(1, rs.getInt("aeropuertoDestino"));

                rsCliente = pstCliente.executeQuery();
                rsVuelo = pstVuelo.executeQuery();
                rsAerpuertoOrigen = pstAeropuertoOrigen.executeQuery();
                rsAerpuertoDestino = pstAeropuertoDestino.executeQuery();

                listaBilletes.add(new Billete(
                        rs.getInt("id"), new Cliente(rsCliente.getInt("id"), rsCliente.getString("username"), rsCliente.getString("password"), rsCliente.getString("dni"), rsCliente.getString("nombre"), rsCliente.getString("apellido"), rsCliente.getString("email"), rsCliente.getString("telefono")),new Vuelo(rsVuelo.getInt("id"), rsVuelo.getString("aerolinea"), rsVuelo.getString("designator"), new Aeropuerto(rsAerpuertoOrigen.getInt("id"), rsAerpuertoOrigen.getString("nombre"), rsAerpuertoOrigen.getString("IATA"), rsAerpuertoOrigen.getString("ciudad"), rsAerpuertoOrigen.getString("pais")), new Aeropuerto(rsAerpuertoDestino.getInt("id"), rsAerpuertoDestino.getString("nombre"), rsAerpuertoDestino.getString("IATA"), rsAerpuertoDestino.getString("ciudad"), rsAerpuertoDestino.getString("pais")), rs.getFloat("precio_base_adulto"), rs.getFloat("precio_base_ninyio"), rs.getFloat("precio_maleta"), rs.getString("fecha"), rs.getInt("asientos_clase_1"), rs.getInt("asientos_clase_2"), rs.getInt("asientos_clase_3")) , rs.getInt("numero_pasajeros_adultos"), rs.getInt("numero_pasajeros_ninyios"), rs.getInt("numero_maletas"), rs.getInt("clase"), rs.getFloat("precio")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaBilletes;
    }

    
    // public Vuelo getVueloIdaDisponible(Vuelo vuelo) {
    // try (Connection conn = DriverManager.getConnection(url); Statement stmt =
    // conn.createStatement()) {
    // if (conn != null) {
    // String existeVueloIda = "SELECT id FROM vuelos WHERE aeropuerto_origen == ?,
    // aeropuerto_destino == ?, fecha_origen == ?";
    // try {
    // ResultSet rs = stmt.executeQuery(existeVuelo);
    // boolean encontrado = false;
    // while (rs.next()) {
    // String sqlUpdate = "UPDATE vuelos SET (asientos_clase_1, asientos_clase_2,
    // asientos_clase_3) VALUES (?, ?, ?)";
    // PreparedStatement pst = conn.prepareStatement(sqlUpdate);
    // pst.setInt(10, vuelo.getAsientosClase1());
    // pst.setInt(11, vuelo.getAsientosClase2());
    // pst.setInt(12, vuelo.getAsientosClase3());
    // pst.executeUpdate();
    // pst.close();
    // encontrado = true;
    // break;
    // }

    // } catch (SQLException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // } catch (SQLException e) {
    // System.out.println(e.getMessage());
    // }
    // return vuelo;
    // }

    //
    public Vuelo getVueloIda(Vuelo vuelo) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                try {
                    String sqlExisteVuelo = "SELECT id FROM vuelos WHERE aeropuerto_origen == ? AND aeropuerto_destino == ? AND fecha == ?";
                    // String sqlexisteVuelo = "SELECT a1.id FROM vuelos v1, vuelos v2, aeropuertos a1, aeropuertos a2 WHERE v1.aeropuerto_origen == a1.id AND v2.aeropuerto_destino == a2.id AND a1.ciudad == ? AND a2.ciudad == ? AND v1.fecha == ? AND v2.fecha == ? AND v1.fecha ==  v2.fecha";
                    PreparedStatement pst = conn.prepareStatement(sqlExisteVuelo);
                    ResultSet rs = stmt.executeQuery(sqlExisteVuelo);
                    while (rs.next()) {
                        String sqlExisteAeropuertoOrigen = "SELECT id FROM aeropuerto WHERE ciudad == ?";
                        String sqlExisteAeropuertoDestino = "SELECT id FROM aeropuerto WHERE ciudad == ?";

                        ResultSet rsAerpuertoOrigen = stmt.executeQuery(sqlExisteAeropuertoOrigen);
                        ResultSet rsAerpuertoDestino = stmt.executeQuery(sqlExisteAeropuertoDestino);

                        PreparedStatement pstExisteAeropuertoOrigen = conn.prepareStatement(sqlExisteAeropuertoOrigen);
                        PreparedStatement pstExisteAeropuertoDestino = conn
                                .prepareStatement(sqlExisteAeropuertoDestino);

                        pstExisteAeropuertoOrigen.setObject(1, vuelo.getAeropuertOrigen().getCiudad());
                        pstExisteAeropuertoDestino.setObject(1, vuelo.getAeropuertoDestino().getCiudad());

                        pst.setString(1, vuelo.getAeropuertOrigen().getCiudad());
                        pst.setString(2, vuelo.getAeropuertoDestino().getCiudad());

                        rsAerpuertoOrigen = pstExisteAeropuertoOrigen.executeQuery();
                        rsAerpuertoDestino = pstExisteAeropuertoDestino.executeQuery();

                        pst.setObject(1, rsAerpuertoOrigen);
                        pst.setObject(3, rsAerpuertoDestino);
                        pst.setString(3, vuelo.getFecha());
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

}
