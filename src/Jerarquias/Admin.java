package Jerarquias;

public class Admin extends Usuario {
    protected int nivel;

    public Admin(int id, String username, String password, int nivel) {
        super(id, username, password);
        this.nivel = nivel;
    }

    public Admin() {
        super();
        this.nivel = 0;
    }
        
    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Admin nivel(int nivel) {
        setNivel(nivel);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " username='" + getUsername() + "'" +
            " password='" + getPassword() + "'" +
            " nivel='" + getNivel() + "'" +
            "}";
    }

}
