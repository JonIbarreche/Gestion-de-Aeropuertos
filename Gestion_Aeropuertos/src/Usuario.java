import java.util.Objects;

public abstract class Usuario {
    public static int contadorUsuario = 0; 
    protected int idUsuario;
    protected String nombreUsuario;
    protected String passwordUsuario;


    public Usuario(int idUsuario, String nombreUsuario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Usuario() {
        contadorUsuario++;
        this.idUsuario = contadorUsuario;
        this.nombreUsuario = "";
        this.passwordUsuario = "";
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return this.passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Usuario idUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public Usuario nombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public Usuario passwordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
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
        return idUsuario == usuario.idUsuario && Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(passwordUsuario, usuario.passwordUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreUsuario, passwordUsuario);
    }

    @Override
    public String toString() {
        return "{" +
            " idUsuario='" + getIdUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", passwordUsuario='" + getPasswordUsuario() + "'" +
            "}";
    }
   
}