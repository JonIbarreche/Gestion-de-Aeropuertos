package BDAPI;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.ResultSet;

import Jerarquias.Admin;
import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Cliente;
import Jerarquias.Usuario;
import Jerarquias.Vuelo;
import logger.Log;

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
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n" + "	nombre text NOT NULL,\n"
                + "	iata text NOT NULL UNIQUE,\n" + "	ciudad text NOT NULL,\n" + "	pais text NOT NULL\n" + ");";

        String queryCreateTableClientes = "CREATE TABLE IF NOT EXISTS clientes (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n" + "	username text NOT NULL UNIQUE,\n"
                + "	password text NOT NULL,\n" + "	dni text UNIQUE,\n" + "	nombre text,\n" + "	apellido text,\n"
                + "	email text,\n" + "	telefono text\n" + ");";

        String queryCreateTableAdmins = "CREATE TABLE IF NOT EXISTS admins (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n" + "	username text NOT NULL UNIQUE,\n"
                + "	password text NOT NULL,\n" + "	nivel integer\n" + ");";

        String queryCreateTableVuelos = "CREATE TABLE IF NOT EXISTS vuelos (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n" + "	aerolinea text NOT NULL,\n"
                + "	designator text NOT NULL UNIQUE,\n" + "aeropuerto_origen integer,\n"
                + " aeropuerto_destino integer,\n" + "	precio_base_adulto real NOT NULL,\n"
                + "	precio_base_ninyio real NOT NULL,\n" + "	precio_maleta real NOT NULL,\n"
                + "	fecha text NOT NULL,\n" + "	hora text NOT NULL,\n" + "	asientos_clase_1 integer NOT NULL,\n"
                + "	asientos_clase_2 integer NOT NULL,\n" + "	asientos_clase_3 integer NOT NULL,\n"
                + " FOREIGN KEY(aeropuerto_origen) REFERENCES aeropuertos(id),\n"
                + " FOREIGN KEY(aeropuerto_destino) REFERENCES aeropuertos(id)\n" + ");";

        String queryCreateTableBilletes = "CREATE TABLE IF NOT EXISTS billetes (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n" + "	cliente integer NOT NULL,\n"
                + "	vuelo integer NOT NULL,\n" + "	numero_pasajeros_adultos integer NOT NULL,\n"
                + "	numero_pasajeros_ninyios integer NOT NULL,\n" + "	numero_maletas integer NOT NULL,\n"
                + "	clase integer NOT NULL,\n" + "	precio real NOT NULL,\n"
                + " FOREIGN KEY(vuelo) REFERENCES vuelos(id)\n" + " FOREIGN KEY(cliente) REFERENCES clientes(id)\n"
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
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Conexion con la base de datos establecida");
    }

    // Editar aeropuerto
    public Aeropuerto editarAeropuerto(Aeropuerto aeropuerto) {
        Aeropuerto tmpAeropuerto = aeropuerto;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeAeropuerto = "SELECT id FROM aeropuertos";

                try {
                    ResultSet rs = stmt.executeQuery(existeAeropuerto);
                    boolean encontrado = false;
                    while (rs.next()) {
                        if (rs.getInt("id") == tmpAeropuerto.getId()) {

                            String sqlUpdate = "UPDATE aeropuertos SET (nombre, iata, ciudad, pais) VALUES (?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, tmpAeropuerto.getNombre());
                            pst.setString(2, tmpAeropuerto.getIATA());
                            pst.setString(3, tmpAeropuerto.getCiudad());
                            pst.setString(4, tmpAeropuerto.getPais());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO aeropuertos (nombre, iata, ciudad, pais) VALUES (?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, tmpAeropuerto.getNombre());
                        pst.setString(2, tmpAeropuerto.getIATA());
                        pst.setString(3, tmpAeropuerto.getCiudad());
                        pst.setString(4, tmpAeropuerto.getPais());
                        pst.executeUpdate();
                        pst.close();

                        String sqlSelectId = "SELECT id FROM aeropuertos WHERE ciudad = ?";
                        PreparedStatement pstId = conn.prepareStatement(sqlSelectId);

                        pstId.setString(1, tmpAeropuerto.getCiudad());
                        ResultSet rsID = pstId.executeQuery();
                        tmpAeropuerto.setId(rsID.getInt("id"));

                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Aeropuerto actualizado correctamente");
        return tmpAeropuerto;
    }

    // Editar cliente
    public Cliente editarCliente(Cliente cliente) {
        Cliente tmpCliente = cliente;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeCliente = "SELECT id FROM clientes";
                try {
                    ResultSet rs = stmt.executeQuery(existeCliente);
                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getInt("id") == tmpCliente.getId()) {

                            String sqlUpdate = "UPDATE clientes SET(username, password, dni, nombre, apellido, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, tmpCliente.getUsername());
                            pst.setString(2, tmpCliente.getPassword());
                            pst.setString(3, tmpCliente.getDni());
                            pst.setString(4, tmpCliente.getNombre());
                            pst.setString(5, tmpCliente.getApellido());
                            pst.setString(6, tmpCliente.getEmail());
                            pst.setString(7, tmpCliente.getTelefono());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO clientes (username, password, dni, nombre, apellido, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, tmpCliente.getUsername());
                        pst.setString(2, tmpCliente.getPassword());
                        pst.setString(3, tmpCliente.getDni());
                        pst.setString(4, tmpCliente.getNombre());
                        pst.setString(5, tmpCliente.getApellido());
                        pst.setString(6, tmpCliente.getEmail());
                        pst.setString(7, tmpCliente.getTelefono());
                        pst.executeUpdate();
                        pst.close();

                        String sqlSelectId = "SELECT id FROM clientes WHERE username = ?";
                        PreparedStatement pstId = conn.prepareStatement(sqlSelectId);

                        pstId.setString(1, tmpCliente.getUsername());
                        ResultSet rsID = pstId.executeQuery();
                        tmpCliente.setId(rsID.getInt("id"));
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Cliente actualizado correctamente");
        return cliente;
    }

    // Editar admin
    public Admin editarAdmin(Admin admin) {
        Admin tmpAdmin = admin;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeAdmin = "SELECT id FROM admins";
                try {
                    ResultSet rs = stmt.executeQuery(existeAdmin);
                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getInt("id") == tmpAdmin.getId()) {
                            String sqlUpdate = "UPDATE admins SET (username, password, nivel) VALUES (?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setString(1, tmpAdmin.getUsername());
                            pst.setString(2, tmpAdmin.getPassword());
                            pst.setInt(3, tmpAdmin.getNivel());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO admins (username, password, nivel) VALUES (?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setString(1, tmpAdmin.getUsername());
                        pst.setString(2, tmpAdmin.getPassword());
                        pst.setInt(3, tmpAdmin.getNivel());
                        pst.executeUpdate();
                        pst.close();

                        String sqlSelectId = "SELECT id FROM admins WHERE username = ?";
                        PreparedStatement pstId = conn.prepareStatement(sqlSelectId);

                        pstId.setString(1, tmpAdmin.getUsername());
                        ResultSet rsID = pstId.executeQuery();
                        tmpAdmin.setId(rsID.getInt("id"));
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Admin actualizado correctamente");
        return admin;
    }

    // Editar vuelo
    public Vuelo editarVuelo(Vuelo vuelo) {
        Vuelo tmpVuelo = vuelo;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeVuelo = "SELECT id FROM vuelos";
                try {
                    ResultSet rs = stmt.executeQuery(existeVuelo);
                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getInt("id") == tmpVuelo.getId()) {
                            String sqlUpdate = "UPDATE vuelos SET (aerolinea, designator, aeropuerto_origen, aeropuerto_destino, precio_base_adulto, precio_base_ninyio, precio_maleta, fecha, hora, asientos_clase_1, asientos_clase_2, asientos_clase_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);
 
                            pst.setString(1, tmpVuelo.getAerolinea());
                            pst.setString(2, tmpVuelo.getDesignator());
                            pst.setInt(3, tmpVuelo.getAeropuertOrigen().getId());
                            pst.setInt(4, tmpVuelo.getAeropuertoDestino().getId());
                            pst.setFloat(5, tmpVuelo.getPrecioBaseAdulto());
                            pst.setFloat(6, tmpVuelo.getPrecioBaseNinyio());
                            pst.setFloat(7, tmpVuelo.getPrecioMaleta());
                            pst.setString(8, tmpVuelo.getFecha());
                            pst.setString(9, tmpVuelo.getHora());
                            pst.setInt(10, tmpVuelo.getAsientosClase1());
                            pst.setInt(11, tmpVuelo.getAsientosClase2());
                            pst.setInt(12, tmpVuelo.getAsientosClase3());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        String sqlInsert = "INSERT INTO vuelos (aerolinea, designator, aeropuerto_origen, aeropuerto_destino, precio_base_adulto, precio_base_ninyio, precio_maleta, fecha, hora, asientos_clase_1, asientos_clase_2, asientos_clase_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);
                        pst.setString(1, tmpVuelo.getAerolinea());
                        pst.setString(2, tmpVuelo.getDesignator());
                        pst.setInt(3, tmpVuelo.getAeropuertOrigen().getId());
                        pst.setInt(4, tmpVuelo.getAeropuertoDestino().getId());
                        pst.setFloat(5, tmpVuelo.getPrecioBaseAdulto());
                        pst.setFloat(6, tmpVuelo.getPrecioBaseNinyio());
                        pst.setFloat(7, tmpVuelo.getPrecioMaleta());
                        pst.setString(8, tmpVuelo.getFecha());
                        pst.setString(9, tmpVuelo.getHora());
                        pst.setInt(10, tmpVuelo.getAsientosClase1());
                        pst.setInt(11, tmpVuelo.getAsientosClase2());
                        pst.setInt(12, tmpVuelo.getAsientosClase3());
                        pst.executeUpdate();
                        pst.close();

                        String sqlSelectId = "SELECT id FROM vuelos WHERE designator = ?";
                        PreparedStatement pstId = conn.prepareStatement(sqlSelectId);

                        pstId.setString(1, tmpVuelo.getDesignator());
                        ResultSet rsID = pstId.executeQuery();
                        tmpVuelo.setId(rsID.getInt("id"));
                    }
                } catch (SQLException e) {
                    logger.Log.getLOGGER().log(Level.SEVERE,e.toString());
                  }
            }
        } catch (SQLException e) {
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Vuelo actualizado correctamente");
        return vuelo;
    }

    // Editar billete
    public Billete editarBillete(Billete billete, String cliente) {
        Billete tmpBillete = billete;
        int tmpClienteId;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String existeBillete = "SELECT id FROM billetes";
                try {

                    String sqlClienteId = "SELECT id FROM clientes WHERE username = ?";
                    PreparedStatement pstClienteId = conn.prepareStatement(sqlClienteId);
                    pstClienteId.setString(1, cliente);
                    ResultSet rsClienteId = pstClienteId.executeQuery();
                    tmpClienteId = rsClienteId.getInt("id");

                    ResultSet rs = stmt.executeQuery(existeBillete);
                    boolean encontrado = false;
                    while (rs.next()) {
                        if (rs.getInt("id") == tmpBillete.getId()) {

                            String sqlUpdate = "UPDATE billetes SET (cliente, vuelo, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = conn.prepareStatement(sqlUpdate);

                            pst.setInt(1, tmpClienteId);
                            pst.setInt(2, tmpBillete.getVuelo().getId());
                            pst.setInt(3, tmpBillete.getNumPasajerosAdultos());
                            pst.setInt(4, tmpBillete.getNumPasajerosNinyios());
                            pst.setInt(5, tmpBillete.getNumMaletas());
                            pst.setInt(6, tmpBillete.getClase());
                            pst.setFloat(7, tmpBillete.getPrecio());
                            pst.executeUpdate();
                            pst.close();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {

                        String sqlInsert = "INSERT INTO billetes (cliente, vuelo, numero_pasajeros_adultos, numero_pasajeros_ninyios, numero_maletas, clase, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sqlInsert);

                        pst.setInt(1, tmpClienteId);
                        pst.setObject(2, tmpBillete.getVuelo());
                        pst.setInt(3, tmpBillete.getNumPasajerosAdultos());
                        pst.setInt(4, tmpBillete.getNumPasajerosNinyios());
                        pst.setInt(5, tmpBillete.getNumMaletas());
                        pst.setInt(6, tmpBillete.getClase());
                        pst.setFloat(7, tmpBillete.getPrecio());
                        pst.executeUpdate();
                        pst.close();

                        String sqlSelectId = "SELECT id FROM billetes WHERE cliente = ? AND vuelo = ?";
                        PreparedStatement pstId = conn.prepareStatement(sqlSelectId);

                        pstId.setInt(1, tmpBillete.getCliente().getId());
                        pstId.setInt(2, tmpBillete.getVuelo().getId());
                        ResultSet rsID = pstId.executeQuery();
                        pstId.close();
                        tmpBillete.setId(rsID.getInt("id"));
                        
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
                    logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Billete actualizado correctamente");
        return tmpBillete;
    }

    // Eliminar aeropuerto
    public void eliminarAeropuerto(Aeropuerto aeropuerto) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "SELECT id from aeropuertos";
                String delete = "DELETE from aeropuertos WHERE id = ?";
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
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Aeropuerto eliminado correctamente");
    }

    // Eliminar cliente
    public void eliminarCliente(Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "SELECT id from clientes";
                String delete = "DELETE from clientes WHERE id = ?";
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
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Cliente eliminado correctamente");
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
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Admin eliminado correctamente");
    }

    // Eliminar vuelo
    public void eliminarVuelo(Vuelo vuelo) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "SELECT id from vuelos";
                String delete = "DELETE from vuelos WHERE id = ?";
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
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Vuelo elimindado correctamente");
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
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Billete eliminado correctamente");
    }

    // Listar aeropuertos
    public List<Aeropuerto> getListaAeropuertos() {
        String sql = "SELECT * FROM aeropuertos";
        List<Aeropuerto> listaAeropuertos = new ArrayList<Aeropuerto>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Aeropuerto a1 = new Aeropuerto(rs.getString("nombre"), rs.getString("iata"), rs.getString("ciudad"),
                        rs.getString("pais"));
                a1.setId(rs.getInt("id"));
                listaAeropuertos.add(a1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Lista de aeropouertos obtenida correctamente");
        return listaAeropuertos;
    }

    // Listar clientes
    public List<Cliente> getListaClientes() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaClientes.add(new Cliente(rs.getString("username"), rs.getString("password"), rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"),
                        rs.getString("telefono")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Lista de clientes obtenida correctamente");
        return listaClientes;
    }

    // Listar admins
    public List<Admin> getListaAdmins() {
        String sql = "SELECT * FROM admins";
        List<Admin> listaAdmins = new ArrayList<Admin>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaAdmins.add(new Admin(rs.getString("username"), rs.getString("password"), rs.getInt("nivel")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Lista de admins obtenida correctamente");
        return listaAdmins;
    }

    // Listar aeropuertos

    // String sqlAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE id == ?";
    // String sqlAeropuertoDestino = "SELECT * FROM aeropuertos WHERE id == ?";
    // ResultSet rsAeropuertoOrigen = stmt.executeQuery(sqlAeropuertoOrigen);
    // ResultSet rsAeropuertoDestino = stmt.executeQuery(sqlAeropuertoDestino);
    // PreparedStatement pstAeropuertoOrigen =
    // conn.prepareStatement(sqlAeropuertoOrigen);
    // PreparedStatement pstAeropuertoDestino =
    // conn.prepareStatement(sqlAeropuertoDestino);

    // pstAeropuertoOrigen.setInt(1, rs.getInt("aeropuertoOrigen"));
    // pstAeropuertoDestino.setInt(1, rs.getInt("aeropuertoOrigen"));

    public List<Vuelo> getListaVuelos() {
        String sql = "SELECT * FROM vuelos";
        List<Vuelo> listaVuelos = new ArrayList<Vuelo>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String sqlAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE id = ?";
                String sqlAeropuertoDestino = "SELECT * FROM aeropuertos WHERE id = ?";

                PreparedStatement pstAeropuertoOrigen = conn.prepareStatement(sqlAeropuertoOrigen);
                PreparedStatement pstAeropuertoDestino = conn.prepareStatement(sqlAeropuertoDestino);
                
                pstAeropuertoOrigen.setInt(1, rs.getInt("aeropuerto_origen"));
                pstAeropuertoDestino.setInt(1, rs.getInt("aeropuerto_destino"));
                
                ResultSet rsAeropuertoOrigen = pstAeropuertoOrigen.executeQuery();
                ResultSet rsAeropuertoDestino = pstAeropuertoDestino.executeQuery();
                
                listaVuelos.add(new Vuelo(rs.getString("aerolinea"), rs.getString("designator"),
                        new Aeropuerto(rsAeropuertoOrigen.getString("nombre"), rsAeropuertoOrigen.getString("IATA"),
                                rsAeropuertoOrigen.getString("ciudad"), rsAeropuertoOrigen.getString("pais")),
                        new Aeropuerto(rsAeropuertoDestino.getString("nombre"), rsAeropuertoDestino.getString("IATA"),
                                rsAeropuertoDestino.getString("ciudad"), rsAeropuertoDestino.getString("pais")),
                        rs.getFloat("precio_base_adulto"), rs.getFloat("precio_base_ninyio"),
                        rs.getFloat("precio_maleta"), rs.getString("fecha"), rs.getString("hora"), rs.getInt("asientos_clase_1"),
                        rs.getInt("asientos_clase_2"), rs.getInt("asientos_clase_3")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Lista de vuelos obtenida correctamente");
        return listaVuelos;
    }

    public List<Billete> getListaBilletes() {
        String sql = "SELECT * FROM billetes";
        List<Billete> listaBilletes = new ArrayList<Billete>();
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String sqlCliente = "SELECT * FROM clientes WHERE id = ?";
                String sqlVuelo = "SELECT * FROM vuelos WHERE id = ?";
                String sqlAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE id = ?";
                String sqlAeropuertoDestino = "SELECT * FROM aeropuertos WHERE id = ?";

                ResultSet rsCliente = stmt.executeQuery(sqlCliente);
                ResultSet rsVuelo = stmt.executeQuery(sqlVuelo);
                ResultSet rsAeropuertoOrigen = stmt.executeQuery(sqlAeropuertoOrigen);
                ResultSet rsAeropuertoDestino = stmt.executeQuery(sqlAeropuertoDestino);

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
                rsAeropuertoOrigen = pstAeropuertoOrigen.executeQuery();
                rsAeropuertoDestino = pstAeropuertoDestino.executeQuery();

                listaBilletes.add(new Billete(new Cliente(rsCliente.getString("username"),
                        rsCliente.getString("password"), rsCliente.getString("dni"), rsCliente.getString("nombre"),
                        rsCliente.getString("apellido"), rsCliente.getString("email"), rsCliente.getString("telefono")),
                        new Vuelo(rsVuelo.getString("aerolinea"), rsVuelo.getString("designator"),
                                new Aeropuerto(rsAeropuertoOrigen.getString("nombre"),
                                        rsAeropuertoOrigen.getString("IATA"), rsAeropuertoOrigen.getString("ciudad"),
                                        rsAeropuertoOrigen.getString("pais")),
                                new Aeropuerto(rsAeropuertoDestino.getString("nombre"),
                                        rsAeropuertoDestino.getString("IATA"), rsAeropuertoDestino.getString("ciudad"),
                                        rsAeropuertoDestino.getString("pais")),
                                rs.getFloat("precio_base_adulto"), rs.getFloat("precio_base_ninyio"),
                                rs.getFloat("precio_maleta"), rs.getString("fecha"), rs.getString("hora"), rs.getInt("asientos_clase_1"),
                                rs.getInt("asientos_clase_2"), rs.getInt("asientos_clase_3")),
                        rs.getInt("numero_pasajeros_adultos"), rs.getInt("numero_pasajeros_ninyios"),
                        rs.getInt("numero_maletas"), rs.getInt("clase"), rs.getFloat("precio")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Lista de billetes obtenida correctamente");
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
    public Vuelo getVueloEspecifico(String origen, String destino, String fecha) {
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            System.out.println("rula");
            String sqlExisteAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE ciudad = ?";
            String sqlExisteAeropuertoDestino = "SELECT * FROM aeropuertos WHERE ciudad = ?";
            String sqlExisteVuelo = "SELECT * FROM vuelos WHERE aeropuerto_origen = ? AND aeropuerto_destino = ? AND fecha = ?";
            // String sqlexisteVuelo = "SELECT a1.id FROM vuelos v1, vuelos v2, aeropuertos
            // a1, aeropuertos a2 WHERE v1.aeropuerto_origen == a1.id AND
            // v2.aeropuerto_destino == a2.id AND a1.ciudad == ? AND a2.ciudad == ? AND
            // v1.fecha == ? AND v2.fecha == ? AND v1.fecha == v2.fecha";
            PreparedStatement pstExisteAeropuertoOrigen = conn.prepareStatement(sqlExisteAeropuertoOrigen);
            PreparedStatement pstExisteAeropuertoDestino = conn.prepareStatement(sqlExisteAeropuertoDestino);

            pstExisteAeropuertoOrigen.setString(1, origen);
            pstExisteAeropuertoDestino.setString(1, destino);

            ResultSet rsAeropuertoOrigen = pstExisteAeropuertoOrigen.executeQuery();
            ResultSet rsAeropuertoDestino = pstExisteAeropuertoDestino.executeQuery();

            int idAeropuertoOrigen = rsAeropuertoOrigen.getInt("id");
            System.out.println("ID Origen: " + idAeropuertoOrigen);
            int idAeropuertoDestino = rsAeropuertoDestino.getInt("id");
            System.out.println("ID Destino: " + idAeropuertoDestino);

            PreparedStatement pst = conn.prepareStatement(sqlExisteVuelo);

            pst.setInt(1, idAeropuertoOrigen);
            pst.setInt(2, idAeropuertoDestino);
            pst.setString(3, fecha);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Aeropuerto aeropuertoOrigen = new Aeropuerto(rsAeropuertoOrigen.getString("nombre"),
                        rsAeropuertoOrigen.getString("iata"), rsAeropuertoOrigen.getString("ciudad"),
                        rsAeropuertoOrigen.getString("pais"));
                Aeropuerto aeropuertoDestino = new Aeropuerto(rsAeropuertoDestino.getString("nombre"),
                        rsAeropuertoDestino.getString("iata"), rsAeropuertoDestino.getString("ciudad"),
                        rsAeropuertoDestino.getString("pais"));
                
                aeropuertoOrigen.setId(rsAeropuertoOrigen.getInt("id"));
                aeropuertoDestino.setId(rsAeropuertoDestino.getInt("id"));
                
                Vuelo vuelo = new Vuelo(rs.getString("aerolinea"), rs.getString("designator"), aeropuertoOrigen,
                        aeropuertoDestino, rs.getFloat("precio_base_adulto"), rs.getFloat("precio_base_ninyio"),
                        rs.getFloat("precio_maleta"), rs.getString("fecha"), rs.getString("hora"),
                        rs.getInt("asientos_clase_1"), rs.getInt("asientos_clase_2"), rs.getInt("asientos_clase_3"));
                
                vuelo.setId(rs.getInt("id"));

                pstExisteAeropuertoOrigen.close();
                pstExisteAeropuertoDestino.close();
                pst.close();
                System.out.println("devuelve Vuelo");

                return vuelo;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Vuelo obtenido correctamente");
        return null;
    }

    public Cliente getClienteEspecifico(String cliente) {
        Cliente clienteEspecifico = new Cliente();

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            String sqlCliente = "SELECT * FROM clientes WHERE username = ?";
            PreparedStatement pstCliente = conn.prepareStatement(sqlCliente);
            pstCliente.setString(1, cliente);
            ResultSet rsCliente = pstCliente.executeQuery();

            clienteEspecifico = new Cliente(rsCliente.getString("username"), rsCliente.getString("password"),
                    rsCliente.getString("dni"), rsCliente.getString("nombre"), rsCliente.getString("apellido"),
                    rsCliente.getString("email"), rsCliente.getString("telefono"));

            clienteEspecifico.setId(rsCliente.getInt("id"));
            pstCliente.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Admin " + String.valueOf(clienteEspecifico.getId()) + " obtenid correctamente");
        return clienteEspecifico;
    }

    public Admin getAdminEspecifico(String admin) {
        Admin adminEspecifico = new Admin();

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            String sqlAdmin = "SELECT * FROM admins WHERE username = ?";
            PreparedStatement pstAdmin = conn.prepareStatement(sqlAdmin);
            pstAdmin.setString(1, admin);
            ResultSet rsAdmin = pstAdmin.executeQuery();

            adminEspecifico = new Admin(rsAdmin.getString("username"), rsAdmin.getString("password"),
                    rsAdmin.getInt("nivel"));

            adminEspecifico.setId(rsAdmin.getInt("id"));
            pstAdmin.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Admin " + String.valueOf(adminEspecifico.getId()) + " obtenid correctamente");
        return adminEspecifico;
    }
    
    public List<Cliente> getClientesVuelo(Vuelo vuelo) {
        Cliente clienteVuelo = new Cliente();
        List<Cliente> listaClientesVuelo = new ArrayList<Cliente>();

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            String sqlVuelo = "SELECT * FROM billetes WHERE vuelo = ?";
            PreparedStatement pstVuelo = conn.prepareStatement(sqlVuelo);
            pstVuelo.setInt(1, vuelo.getId());
            ResultSet rsCliente = pstVuelo.executeQuery();

            while (rsCliente.next()) {
                listaClientesVuelo.add(new Cliente(rsCliente.getString("username"), rsCliente.getString("password"),
                rsCliente.getString("dni"), rsCliente.getString("nombre"), rsCliente.getString("apellido"),
                rsCliente.getString("email"), rsCliente.getString("telefono")));
            }
            pstVuelo.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
        }
        logger.Log.getLOGGER().info("Lista de clientes del vuelo " + String.valueOf(vuelo.getId()) + " obtenida correctamente");
        return listaClientesVuelo;
    }
    // public Vuelo getUsuarioEspecifico(String usuario, String password) {
    //     try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
    //         System.out.println("rula");
    //         String sqlExisteAeropuertoOrigen = "SELECT * FROM aeropuertos WHERE ciudad = ?";
    //         String sqlExisteAeropuertoDestino = "SELECT * FROM aeropuertos WHERE ciudad = ?";
    //         String sqlExisteVuelo = "SELECT * FROM vuelos WHERE aeropuerto_origen = ? AND aeropuerto_destino = ? AND fecha = ?";
    //         // String sqlexisteVuelo = "SELECT a1.id FROM vuelos v1, vuelos v2, aeropuertos
    //         // a1, aeropuertos a2 WHERE v1.aeropuerto_origen == a1.id AND
    //         // v2.aeropuerto_destino == a2.id AND a1.ciudad == ? AND a2.ciudad == ? AND
    //         // v1.fecha == ? AND v2.fecha == ? AND v1.fecha == v2.fecha";
    //         PreparedStatement pstExisteAeropuertoOrigen = conn.prepareStatement(sqlExisteAeropuertoOrigen);
    //         PreparedStatement pstExisteAeropuertoDestino = conn.prepareStatement(sqlExisteAeropuertoDestino);

    //         pstExisteAeropuertoOrigen.setString(1, origen);
    //         pstExisteAeropuertoDestino.setString(1, destino);

    //         ResultSet rsAeropuertoOrigen = pstExisteAeropuertoOrigen.executeQuery();
    //         ResultSet rsAeropuertoDestino = pstExisteAeropuertoDestino.executeQuery();

    //         int idAeropuertoOrigen = rsAeropuertoOrigen.getInt("id");
    //         System.out.println("ID Origen: " + idAeropuertoOrigen);
    //         int idAeropuertoDestino = rsAeropuertoDestino.getInt("id");
    //         System.out.println("ID Destino: " + idAeropuertoDestino);

    //         PreparedStatement pst = conn.prepareStatement(sqlExisteVuelo);

    //         pst.setInt(1, idAeropuertoOrigen);
    //         pst.setInt(2, idAeropuertoDestino);
    //         pst.setString(3, fecha);

    //         ResultSet rs = pst.executeQuery();

    //         while (rs.next()) {
    //             Aeropuerto aeropuertoOrigen = new Aeropuerto(rsAeropuertoOrigen.getString("nombre"),
    //                     rsAeropuertoOrigen.getString("iata"), rsAeropuertoOrigen.getString("ciudad"),
    //                     rsAeropuertoOrigen.getString("pais"));
    //             Aeropuerto aeropuertoDestino = new Aeropuerto(rsAeropuertoDestino.getString("nombre"),
    //                     rsAeropuertoDestino.getString("iata"), rsAeropuertoDestino.getString("ciudad"),
    //                     rsAeropuertoDestino.getString("pais"));
                
    //             aeropuertoOrigen.setId(rsAeropuertoOrigen.getInt("id"));
    //             aeropuertoDestino.setId(rsAeropuertoDestino.getInt("id"));
                
    //             Vuelo vuelo = new Vuelo(rs.getString("aerolinea"), rs.getString("designator"), aeropuertoOrigen,
    //                     aeropuertoDestino, rs.getFloat("precio_base_adulto"), rs.getFloat("precio_base_ninyio"),
    //                     rs.getFloat("precio_maleta"), rs.getString("fecha"), rs.getString("hora"),
    //                     rs.getInt("asientos_clase_1"), rs.getInt("asientos_clase_2"), rs.getInt("asientos_clase_3"));
                
    //             vuelo.setId(rs.getInt("id"));

    //             return vuelo;

    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     }
    //     return null;
    // }
}
