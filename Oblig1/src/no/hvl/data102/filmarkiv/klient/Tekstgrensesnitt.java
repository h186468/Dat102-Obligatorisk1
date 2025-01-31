package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt

	

	public Film lesFilm() {

		

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Skriv inn filmnr: ");
		int filmnr = sc.nextInt();
		System.out.println("Skriv inn produsent: ");
		String produsent = sc.next();
		System.out.println("Skriv inn tittel: ");
		sc.nextLine();
		String tittel = sc.next();
		System.out.println("Skriv inn lanseringsår: ");
		int lanseringsår = sc.nextInt();
		System.out.println("Gyldige sjangere : ACTION, DRAMA, COMEDY, HORROR, THRILLER, DOCUMENTARY, ANNET");
		System.out.println("Skriv inn sjanger: ");
		String s = sc.next();
		Sjanger sjanger = Sjanger.finnSjanger(s);
		System.out.println("Skriv inn filmselskap: ");
		String filmselskap = sc.next();
		

		Film film = new Film(filmnr, produsent, tittel, lanseringsår, sjanger, filmselskap);
		
		//sc.close(); klarer ikke helt å få ting til å funke når jeg closer denne?

		return film;

	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Filmnr: " + film.getFilmnr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("Lanseringsår: " + film.getLanseringsår());
		System.out.println("Sjanger: " + film.getSjanger().toString());
		System.out.println("Filmselskap: " + film.getFilmselskap());
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {

		Film[] filmer = arkiv.soekTittel(delstreng);

		for (int i = 0; i < filmer.length; i++) {
			skrivUtFilm(filmer[i]);
		}

	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {

		Film[] filmer = arkiv.soekProdusent(delstreng);

		for (int i = 0; i < filmer.length; i++) {
			skrivUtFilm(filmer[i]);
		}

	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {

		System.out.println("Antall filmer totalt: " + arkiv.antall());
		System.out.println("Antall filmer i sjangeren ACTION: " + arkiv.antall(Sjanger.ACTION));
		System.out.println("Antall filmer i sjangeren DRAMA: " + arkiv.antall(Sjanger.DRAMA));
		System.out.println("Antall filmer i sjangeren COMEDY: " + arkiv.antall(Sjanger.COMEDY));
		System.out.println("Antall filmer i sjangeren HORROR: " + arkiv.antall(Sjanger.HORROR));
		System.out.println("Antall filmer i sjangeren THRILLER: " + arkiv.antall(Sjanger.THRILLER));
		System.out.println("Antall filmer i sjangeren DOCUMENTARY: " + arkiv.antall(Sjanger.DOCUMENTARY));
		System.out.println("Antall filmer i sjangeren ANNET: " + arkiv.antall(Sjanger.ANNET));

	}
	// osv ... andre metoder
}