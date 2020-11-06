package gestion_aeropuertos.aeropuertos.src.main.administracion_aeropuertos;

public class Aeropuerto {
    String nombre_aeropuerto;
    String ciudad_aeropuerto;
    String pais_aeropuerto;

    public Aeropuerto(String nombre_aeropuerto, String ciudad_aeropuerto, String pais_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
        this.ciudad_aeropuerto = ciudad_aeropuerto;
        this.pais_aeropuerto = pais_aeropuerto;
    }

    public Aeropuerto() {
        this.nombre_aeropuerto = "";
        this.ciudad_aeropuerto = "";
        this.pais_aeropuerto = "";
    }

    public String getNombre_aeropuerto() {
        return this.nombre_aeropuerto;
    }

    public void setNombre_aeropuerto(String nombre_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
    }

    public String getCiudad_aeropuerto() {
        return this.ciudad_aeropuerto;
    }

    public void setCiudad_aeropuerto(String ciudad_aeropuerto) {
        this.ciudad_aeropuerto = ciudad_aeropuerto;
    }

    public String getPais_aeropuerto() {
        return this.pais_aeropuerto;
    }

    public void setPais_aeropuerto(String pais_aeropuerto) {
        this.pais_aeropuerto = pais_aeropuerto;
    }

    public Aeropuerto nombre_aeropuerto(String nombre_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
        return this;
    }

    public Aeropuerto ciudad_aeropuerto(String ciudad_aeropuerto) {
        this.ciudad_aeropuerto = ciudad_aeropuerto;
        return this;
    }

    public Aeropuerto pais_aeropuerto(String pais_aeropuerto) {
        this.pais_aeropuerto = pais_aeropuerto;
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
        return Objects.equals(nombre_aeropuerto, aeropuerto.nombre_aeropuerto) && Objects.equals(ciudad_aeropuerto, aeropuerto.ciudad_aeropuerto) && Objects.equals(pais_aeropuerto, aeropuerto.pais_aeropuerto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_aeropuerto, ciudad_aeropuerto, pais_aeropuerto);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre_aeropuerto='" + getNombre_aeropuerto() + "'" +
            ", ciudad_aeropuerto='" + getCiudad_aeropuerto() + "'" +
            ", pais_aeropuerto='" + getPais_aeropuerto() + "'" +
            "}";
    }

}
