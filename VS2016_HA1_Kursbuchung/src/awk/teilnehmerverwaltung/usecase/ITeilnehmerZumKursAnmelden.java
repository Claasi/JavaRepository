package awk.teilnehmerverwaltung.usecase;

import awk.AnwendungskernException;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;

public interface ITeilnehmerZumKursAnmelden {
	
	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException;

}
