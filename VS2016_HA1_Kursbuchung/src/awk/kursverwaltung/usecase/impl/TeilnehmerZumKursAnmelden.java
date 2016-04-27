package awk.kursverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.entity.internal.Teilnehmer;
import awk.kursverwaltung.usecase.ITeilnehmerZumKursAnmelden;

public class TeilnehmerZumKursAnmelden implements ITeilnehmerZumKursAnmelden{

	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException {
		
		KursManager kursManagement = KursManager.getKursManager();
		
		Kurs einKurs = kursManagement.sucheKursByKursNr(kursnummer);
		
		einKurs.addTeilnehmer(einTeilnehmer);
		kursManagement.saveKursListe();
		
	}

}
