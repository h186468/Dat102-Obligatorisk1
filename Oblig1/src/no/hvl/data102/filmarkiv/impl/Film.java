package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    
    private int filmnr;
    private String produsent;
    private String tittel;
    private int lanseringsår;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {
        this.filmnr = 0;
        this.produsent = "";
        this.tittel = "";
        this.lanseringsår = 0;
        this.sjanger = Sjanger.ANNET; 
        this.filmselskap = "";
    }

    public Film(int filmnr, String produsent, String tittel, int lanseringsår, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lanseringsår = lanseringsår;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    
    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLanseringsår() {
        return lanseringsår;
    }

    public void setLanseringsår(int lanseringsår) {
        this.lanseringsår = lanseringsår;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return filmnr == film.filmnr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnr);
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmnr=" + filmnr +
                ", produsent='" + produsent + '\'' +
                ", tittel='" + tittel + '\'' +
                ", lanseringsår=" + lanseringsår +
                ", sjanger=" + sjanger +
                ", filmselskap='" + filmselskap + '\'' +
                '}';
    }
}
