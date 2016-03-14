package awk.kontenverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kontenverwaltung.entity.internal.Konto;
import awk.kontenverwaltung.persistence.IKontoDatenzugriff;
import awk.kontenverwaltung.persistence.impl.KontoDatenzugriff_Datei;

public class KontenManager {
	
	/* Hier wird festgelegt, dass zur Speicherung eine Datei verwendet wird!*/
	private IKontoDatenzugriff einDatenverwalter = new KontoDatenzugriff_Datei();
	
	Collection<Konto> konten;
	

	public KontenManager () throws AnwendungskernException {
		this.konten = new ArrayList<Konto>();
		this.kontenLaden();
	}
	
	public void kontoHinzufuegen (Konto einKonto) throws AnwendungskernException {
		this.konten.add(einKonto);
		this.kontenSpeichern();
	}
	
	
	public int naechsteKontonummerErmitteln () {
		int max = 5000;
		for (Konto einKonto:this.konten)
			if (einKonto.getKontoNr()>max)
				max = einKonto.getKontoNr();
		
		return max;
	
	}
	
	public Konto kontoSuchenByNr(int kontoNr) throws AnwendungskernException {
		for (Konto einKonto:this.konten) {
			if (einKonto.getKontoNr() == kontoNr)
				return einKonto;
		}
		return null;
	}
	
	public void kontenSpeichern () throws AnwendungskernException {
		
		try {
			einDatenverwalter.kontendatenSpeichern(this.konten);
		} catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
	}
	
	public void kontenLaden () throws AnwendungskernException {

		this.konten.clear();
		try {
			this.konten =  einDatenverwalter.kontendatenLesen();
		} catch (DatenhaltungsException e) {
			throw new AnwendungskernException();		
		}
		
	}
}
