package Jerarquias;

public class Admin extends Usuario {
    protected int nivel;

    public Admin(String username, String password, int nivel) {
        super(username, password);
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
	 public boolean equals(Object objeto) {
	 	Admin a = (Admin) objeto;
	 	return this.username == a.username && this.password == a.password && this.nivel == a.nivel;
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
