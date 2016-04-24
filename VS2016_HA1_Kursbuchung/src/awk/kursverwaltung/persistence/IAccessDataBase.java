package awk.kursverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.entity.TeilnehmerTO;

public interface IAccessDataBase {
	
//	public KursTO getKursInfo() throws DatenhaltungsException;
//	public void updateKursInfo(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException;
//	public void speichereKurs(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException;
	
	public Collection<KursTO> getKursListe() throws DatenhaltungsException;
	public void kursDatenListeSpeichern(Collection<KursTO> kursTOListe) throws DatenhaltungsException;
	
	public Collection<TeilnehmerTO> getTeilnehmerListe() throws DatenhaltungsException;
	public void saveTeilnehmerListe(Collection<TeilnehmerTO> teilnehmerTOListe) throws DatenhaltungsException;

}
