package Jerarquias;

import java.util.Objects;
import java.time.ZonedDateTime;

public class Vuelo{
    
    public int contadorVuelo = 0;
    protected int id;
    protected String companyia;
    protected Aeropuerto aeropuertOrigen;
    protected Aeropuerto aeropuertoDestino;
    protected ZonedDateTime fechaOrigen;
    protected ZonedDateTime fechaDestino;
    protected int precio;

    public Vuelo(String companyia, Aeropuerto aeropuertOrigen, Aeropuerto aeropuertoDestino,
            ZonedDateTime fechaOrigen, ZonedDateTime fechaDestino, int precio) {
        this.contadorVuelo = contadorVuelo++;
        this.id = contadorVuelo;
        this.companyia = companyia;
        this.aeropuertOrigen = aeropuertOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaOrigen = fechaOrigen;
        this.fechaDestino = fechaDestino;
        this.precio = precio;
    }
    
    public Vuelo() {
        this.contadorVuelo = contadorVuelo++;
        this.id = contadorVuelo;
        this.companyia = "";
        this.aeropuertOrigen = null;
        this.aeropuertoDestino = null;
        this.fechaOrigen = null;
        this.fechaDestino = null;
        this.precio = 0;
    }

    public int getContadorVuelo() {
        return this.contadorVuelo;
    }

    public void setContadorVuelo(int contadorVuelo) {
        this.contadorVuelo = contadorVuelo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyia() {
        return this.companyia;
    }

    public void setCompanyia(String companyia) {
        this.companyia = companyia;
    }

    public Aeropuerto getAeropuertOrigen() {
        return this.aeropuertOrigen;
    }

    public void setAeropuertOrigen(Aeropuerto aeropuertOrigen) {
        this.aeropuertOrigen = aeropuertOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return this.aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public ZonedDateTime getFechaOrigen() {
        return this.fechaOrigen;
    }

    public void setFechaOrigen(ZonedDateTime fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
    }

    public ZonedDateTime getFechaDestino() {
        return this.fechaDestino;
    }

    public void setFechaDestino(ZonedDateTime fechaDestino) {
        this.fechaDestino = fechaDestino;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Vuelo contadorVuelo(int contadorVuelo) {
        this.contadorVuelo = contadorVuelo;
        return this;
    }

    public Vuelo id(int id) {
        this.id = id;
        return this;
    }

    public Vuelo companyia(String companyia) {
        this.companyia = companyia;
        return this;
    }

    public Vuelo aeropuertOrigen(Aeropuerto aeropuertOrigen) {
        this.aeropuertOrigen = aeropuertOrigen;
        return this;
    }

    public Vuelo aeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
        return this;
    }

    public Vuelo fechaOrigen(ZonedDateTime fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
        return this;
    }

    public Vuelo fechaDestino(ZonedDateTime fechaDestino) {
        this.fechaDestino = fechaDestino;
        return this;
    }

    public Vuelo precio(int precio) {
        this.precio = precio;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vuelo)) {
            return false;
        }
        Vuelo vuelo = (Vuelo) o;
        return contadorVuelo == vuelo.contadorVuelo && id == vuelo.id && Objects.equals(companyia, vuelo.companyia) && Objects.equals(aeropuertOrigen, vuelo.aeropuertOrigen) && Objects.equals(aeropuertoDestino, vuelo.aeropuertoDestino) && Objects.equals(fechaOrigen, vuelo.fechaOrigen) && Objects.equals(fechaDestino, vuelo.fechaDestino) && precio == vuelo.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contadorVuelo, id, companyia, aeropuertOrigen, aeropuertoDestino, fechaOrigen, fechaDestino, precio);
    }

    @Override
    public String toString() {
        return "{" +
            " contadorVuelo='" + getContadorVuelo() + "'" +
            ", id='" + getId() + "'" +
            ", companyia='" + getCompanyia() + "'" +
            ", aeropuertOrigen='" + getAeropuertOrigen() + "'" +
            ", aeropuertoDestino='" + getAeropuertoDestino() + "'" +
            ", fechaOrigen='" + getFechaOrigen() + "'" +
            ", fechaDestino='" + getFechaDestino() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    
}
