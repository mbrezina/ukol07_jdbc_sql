package cz.czechitas.java.database;

public class Zamestnanec {
    private int id_autor;
    private String jmeno;
    private String bydliste;
    private int plat;
    private String datum_nastupu;

    @Override
    public String toString() {
        return id_autor + ": Jméno: " + jmeno + ", bydliště: " + bydliste + ", měsíční plat: " + plat + "Kč, v Daily planet od: "+  datum_nastupu;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setBydliste(String bydliste) {
        this.bydliste = bydliste;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public void setDatum_nastupu(String datum_nastupu) {
        this.datum_nastupu = datum_nastupu;
    }

    public int getId_autor() {
        return id_autor;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getBydliste() {
        return bydliste;
    }

    public int getPlat() {
        return plat;
    }

    public String getDatum_nastupu() {
        return datum_nastupu;
    }
}
