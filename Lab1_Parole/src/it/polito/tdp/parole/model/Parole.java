package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	private LinkedList<String> parole;
	
	public Parole() {
		parole= new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.removeAll(parole);
	}

	public void eliminaParola(String s) {
		parole.remove(s);
		
	}

}
