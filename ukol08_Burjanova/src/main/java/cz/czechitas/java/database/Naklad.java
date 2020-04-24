package cz.czechitas.java.database;

public class Naklad {
    private String datum;
    private String den_v_tydnu;
    private int prodany_naklad;
    private Float zisk;
    private int prumerny_prodany_naklad;


    public void setPrumerny_prodany_naklad(int prumerny_prodany_naklad) {
        this.prumerny_prodany_naklad = prumerny_prodany_naklad;
    }

    public int getPrumerny_prodany_naklad() {
        return prumerny_prodany_naklad;
    }

    @Override
    public String toString() {
        return "Den " + den_v_tydnu + ", průměrný prodaný náklad: " + prumerny_prodany_naklad + " kusů novin Daily Planet";
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setDen_v_tydnu(String den_v_tydnu) {
        this.den_v_tydnu = den_v_tydnu;
    }

    public void setProdany_naklad(int prodany_naklad) {
        this.prodany_naklad = prodany_naklad;
    }

    public void setZisk(Float zisk) {
        this.zisk = zisk;
    }

    public String getDatum() {
        return datum;
    }

    public String getDen_v_tydnu() {
        return den_v_tydnu;
    }

    public int getProdany_naklad() {
        return prodany_naklad;
    }

    public Float getZisk() {
        return zisk;
    }
}
