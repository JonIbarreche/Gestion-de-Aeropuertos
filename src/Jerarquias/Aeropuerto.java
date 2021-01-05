package Jerarquias;

import java.util.Objects;

public class Aeropuerto {

    protected int id;
    protected String nombre;
    protected String IATA;
    protected String ciudad;
    protected String pais;

    public Aeropuerto(String nombre, String IATA, String ciudad, String pais) {
        this.nombre = nombre;
        this.IATA = IATA;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Aeropuerto() {
        this.nombre = "";
        this.IATA = "";
        this.ciudad = "";
        this.pais = "";
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIATA() {
        return this.IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Aeropuerto Id(int id) {
        this.id = id;
        return this;
    }

    public Aeropuerto Nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Aeropuerto IATA(String IATA) {
        this.IATA = IATA;
        return this;
    }

    public Aeropuerto ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public Aeropuerto pais(String pais) {
        this.pais = pais;
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
        return id == aeropuerto.id && Objects.equals(nombre, aeropuerto.nombre) && Objects.equals(IATA, aeropuerto.IATA) && Objects.equals(ciudad, aeropuerto.ciudad) && Objects.equals(pais, aeropuerto.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, IATA, ciudad, pais);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", nombre='" + getIATA() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            ", pais='" + getPais() + "'" +
            "}";
    }
}
