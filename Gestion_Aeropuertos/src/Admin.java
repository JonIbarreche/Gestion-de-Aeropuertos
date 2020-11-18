import java.util.Objects;

public class Admin extends Usuario {
    
    protected int nivel;

    public Admin(int idUsuario, String nombreUsuario, String passwordUsuario,int nivel) {
        super(idUsuario, nombreUsuario, passwordUsuario);
        this.nivel = nivel;
    }

    public Admin() {
        this.nivel = 1;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0 && nivel < 3){
            this.nivel = nivel;
        } 
    }

    public Admin nivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin admin = (Admin) o;
        return idUsuario == admin.idUsuario && Objects.equals(nombreUsuario, admin.nombreUsuario) && Objects.equals(passwordUsuario, admin.passwordUsuario) && nivel == admin.nivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreUsuario, passwordUsuario, nivel);
    }

    @Override
    public String toString() {
        return "{" +
            "idUsuario='" + getIdUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", passwordUsuario='" + getPasswordUsuario() + "'" +
            ", nivel='" + getNivel() + "'" +
            "}";
    }
}
