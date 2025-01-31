package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmer;
    private int antall;

    
    public Filmarkiv(int kapasitet) {
        filmer = new Film[kapasitet];
        antall = 0;
    }
    
    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == nr) {
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvid();
        }
        filmer[antall++] = nyFilm;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == filmnr) {
                filmer[i] = filmer[antall - 1]; 
                filmer[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[teller++] = filmer[i];
            }
        }
        return trimTabell(treff, teller);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] treff = new Film[antall];
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[teller++] = filmer[i];
            }
        }
        return trimTabell(treff, teller);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }


    private void utvid() {
        filmer = Arrays.copyOf(filmer, filmer.length * 2);
    }

    
    private Film[] trimTabell(Film[] tabell, int lengde) {
        return Arrays.copyOf(tabell, lengde);
    }
}
