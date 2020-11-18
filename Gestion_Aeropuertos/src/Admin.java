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
        return nivel == admin.nivel;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nivel);
    }

    @Override
    public String toString() {
        return "{" +
            " nivel='" + getNivel() + "'" +
            "}";
    }
}
