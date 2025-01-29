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
}
