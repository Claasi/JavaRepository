package awk.kundenverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kundenverwaltung.entity.internal.Kunde;
import awk.kundenverwaltung.persistence.IKundenDatenzugriff;
import awk.kundenverwaltung.persistence.impl.KundenDatenzugriff_Datei;


public class KundenManager {
	
	/* Hier wird festgelegt, dass zur Speicherung eine Datei verwendet wird!*/
	private IKundenDatenzugriff einDatenverwalter= new KundenDatenzugriff_Datei();
	
	private Collection<Kunde> kunden;
	
	public KundenManager () throws AnwendungskernException {
		kunden = new ArrayList<Kunde>();
		this.kundenLaden();
	}
	
	
	public void kundeHinzufuegen (Kunde kunde) throws AnwendungskernException {
		this.kunden.add(kunde);
		this.kundenSpeichern();
	}
	
	public void kundeEntfernen (Kunde kunde) throws AnwendungskernException {
		this.kunden.remove(kunde);
		this.kundenSpeichern();
	}
	
	public void kundeAendern (Kunde kunde, int kontonummer) throws AnwendungskernException {
		kunde.addKonto(kontonummer);
		this.kundenSpeichern();
	}
		
	public boolean istKundevorhanden(Kunde kunde) {
		return kunden.contains(kunde);
	}
	
	public int naechsteKundennummerErmitteln () {
		int max = 1000;
		for (Kunde einKunde:this.kunden)
			if (einKunde.getKundenummer()>max)
				max = einKunde.getKundenummer();
		
		return max;
	
	}
		
	public Collection<Kunde> kundeSuchenByName (
			String nachname,
			String vorname) {
		Collection<Kunde> ergebnisliste = new ArrayList<Kunde>();
		for (Kunde einKunde:this.kunden) {
			if (einKunde.getNachname().equals(nachname) && einKunde.getVorname().equals(vorname))
				ergebnisliste.add(einKunde);
		}
		return ergebnisliste;
	}
	
	public Kunde kundeSuchenByNr (int kundennummer) {
		for (Kunde einKunde:this.kunden) {
			if (einKunde.getKundenummer() == kundennummer)
				return einKunde;
		}
		return null;
		
	}

	
	public Collection<Kunde> kundenLiefern ()  {
		return this.kunden;
	}



	public void kundenSpeichern () throws AnwendungskernException {
		try {
			einDatenverwalter.kundendatenSpeichern(this.kunden);
		} catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
	}
	
	public void kundenLaden () throws AnwendungskernException {
		this.kunden.clear();
		try {
			this.kunden =  einDatenverwalter.kundendatenLesen();

		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			throw new AnwendungskernException();		
		}
		
	}
	
		
}
