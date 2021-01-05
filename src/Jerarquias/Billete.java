package Jerarquias;

import java.util.Objects;

public class Billete {

    private int id;
    private Vuelo[] vuelos;
    private int numPasajerosAdultos;
    private int numPasajerosNinyios;
    private int numMaletas;
    private int clase;
    private float precio;

    public Billete(Vuelo[] vuelos, int numPasajerosAdultos, int numPasajerosNinyios, int numMaletas, int clase,
            float precio) {

        this.vuelos = vuelos;
        this.numPasajerosAdultos = numPasajerosAdultos;
        this.numPasajerosNinyios = numPasajerosNinyios;
        this.numMaletas = numMaletas;
        this.clase = clase;
        this.precio = precio;
    }
    
    public Billete() {
        this.vuelos = null;
        this.numPasajerosAdultos = 0;
        this.numPasajerosNinyios = 0;
        this.numMaletas = 0;
        this.clase = 0;
        this.precio = 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vuelo[] getVuelos() {
        return this.vuelos;
    }

    public void setVuelos(Vuelo[] vuelos) {
        this.vuelos = vuelos;
    }

    public int getNumPasajerosAdultos() {
        return this.numPasajerosAdultos;
    }

    public void setNumPasajerosAdultos(int numPasajerosAdultos) {
        this.numPasajerosAdultos = numPasajerosAdultos;
    }

    public int getNumPasajerosNinyios() {
        return this.numPasajerosNinyios;
    }

    public void setNumPasajerosNinyios(int numPasajerosNinyios) {
        this.numPasajerosNinyios = numPasajerosNinyios;
    }

    public int getNumMaletas() {
        return this.numMaletas;
    }

    public void setNumMaletas(int numMaletas) {
        this.numMaletas = numMaletas;
    }

    public int getClase() {
        return this.clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Billete id(int id) {
        this.id = id;
        return this;
    }

    public Billete vuelos(Vuelo[] vuelos) {
        this.vuelos = vuelos;
        return this;
    }

    public Billete numPasajerosAdultos(int numPasajerosAdultos) {
        this.numPasajerosAdultos = numPasajerosAdultos;
        return this;
    }

    public Billete numPasajerosNinyios(int numPasajerosNinyios) {
        this.numPasajerosNinyios = numPasajerosNinyios;
        return this;
    }

    public Billete numMaletas(int numMaletas) {
        this.numMaletas = numMaletas;
        return this;
    }

    public Billete clase(int clase) {
        this.clase = clase;
        return this;
    }

    public Billete precio(float precio) {
        this.precio = precio;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Billete)) {
            return false;
        }
        Billete billete = (Billete) o;
        return id == billete.id && Objects.equals(vuelos, billete.vuelos) && numPasajerosAdultos == billete.numPasajerosAdultos && numPasajerosNinyios == billete.numPasajerosNinyios && numMaletas == billete.numMaletas && clase == billete.clase && precio == billete.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vuelos, numPasajerosAdultos, numPasajerosNinyios, numMaletas, clase, precio);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", vuelos='" + getVuelos() + "'" +
            ", numPasajerosAdultos='" + getNumPasajerosAdultos() + "'" +
            ", numPasajerosNinyios='" + getNumPasajerosNinyios() + "'" +
            ", numMaletas='" + getNumMaletas() + "'" +
            ", clase='" + getClase() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }

    
   
}