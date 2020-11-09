import java.util.Objects;

public class Billete {

    private String tipo;
    private int adulto;
    private int ninyo;
    private int maletas;
    private String pais_o;
    private String pais_d;
    private String hora_o;
    private String hora_d;
    private String clase;
    

   

    public Billete(String tipo, int adulto, int ninyo, int maletas, String pais_o, String pais_d, String hora_o, String hora_d, String clase) {
        this.tipo = tipo;
        this.adulto = adulto;
        this.ninyo = ninyo;
        this.maletas = maletas;
        this.pais_o = pais_o;
        this.pais_d = pais_d;
        this.hora_o = hora_o;
        this.hora_d = hora_d;
        this.clase = clase;
    }

    public Billete() {
        this.tipo = "";
        this.adulto = 0;
        this.ninyo = 0;
        this.maletas = 0;
        this.pais_o = "";
        this.pais_d = "";
        this.hora_o = "";
        this.hora_d = "";
        this.clase = "";
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getPais_o() {
        return this.pais_o;
    }

    public void setPais_o(String pais_o) {
        this.pais_o = pais_o;
    }

    public String getPais_d() {
        return this.pais_d;
    }

    public void setPais_d(String pais_d) {
        this.pais_d = pais_d;
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

    public String getClase() {
        return this.clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Billete tipo(String tipo) {
        this.tipo = tipo;
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

    public Billete pais_o(String pais_o) {
        this.pais_o = pais_o;
        return this;
    }

    public Billete pais_d(String pais_d) {
        this.pais_d = pais_d;
        return this;
    }

    public Billete hora_o(String hora_o) {
        this.hora_o = hora_o;
        return this;
    }

    public Billete hora_d(String hora_d) {
        this.hora_d = hora_d;
        return this;
    }

    public Billete clase(String clase) {
        this.clase = clase;
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
        return Objects.equals(tipo, billete.tipo) && adulto == billete.adulto && ninyo == billete.ninyo && maletas == billete.maletas && Objects.equals(pais_o, billete.pais_o) && Objects.equals(pais_d, billete.pais_d) && Objects.equals(hora_o, billete.hora_o) && Objects.equals(hora_d, billete.hora_d) && Objects.equals(clase, billete.clase);
    }

    @Override
    public String toString() {
        return "{" +
            " tipo='" + getTipo() + "'" +
            ", adulto='" + getAdulto() + "'" +
            ", ninyo='" + getNinyo() + "'" +
            ", maletas='" + getMaletas() + "'" +
            ", pais_o='" + getPais_o() + "'" +
            ", pais_d='" + getPais_d() + "'" +
            ", hora_o='" + getHora_o() + "'" +
            ", hora_d='" + getHora_d() + "'" +
            ", clase='" + getClase() + "'" +
            "}";
    }

   
}