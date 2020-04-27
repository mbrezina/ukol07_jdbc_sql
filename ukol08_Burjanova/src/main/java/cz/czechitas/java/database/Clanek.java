package cz.czechitas.java.database;

public class Clanek {

    private Long id;
    private String nazev;
    private Zamestnanec autor;
    private String datum;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setAutor(Zamestnanec autor) {
        this.autor = autor;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public Zamestnanec getAutor() {
        return autor;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return id + ": " + nazev + ", " + autor + ", vydáno dne " + datum;
    }


    public String clankySIdPodleAutora() {
        return "Id článku: " + id + ": " + nazev + ", autor: " + autor.getJmeno() + ", vydán dne: " + datum;
    }


    public String clankyBezAutora() {
        return "Id článku: " + id + ": " + nazev + ", vydán dne: " + datum;
    }


}
