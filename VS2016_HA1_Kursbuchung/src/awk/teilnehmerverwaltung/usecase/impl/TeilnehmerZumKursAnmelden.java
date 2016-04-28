package awk.teilnehmerverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.usecase.impl.KursManager;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmelden;

public class TeilnehmerZumKursAnmelden implements ITeilnehmerZumKursAnmelden{

	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException {
		
		KursManager kursManagement = KursManager.getKursManager();
		
		Kurs einKurs = kursManagement.getKursByNumber(kursnummer);
		
		einKurs.addTeilnehmer(einTeilnehmer);
		kursManagement.saveKursListe();
	}

}
