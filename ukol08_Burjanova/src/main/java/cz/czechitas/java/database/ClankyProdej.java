package cz.czechitas.java.database;

public class ClankyProdej {

    private String nazev;
    private String autor;
    private int prodanyNaklad;
    private String datum;

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Datum: " + datum + ", název článku: " + nazev + ", autor: " + autor + ", prodaný náklad toho dne: " + prodanyNaklad;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setProdanyNaklad(int prodanyNaklad) {
        this.prodanyNaklad = prodanyNaklad;
    }

    public String getNazev() {
        return nazev;
    }

    public String getAutor() {
        return autor;
    }

    public int getProdanyNaklad() {
        return prodanyNaklad;
    }



}
