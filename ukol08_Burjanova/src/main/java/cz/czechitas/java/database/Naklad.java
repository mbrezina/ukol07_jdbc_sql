package cz.czechitas.java.database;

public class Naklad {
    private String datum;
    private String denVTydnu;
    private int prodanyNaklad;
    private Float zisk;
    private int prumernyProdanyNaklad;


    public void setPrumernyProdanyNaklad(int prumernyProdanyNaklad) {
        this.prumernyProdanyNaklad = prumernyProdanyNaklad;
    }

    public int getPrumernyProdanyNaklad() {
        return prumernyProdanyNaklad;
    }

    @Override
    public String toString() {
        return "Den " + denVTydnu + ", průměrný prodaný náklad: " + prumernyProdanyNaklad + " kusů novin Daily Planet";
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setDenVTydnu(String denVTydnu) {
        this.denVTydnu = denVTydnu;
    }

    public void setProdanyNaklad(int prodanyNaklad) {
        this.prodanyNaklad = prodanyNaklad;
    }

    public void setZisk(Float zisk) {
        this.zisk = zisk;
    }

    public String getDatum() {
        return datum;
    }

    public String getDenVTydnu() {
        return denVTydnu;
    }

    public int getProdanyNaklad() {
        return prodanyNaklad;
    }

    public Float getZisk() {
        return zisk;
    }
}
