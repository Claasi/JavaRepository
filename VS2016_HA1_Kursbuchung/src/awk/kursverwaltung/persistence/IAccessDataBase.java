package awk.kursverwaltung.persistence;

import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;

public interface IAccessDataBase {
	
	public KursTO getKursInfo() throws DatenhaltungsException;
	public void updateKursInfo(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException;
	public void speichereKurs(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException;

}
