package Jerarquias;

import java.util.Calendar;
import java.util.Objects;
import java.util.Date;

public class Vuelo{

    protected int id;
    protected String aerolinea;
    protected String designator;
    protected Aeropuerto aeropuertOrigen;
    protected Aeropuerto aeropuertoDestino;
    protected float precioBaseAdulto;
    protected float precioBaseNinyio;
    protected float precioMaleta;
    protected String fecha;
    protected String hora;
    protected int asientosClase1;
    protected int asientosClase2;
    protected int asientosClase3;

    public Vuelo(String aerolinea, String designator, Aeropuerto aeropuertOrigen, Aeropuerto aeropuertoDestino, float precioBaseAdulto, float precioBaseNinyio, float precioMaleta, String fecha, String hora, int asientosClase1, int asientosClase2, int asientosClase3) {
        
        this.aerolinea = aerolinea;
        this.designator = designator;
        this.aeropuertOrigen = aeropuertOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.precioBaseAdulto = precioBaseAdulto;
        this.precioBaseNinyio = precioBaseNinyio;
        this.precioMaleta = precioMaleta;
        this.fecha = fecha;
        this.hora = hora;
        this.asientosClase1 = asientosClase1;
        this.asientosClase2 = asientosClase2;
        this.asientosClase3 = asientosClase3;
    }

    public Vuelo() {
        this.aerolinea = "";
        this.designator = "";
        this.aeropuertOrigen = null;
        this.aeropuertoDestino = null;
        this.precioBaseAdulto = 0;
        this.precioBaseNinyio = 0;
        this.precioMaleta = 0;
        this.fecha = "";
        this.hora = "";
        this.asientosClase1 = 0;
        this.asientosClase2 = 0;
        this.asientosClase3 = 0;
    }
        
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAerolinea() {
        return this.aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getDesignator() {
        return this.designator;
    }

    public void setDesignator(String designator) {
        this.designator = designator;
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

    public float getPrecioBaseAdulto() {
        return this.precioBaseAdulto;
    }

    public void setPrecioBaseAdulto(float precioBaseAdulto) {
        this.precioBaseAdulto = precioBaseAdulto;
    }

    public float getPrecioBaseNinyio() {
        return this.precioBaseNinyio;
    }

    public void setPrecioBaseNinyio(float precioBaseNinyio) {
        this.precioBaseNinyio = precioBaseNinyio;
    }

    public float getPrecioMaleta() {
        return this.precioMaleta;
    }

    public void setPrecioMaleta(float precioMaleta) {
        this.precioMaleta = precioMaleta;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getAsientosClase1() {
        return this.asientosClase1;
    }

    public void setAsientosClase1(int asientosClase1) {
        this.asientosClase1 = asientosClase1;
    }

    public int getAsientosClase2() {
        return this.asientosClase2;
    }

    public void setAsientosClase2(int asientosClase2) {
        this.asientosClase2 = asientosClase2;
    }

    public int getAsientosClase3() {
        return this.asientosClase3;
    }

    public void setAsientosClase3(int asientosClase3) {
        this.asientosClase3 = asientosClase3;
    }

    public Vuelo id(int id) {
        setId(id);
        return this;
    }

    public Vuelo aerolinea(String aerolinea) {
        setAerolinea(aerolinea);
        return this;
    }

    public Vuelo designator(String designator) {
        setDesignator(designator);
        return this;
    }

    public Vuelo aeropuertOrigen(Aeropuerto aeropuertOrigen) {
        setAeropuertOrigen(aeropuertOrigen);
        return this;
    }

    public Vuelo aeropuertoDestino(Aeropuerto aeropuertoDestino) {
        setAeropuertoDestino(aeropuertoDestino);
        return this;
    }

    public Vuelo precioBaseAdulto(float precioBaseAdulto) {
        setPrecioBaseAdulto(precioBaseAdulto);
        return this;
    }

    public Vuelo precioBaseNinyio(float precioBaseNinyio) {
        setPrecioBaseNinyio(precioBaseNinyio);
        return this;
    }

    public Vuelo precioMaleta(float precioMaleta) {
        setPrecioMaleta(precioMaleta);
        return this;
    }

    public Vuelo fecha(String fecha) {
        setFecha(fecha);
        return this;
    }

    public Vuelo hora(String hora) {
        setHora(hora);
        return this;
    }

    public Vuelo asientosClase1(int asientosClase1) {
        setAsientosClase1(asientosClase1);
        return this;
    }

    public Vuelo asientosClase2(int asientosClase2) {
        setAsientosClase2(asientosClase2);
        return this;
    }

    public Vuelo asientosClase3(int asientosClase3) {
        setAsientosClase3(asientosClase3);
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
        return id == vuelo.id && Objects.equals(aerolinea, vuelo.aerolinea) && Objects.equals(designator, vuelo.designator) && Objects.equals(aeropuertOrigen, vuelo.aeropuertOrigen) && Objects.equals(aeropuertoDestino, vuelo.aeropuertoDestino) && precioBaseAdulto == vuelo.precioBaseAdulto && precioBaseNinyio == vuelo.precioBaseNinyio && precioMaleta == vuelo.precioMaleta && Objects.equals(fecha, vuelo.fecha) && Objects.equals(hora, vuelo.hora) && asientosClase1 == vuelo.asientosClase1 && asientosClase2 == vuelo.asientosClase2 && asientosClase3 == vuelo.asientosClase3;
    }

   
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", aerolinea='" + getAerolinea() + "'" +
            ", designator='" + getDesignator() + "'" +
            ", aeropuertOrigen='" + getAeropuertOrigen() + "'" +
            ", aeropuertoDestino='" + getAeropuertoDestino() + "'" +
            ", precioBaseAdulto='" + getPrecioBaseAdulto() + "'" +
            ", precioBaseNinyio='" + getPrecioBaseNinyio() + "'" +
            ", precioMaleta='" + getPrecioMaleta() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", hora='" + getHora() + "'" +
            ", asientosClase1='" + getAsientosClase1() + "'" +
            ", asientosClase2='" + getAsientosClase2() + "'" +
            ", asientosClase3='" + getAsientosClase3() + "'" +
            "}";
    }
    
}
