package Jerarquias;

import java.util.Objects;

public class Pasajero extends Usuario {

    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected Pago tarjeta;
    protected Billete[] bookings;

    public Pasajero(String nombre, String apellido, String email, String telefono, Pago tarjeta, Billete[] bookings) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.bookings = bookings;
    }

    public Pasajero() {
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.tarjeta = null;
        this.bookings = null;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Pago getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(Pago tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Billete[] getBookings() {
        return this.bookings;
    }

    public void setBookings(Billete[] bookings) {
        this.bookings = bookings;
    }

    public Pasajero nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Pasajero apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Pasajero email(String email) {
        this.email = email;
        return this;
    }

    public Pasajero telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Pasajero tarjeta(Pago tarjeta) {
        this.tarjeta = tarjeta;
        return this;
    }

    public Pasajero bookings(Billete[] bookings) {
        this.bookings = bookings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pasajero)) {
            return false;
        }
        Pasajero pasajero = (Pasajero) o;
        return Objects.equals(nombre, pasajero.nombre) && Objects.equals(apellido, pasajero.apellido) && Objects.equals(email, pasajero.email) && Objects.equals(telefono, pasajero.telefono) && Objects.equals(tarjeta, pasajero.tarjeta) && Objects.equals(bookings, pasajero.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, email, telefono, tarjeta, bookings);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", tarjeta='" + getTarjeta() + "'" +
            ", bookings='" + getBookings() + "'" +
            "}";
    }    
}
