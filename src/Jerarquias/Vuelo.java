package Jerarquias;

import java.util.Objects;

public class Vuelo{
    
    public int contadorVuelo = 0;
    protected int id;
    protected String companyia;
    protected Aeropuerto aeropuertOrigen;
    protected Aeropuerto aeropuertoDestino;
    protected String hora_o;
    protected String hora_d;
    protected int precio;

    public Vuelo(int id, String companyia, Aeropuerto aeropuertOrigen, Aeropuerto aeropuertoDestino, String hora_o, String hora_d, int precio) {
        this.contadorVuelo++;
        this.id = contadorVuelo;
        this.companyia = companyia;
        this.aeropuertOrigen = aeropuertOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.hora_o = hora_o;
        this.hora_d = hora_d;
        this.precio = precio;
    }

    public Vuelo() {
        this.contadorVuelo++;
        this.id = contadorVuelo;
        this.companyia = "";
        this.aeropuertOrigen = null;
        this.aeropuertoDestino = null;
        this.hora_o = "";
        this.hora_d = "";
        this.precio = 0;
    }

    public int getId() {
        return this.id;
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

    public String getHora_o() {
        return this.hora_o;
    }

    public void setHora_o(String hora_o) {
        this.hora_o = hora_o;
    }

    public String getHora_d() {
        return this.hora_d;
    }

    public void setHora_d(String hora_d) {
        this.hora_d = hora_d;
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

    public Vuelo hora_o(String hora_o) {
        this.hora_o = hora_o;
        return this;
    }

    public Vuelo hora_d(String hora_d) {
        this.hora_d = hora_d;
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
        return contadorVuelo == vuelo.contadorVuelo && id == vuelo.id && Objects.equals(companyia, vuelo.companyia) && Objects.equals(aeropuertOrigen, vuelo.aeropuertOrigen) && Objects.equals(aeropuertoDestino, vuelo.aeropuertoDestino) && Objects.equals(hora_o, vuelo.hora_o) && Objects.equals(hora_d, vuelo.hora_d) && precio == vuelo.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contadorVuelo, id, companyia, aeropuertOrigen, aeropuertoDestino, hora_o, hora_d, precio);
    }

    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            ", companyia='" + getCompanyia() + "'" +
            ", aeropuertOrigen='" + getAeropuertOrigen() + "'" +
            ", aeropuertoDestino='" + getAeropuertoDestino() + "'" +
            ", hora_o='" + getHora_o() + "'" +
            ", hora_d='" + getHora_d() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
}
