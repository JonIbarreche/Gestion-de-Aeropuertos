package Jerarquias;

import java.util.Objects;

public abstract class Usuario {
    public static int contadorUsuario = 0; 
    protected int id;
    protected String username;
    protected String password;


    public Usuario(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Usuario() {
        contadorUsuario++;
        this.id = contadorUsuario;
        this.username = "";
        this.password = "";
    }

    public int getId() {
        return this.id;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
   
}