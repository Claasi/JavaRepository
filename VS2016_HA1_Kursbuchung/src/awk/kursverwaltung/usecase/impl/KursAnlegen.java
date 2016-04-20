package awk.kursverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.usecase.IKursAnlegen;

public class KursAnlegen implements IKursAnlegen{
	
	public boolean kursAnlegen(String kursName, int anzahlTeilnehmer) throws AnwendungskernException, DatenhaltungsException{
		
		KursManager km = KursManager.getKursManager();
		int max = km.naechsteKursNummerErmitteln();
		km.addKursCollectionAndDB(new Kurs(max+1, kursName, anzahlTeilnehmer));
		
		//km.speichereKurs(kursNr, kursName, anzahlTeilnehmer);
		return true;
	}

}
