package Jerarquias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Billete {

    protected int id;
    protected Cliente cliente;
    protected Vuelo vuelo;
    protected int numPasajerosAdultos;
    protected int numPasajerosNinyios;
    protected int numMaletas;
    protected int clase;
    protected float precio;

    public Billete(Cliente cliente, Vuelo vuelo, int numPasajerosAdultos, int numPasajerosNinyios,
            int numMaletas, int clase, float precio) {
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.numPasajerosAdultos = numPasajerosAdultos;
        this.numPasajerosNinyios = numPasajerosNinyios;
        this.numMaletas = numMaletas;
        this.clase = clase;
        this.precio = precio;
    }
    
    public Billete() {
        this.cliente = null;
        this.vuelo = null;
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

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vuelo getVuelo() {
        return this.vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
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
        setId(id);
        return this;
    }

    public Billete cliente(Cliente cliente) {
        setCliente(cliente);
        return this;
    }

    public Billete vuelo(Vuelo vuelo) {
        setVuelo(vuelo);
        return this;
    }

    public Billete numPasajerosAdultos(int numPasajerosAdultos) {
        setNumPasajerosAdultos(numPasajerosAdultos);
        return this;
    }

    public Billete numPasajerosNinyios(int numPasajerosNinyios) {
        setNumPasajerosNinyios(numPasajerosNinyios);
        return this;
    }

    public Billete numMaletas(int numMaletas) {
        setNumMaletas(numMaletas);
        return this;
    }

    public Billete clase(int clase) {
        setClase(clase);
        return this;
    }

    public Billete precio(float precio) {
        setPrecio(precio);
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
        return id == billete.id && Objects.equals(cliente, billete.cliente) && Objects.equals(vuelo, billete.vuelo) && numPasajerosAdultos == billete.numPasajerosAdultos && numPasajerosNinyios == billete.numPasajerosNinyios && numMaletas == billete.numMaletas && clase == billete.clase && precio == billete.precio;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", vuelo='" + getVuelo() + "'" +
            ", numPasajerosAdultos='" + getNumPasajerosAdultos() + "'" +
            ", numPasajerosNinyios='" + getNumPasajerosNinyios() + "'" +
            ", numMaletas='" + getNumMaletas() + "'" +
            ", clase='" + getClase() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    
   
}