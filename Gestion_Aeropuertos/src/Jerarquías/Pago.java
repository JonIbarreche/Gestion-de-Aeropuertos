package Jerarquías;

public class Pago {
    private int tarjeta;
    private int anyo;
    private int mes;
    private int CVV;

    public Pago(int tarjeta, int anyo, int mes, int CVV) {
        this.tarjeta = tarjeta;
        this.anyo = anyo;
        this.mes = mes;
        this.CVV = CVV;
    }

    public Pago() {
        this.tarjeta = 0;
        this.anyo = 0;
        this.mes = 0;
        this.CVV = 0;
    }

    public int getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getAnyo() {
        return this.anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCVV() {
        return this.CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public Pago tarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
        return this;
    }

    public Pago anyo(int anyo) {
        this.anyo = anyo;
        return this;
    }

    public Pago mes(int mes) {
        this.mes = mes;
        return this;
    }

    public Pago CVV(int CVV) {
        this.CVV = CVV;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pago)) {
            return false;
        }
        Pago pago = (Pago) o;
        return tarjeta == pago.tarjeta && anyo == pago.anyo && mes == pago.mes && CVV == pago.CVV;
    }

    @Override
    public String toString() {
        return "{" +
            " tarjeta='" + getTarjeta() + "'" +
            ", anyo='" + getAnyo() + "'" +
            ", mes='" + getMes() + "'" +
            ", CVV='" + getCVV() + "'" +
            "}";
    }

    public int numTarjeta(){
        return numTarjeta();
    }

}