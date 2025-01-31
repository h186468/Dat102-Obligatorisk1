package no.hvl.data102.filmarkiv.klient;
import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        Film film1 = new Film(1, "Steven Spielberg", "E.T.", 1982, Sjanger.DRAMA, "Universal Pictures");
        Film film2 = new Film(2, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "20th Century Fox");
        Film film3 = new Film(3, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);

        boolean ferdig = false;
        Scanner sc = new Scanner(System.in);

        while (!ferdig) {
            System.out.println("Hva ønsker du å gjøre?");
            System.out.println("1 for å finne film");
            System.out.println("2 for å legge til film");
            System.out.println("3 for å slette en film");
            System.out.println("4 søke etter film-tittel");
            System.out.println("5 for å søke etter produsent");
            System.out.println("6 statistikk for filmarkivet, antall filmer og filmer pr sjanger");
            System.out.println("7 for å avslutte");

        
                int svar = sc.nextInt();

                switch (svar) {
                    case 1:
                        System.out.println("Skriv inn filmnummeret du vil finne");
                      
                            int nummer = sc.nextInt();
                            tekstgr.skrivUtFilm(filmarkiv.finnFilm(nummer));
                        
                        	
           
                        break;

                    case 2:
                        Film nyFilm = tekstgr.lesFilm();
                        filmarkiv.leggTilFilm(nyFilm);
                        break;

                    case 3:
                     
                    		System.out.println("hvilken film vil du slette");
                    		
                            int nummer1 = sc.nextInt();
                            if (filmarkiv.finnFilm(nummer1) == null) {
                                System.out.println("Fant ikke filmnummeret");
                           	 	sc.nextLine();

                            } else {
                                filmarkiv.slettFilm(nummer1);
                                System.out.println("Slettet");
                            }
                      
                        break;

                    case 4:
                        System.out.println("Hva vil du søke etter?");
                        String s = sc.next();
                        tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, s);
                        break;

                    case 5:
                        System.out.println("Hva vil du søke etter?");
                        String s1 = sc.next();
                        tekstgr.skrivUtFilmProdusent(filmarkiv, s1);
                        break;

                    case 6:
                        tekstgr.skrivUtStatistikk(filmarkiv);
                        break;

                    case 7:
                        ferdig = true;
                        break;

                    default:
                        System.out.println("Ugyldig valg");
                        break;
                }
            
        }

        //sc.close();
    }
}
