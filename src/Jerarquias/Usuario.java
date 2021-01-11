package Jerarquias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    protected int id;
    protected String username;
    protected String password;
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected Pago tarjeta;
    protected List<Billete> billetes = new ArrayList<Billete>();
    protected int nivel;

    public Usuario(int id, String username, String password, String dni, String nombre, String apellido, String email, String telefono, Pago tarjeta, List<Billete> billetes, int nivel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.billetes = billetes;
        this.nivel = nivel;
    }

    public Usuario() {
        this.id = 0;
        this.username = "";
        this.password = "";
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.tarjeta = null;
        this.billetes = null;
        this.nivel = 0;
    }
        
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Pago getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(Pago tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Billete> getBilletes() {
        return this.billetes;
    }

    public void setBilletes(List<Billete> billetes) {
        this.billetes = billetes;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Usuario id(int id) {
        setId(id);
        return this;
    }

    public Usuario username(String username) {
        setUsername(username);
        return this;
    }

    public Usuario password(String password) {
        setPassword(password);
        return this;
    }

    public Usuario dni(String dni) {
        setDni(dni);
        return this;
    }

    public Usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Usuario apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public Usuario email(String email) {
        setEmail(email);
        return this;
    }

    public Usuario telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }

    public Usuario tarjeta(Pago tarjeta) {
        setTarjeta(tarjeta);
        return this;
    }

    public Usuario billetes(List<Billete> billetes) {
        setBilletes(billetes);
        return this;
    }

    public Usuario nivel(int nivel) {
        setNivel(nivel);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password) && Objects.equals(dni, usuario.dni) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(email, usuario.email) && Objects.equals(telefono, usuario.telefono) && Objects.equals(tarjeta, usuario.tarjeta) && Objects.equals(billetes, usuario.billetes) && nivel == usuario.nivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, dni, nombre, apellido, email, telefono, tarjeta, billetes, nivel);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", dni='" + getDni() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", tarjeta='" + getTarjeta() + "'" +
            ", billetes='" + getBilletes() + "'" +
            ", nivel='" + getNivel() + "'" +
            "}";
    }
    

}