package no.hvl.dat102.filmarkiv2.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import no.hvl.data102.filmarkiv.impl.*;

public class FilmarkivTest2 {

	@Test
	void testFinnFilm() {
		Filmarkiv2 arkiv = new Filmarkiv2();
		Film film = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
		arkiv.leggTilFilm(film);

		assertEquals(film, arkiv.finnFilm(1)); // Skal finne filmen (1)
		assertNull(arkiv.finnFilm(2));
	}

	@Test
	void testLeggTilFilm() {
		Filmarkiv2 arkiv = new Filmarkiv2();
		Film film1 = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");

		arkiv.leggTilFilm(film1);

		Film result = arkiv.finnFilm(1);

		assertEquals(film1, result);
	}

	@Test
	void testSlettFilm() {

		Filmarkiv2 arkiv = new Filmarkiv2();
		Film film = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
		arkiv.leggTilFilm(film);

		assertTrue(arkiv.slettFilm(1));
		assertNull(arkiv.finnFilm(1));

	}

	@Test
	void testSoekTittel() {

		Filmarkiv2 arkiv = new Filmarkiv2();
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

	@Test
	void testSoekProdusent() {

		Filmarkiv2 arkiv = new Filmarkiv2();
		Film film1 = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
		Film film2 = new Film(2, "Steven Spielberg", "E.T.", 1982, Sjanger.DRAMA, "Universal");
		Film film3 = new Film(3, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal");

		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);

		Film[] filmer = arkiv.soekProdusent("Steven Spielberg");
		assertEquals(2, filmer.length);
		assertEquals(film2, filmer[0]);
		assertEquals(film3, filmer[1]);

	}

	@Test
	void testantall() { //for sjanger
		Filmarkiv2 arkiv = new Filmarkiv2();
		Film film1 = new Film(1, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "Fox");
		Film film2 = new Film(2, "Steven Spielberg", "E.T.", 1982, Sjanger.DRAMA, "Universal");
		Film film3 = new Film(3, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal");

		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);

		assertEquals(2, arkiv.antall(Sjanger.ACTION));
		assertEquals(1, arkiv.antall(Sjanger.DRAMA));
	}

}

// osv.
