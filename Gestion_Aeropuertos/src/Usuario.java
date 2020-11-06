
public class Usuario {
    private String user;
    private String password;
    private String nomnbre;
    private String apellido;
    private String DNI;
    private String telefono;

    public Usuario(String user, String password, String nomnbre, String apellido, String DNI, String telefono) {
        this.user = user;
        this.password = password;
        this.nomnbre = nomnbre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
    }

     public Usuario() {
        this.user = "";
        this.password = "";
        this.nomnbre = "";
        this.apellido = "";
        this.DNI = "";
        this.telefono = "";
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomnbre() {
        return this.nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario user(String user) {
        this.user = user;
        return this;
    }

    public Usuario password(String password) {
        this.password = password;
        return this;
    }

    public Usuario nomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
        return this;
    }

    public Usuario apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Usuario DNI(String DNI) {
        this.DNI = DNI;
        return this;
    }

    public Usuario telefono(String telefono) {
        this.telefono = telefono;
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
        return user == usuario.user && password == usuario.password && nomnbre == usuario.nomnbre && apellido == usuario.apellido && DNI == usuario.DNI && telefono == usuario.telefono;
    }

    @Override
    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            ", password='" + getPassword() + "'" +
            ", nomnbre='" + getNomnbre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", DNI='" + getDNI() + "'" +
            ", telefono='" + getTelefono() + "'" +
            "}";
    }

}