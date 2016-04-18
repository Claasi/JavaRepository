package awk.kursverwaltung.usecase;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;

public interface IKursAnlegen {
	
	public void kursAnlegen(int kursNr, String kursName, int anzahlTeilnehmer) throws AnwendungskernException, DatenhaltungsException;

}
