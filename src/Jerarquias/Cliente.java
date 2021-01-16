package Jerarquias;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;

    public Cliente(int id, String username , String password, String dni, String nombre, String apellido, String email, String telefono) {
        super(id, username, password);
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Cliente() {
        super();
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
    }
        
    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Cliente dni(String dni) {
        setDni(dni);
        return this;
    }

    public Cliente nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Cliente apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Cliente email(String email) {
        setEmail(email);
        return this;
    }

    public Cliente telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " username='" + getUsername() + "'" +
            " password='" + getPassword() + "'" +
            " dni='" + getDni() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            "}";
    }


}
