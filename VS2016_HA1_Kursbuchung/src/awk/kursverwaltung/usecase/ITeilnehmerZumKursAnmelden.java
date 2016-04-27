package awk.kursverwaltung.usecase;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.internal.Teilnehmer;

public interface ITeilnehmerZumKursAnmelden {
	
	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException;

}
