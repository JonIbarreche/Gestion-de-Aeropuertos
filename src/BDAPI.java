import java.sql.Statement;

import Jerarquias.Aeropuerto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDAPI {
    
    protected String url = "jdbc:sqlite:sqlite/main.db";
    
    public BDAPI() {

        String queryCreateTableAeropuertos = "CREATE TABLE IF NOT EXISTS aeropuertos (\n"
                + "	id integer NOT NULL,\n" + "	nombre text NOT NULL,\n" + "	iata text PRIMARY KEY,\n"
                + "	ciudad text NOT NULL,\n" + "	pais text NOT NULL\n" + ");";

        String queryCreateTableUsers = "CREATE TABLE IF NOT EXISTS usuarios (\n" + "	id integer PRIMARY KEY,\n"
                + "	username text NOT NULL,\n" + "	password text NOT NULL,\n" + "	nombre text,\n"
                + "	apellido text,\n" + "	email text,\n" + "	telefono text,\n" + "	tarjeta text,\n"
                + "	bookings text,\n" + "	nivel integer\n" + ");";

        String queryCreateTableBookings = "CREATE TABLE IF NOT EXISTS bookings (\n" + "	id integer PRIMARY KEY,\n"
                + "	vuelos text NOT NULL,\n" + "	numero_pasajeros_adultos integer NOT NULL,\n"
                + "	numero_pasajeros_ninyios integer NOT NULL,\n" + "	numero_maletas integer NOT NULL,\n"
                + "	clase integer NOT NULL,\n" + "	precio real NOT NULL\n" + ");";

        String queryCreateTableVuelos = "CREATE TABLE IF NOT EXISTS vuelos (\n" + "	id integer PRIMARY KEY,\n"
                + "	aerolinea text NOT NULL,\n" + "	designator text NOT NULL,\n" + "	origen_iata text NOT NULL,\n"
                + "	destino_iata text NOT NULL,\n" + "	precio_base_adulto real NOT NULL,\n"
                + "	precio_base_ninyio real NOT NULL,\n" + "	precio_maleta real NOT NULL,\n"
                + "	fecha text NOT NULL,\n" + "	asientos_clase_1 text NOT NULL,\n"
                + "	asientos_clase_2 text NOT NULL,\n" + "	asientos_clase_3 text NOT NULL\n" + ");";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(queryCreateTableAeropuertos);
                stmt.execute(queryCreateTableUsers);
                stmt.execute(queryCreateTableBookings);
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
                String existeAeropuerto = "SELECT iata FROM aeropuertos WHERE iata =" + aeropuerto.getIATA();
                if (existeAeropuerto == aeropuerto.getIATA()) {
                    stmt.executeUpdate(String.format("UPDATE aeropuertos SET (nombre, ciudad, pais) VALUES ('%s', '%s', '%s') WHERE iata = '%s'", aeropuerto.getnombre(), aeropuerto.getciudad(), aeropuerto.getpais(), aeropuerto.getIATA()));
                } else {
                    stmt.executeUpdate(String.format("INSERT INTO aeropuertos (nombre, ciudad, pais, iata) VALUES ('%s', '%s', '%s', '%s')", aeropuerto.getnombre(), aeropuerto.getciudad(), aeropuerto.getpais(), aeropuerto.getIATA()));
                }   
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aeropuerto;
    }
    // Editar user
    // Editar booking
    // Editar vuelo

    // Eliminar aeropuerto
    // Eliminar user
    // Eliminar booking
    // Eliminar vuelo

    // Buscar aeropuerto
    // Buscar user
    // Buscar booking
    // Buscar vuelo



}
