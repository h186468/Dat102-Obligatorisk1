package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import no.hvl.data102.filmarkiv.impl.*;

class FilmarkivTest {
    
    @Test
    void testFinnFilm() {
        Filmarkiv arkiv = new Filmarkiv(10);
        Film film = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
        arkiv.leggTilFilm(film);

        assertEquals(film, arkiv.finnFilm(1));  // Skal finne filmen (1)
        assertNull(arkiv.finnFilm(2));        
    }
    
    @Test
	void testLeggTilFilm() {
		Filmarkiv arkiv = new Filmarkiv(10);
		Film film = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
		arkiv.leggTilFilm(film);

		assertEquals(film, arkiv.finnFilm(1)); // Skal finne filmen (1)
	}
        
    @Test
    void testSlettFilm() {
    	
    	Filmarkiv arkiv = new Filmarkiv(10);
    	Film film = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
    	arkiv.leggTilFilm(film);
    	
    	assertTrue(arkiv.slettFilm(1)); 
    	assertNull(arkiv.finnFilm(1));
    	
    }
    
    @Test
	void testSoekTittel() {

		Filmarkiv arkiv = new Filmarkiv(10);
		Film film1 = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
		Film film2 = new Film(2, "Steven Spielberg", "E.T.", 1982, Sjanger.DRAMA, "Universal");
		Film film3 = new Film(3, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal");

		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);

		Film[] filmer = arkiv.soekTittel("a");
		assertEquals(2, filmer.length);
		assertEquals(film1, filmer[0]);
		assertEquals(film3, filmer[1]);

	}
    
    // osv.
    
}
