import java.util.Objects;

public class example {
    int n_vuelos;
    double precio_vuelo;
    String nombre_pasajero;

    public example(int n_vuelos, double precio_vuelo, String nombre_pasajero) {
        this.n_vuelos = n_vuelos;
        this.precio_vuelo = precio_vuelo;
        this.nombre_pasajero = nombre_pasajero;
    }
    public example() {
        this.n_vuelos = 0;
        this.precio_vuelo = 0;
        this.nombre_pasajero = "";
    }
    public int getN_vuelos() {
        return this.n_vuelos;
    }

    public void setN_vuelos(int n_vuelos) {
        this.n_vuelos = n_vuelos;
    }

    public double getPrecio_vuelo() {
        return this.precio_vuelo;
    }

    public void setPrecio_vuelo(double precio_vuelo) {
        this.precio_vuelo = precio_vuelo;
    }

    public String getNombre_pasajero() {
        return this.nombre_pasajero;
    }

    public void setNombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
    }

    public example n_vuelos(int n_vuelos) {
        this.n_vuelos = n_vuelos;
        return this;
    }

    public example precio_vuelo(double precio_vuelo) {
        this.precio_vuelo = precio_vuelo;
        return this;
    }

    public example nombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof example)) {
            return false;
        }
        example example = (example) o;
        return n_vuelos == example.n_vuelos && precio_vuelo == example.precio_vuelo && Objects.equals(nombre_pasajero, example.nombre_pasajero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n_vuelos, precio_vuelo, nombre_pasajero);
    }

    @Override
    public String toString() {
        return "{" +
            " n_vuelos='" + getN_vuelos() + "'" +
            ", precio_vuelo='" + getPrecio_vuelo() + "'" +
            ", nombre_pasajero='" + getNombre_pasajero() + "'" +
            "}";
    }
   
    
}
