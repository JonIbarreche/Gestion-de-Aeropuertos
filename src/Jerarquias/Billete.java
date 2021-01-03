package Jerarquias;

import java.util.Objects;

public class Billete {

    private Pasajero pasajero;
    private Vuelo vuelo;
    private int adulto;
    private int ninyo;
    private int maletas;
    private String clase;
    private int precio;


    public Billete() {
        this.pasajero = null;
        this.vuelo = null;
        this.adulto = 0;
        this.ninyo = 0;
        this.maletas = 0;
        this.clase = "turista";
        this.precio = 0;
    }

    public Billete(Pasajero pasajero, Vuelo vuelo, int adulto, int ninyo, int maletas, String clase, int precio) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.adulto = adulto;
        this.ninyo = ninyo;
        this.maletas = maletas;
        this.clase = clase;
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return this.vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getAdulto() {
        return this.adulto;
    }

    public void setAdulto(int adulto) {
        this.adulto = adulto;
    }

    public int getNinyo() {
        return this.ninyo;
    }

    public void setNinyo(int ninyo) {
        this.ninyo = ninyo;
    }

    public int getMaletas() {
        return this.maletas;
    }

    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }

    public String getClase() {
        return this.clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Billete pasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
        return this;
    }

    public Billete vuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
        return this;
    }

    public Billete adulto(int adulto) {
        this.adulto = adulto;
        return this;
    }

    public Billete ninyo(int ninyo) {
        this.ninyo = ninyo;
        return this;
    }

    public Billete maletas(int maletas) {
        this.maletas = maletas;
        return this;
    }

    public Billete clase(String clase) {
        this.clase = clase;
        return this;
    }

    public Billete precio(int precio) {
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
        return Objects.equals(pasajero, billete.pasajero) && Objects.equals(vuelo, billete.vuelo) && adulto == billete.adulto && ninyo == billete.ninyo && maletas == billete.maletas && Objects.equals(clase, billete.clase) && precio == billete.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasajero, vuelo, adulto, ninyo, maletas, clase, precio);
    }

    @Override
    public String toString() {
        return "{" +
            " pasajero='" + getPasajero() + "'" +
            ", vuelo='" + getVuelo() + "'" +
            ", adulto='" + getAdulto() + "'" +
            ", ninyo='" + getNinyo() + "'" +
            ", maletas='" + getMaletas() + "'" +
            ", clase='" + getClase() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    
   
}