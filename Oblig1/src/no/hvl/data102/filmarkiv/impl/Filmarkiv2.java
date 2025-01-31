package no.hvl.data102.filmarkiv.impl;


import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		this.antall = 0;
		this.start = null;
	}
	
	@Override
	public Film finnFilm(int nr) {
		
		LinearNode<Film> sok = start;
		
		while (sok != null) {
            if (sok.data.getFilmnr() == nr) {
                return sok.data;
            }
            sok = sok.neste;
        }
		
	    return null;
		
		
		}


	@Override
	public void leggTilFilm(Film nyFilm) {
		
		LinearNode<Film> nyNode = new LinearNode<>();
		nyNode.data = nyFilm;
		nyNode.neste = start;
		start = nyNode;
		antall++;

	}
		
	

	@Override
	public boolean slettFilm(int filmnr) {
		
		LinearNode<Film> forrige = null;
		LinearNode<Film> denne = start;
		
		while (denne != null) {
			if (denne.data.getFilmnr() == filmnr) {
				if (forrige == null) {
					start = denne.neste;
				} else {
					forrige.neste = denne.neste;
				}
				antall--;
				return true;
			}
			forrige = denne;
			denne = denne.neste;
		}
		
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

}
