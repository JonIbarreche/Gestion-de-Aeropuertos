import java.util.Objects;

public class Aeropuerto {
   
    public static int contadorAeropuerto = 0;
    protected int idAeropuerto;
    protected String nombreAeropuerto;
    protected String ciudadAeropuerto;
    protected String paisAeropuerto;

    public Aeropuerto(int idAeropuerto, String nombreAeropuerto, String ciudadAeropuerto, String paisAeropuerto) {
        contadorAeropuerto++;
        this.idAeropuerto = contadorAeropuerto;
        this.nombreAeropuerto = nombreAeropuerto;
        this.ciudadAeropuerto = ciudadAeropuerto;
        this.paisAeropuerto = paisAeropuerto;
    }

    public Aeropuerto() {
        contadorAeropuerto++;
        this.idAeropuerto = contadorAeropuerto;
        this.nombreAeropuerto = "";
        this.ciudadAeropuerto = "";
        this.paisAeropuerto = "";
    }

    public int getIdAeropuerto() {
        return this.idAeropuerto;
    }

    public String getNombreAeropuerto() {
        return this.nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public String getCiudadAeropuerto() {
        return this.ciudadAeropuerto;
    }

    public void setCiudadAeropuerto(String ciudadAeropuerto) {
        this.ciudadAeropuerto = ciudadAeropuerto;
    }

    public String getPaisAeropuerto() {
        return this.paisAeropuerto;
    }

    public void setPaisAeropuerto(String paisAeropuerto) {
        this.paisAeropuerto = paisAeropuerto;
    }

    public Aeropuerto idAeropuerto(int idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
        return this;
    }

    public Aeropuerto nombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
        return this;
    }

    public Aeropuerto ciudadAeropuerto(String ciudadAeropuerto) {
        this.ciudadAeropuerto = ciudadAeropuerto;
        return this;
    }

    public Aeropuerto paisAeropuerto(String paisAeropuerto) {
        this.paisAeropuerto = paisAeropuerto;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto aeropuerto = (Aeropuerto) o;
        return idAeropuerto == aeropuerto.idAeropuerto && Objects.equals(nombreAeropuerto, aeropuerto.nombreAeropuerto) && Objects.equals(ciudadAeropuerto, aeropuerto.ciudadAeropuerto) && Objects.equals(paisAeropuerto, aeropuerto.paisAeropuerto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAeropuerto, nombreAeropuerto, ciudadAeropuerto, paisAeropuerto);
    }

    @Override
    public String toString() {
        return "{" +
            " idAeropuerto='" + getIdAeropuerto() + "'" +
            ", nombreAeropuerto='" + getNombreAeropuerto() + "'" +
            ", ciudadAeropuerto='" + getCiudadAeropuerto() + "'" +
            ", paisAeropuerto='" + getPaisAeropuerto() + "'" +
            "}";
    }
}
