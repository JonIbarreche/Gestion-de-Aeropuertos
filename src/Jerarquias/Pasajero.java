package Jerarquías;

import java.util.Objects;

public class Pasajero extends Usuario {

    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected Pago tarjeta;


   
    public Pasajero(int id, String username, String password, String nombre, String apellido, String email, String telefono, Pago tarjeta) {
        super(id, username, password);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
    }
    public Pasajero() {
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.tarjeta = null;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pasajero)) {
            return false;
        }
        Pasajero Pasajero = (Pasajero) o;
        return id == Pasajero.id && Objects.equals(username, Pasajero.username) && Objects.equals(password, Pasajero.password) && Objects.equals(apellido, Pasajero.apellido) && Objects.equals(email, Pasajero.email) && Objects.equals(telefono, Pasajero.telefono) && Objects.equals(tarjeta, Pasajero.tarjeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, nombre, apellido, email, telefono, tarjeta);
    }

    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", tarjeta='" + getTarjeta() + "'" +
            "}";
    }


}
