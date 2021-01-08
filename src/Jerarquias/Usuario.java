package Jerarquias;

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
    protected Billete[] billetes;
    protected int nivel;

    public Usuario(String username, String password, String dni, String nombre, String apellido, String email,
            String telefono, Pago tarjeta, Billete[] billetes, int nivel) {
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

    public Billete[] getBilletes() {
        return this.billetes;
    }

    public void setBilletes(Billete[] billetes) {
        this.billetes = billetes;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Usuario id(int id) {
        this.id = id;
        return this;
    }

    public Usuario username(String username) {
        this.username = username;
        return this;
    }

    public Usuario password(String password) {
        this.password = password;
        return this;
    }

    public Usuario dni(String dni) {
        this.dni = dni;
        return this;
    }

    public Usuario nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Usuario apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    public Usuario telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Usuario tarjeta(Pago tarjeta) {
        this.tarjeta = tarjeta;
        return this;
    }

    public Usuario billetes(Billete[] billetes) {
        this.billetes = billetes;
        return this;
    }

    public Usuario nivel(int nivel) {
        this.nivel = nivel;
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
        return id == usuario.id && Objects.equals(username, usuario.username)
                && Objects.equals(password, usuario.password) && Objects.equals(dni, usuario.dni)
                && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido)
                && Objects.equals(email, usuario.email) && Objects.equals(telefono, usuario.telefono)
                && Objects.equals(tarjeta, usuario.tarjeta) && Objects.equals(billetes, usuario.billetes)
                && nivel == usuario.nivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, dni, nombre, apellido, email, telefono, tarjeta, billetes, nivel);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", password='" + getPassword()
                + "'" + ", dni='" + getDni() + "'" + ", nombre='" + getNombre() + "'" + ", apellido='" + getApellido()
                + "'" + ", email='" + getEmail() + "'" + ", telefono='" + getTelefono() + "'" + ", tarjeta='"
                + getTarjeta() + "'" + ", billetes='" + getBilletes() + "'" + ", nivel='" + getNivel() + "'" + "}";
    }

}