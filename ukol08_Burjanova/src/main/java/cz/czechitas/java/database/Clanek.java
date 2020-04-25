package cz.czechitas.java.database;

public class Clanek {

    private Long id;
    private String Nazev;
    private Zamestnanec autor;
    private String Datum;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazev(String nazev) {
        Nazev = nazev;
    }

    public void setAutor(Zamestnanec autor) {
        this.autor = autor;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public Long getId() {
        return id;
    }

    public String getNazev() {
        return Nazev;
    }

    public Zamestnanec getAutor() {
        return autor;
    }

    public String getDatum() {
        return Datum;
    }

    @Override
    public String toString() {
        return id + ": " + Nazev + ", " + autor + ", vydáno dne " + Datum;
    }
}
