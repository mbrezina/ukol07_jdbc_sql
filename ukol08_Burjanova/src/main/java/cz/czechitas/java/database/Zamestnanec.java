package cz.czechitas.java.database;

public class Zamestnanec {

    private Long id;
    private String jmeno;
    private String bydliste;
    private int plat;
    private String datumNastupu;


    public String zamestnanciPrint() {
        return "Jméno: " + jmeno + ", bydliště: " + bydliste + ", měsíční plat: " + plat + "Kč, v Daily planet od: "+ datumNastupu;
    }

        public void setId(Long id) {
        this.id = id;
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

    public void setDatumNastupu(String datumNastupu) {
        this.datumNastupu = datumNastupu;
    }

    public Long getId() {
        return id;
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

    public String getDatumNastupu() {
        return datumNastupu;
    }


}
