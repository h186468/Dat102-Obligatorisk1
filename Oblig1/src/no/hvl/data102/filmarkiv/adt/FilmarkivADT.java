package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.Film;  
import no.hvl.data102.filmarkiv.impl.Sjanger;

/**
 * Et grensesnitt for filmarkiv med nødvendige operasjoner.
 */
public interface FilmarkivADT {

    /**
     * Henter en film med gitt nummer fra arkivet.
     * 
     * @param nr nummeret på filmen som skal hentes.
     * @return filmen med gitt nummer, eller null hvis den ikke finnes.
     */
    Film finnFilm(int nr);

    /**
     * Legger til en ny film i arkivet.
     * 
     * @param nyFilm filmen som skal legges til.
     */
    void leggTilFilm(Film nyFilm);

    /**
     * Sletter en film med gitt nummer.
     * 
     * @param filmnr nummeret på filmen som skal slettes.
     * @return true hvis filmen ble slettet, false ellers.
     */
    boolean slettFilm(int filmnr);

    /**
     * Søker etter filmer som inneholder en gitt delstreng i tittelen.
     * 
     * @param delstreng delstrengen som må være i tittelen.
     * @return en tabell med filmer som inneholder delstrengen i tittelen.
     */
    Film[] soekTittel(String delstreng);

    /**
     * Søker etter filmer som inneholder en gitt delstreng i produsentens navn.
     * 
     * @param delstreng delstrengen som må være i produsentens navn.
     * @return en tabell med filmer som inneholder delstrengen i produsentens navn.
     */
    Film[] soekProdusent(String delstreng);

    /**
     * Finner antall filmer av en gitt sjanger.
     * 
     * @param sjanger sjangeren som skal telles.
     * @return antall filmer av gitt sjanger.
     */
    int antall(Sjanger sjanger);

    /**
     * Finner totalt antall filmer i arkivet.
     * 
     * @return antall filmer i arkivet.
     */
    int antall();
}
