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

}

// osv.
