import java.util.Objects;

public class Usuario {
    public static int contadorUsuario = 0; 
    protected int idUsuario;
    protected boolean admin;
    protected String usuario;
    protected String password;
    protected String nombreUsuario;
    protected String apellidoUsuario;
    protected String dniUsuario;
    protected String telefonoUsuario;
    protected Pago tarjetaUsuario;
    
    public Usuario(int idUsuario, boolean admin, String usuario, String password, String nombreUsuario, String apellidoUsuario, String dniUsuario, String telefonoUsuario, Pago tarjetaUsuario) {
        this.idUsuario = contadorUsuario;
        this.admin = admin;
        this.usuario = usuario;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.dniUsuario = dniUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.tarjetaUsuario = tarjetaUsuario;
    }

    public Usuario() {
        contadorUsuario++;
        this.idUsuario = contadorUsuario;
        this.admin = false;
        this.usuario = "";
        this.password = "";
        this.nombreUsuario = "";
        this.apellidoUsuario = "";
        this.dniUsuario = "";
        this.telefonoUsuario = "";
        this.tarjetaUsuario = null;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return this.apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDniUsuario() {
        return this.dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getTelefonoUsuario() {
        return this.telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Pago getTarjetaUsuario() {
        return this.tarjetaUsuario;
    }

    public void setTarjetaUsuario(Pago tarjetaUsuario) {
        this.tarjetaUsuario = tarjetaUsuario;
    }

    public Usuario idUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public Usuario admin(boolean admin) {
        this.admin = admin;
        return this;
    }

    public Usuario usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public Usuario password(String password) {
        this.password = password;
        return this;
    }

    public Usuario nombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public Usuario apellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
        return this;
    }

    public Usuario dniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
        return this;
    }

    public Usuario telefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
        return this;
    }

    public Usuario tarjetaUsuario(Pago tarjetaUsuario) {
        this.tarjetaUsuario = tarjetaUsuario;
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
        return idUsuario == usuario.idUsuario && admin == usuario.admin && Objects.equals(usuario, usuario.usuario) && Objects.equals(password, usuario.password) && Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(apellidoUsuario, usuario.apellidoUsuario) && Objects.equals(dniUsuario, usuario.dniUsuario) && Objects.equals(telefonoUsuario, usuario.telefonoUsuario) && Objects.equals(tarjetaUsuario, usuario.tarjetaUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, admin, usuario, password, nombreUsuario, apellidoUsuario, dniUsuario, telefonoUsuario, tarjetaUsuario);
    }

    @Override
    public String toString() {
        return "{" +
            " idUsuario='" + getIdUsuario() + "'" +
            ", admin='" + isAdmin() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", password='" + getPassword() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", apellidoUsuario='" + getApellidoUsuario() + "'" +
            ", dniUsuario='" + getDniUsuario() + "'" +
            ", telefonoUsuario='" + getTelefonoUsuario() + "'" +
            ", tarjetaUsuario='" + getTarjetaUsuario() + "'" +
            "}";
    }

   
}