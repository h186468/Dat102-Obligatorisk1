package no.hvl.data102.filmarkiv.impl;

import java.util.ArrayList;
import java.util.List;

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
			if (sok.data != null && sok.data.getFilmnr() == nr) {
				return sok.data;
			}
			sok = sok.neste;
		}

		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		if (start == null) {
			start = nyNode;
		} else {
			LinearNode<Film> current = start;
			while (current.neste != null) {
				current = current.neste;
			}
			current.neste = nyNode;
		}
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {

		LinearNode<Film> forrige = null;
		LinearNode<Film> filmNode = start;

		while (filmNode != null) {
			if (filmNode.data.getFilmnr() == filmnr) {
				if (forrige == null) {
					start = filmNode.neste;
				} else {
					forrige.neste = filmNode.neste;
				}
				antall--;
				return true;
			}
			forrige = filmNode;
			filmNode = filmNode.neste;
		}

		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> filmNode = start;
		List<Film> filmer = new ArrayList<>();

		while (filmNode != null) {
			if (filmNode.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				filmer.add(filmNode.data);
			}
			filmNode = filmNode.neste;
		}

		return filmer.toArray(new Film[0]);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		LinearNode<Film> filmNode = start;
		int antall = 0;

		while (filmNode != null) {
			if (filmNode.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				antall++;
			}
			filmNode = filmNode.neste;
		}

		Film[] filmer = new Film[antall];
		filmNode = start;
		int i = 0;

		while (filmNode != null) {
			if (filmNode.data.getProdusent().contains(delstreng)) {
				filmer[i] = filmNode.data;
				i++;
			}
			filmNode = filmNode.neste;
		}

		return filmer;
	}

	@Override
	public int antall(Sjanger sjanger) {

		LinearNode<Film> filmNode = start;
		int antall = 0;

		while (filmNode != null) {
			if (filmNode.data.getSjanger() == sjanger) {
				antall++;
			}
			filmNode = filmNode.neste;
		}

		return antall;
	}

	@Override
	public int antall() {
		return antall;
	}

}
