package Jerarquias;

import java.util.Objects;

public class Admin extends Usuario {
    
    protected int nivel;

    public Admin(String username, String password,int nivel) {
        super(username, password);
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
        return id == admin.id && Objects.equals(username, admin.username) && Objects.equals(password, admin.password) && nivel == admin.nivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, nivel);
    }

    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", nivel='" + getNivel() + "'" +
            "}";
    }
}
