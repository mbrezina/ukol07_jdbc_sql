package cz.czechitas.java.database;

public class PocetClanku {
    private String autor;
    private String pocetClanku;

    @Override
    public String toString() {
        return "Autor " + autor + " napsal za únor 2019 celkem " + pocetClanku + " článků";
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPocetClanku(String pocetClanku) {
        this.pocetClanku = pocetClanku;
    }

    public String getAutor() {
        return autor;
    }

    public String getPocetClanku() {
        return pocetClanku;
    }


}
