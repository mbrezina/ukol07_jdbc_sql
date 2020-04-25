package cz.czechitas.java.database;

public class Clanek {
    private Long id_clanku;
    private String Nazev;
    private String Autor;
    private Long id_autor;
    private String Datum;

    public void setId_clanku(Long id_clanku) {
        this.id_clanku = id_clanku;
    }

    @Override
    public String toString() {
        return id_clanku + ": " + Nazev + ", " + Autor + ", vydáno dne " + Datum;
    }

    public void setNazev(String nazev) {
        Nazev = nazev;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public Long getId_clanku() {
        return id_clanku;
    }

    public String getNazev() {
        return Nazev;
    }

    public String getAutor() {
        return Autor;
    }

    public Long getId_autor() {
        return id_autor;
    }

    public String getDatum() {
        return Datum;
    }





}
