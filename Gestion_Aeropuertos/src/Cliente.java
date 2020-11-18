import java.util.Objects;

public class Cliente extends Usuario {

    protected String nombreCliente;
    protected String apellidoCliente;
    protected String mailCliente;
    protected String telefonoCliente;
    protected Pago tarjetaCliente;


   
    public Cliente(int idUsuario, String nombreUsuario, String passwordUsuario, String nombreCliente, String apellidoCliente, String mailCliente, String telefonoCliente, Pago tarjetaCliente) {
        super(idUsuario, nombreUsuario, passwordUsuario);
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.mailCliente = mailCliente;
        this.telefonoCliente = telefonoCliente;
        this.tarjetaCliente = tarjetaCliente;
    }
    public Cliente() {
        this.nombreCliente = "";
        this.apellidoCliente = "";
        this.mailCliente = "";
        this.telefonoCliente = "";
        this.tarjetaCliente = null;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return this.apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getMailCliente() {
        return this.mailCliente;
    }

    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }

    public String getTelefonoCliente() {
        return this.telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Pago getTarjetaCliente() {
        return this.tarjetaCliente;
    }

    public void setTarjetaCliente(Pago tarjetaCliente) {
        this.tarjetaCliente = tarjetaCliente;
    }

    public Cliente nombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public Cliente apellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
        return this;
    }

    public Cliente mailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
        return this;
    }

    public Cliente telefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
        return this;
    }

    public Cliente tarjetaCliente(Pago tarjetaCliente) {
        this.tarjetaCliente = tarjetaCliente;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return idUsuario == cliente.idUsuario && Objects.equals(nombreUsuario, cliente.nombreUsuario) && Objects.equals(passwordUsuario, cliente.passwordUsuario) && Objects.equals(apellidoCliente, cliente.apellidoCliente) && Objects.equals(mailCliente, cliente.mailCliente) && Objects.equals(telefonoCliente, cliente.telefonoCliente) && Objects.equals(tarjetaCliente, cliente.tarjetaCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreUsuario, passwordUsuario, nombreCliente, apellidoCliente, mailCliente, telefonoCliente, tarjetaCliente);
    }

    @Override
    public String toString() {
        return "{" +
            "idUsuario='" + getIdUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", passwordUsuario='" + getPasswordUsuario() + "'" +
            ", nombreCliente='" + getNombreCliente() + "'" +
            ", apellidoCliente='" + getApellidoCliente() + "'" +
            ", mailCliente='" + getMailCliente() + "'" +
            ", telefonoCliente='" + getTelefonoCliente() + "'" +
            ", tarjetaCliente='" + getTarjetaCliente() + "'" +
            "}";
    }


}
