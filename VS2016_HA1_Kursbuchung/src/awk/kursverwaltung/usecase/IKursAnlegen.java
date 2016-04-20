package awk.kursverwaltung.usecase;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;

public interface IKursAnlegen {
	
	public boolean kursAnlegen(String kursName, int anzahlTeilnehmer) throws AnwendungskernException, DatenhaltungsException;

}
