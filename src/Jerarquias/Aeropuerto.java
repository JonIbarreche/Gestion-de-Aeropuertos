package Jerarquias;

import java.util.Objects;

public class Aeropuerto {
   
    public static int contadorAeropuerto = 0;
    protected int id;
    protected String nombre;
    protected String IATA;
    protected String ciudad;
    protected String pais;

    public Aeropuerto(int id, String nombre, String IATA, String ciudad, String pais) {
        contadorAeropuerto++;
        this.id = contadorAeropuerto;
        this.nombre = nombre;
        this.IATA = IATA;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Aeropuerto() {
        contadorAeropuerto++;
        this.id = contadorAeropuerto;
        this.nombre = "";
        this.IATA = "";
        this.ciudad = "";
        this.pais = "";
    }

    public int getid() {
        return this.id;
    }

    public String getnombre() {
        return this.nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIATA() {
        return this.IATA;
    }

    public void IATA(String IATA) {
        this.IATA = IATA;
    }

    public String getciudad() {
        return this.ciudad;
    }

    public void setciudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getpais() {
        return this.pais;
    }

    public void setpais(String pais) {
        this.pais = pais;
    }

    public Aeropuerto id(int id) {
        this.id = id;
        return this;
    }

    public Aeropuerto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Aeropuerto iATA(String IATA) {
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
            " id='" + getid() + "'" +
            ", nombre='" + getnombre() + "'" +
            ", nombre='" + getIATA() + "'" +
            ", ciudad='" + getciudad() + "'" +
            ", pais='" + getpais() + "'" +
            "}";
    }
}
